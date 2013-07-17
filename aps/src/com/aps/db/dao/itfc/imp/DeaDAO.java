package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Dea;
import com.aps.db.model._Dea;
import com.aps.db.tem.GetSelectQurey;

/**
 * 配送点员工权限外键表
 * @author Administrator
 *
 */
public class DeaDAO extends GetSelectQurey implements Dea{

	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 向dea表写入数据
	 */
	public boolean doInster(_Dea alobj) {

		boolean bool = false;
		try {
			ps = super.getPs("insert into aps_dea values(sdii.nextval,?,?,?)");
			ps.setString(1, alobj.getFk_dpid());
			ps.setString(2, alobj.getFk_eid());
			ps.setString(3, alobj.getFk_auid());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public ArrayList<_Dea> doSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<_Dea> doSelect(ArrayList<_Dea> alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(ArrayList<_Dea> obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
