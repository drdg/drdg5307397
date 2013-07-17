package com.sino.bjcc.discuss.service;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.discuss.bean.Discuss;
import com.sino.bjcc.discuss.dao.IDiscussDao;

public class DiscussService implements IDiscussService {
private IDiscussDao discussDao;
public void setDiscussDao(IDiscussDao discussDao) {
	this.discussDao = discussDao;
}

public void addDiscuss(Discuss dis) {
	discussDao.addDiscuss(dis);
	
}

public Object getEntity(Class entityClass, long id){
	return discussDao.getEntity(entityClass, id);
}
public List getDiscuss(PaginationBean page,long articleId,int type) {
	return discussDao.getDiscuss( page,articleId,type);
}
public Double getAvg(long articleId,int type){
	return discussDao.getAvg(articleId,type);
}
}
