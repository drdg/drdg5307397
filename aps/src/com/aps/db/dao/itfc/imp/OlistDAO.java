package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Olist;
import com.aps.db.model.FenPage;
import com.aps.db.model._Olist;
import com.aps.db.model._Route;
import com.aps.db.tem.CopyLimit;

/**
 * 订单
 * @author Administrator
 *
 */
public class OlistDAO implements Olist{

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doInster(_Olist alobj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 以分页的方式查看订单
	 */
	@SuppressWarnings("static-access")
	public ArrayList<_Olist> doSelect(FenPage page) {
		
		ArrayList<_Olist> almodel = new ArrayList<_Olist>();
		/*判断用以第一次取数据库信息时候把分页信息加载进去*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_olist", "olid", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				_Olist model = new _Olist();
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
				model.setOlgoodsnum(rs.getString("olgoodsnum"));
				model.setOlgoodsweight(rs.getString("olgoodsweight"));
				model.setOlgoodsaddress(rs.getString("olgoodsaddress"));
				model.setOldate(rs.getString("oldate"));
				model.setOlingoodsadd(rs.getString("olingoodsadd"));
				model.setOlins(rs.getString("olins"));
				model.setOlsnotice(rs.getString("olsnotice"));
				model.setOlpays(rs.getString("olpays"));
				model.setOlnote(rs.getString("olnote"));
				
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
	public ArrayList<_Olist> doSelect(_Olist alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(_Olist obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
