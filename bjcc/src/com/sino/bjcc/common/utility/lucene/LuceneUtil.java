package com.sino.bjcc.common.utility.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TermRangeFilter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.bean.SearchFileBean;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.bjcc.common.utility.PropertyUtil;
import com.sino.bjcc.common.utility.StringUtil;

public class LuceneUtil {
	/**检索出最多多少条数据**/
	private final int SEARCH_MAX_FILES = 10000;
	/**创建索引的文件的扩展名**/
	private final String INDEX_FILE_EXT="html";
	/**内容**/
	private final String FIELD_CONTENT = "content";
	/**路径**/
	private final String FIELD_PATH = "path";
	/**标题**/
	private final String FIELD_TITLE = "title";
	/**时间**/
	private final String FIELD_TIME = "time";
	/**文件大小**/
	private final String FIELD_SIZE = "size";
	/**降序**/
	private final int SORT_DESC = 1;
	
	public void createIndexFile() throws IOException {
		IndexWriter indexWriter = null;
		FileInputStream fis = null;
		BufferedReader reader = null;
		Directory directory = null;
		Analyzer analyzer = null;
		try {
			//需要的分词器
			analyzer = new IKAnalyzer();
			//创建IndexWriterConfig
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_41, analyzer);
			//设定创建索引模式为新建模式
			indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
			//打开索引文件路径
			directory = FSDirectory.open(getIndexDir());
			//声明索引创建对象，创建索引前删除已经存在的索引
			indexWriter = new IndexWriter(directory, indexWriterConfig);
			indexWriter.deleteAll();

			//读取指定路径下的所有文件（包含子目录），针对读取到的文件创建索引
			List<File> fileList = new ArrayList<File>();
			getAllFiles(fileList, PropertyUtil.getProperty("lucene.search.dir"));

			for (File file : fileList) {
				Document doc = new Document();
				//读取文件内容，读取内容时指定编码否则中文有问题
				fis = new FileInputStream(file);
				reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

				StringBuffer buffer = new StringBuffer("");
				//按行读取文件内容
				String content = reader.readLine();
				while (content != null) {
					buffer.append(content);
					content = reader.readLine();
				}
				String html = buffer.toString();
				String title = getHtmlTitle(html);
				doc.add(new Field(FIELD_TITLE, (title == null ? file.getName() : title), TextField.TYPE_STORED));//添加属性文件名称
				doc.add(new Field(FIELD_PATH, file.getPath(), TextField.TYPE_STORED));	//文件路径
				doc.add(new Field(FIELD_CONTENT, html2Text(html), TextField.TYPE_STORED));	//内容
				doc.add(new Field(FIELD_TIME, DateTimeUtil.ConvertDate2String(new Date(file.lastModified()), DateTimeUtil.FORMAT_YMD), TextField.TYPE_STORED));	//时间
				doc.add(new Field(FIELD_SIZE, String.valueOf(file.length()), TextField.TYPE_STORED));	//时间
				indexWriter.addDocument(doc);
			}
		} catch (Exception ex) {
			System.err.println("创建索引时发生异常：" + ex.getStackTrace());
		} finally {
			if (reader != null){
				reader.close();		//关闭数据流
			}
			if (fis != null){
				fis.close();		//关闭文件流
			}
			if (analyzer != null) {
				analyzer.close();	//关闭分词器
			}
			if (indexWriter != null) {
				indexWriter.close();//关闭索引创建
			}
			if (directory != null) {
				directory.close();	//关闭索引路径
			}
		}
	}

	/**
	 * 方法说明：取得指定路径下所有文件
	 */
	private void getAllFiles(List<File> files, String path) {
		File baseDir = new File(path);
		File[] fileArr = baseDir.listFiles();
		for (File file : fileArr) {
			if (file.isFile()) {
				if((file.getName().toLowerCase()).endsWith(INDEX_FILE_EXT)){
					files.add(file);
				}
				continue;
			}
			//含有子目录时递归获取文件
			if (file.isDirectory()) {
				getAllFiles(files, file.getAbsolutePath());
			}
		}
	}

	/**
	 * 方法说明：获取索引所在路径
	 */
	private File getIndexDir() throws Exception{
		return new File(PropertyUtil.getProperty("lucene.index.dir"));
	}
	
	/**
	 * 方法说明：获取html的title
	 */
	private String getHtmlTitle(String html){
		String regxp = "<title>.*?</title>";   
        Pattern pattern = Pattern.compile(regxp);   
        Matcher matcher = pattern.matcher(html); 
        if(matcher.find()) {
        	return matcher.group().replace("<title>", "").replace("</title>", "");
        }
        return null;
	}
	
	/**
	 * 方法说明：html转换为文本
	 */
	private String html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;// 返回文本字符串
	}

	/**
	 * 方法说明：根据关键字全文检索
	 */
	public List<SearchFileBean> searchIndexFileResult(String key, PaginationBean page) throws IOException {
		List<SearchFileBean> beanList = new ArrayList<SearchFileBean>();
		if(StringUtil.isNullOrEmpty(key)){
			return beanList;
		}
		Directory dir = null;
		Analyzer analyzer = null;
		DirectoryReader ireader = null;
		try {
			//读取索引文件
			dir = FSDirectory.open(getIndexDir());
			ireader = DirectoryReader.open(dir);
			IndexSearcher search = new IndexSearcher(ireader);
			//定义分词器
			analyzer = new IKAnalyzer();
			
			Query query = createQuery(key, analyzer);
			//查询出含有关键字的文件
			ScoreDoc[] hits = search.search(query, getFilter(), SEARCH_MAX_FILES, getSort()).scoreDocs;

			//设定高亮显示的格式，也就是对高亮显示的词组加上前缀后缀
			SimpleHTMLFormatter simpleHtmlFormatter = new SimpleHTMLFormatter("<font class=\"query_keyword\">", "</font>");
			Highlighter highlighter = new Highlighter(simpleHtmlFormatter, new QueryScorer(query));
			highlighter.setTextFragmenter(new SimpleFragmenter(150));

			//设定检索出的总量
			page.setTotalRecord(hits.length);
			//计算出要取得数据的开始索引及结束索引
			int start = (page.getCurrentPage()-1) * page.getPageSize();
			int end = (start + page.getPageSize()) > hits.length ? hits.length : start + page.getPageSize();
			//取数据条件不符合要求时返回空
			if(start > end){
				return beanList;
			}
			SearchFileBean fileBean = null;
			for (int index=start; index < end; index++) {
				Document doc = search.doc(hits[index].doc);
				TokenStream tokenStream = analyzer.tokenStream("", new StringReader(doc.get(FIELD_CONTENT)));
				String content = highlighter.getBestFragment(tokenStream, doc.get(FIELD_CONTENT));
				if (StringUtil.isNullOrEmpty(content)) {
					content = doc.get(FIELD_CONTENT);
				}
				//设定文件对象的属性
				fileBean = new SearchFileBean();
				fileBean.setContent(content);
				fileBean.setTitle(doc.get(FIELD_TITLE));
				fileBean.setModifyDate(doc.get(FIELD_TIME));
				fileBean.setPath(doc.get(FIELD_PATH));
				beanList.add(fileBean);
			}
		} catch (Exception ex) {
			System.err.println("全文检索时发生异常" + ex.getMessage());
		} finally {
			if (analyzer != null){
				analyzer.close();		//关闭分词器
			}
			if (null != ireader){
				ireader.close();		//关闭数据流
			}
			if (dir != null){
				dir.close();			//关闭索引
			}
		}
		return beanList;
	}

	/**
	 * 方法说明：创建查询对象
	 */
	private Query createQuery(String key, Analyzer analyzer) throws ParseException{
		//定义查询字段、关键字
		String[] fields = {FIELD_CONTENT};
		String[] keys = {key};
		BooleanClause.Occur[] flags=new BooleanClause.Occur[]{BooleanClause.Occur.SHOULD};   

		if(key.contains(" ")){
			//去掉多余空格，把两个空格替换为一个空格
			while(key.contains("  ")){
				key = key.replace("  ", " ");
			}
			keys = key.split(" ");
			List<String> fieldList = new ArrayList<String>();
			List<BooleanClause.Occur> orList = new ArrayList<BooleanClause.Occur>();
			for(int index=0; index<keys.length; index++){
				fieldList.add(FIELD_CONTENT);
				orList.add(BooleanClause.Occur.SHOULD);
			}
			fields = fieldList.toArray(new String[]{});
			flags = orList.toArray(new BooleanClause.Occur[]{});
		}
		//创建查询对象
		Query query =  MultiFieldQueryParser.parse(Version.LUCENE_41,keys, fields, flags, analyzer); 
		return query;
	}
	
	private Sort sort = Sort.RELEVANCE;
	private Sort getSort(){
		return this.sort;
	}
	/**
	 * 方法说明：设定排序字段及排序类型，sortType:0-升序；1-降序
	 */
	public void setSortField(String field, int sortType){
		SortField sortField = SortField.FIELD_SCORE;
		if(FIELD_SIZE.equalsIgnoreCase(field)){
			//按文件大小排序
			if(SORT_DESC==sortType){
				sortField =  new SortField(FIELD_SIZE, SortField.Type.LONG, true);
			}else{
				sortField =  new SortField(FIELD_SIZE, SortField.Type.LONG, false);
			}
		}else if(FIELD_TIME.equalsIgnoreCase(field)){
			//按日期排序
			if(SORT_DESC==sortType){
				sortField =  new SortField(FIELD_TIME, SortField.Type.STRING, true);
			}else{
				sortField =  new SortField(FIELD_TIME, SortField.Type.STRING, false);
			}
		}else{
			return;
		}
		sortField.setUseIndexValues(true);
		this.sort = new Sort(sortField);
	}
	
	private Filter filter = null;
	private Filter getFilter(){
		return this.filter;
	}
	/**
	 * 方法说明：设定检索条件时间段，1：一个月；2：三个月；3：半年；4：一年；其他：所有
	 */
	public void setDateRangeFilter(int range){
		if(!"1234".contains(String.valueOf(range))){
			return;
		}
		Date start = null;
		Date end = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(end);
		//一个月
		if(1==range){
			cal.add(Calendar.MONTH, -1);
			start = cal.getTime();
		}else if(2==range){
			//三个月
			cal.add(Calendar.MONTH, -3);
			start = cal.getTime();
		}else if(3==range){
			//半年
			cal.add(Calendar.MONTH, -6);
			start = cal.getTime();
		}else if(4==range){
			//一年
			cal.add(Calendar.YEAR, -1);
			start = cal.getTime();
		}
		this.filter = new TermRangeFilter(FIELD_TIME, 
				new BytesRef(DateTimeUtil.ConvertDate2String(start, DateTimeUtil.FORMAT_YMD)), 
				new BytesRef(DateTimeUtil.ConvertDate2String(end, DateTimeUtil.FORMAT_YMD)), 
				true, true);
	}
	
}
