package com.sino.bjcc.discuss.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.discuss.bean.Discuss;

public class DiscussDao extends PersistenceBase implements IDiscussDao {

	public Object getEntity(Class entityClass, long id) {
		return get(entityClass, id);
	}

	public void addDiscuss(Discuss dis) {
		save(dis);
	}

	public List<Discuss> getDiscuss(PaginationBean page,long articleId,int type ) {
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		String hql = "from Discuss d where  d.status=1 and d.articleID=:ARTICLEID and d.type=:type";
		
			paramList.add(new SqlParameter("ARTICLEID", articleId));
			paramList.add(new SqlParameter("type", type));
		String countSql = " select count(status) "+hql ;
		page = getRecordCount(page, countSql,paramList.toArray(new SqlParameter[]{}));
		return (List) getRecordByPage(page, hql,paramList.toArray(new SqlParameter[]{}));
	}
	public Double getAvg(long articleId,int type ){
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		String hql="select avg(d.grade) from Discuss d where  d.status=1 and d.articleID=:ARTICLEID and d.type=:type";
		
			paramList.add(new SqlParameter("ARTICLEID", articleId));
			paramList.add(new SqlParameter("type", type));
		if(executeQuery(hql,paramList.toArray(new SqlParameter[]{})).get(0)!=null){
		return (Double) Double.parseDouble(executeQuery(hql,paramList.toArray(new SqlParameter[]{})).get(0).toString());
	}else{
		return 0.0;
		}
	}
}
