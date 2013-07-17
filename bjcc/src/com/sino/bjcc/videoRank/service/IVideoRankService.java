package com.sino.bjcc.videoRank.service;

import java.util.List;

public interface IVideoRankService {
	
	//获取视频月排行列表
	public List MonthRank(int resourcesType);
	//获取视频点播季排行
	public List SeasonRank(int resourcesType);
	//获取视频点播年排行
	public List YearRank(int resourcesType);

}
