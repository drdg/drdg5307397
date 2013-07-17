package com.sino.bjcc.discuss.service;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.discuss.bean.Discuss;

public interface IDiscussService {
public void addDiscuss(Discuss dis);
public List getDiscuss(PaginationBean page,long articleId,int type);
public Object getEntity(Class entityClass, long id);
public Double getAvg(long articleId,int type);
}
