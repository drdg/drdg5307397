package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Customer;
import com.aps.db.model.FenPage;
import com.aps.db.model._Customer;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;
import com.aps.email.SendEmail;
import com.aps.log.imp.UserLog;

/**
 * 用户管理
 * @author Administrator
 *
 */
public class CustomerDAO extends GetSelectQurey implements Customer{

	private PreparedStatement ps;
	private ResultSet rs;
	private UserLog userLog = UserLog.getUserLogSingleton();
	private SendEmail sendEmail = new SendEmail();
	
	public boolean doDelete(String id) {
		boolean bool = false;
		try {
			ps = super.getPs("delete from aps_customer where CTID = ?");
			ps.setString(1, id);
			bool = ps.executeUpdate() > 0;
			super.commit();
			
			/*
			 * 加入日志删除客户
			 * */
			userLog.doSaveLog("删除客户："+id);
			
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}

	/**
	 * 增加用户
	 */
	public boolean doInster(_Customer alobj) {
		boolean bool = false;
		try {
			ps = super.getPs("insert into aps_customer values(sdii.nextval,?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?)");
			ps.setString(1, alobj.getCnickname());
			ps.setString(2, alobj.getCname());
			ps.setString(3, alobj.getCsex());
			ps.setString(4, alobj.getCpwd());
			ps.setString(5, alobj.getCtel());
			ps.setString(6, alobj.getCemail());
			ps.setString(7, alobj.getCbirthday());
			ps.setString(8, alobj.getCaddress());
			bool =  ps.executeUpdate() > 0;
			super.commit();
			
			/*
			 *加入到日志中 
			 *新增客户
			 */
			userLog.doSaveLog("新增客户："+alobj.getCname());
			
			/*
			 *发送用户注册信息给用户，邮件发送 
			 */
			StringBuffer userMessage = new StringBuffer(); 
			userMessage.append("欢迎注册成我们的用户<br>")
					   .append("请保护好您的用户名和密码<br>")
					   .append("用户名："+alobj.getCname()+"<br>")
					   .append("密码："+alobj.getCpwd()+"<br>");
			sendEmail.doSendHtmlEmail("爱配送", userMessage, alobj.getCemail());
			
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}

	/**
	 * 以分页方式查看客户信息
	 */
	@SuppressWarnings("static-access")
	public ArrayList<_Customer> doSelect(FenPage page) {
		ArrayList<_Customer> almodel = new ArrayList<_Customer>();
		/*判断用以第一次取数据库信息时候把分页信息加载进去*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_customer", "CTID", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				_Customer model = new _Customer();
				//客户
				model.setCtid(rs.getString("ctid"));
				model.setCnickname(rs.getString("cnickname"));
				model.setCname(rs.getString("cname"));
				model.setCsex(rs.getString("csex"));
				model.setCpwd(rs.getString("cpwd"));
				model.setCtel(rs.getString("ctel"));
				model.setCemail(rs.getString("cemail"));
				model.setCbirthday(rs.getString("cbirthday"));
				model.setCaddress(rs.getString("caddress"));
				
				//分页信息
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());										//显示一共有多少条数据
					model.setPageNow(String.valueOf(Integer.valueOf(page.getPageNow()) + 1));//当前页为第几页
					model.setPageNum(limit.pageNum);											//每页显示的 下面的 几个数字1 2 3 4 5
					model.setPageSize(limit.pageSize);										//每页大小，既是显示出来多少条
					model.setPageS(limit.doPageS());											//显示一共能分出来多少页
					pdFp = true;
				}
				
				almodel.add(model);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almodel;
	}

	public ArrayList<_Customer> doSelect(_Customer alobj) {
		return null;
	}

	/**
	 * 异步更新数据
	 */
	public boolean doUpdate(_Customer obj) {
		boolean bool = false;
		try {
			ps = super.getPs("update aps_customer set cnickname=?,cname = ?,csex = ?,ctel = ?,cemail = ?,caddress = ? where ctid = ?");
			ps.setString(1, obj.getCnickname());
			ps.setString(2, obj.getCname());
			ps.setString(3, obj.getCsex());
			ps.setString(4, obj.getCtel());
			ps.setString(5, obj.getCemail());
			ps.setString(6, obj.getCaddress());
			ps.setString(7, obj.getCtid());
			bool = ps.executeUpdate() > 0;
			super.commit();
			
			/*
			 *跟新数据也写如日志 
			 */
			userLog.doSaveLog("更新用户："+obj.getCname());
			
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		return bool;
	}

}
