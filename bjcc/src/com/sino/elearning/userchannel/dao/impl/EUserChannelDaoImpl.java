package com.sino.elearning.userchannel.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.timetable.bean.CmsArticle;
import com.sino.bjcc.timetable.bean.CmsChannel;
import com.sino.elearning.userchannel.dao.IEUserChannelDao;
/**
 * 用户专题dao实现类
 * @author Administrator
 *
 */
public class EUserChannelDaoImpl extends PersistenceBase implements
		IEUserChannelDao {
	/**
	 * 根据参数查询专题
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CmsChannel> findCmsChannelByParams(Map params) throws Exception {
		List<CmsChannel> list = null;
		StringBuffer hql = new StringBuffer();
        Object values[] = new Object[params.size()];
        int i = 0;
        hql.append("from CmsChannel as cc where 1=1 and (cc.id in(5, 8, 9 ,92) or cc.parentid in (5,6, 213, 8, 9) and cc.id not in(90,91)) ");
        for(Iterator iterator = params.keySet().iterator(); iterator.hasNext();)
        {
            String key = (String)iterator.next();
            hql.append(" and");
            hql.append(" cc.");
            hql.append(key);
            hql.append("=?");
            values[i] = params.get(key);
            i++;
        }
        
        String qureString = hql.toString();
        
        try {
        	list = getHibernateTemplate().find(qureString, values);
        } catch ( Exception e ) {
        	log.error("查询专题失败findCmsChannelByParams(Map params)");
        	throw e;
        }
		return list;
	}
	
	
	/**
	 * 根据参数查询用户专题
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CmsChannel> findUserChannelByParams(Map params) throws Exception {
		List<CmsChannel> list = null;
		StringBuffer hql = new StringBuffer();
        Object values[] = new Object[params.size()];
        int i = 0;
        hql.append("select cc from CmsChannel as cc, EUserChannel euc where euc.channelId = cc.id ");
        for(Iterator iterator = params.keySet().iterator(); iterator.hasNext();)
        {
            String key = (String)iterator.next();
            hql.append(" and ");
            hql.append(key);
            hql.append("=?");
            values[i] = params.get(key);
            i++;
        }
        
        String qureString = hql.toString();
        
        try {
        	list = getHibernateTemplate().find(qureString, values);
        } catch ( Exception e ) {
        	log.error("查询用户专题失败findUserChannelByParams(Map params)");
        	throw e;
        }
		return list;
	}
	
	/**
	 * 根据用户ID删除用户专题
	 * @param userId
	 * @throws Exception
	 */
	public void deleteByUserId(final Long userId) throws Exception {
		try {
			getHibernateTemplate().execute(new HibernateCallback() {
            	 
                public Object doInHibernate(Session session) {
            		Query query = session.createQuery("delete from  EUserChannel as euc where euc.userId=:USERID");
                    query.setLong("USERID", userId);
                    return Integer.valueOf(query.executeUpdate());
                }
            });
        } catch(Exception e) {
            log.error("删除用户专题失败userid = " + userId);
            throw e;
        }
	}
	
	/**
	 * 根据hql语句查询文章列表前10条
	 * @param channelids
	 * @return
	 * @throws Exception
	 */
	public List<CmsArticle> queryCmsArticleByHql(String channelids) throws Exception {
		List<CmsArticle> articles = null;
		StringBuffer sb = new StringBuffer();
		sb.append("from CmsArticle ca where ca.status = 7 and ca.parentid in (")
		  .append(channelids)
		  .append(") order by ca.modifieddate desc");
		try{
			Query query= super.getCurSession().createQuery(sb.toString());
			query.setFirstResult(0);
			query.setMaxResults(10);
			articles = query.list();
		}catch(Exception e) {
			log.error("查询文章失败 queryCmsArticleByHql()");
			throw e;
		}
		return articles;
	}
	Log log = LogFactory.getLog(com.sino.elearning.userchannel.dao.impl.EUserChannelDaoImpl.class);
}