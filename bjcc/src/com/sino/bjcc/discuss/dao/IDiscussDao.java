package com.sino.bjcc.discuss.dao;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.discuss.bean.Discuss;

public interface IDiscussDao {
public List<Discuss> getDiscuss(PaginationBean page,long articleId,int type);
public void addDiscuss(Discuss dis);
public Object getEntity(Class entityClass, long id);
public Double getAvg(long articleId,int type);
}
