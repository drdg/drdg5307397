package com.sino.bjcc.videoRecommend.persistence.impl;

import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.videoRecommend.persistence.IVideoRecommendDao;

public class VideoRecommendDaoImpl extends PersistenceBase implements IVideoRecommendDao{

	//获取最新视频
	public List NewVideo(int num) {
		
		String sql = "select p.ID,p.middle_image,v.Name,v.channel,'' as path from sino_Video v,sino_Program p where rownum<=:num and v.program_id=p.ID and state=10 order by v.ID desc";
		return (List)executeSqlQuery(sql,new SqlParameter("num",num));
	}
	
	
	//获取视频父栏目的path
	public List parentPath(String channel) {
		
		String sql = "select cc.path,cc.id from cms_channel cc where cc.code1=:channel";
		return executeSqlQuery(sql,new SqlParameter("channel",channel));
	}
	
	

}
