package com.sino.bjcc.videoRecommend.persistence;

import java.util.List;

public interface IVideoRecommendDao {

	//获取最新视频
	public List NewVideo(int num);
	//获取视频父栏目path
	public List parentPath(String channel);
	
}
