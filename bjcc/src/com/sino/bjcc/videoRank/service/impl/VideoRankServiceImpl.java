package com.sino.bjcc.videoRank.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sino.bjcc.videoRank.persistence.IVideoRankDao;
import com.sino.bjcc.videoRank.service.IVideoRankService;

public class VideoRankServiceImpl implements IVideoRankService{
	
	private IVideoRankDao videoRankDao; //视频点播排行的dao
	

	public IVideoRankDao getVideoRankDao() {
		return videoRankDao;
	}

	public void setVideoRankDao(IVideoRankDao videoRankDao) {
		this.videoRankDao = videoRankDao;
	}

	//获取视频月排行列表
	public List MonthRank(int resourcesType) {
		List<Object[]> list = videoRankDao.MonthRank(resourcesType);
		for(Object[] objs : list ){
			if(null!=objs[3] && !"".equals(objs[3].toString())){
				StringBuffer St = new StringBuffer();
				String[] channel = objs[3].toString().substring(1, objs[3].toString().length()-1).split(",");
                if(channel.length>0){
                	for(int i = 0;i < channel.length;i++){
                		List<Object[]> pathList = videoRankDao.parentPath(channel[i]);
                		for(Object[] objs2 : pathList){
                			if(null!=objs2[0] && !"".equals(objs2[0].toString())){
                				St.append(objs2[0].toString());
                			}
                		}
                		St.append("/");
                	}
                 }
			    objs[4] = St;
		    }
		}
		return list;
	}

	//获取视频点播季排行
	public List SeasonRank(int resourcesType) {
		
		List<Object[]> list = videoRankDao.SeasonRank(resourcesType);
		for(Object[] objs : list ){
			if(null!=objs[3] && !"".equals(objs[3].toString())){
				StringBuffer St = new StringBuffer();
				String[] channel = objs[3].toString().substring(1, objs[3].toString().length()-1).split(",");
                if(channel.length>0){
                	for(int i = 0;i < channel.length;i++){
                		List<Object[]> pathList = videoRankDao.parentPath(channel[i]);
                		for(Object[] objs2 : pathList){
                			if(null!=objs2[0] && !"".equals(objs2[0].toString())){
                				St.append(objs2[0].toString());
                			}
                		}
                		St.append("/");
                	}
                 }
			    objs[4] = St;
		    }
		}
		return list;
	}

	//获取视频点播年排行
	public List YearRank(int resourcesType) {
		
		List<Object[]> list = videoRankDao.YearRank(resourcesType);
		for(Object[] objs : list ){
			if(null!=objs[3] && !"".equals(objs[3].toString())){
				StringBuffer St = new StringBuffer();
				String[] channel = objs[3].toString().substring(1, objs[3].toString().length()-1).split(",");
                if(channel.length>0){
                	for(int i = 0;i < channel.length;i++){
                		List<Object[]> pathList = videoRankDao.parentPath(channel[i]);
                		for(Object[] objs2 : pathList){
                			if(null!=objs2[0] && !"".equals(objs2[0].toString())){
                				St.append(objs2[0].toString());
                			}
                		}
                		St.append("/");
                	}
                 }
			    objs[4] = St;
		    }
		}
		return list;
	}
	
	

}
