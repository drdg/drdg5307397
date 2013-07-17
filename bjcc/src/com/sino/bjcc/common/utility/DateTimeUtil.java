package com.sino.bjcc.common.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.sino.bjcc.common.dao.IDateTimeDao;

public class DateTimeUtil {

	public final static String FORMAT_YMD = "yyyy-MM-dd";
	public final static String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	public final static String FORMAT_YM = "yyyy-MM";
	
	public static IDateTimeDao dateTimeDao;
	/**
	 * 方法说明：把字符串转换为日期
	 * 参数说明：dateStr：日期格式的字符串；
	 *          formatStr：字符串对应的日期格式
	 */
	public static Date ConvertString2Date(String dateStr,String formatStr) throws ParseException{
		return getFormat(formatStr).parse(dateStr);
	}
	
	/**
	 * 方法说明：把日期转换为字符串
	 * 参数说明：date：日期；
	 *          formatStr：转换后的日期字符串的格式
	 */
	public static String ConvertDate2String(Date date, String formatStr){
		return getFormat(formatStr).format(date);
	}
	
	/**
	 * 方法说明:获取格式化对象
	 */
	private static DateFormat getFormat(String formatStr){
		return new SimpleDateFormat(formatStr,Locale.CHINA);
	}
	
	/**
	 * 方法说明:获取当前时间
	 */
	public static Date getNow(){
		Date now = null;
		try{
			now = ConvertString2Date(getNowStr(), DateTimeUtil.FORMAT_YMDHMS);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return now;
	}

	/**
	 * 方法说明:获取当前时间字符串
	 */
	public static String getNowStr(){
		if(null == dateTimeDao) {
			init();
		}
		return dateTimeDao.getDbNowStr();
	}
	
	/**
	 * 获取在date_mon之后的delay月的月份
	 * @param date_mon
	 * @param delay
	 * @return
	 * @throws Exception
	 */
	public static String getBeforeOrAfterMon(String date_mon, int delay) throws Exception{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateTimeUtil.FORMAT_YM);
		Date d = format.parse(date_mon);
		calendar.setTime(d);
		calendar.add(Calendar.MONTH, delay);
		return format.format(calendar.getTime());
	}
	
	public static void init(){
		String path = BjccConfig.realPath + "WEB-INF/conf/applicationContext.xml";
		Resource rs=new FileSystemResource(path);
        BeanFactory factory=new XmlBeanFactory(rs);
        dateTimeDao = (IDateTimeDao) factory.getBean("dateTimeDao");
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(getBeforeOrAfterMon("2012-01", 1));
	}
}
