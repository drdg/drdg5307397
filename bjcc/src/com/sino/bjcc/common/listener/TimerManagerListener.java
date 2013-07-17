package com.sino.bjcc.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sino.bjcc.common.utility.lucene.TimerManagerUtil;

public class TimerManagerListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		TimerManagerUtil.createInstance().startTimer();
	}

}
