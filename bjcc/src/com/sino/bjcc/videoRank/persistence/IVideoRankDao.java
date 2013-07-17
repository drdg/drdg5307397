package com.sino.bjcc.videoRank.persistence;

import java.util.List;

public interface IVideoRankDao {
	
	//获取视频点播月排行
	public List MonthRank(int resourcesType);
	//获取视频点播季排行
	public List SeasonRank(int resourcesType);
	//获取视频点播年排行
	public List YearRank(int resourcesType);
	//获取视频父栏目的path
	public List parentPath(String channel);

}
