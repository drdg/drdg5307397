package com.sino.bjcc.videoRecommend.service.impl;

import java.util.List;

import com.sino.bjcc.videoRecommend.persistence.IVideoRecommendDao;
import com.sino.bjcc.videoRecommend.service.IVideoRecommendService;

public class VideoRecommendServiceImpl implements IVideoRecommendService{
	
	private IVideoRecommendDao videoRecommendDao;
	
	public IVideoRecommendDao getVideoRecommendDao() {
		return videoRecommendDao;
	}

	public void setVideoRecommendDao(IVideoRecommendDao videoRecommendDao) {
		this.videoRecommendDao = videoRecommendDao;
	}






	//获取视频播放地址
	public List playUrl(int num) {
		
		List<Object[]> list = videoRecommendDao.NewVideo(num);
		for(Object[] objs : list ){
			if(null!=objs[3] && !"".equals(objs[3].toString())){
				StringBuffer St = new StringBuffer();
				String[] channel = objs[3].toString().substring(1, objs[3].toString().length()-1).split(",");
                if(channel.length>0){
                	for(int i = 0;i < channel.length;i++){
                		List<Object[]> pathList = videoRecommendDao.parentPath(channel[i]);
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
