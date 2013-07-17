package com.sino.bjcc.common.utility.lucene;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class TimerManagerUtil {
	private static TimerManagerUtil timerUtil = null;
	/**
	 * 私有化构造函数使用单例模式
	 */
	private TimerManagerUtil() {
	}

	// 时间间隔
	private static final long PERIOD_DAY = 3 * 60 * 60 * 1000;

	/**
	 * 方法说明：创建定时器工具类实例
	 */
	public static TimerManagerUtil createInstance(){
		if(null == timerUtil){
			timerUtil = new TimerManagerUtil();
		}
		return timerUtil;
	}

	/**
	 * 方法说明：启动定时器
	 */
	public void startTimer(){
		Calendar calendar = Calendar.getInstance();
		//定制每日2:00执行方法 
		calendar.set(Calendar.HOUR_OF_DAY, 14);
		calendar.set(Calendar.MINUTE, 36);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime(); // 第一次执行定时任务的时间
		// 如果第一次执行定时任务的时间 小于 当前的时间
		// 此时要在 第一次执行定时任务的时间 加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
		if (date.before(new Date())) {
			date = this.addDay(date, 1);
		}
		Timer timer = new Timer();
		LuceneIndexTimerTask task = new LuceneIndexTimerTask();
		// 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timer.schedule(task, 2000, PERIOD_DAY);
	}
	
	/**
	 * 方法说明：为指定日期增加天数
	 */
	private Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_YEAR, num);
		return startDT.getTime();
	}

}
