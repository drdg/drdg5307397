package com.sino.bjcc.common.utility.lucene;

import java.util.TimerTask;

public class LuceneIndexTimerTask extends TimerTask {

	@Override
	public void run() {
		try{
			new LuceneUtil().createIndexFile();
		}catch(Exception ex){
			
		}
	}

}
