package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Eir;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_Eirs;
import com.aps.db.model._Eir;
import com.aps.db.tem.CopyLimit;

/**
 * 交接单
 * @author Administrator
 *
 */
public class EirDAO implements Eir{

	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * 通过id删除数据
	 */
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 插入数据
	 */
	public boolean doInster(_Eir alobj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 以分页的方式显示订单信息
	 */
	@SuppressWarnings("static-access")
	public ArrayList<V_Eirs> doSelect(FenPage page) {
		
		ArrayList<V_Eirs> almodel = new ArrayList<V_Eirs>();
		/*判断用以第一次取数据库信息时候把分页信息加载进去*/
		boolean pdFp = false;
		CopyLimit limit = new CopyLimit();
		
		try {
			rs = limit.doVLimit("v_eirs", "DPID", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				V_Eirs model = new V_Eirs();
				
				//装载配送点信息
				model.setDpid(rs.getString("dpid"));
				model.setDpname(rs.getString("dpname"));
				model.setDptel(rs.getString("dptel"));
				
				//装载路线信息
				model.setRtid(rs.getString("rtid"));
				model.setRtname(rs.getString("rtname"));
				model.setRtspoint(rs.getString("rtspoint"));
				
				//装载车辆信息
				model.setCid(rs.getString("cid"));
				model.setCbrand(rs.getString("cbrand"));
				
				//装载员工信息
				model.setEid(rs.getString("eid"));
				model.setEname(rs.getString("ename"));
				model.setEphone(rs.getString("ephone"));
				
				//运力表id
				model.setCapid(rs.getString("capid"));
				
				//装载订单信息
				model.setOlid(rs.getString("olid"));
				model.setOlno(rs.getString("olno"));
				model.setOlname(rs.getString("olname"));
				model.setOlsendtel(rs.getString("olsendtel"));
				model.setOlsendaddress(rs.getString("olsendaddress"));
				model.setOlsendcode(rs.getString("olsendcode"));
				model.setOlsendemail(rs.getString("olsendemail"));
				model.setOlinname(rs.getString("olinname"));
				model.setOlintel(rs.getString("olintel"));
				model.setOlinaddress(rs.getString("olinaddress"));
				model.setOlincode(rs.getString("olincode"));
				model.setOlgoodsname(rs.getString("olgoodsname"));
				model.setOlgoodstype(rs.getString("olgoodstype"));
				model.setOlgoodsum(rs.getString("olgoodsnum"));
				model.setOlgoodsweight(rs.getString("olgoodsweight"));
				model.setOlgoodsaddress(rs.getString("olgoodsaddress"));
				model.setOldate(rs.getString("oldate"));
				model.setOlingoodsadd(rs.getString("olingoodsadd"));
				model.setOlins(rs.getString("olins"));
				model.setOlsnotice(rs.getString("olsnotice"));
				model.setOlpays(rs.getString("olpays"));
				model.setOlnote(rs.getString("olnote"));
				
				//交接单id
				model.setEirid(rs.getString("eirid"));
				
				//分页信息
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());										//显示一共有多少条数据
					model.setPageNow(String.valueOf(Integer.valueOf(page.getPageNow()) + 1));	//当前页为第几页
					model.setPageNum(limit.pageNum);											//每页显示的 下面的 几个数字1 2 3 4 5
					model.setPageSize(limit.pageSize);											//每页大小，既是显示出来多少条
					model.setPageS(limit.doPageS());											//显示一共能分出来多少页
					pdFp = true;
				}
				//装入集合
				almodel.add(model);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return almodel;
	}

	/**
	 * 搜索方式查看并且给予分页
	 */
	public ArrayList<_Eir> doSelect(_Eir page) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 更新数据
	 */
	public boolean doUpdate(_Eir obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
