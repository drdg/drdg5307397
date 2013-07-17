package com.sino.bjcc.tuwenLive.persistence.impl;

import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.tuwenLive.bean.LiveSubject;
import com.sino.bjcc.tuwenLive.persistence.ITuwenLiveDao;

public class TuwenLiveDaoImpl extends PersistenceBase implements ITuwenLiveDao {

	/**
	 * 方法说明：获取所有图文直播
	 */
	@SuppressWarnings("unchecked")
	public List<LiveSubject> getAllLive(){
		String hql = "From LiveSubject Where delFlag<>'1'";
		return (List<LiveSubject>)executeQuery(hql);
	}
	
	/**
	 * 方法说明：获取图文直播信息
	 */
	public LiveSubject getLiveSubject(long subjectId) {
		return (LiveSubject) get(LiveSubject.class, subjectId);
	}

}
