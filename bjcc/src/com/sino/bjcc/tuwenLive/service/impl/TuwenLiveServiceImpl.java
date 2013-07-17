package com.sino.bjcc.tuwenLive.service.impl;

import java.util.List;

import com.sino.bjcc.common.utility.PropertyUtil;
import com.sino.bjcc.tuwenLive.bean.LivePicture;
import com.sino.bjcc.tuwenLive.bean.LiveSubject;
import com.sino.bjcc.tuwenLive.persistence.ITuwenLiveDao;
import com.sino.bjcc.tuwenLive.service.ITuwenLiveService;

public class TuwenLiveServiceImpl implements ITuwenLiveService {

	/**图文直播dao**/
	private ITuwenLiveDao liveDao = null;
	
	/**
	 * 方法说明：获取图文直播Dao
	 */
	public ITuwenLiveDao getLiveDao() {
		return liveDao;
	}

	/**
	 * 方法说明：设定图文直播Dao
	 */
	public void setLiveDao(ITuwenLiveDao liveDao) {
		this.liveDao = liveDao;
	}

	/**
	 * 方法说明：获取图文直播信息
	 */
	public LiveSubject getLiveSubject(long subjectId) throws Exception {
		LiveSubject liveSubject = getLiveDao().getLiveSubject(subjectId);
		
		//指定cms项目的图文直播图片的路径
		String pathRoot = PropertyUtil.getProperty("tuwenlive.img.pathroot");
		for(LivePicture picture : liveSubject.getPictureList()){
			picture.setUrl(pathRoot + picture.getUrl());
		}
		return liveSubject;
	}

	public List<LiveSubject> getAllLive() {
		return getLiveDao().getAllLive();
	}

}
