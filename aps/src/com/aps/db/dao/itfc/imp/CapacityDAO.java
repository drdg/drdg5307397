package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Capacity;
import com.aps.db.model.CapacityS;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_Capacitys;
import com.aps.db.model.V_EmpDetail;
import com.aps.db.model._Capacity;
import com.aps.db.model._Car;
import com.aps.db.model._Dpoint;
import com.aps.db.model._Drange;
import com.aps.db.model._Emp;
import com.aps.db.model._Route;
import com.aps.db.model._Rw;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;

/**
 * 运力表
 * @author Administrator
 */
public class CapacityDAO extends GetSelectQurey implements Capacity{

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 添加运力
	 */
	public boolean doInster(_Capacity alobj) {
		
		boolean bool = false;
		try {
			ps = super.getPs("insert into aps_capacity values(sdii.nextval,?,?,?,?,?)");
			ps.setString(1, alobj.getFk_dpid());
			ps.setString(2, alobj.getFk_rtid());
			ps.setString(3, alobj.getFk_cid());
			ps.setString(4, alobj.getFk_eid());
			ps.setString(5, alobj.getCapstate());
			bool = ps.executeUpdate() > 0;
			super.commit();
			
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		return bool;
	}

	
	@Override
	public ArrayList<V_Capacitys> doSelect(FenPage page) {
		
		ArrayList<V_Capacitys> almodel = new ArrayList<V_Capacitys>();
		/*判断用以第一次取数据库信息时候把分页信息加载进去*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doVLimit("v_capacitys", "DPTEL", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				V_Capacitys model = new V_Capacitys();
				model.setDpname(rs.getString("DPNAME"));
				model.setDpaddress(rs.getString("DPADDRESS"));
				model.setDptel(rs.getString("DPTEL"));
				model.setRtname(rs.getString("RTNAME"));
				model.setRtspoint(rs.getString("RTSPOINT"));
				model.setCbrand(rs.getString("CBRAND"));
				model.setCmodel(rs.getString("CMODEL"));
				model.setEname(rs.getString("ENAME"));
				model.setEphone(rs.getString("EPHONE"));
				model.setCapastate(rs.getString("CAPSTATE"));
				
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());	//显示一共有多少条数据
					model.setPageNow(String.valueOf(Integer.valueOf(page.getPageNow()) + 1));	//当前页为第0页
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
	public ArrayList<_Capacity> doSelect(_Capacity alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(_Capacity obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 装载信息 
	 */
	public ArrayList<CapacityS> doGetAllToCap() {
		
		ArrayList<CapacityS> almodel = new ArrayList<CapacityS>();
		
		try {
			//配送点与配送范围
			ps = super.getPs("select DPID,DPADDRESS,DPNAME,DRID,DREND from v_dpoint_drange");
			rs = ps.executeQuery();
			while(rs.next()){
				CapacityS capacitys = new CapacityS();
				_Dpoint dpoint = new _Dpoint();
				_Drange drange = new _Drange();
				
				dpoint.setDpid(rs.getString("DPID"));
				dpoint.setDpname(rs.getString("DPNAME"));
				dpoint.setDpaddress(rs.getString("DPADDRESS"));
				
				drange.setDrid(rs.getString("DRID"));
				drange.setDrend(rs.getString("DREND"));
				
				capacitys.setDpoint(dpoint);
				capacitys.setDrange(drange);
				
				almodel.add(capacitys);
			}
			//路线与路线途经点
			ps = super.getPs("select RTID,RTNAME,RWID,RWROUTEND from v_route_rw");
			rs = ps.executeQuery();
			while(rs.next()){
				CapacityS capacitys = new CapacityS();
				_Route route = new _Route();
				_Rw rw = new _Rw();
				
				route.setRtid(rs.getString("RTID"));
				route.setRtname(rs.getString("RTNAME"));
				
				rw.setRwid(rs.getString("RWID"));
				rw.setRwroutend(rs.getString("RWROUTEND"));
				
				capacitys.setRoute(route);
				capacitys.setRw(rw);
				almodel.add(capacitys);
			}
			//车辆信息
			ps = super.getPs("select CID,CBRAND,CMODEL from aps_car b where b.cid in (select max(a.cid) from aps_car a group by a.cbrand)");
			rs = ps.executeQuery();
			while(rs.next()){
				CapacityS capacitys = new CapacityS();
				_Car car = new _Car();
				car.setCid(rs.getString("CID"));
				car.setCbrand(rs.getString("CBRAND"));
				car.setCmodel(rs.getString("CMODEL"));
				capacitys.setCar(car);
				almodel.add(capacitys);
			}
			
			
			//员工信息(选出来职位是司机)
			ps = super.getPs("select a.eid,max(ENAME) ename,max(EPHONE) ephone,max(DPNAME) dpname from v_empdetail a group by a.eid");
			//select a.eid,max(ENAME),max(EPHONE),max(DPNAME) from v_empdetail a group by a.eid;
			rs = ps.executeQuery();
			while(rs.next()){
				CapacityS capacitys = new CapacityS();
				_Emp emp = new _Emp();
				_Dpoint dpoint = new _Dpoint();
				V_EmpDetail empdetail = new V_EmpDetail();
				
				emp.setEid(rs.getString("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setEphone(rs.getString("ephone"));
				dpoint.setDpname(rs.getString("dpname"));
				
				empdetail.setEmp(emp);
				empdetail.setDpoint(dpoint);
				
				capacitys.setEmpDetail(empdetail);
				
				almodel.add(capacitys);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return almodel;
	}

}
