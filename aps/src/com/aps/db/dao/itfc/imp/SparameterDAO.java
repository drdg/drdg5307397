package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Sparameter;
import com.aps.db.model._Sparameter;
import com.aps.db.tem.GetSelectQurey;

/**
 * 
 * @author Administrator
 *
 */
public class SparameterDAO extends GetSelectQurey implements Sparameter{

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ²åÈëÊý¾Ý
	 */
	@Override
	public boolean doInster(_Sparameter alobj) {
		boolean bool = false;
		try {
			ps = super.getPs("insert into aps_sparameter values(sdii.nextval,?,?,?,?,?)");
			ps.setString(1, alobj.getSpinto());
			ps.setString(2, alobj.getSpof());
			ps.setString(3, alobj.getSpdeletetime());
			ps.setString(4, alobj.getSpfirstkg());
			ps.setString(5, alobj.getSpfirstvo());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			super.rollback();
		}
		return bool;
	}

	@Override
	public ArrayList<_Sparameter> doSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<_Sparameter> doSelect(ArrayList<_Sparameter> alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(ArrayList<_Sparameter> obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
