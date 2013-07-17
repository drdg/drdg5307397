package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Drange;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_Dpoint_Drange;
import com.aps.db.model._Dpoint;
import com.aps.db.model._Drange;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;

/**
 * 配送范围终点外键
 * @author Administrator
 *
 */
public class DrangeDAO extends GetSelectQurey implements Drange{

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doInster(_Drange alobj) {

		boolean bool = false;
		String sql = "insert into aps_drange values(sdii.nextval,?,?,?,?)";
		try {
			ps = super.getPs(sql);
			ps.setString(1, alobj.getFk_dpid());
			ps.setString(2, alobj.getDrend());
			ps.setString(3, alobj.getDrfkg());
			ps.setString(4, alobj.getDrokg());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}

	/**
	 * 这个地方查询的是视图，采用创建视图方式（右连接方式）
	 * SQL> create view v_dpoint_drange as select a.*,b.* from aps_dpoint a,aps_drange b where a.dpid = b.fk_dpid(+);
	 */
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<V_Dpoint_Drange> doSelect(FenPage page) {
		
		ArrayList<V_Dpoint_Drange> almodel = new ArrayList<V_Dpoint_Drange>();
		CopyLimit limit = new CopyLimit();
		boolean pdFp = false;
		try {
			rs = limit.doVLimit("v_dpoint_drange", "dpid", page.getPageNow(), limit.pageNum);
			while(rs.next()){
				V_Dpoint_Drange model = new V_Dpoint_Drange();
				_Dpoint dpoint = new _Dpoint();
				_Drange drange = new _Drange();
				
				//装载配送点信息
				dpoint.setDpid(rs.getString("dpid"));
				dpoint.setDppro(rs.getString("dppro"));
				dpoint.setDpaddress(rs.getString("dpaddress"));
				dpoint.setDptel(rs.getString("dptel"));
				dpoint.setDpemail(rs.getString("dpemail"));
				dpoint.setDpnote(rs.getString("dpnote"));
				dpoint.setDpname(rs.getString("dpname"));
				
				//装载到
				model.setDpoint(dpoint);
				
				//装载配送范围信息
				drange.setDrid(rs.getString("drid"));
				drange.setFk_dpid(rs.getString("fk_dpid"));
				drange.setDrend(rs.getString("drend"));
				drange.setDrfkg(rs.getString("drfkg"));
				drange.setDrokg(rs.getString("drokg"));
				
				//装载到
				model.setDrange(drange);
				
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());	//显示一共有多少条数据
					model.setPageNow(String.valueOf(Integer.valueOf(page.getPageNow())+1));				//当前页为第0页
					model.setPageNum(limit.pageNum);		//每页显示的 下面的 几个数字1 2 3 4 5
					model.setPageSize(limit.pageSize);	//每页大小，既是显示出来多少条
					model.setPageS(limit.doPageS());		//显示一共能分出来多少页
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
	public ArrayList<_Drange> doSelect(_Drange alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(_Drange obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 装载配送点信息到配送范围
	 */
	public ArrayList<_Dpoint> doGetPointToDrange(){
		
		ArrayList<_Dpoint> almodel = new ArrayList<_Dpoint>();
		try {
			rs = super.getPs("select DPID,DPNAME from aps_dpoint").executeQuery();
			while(rs.next()){
				_Dpoint model = new _Dpoint();
				model.setDpid(rs.getString("DPID"));
				model.setDpname(rs.getString("DPNAME"));
				almodel.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almodel;
	}
	
}
