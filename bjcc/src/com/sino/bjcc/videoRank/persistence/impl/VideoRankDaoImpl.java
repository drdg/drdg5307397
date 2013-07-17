package com.sino.bjcc.videoRank.persistence.impl;

import java.util.Date;
import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.videoRank.persistence.IVideoRankDao;

public class VideoRankDaoImpl extends PersistenceBase implements IVideoRankDao{
	

	//获取视频点播月排行
	public List MonthRank(int resourcesType) {
		
		String sql="select p.name, p.id, v.count, p.channel, '' as path from (select sub.resources_name, sub.resources_id, count(1) as count from sino_user_behavior sub where sub.resources_type = :resourcesType and to_char(sub.create_time, 'MM') = to_char(sysdate, 'MM') GROUP BY sub.resources_id, sub.resources_name) v,sino_program p where p.id = v.resources_id ORDER BY v.count DESC";
		return executeSqlQuery(sql,8,new SqlParameter("resourcesType",resourcesType));
	}
	
	//获取视频点播季排行
	public List SeasonRank(int resourcesType) {

		String sql="select p.name, p.id, v.count, p.channel,'' as path from (select sub.resources_name,sub.resources_id,count(1) as count from sino_user_behavior sub  where sub.resources_type = :resourcesType and to_char(sub.create_time,'Q')=to_char(sysdate,'Q') GROUP BY sub.resources_id,sub.resources_name) v,sino_program p where p.id=v.resources_id ORDER BY v.count DESC";
		return executeSqlQuery(sql,8,new SqlParameter("resourcesType",resourcesType));
		
	}

	//获取视频点播年排行
	public List YearRank(int resourcesType) {
		
		String sql="select p.name, p.id, v.count, p.channel,'' as path from (select sub.resources_name,sub.resources_id,count(1) as count from sino_user_behavior sub  where sub.resources_type=:resourcesType and to_char(sub.create_time,'YYYY')=to_char(sysdate,'YYYY') GROUP BY sub.resources_id,sub.resources_name) v,sino_program p where p.id=v.resources_id ORDER BY v.count DESC";
		return executeSqlQuery(sql,8,new SqlParameter("resourcesType",resourcesType));
		
		
	}
	
	//获取视频父栏目的path
	public List parentPath(String channel) {
		
		String sql = "select cc.path,cc.id from cms_channel cc where cc.code1=:channel";
		return executeSqlQuery(sql,new SqlParameter("channel",channel));
	} 
	
	

}
