package com.sino.bjcc.tuwenLive.persistence;

import java.util.List;

import com.sino.bjcc.tuwenLive.bean.LiveSubject;

public interface ITuwenLiveDao {

	/**
	 * 方法说明：获取所有图文直播
	 */
	public List<LiveSubject> getAllLive();
	
	/**
	 * 方法说明：获取图文直播信息
	 */
	public LiveSubject getLiveSubject(long subjectId);
	
}
