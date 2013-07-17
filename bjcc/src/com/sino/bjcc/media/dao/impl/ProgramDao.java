package com.sino.bjcc.media.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.media.bean.ChannelInfoBean;
import com.sino.bjcc.media.dao.IProgramDao;

public class ProgramDao extends PersistenceBase implements IProgramDao {

	/**
	 * 方法说明：获取视频信息
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List getList(PaginationBean page,String channel,String date,long sourceOrg,long source,long form,long audien,String tag,String search) {
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		
		String str="SELECT V.play_url,V.id,p.name,p.middle_image,p.summary,p.createDate,p.sourceOrg,p.cast,p.timeLength,p.speaker,p.form ,V.channel,p.id ";
		StringBuffer hql = new StringBuffer(" from Video V , Program p where V.program_id=p.id AND V.state=10 "); 
		if(channel!=null&&!channel.equals("")){
			hql.append(" AND V.channel LIKE :CHANNEL");
			paramList.add(new SqlParameter("CHANNEL", channel+"%"));
		}if(date!=null&&!date.equals("")&&!date.equals("全部")){
			Date startDate = new Date(Integer.parseInt(date)-1900,0,1);
			hql.append(" AND p.createDate >= :releaseDate AND p.createDate < :endDate");
			paramList.add(new SqlParameter("releaseDate", startDate));
			Date endDate = new Date(Integer.parseInt(date)-1900+1,0,1);
			paramList.add(new SqlParameter("endDate", endDate));
		}if(sourceOrg>0){
			hql.append(" AND p.sourceOrg=:sourceOrg");
			paramList.add(new SqlParameter("sourceOrg", sourceOrg));
		}if(audien>0){
			hql.append(" AND  p.audiences=:audiences");
			paramList.add(new SqlParameter("audiences", audien));
		}if(form>0){
			hql.append(" AND p.form=:form");
			paramList.add(new SqlParameter("form", form));
		}if(source>0){
			hql.append(" AND  p.source=:source");
			paramList.add(new SqlParameter("source", source));
		}if(null!=tag && !"".equals(tag) && !"0".equals(tag)){
			hql.append(" AND p.tags like :tag");
			paramList.add(new SqlParameter("tag", "%" + tag + "%"));
		}if(search!=null&&!search.equals("")){
			hql.append(" AND (p.name like :search or p.provider like :search or p.speaker like :search or p.cast like :search or p.summary like :search) ");
			paramList.add(new SqlParameter("search", "%"+search+"%"));
		}
		hql.append("  order by p.createDate desc");
		//在视频记录中节目名称、提供商、演讲人、人员、视频介绍中进行模糊匹配
		String hq=str+hql.toString();
		String countSql =" select count(*) "+hql.toString();
		page = getRecordCount(page, countSql, paramList.toArray(new SqlParameter[]{}));
		return (List) getRecordByPage(page, hq,paramList.toArray(new SqlParameter[]{}));

	}
	
	/**
	 * 方法说明：获取频道信息
	 */
	@SuppressWarnings("unchecked")
	public ChannelInfoBean getChannelInfo(String channel) {
		ChannelInfoBean channelBean = null;
		//声明sql语句用于查询频道信息
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SC.ID AS code,						"); 
		sql.append("	   CC.PATH as path,						");
		sql.append("	   CC.PARENTID as parentId				");
		sql.append("  FROM CMS_CHANNEL CC, SINO_CHANNEL SC		");
		sql.append(" WHERE TO_CHAR(SC.ID) = TO_CHAR(CC.CODE1)	");
		sql.append("   AND SC.STATUS <> -1						");
		sql.append("   AND CC.STATUS = 1						");
		sql.append(" AND CC.ID = :ID");
		//声明频道信息的字段名，用于hibernate封装Bean
		List<String> filedList = new ArrayList<String>();
		filedList.add("code");
		filedList.add("path");
		filedList.add("parentId");
		//查询频道信息
		List<ChannelInfoBean> channelList = (List<ChannelInfoBean>) executeSqlQuery2Bean(sql.toString(), 
				ChannelInfoBean.class, filedList, new SqlParameter("ID",Long.parseLong(channel)));
		if(null!=channelList && channelList.size()>0){
			channelBean = channelList.get(0);
		}
		return channelBean;
	}

	/**
	 * 方法说明：获取所有频道信息
	 */
	@SuppressWarnings("unchecked")
	public List<ChannelInfoBean> getChannelList() {
		//声明sql语句用于查询频道信息
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT CC.CODE1 AS code,					"); 
		sql.append("	   CC.ID as id,							");
		sql.append("	   CC.PATH as path,						");
		sql.append("	   CC.PARENTID as parentId				");
		sql.append("  FROM CMS_CHANNEL CC						");
		sql.append(" WHERE CC.STATUS = 1						");
		//声明频道信息的字段名，用于hibernate封装Bean
		List<String> filedList = new ArrayList<String>();
		filedList.add("code");
		filedList.add("id");
		filedList.add("path");
		filedList.add("parentId");
		//查询频道信息
		List<ChannelInfoBean> channelList = (List<ChannelInfoBean>) executeSqlQuery2Bean(sql.toString(), 
				ChannelInfoBean.class, filedList);
		return channelList;
	}
	
}
