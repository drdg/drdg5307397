package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Emp;
import com.aps.db.model.FenPage;
import com.aps.db.model._Authority;
import com.aps.db.model._Dpoint;
import com.aps.db.model._Drange;
import com.aps.db.model._Emp;
import com.aps.db.model._Route;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;
import com.aps.email.SendEmail;
import com.aps.log.imp.UserLog;

/**
 * 员工表
 * @author Administrator
 *
 */
public class EmpDAO extends GetSelectQurey implements Emp{

	private PreparedStatement ps;
	private ResultSet rs;
	private UserLog userLog = UserLog.getUserLogSingleton();
	private SendEmail sendEmail = new SendEmail();
	
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 插入员工
	 */
	public boolean doInster(_Emp alobj) {
		boolean bool = false;
		String sql = "insert into aps_emp values(sdii.nextval,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		try {
			ps = super.getPs(sql);
			ps.setString(1, alobj.getEname());
			ps.setString(2, alobj.getEsex());
			ps.setString(3, alobj.getEage());
			ps.setString(4, alobj.getEbirthday());
			ps.setString(5, alobj.getEpa());
			ps.setString(6, alobj.getEaddress());
			ps.setString(7, alobj.getEphone());
			ps.setString(8, alobj.getEemail());
			ps.setString(9, alobj.getEpost());
			ps.setString(10, alobj.getEdept());
			ps.setString(11, alobj.getEindate());
			ps.setString(12, alobj.getEsal());
			ps.setString(13, alobj.getEstate());
			ps.setString(14, alobj.getEnote());
			bool = ps.executeUpdate() > 0;
			super.commit();
			
			//写入日志
			userLog.doSaveLog("增加了一个新员工："+alobj.getEname());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// error 调用父类方法回滚
			super.rollback();
		}
		return bool;
	}

	/**
	 * 查询并且分页方式返回回去
	 */
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<_Emp> doSelect(FenPage page) {
		ArrayList<_Emp> almodel = new ArrayList<_Emp>();
		/*判断用以第一次取数据库信息时候把分页信息加载进去*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_emp", "eid", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				_Emp model = new _Emp();
				//员工
				model.setEid(rs.getString("eid"));
				model.setEname(rs.getString("ename"));
				model.setEsex(rs.getString("esex"));
				model.setEage(rs.getString("eage"));
				model.setEbirthday(rs.getString("ebirthday"));
				model.setEpa(rs.getString("epa"));
				model.setEaddress(rs.getString("eaddress"));
				model.setEphone(rs.getString("ephone"));
				model.setEemail(rs.getString("eemail"));
				model.setEpost(rs.getString("epost"));
				model.setEdept(rs.getString("edept"));
				model.setEindate(rs.getString("edindate"));
				model.setEsal(rs.getString("esal"));
				model.setEstate(rs.getString("estate"));
				model.setEnote(rs.getString("enote"));
				
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

	@Override
	public ArrayList<_Emp> doSelect(_Emp alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(_Emp obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 找回用户密码
	 * @return
	 */
	public String doFindUserPwd(String cname){
		StringBuffer sbUser = new StringBuffer();
		String email = "",callback = "";
		try {
			ps = super.getPs("select eemail from aps_emp where ename = ?");
			ps.setString(1, cname);
			rs = ps.executeQuery();
			
			if(rs.next()){
				sbUser.append("尊敬的用户您好，请保管好您的密码--爱配送<br/>");
				sbUser.append("用户名："+cname+"<br/>");
				email = rs.getString("eemail");
				ps = super.getPs("select dpid from pdlogin where ename = ?");
				ps.setString(1, cname);
				rs = ps.executeQuery();
				
				if(rs.next()){
					sbUser.append("权限码："+rs.getString("dpid")+"<br/>");
					
					//发送邮件
					sendEmail.doSendHtmlEmail("爱配送系统邮件", sbUser, email);
					
					callback = "您的密码，已经发送到您注册时候的邮箱，请注意查收！";
				}else{
					callback = "你是没有权限登录的用户，请找管理员授权！";
				}
				
			}else{
				callback = "宝贝，这是一个不存在的用户！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return callback;
		
	}
}
