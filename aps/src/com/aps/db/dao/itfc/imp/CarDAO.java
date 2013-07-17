package com.aps.db.dao.itfc.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.aps.db.conn.OracleConn;
import com.aps.db.dao.itfc.Car;
import com.aps.db.model.FenPage;
import com.aps.db.model._Car;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;

/**
 * 车辆管理
 * @author Administrator
 *
 */
public class CarDAO extends GetSelectQurey implements Car{
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *为了将来扩展，可以多条数据插入 
	 **/
	@Override
	public boolean doInster(ArrayList<_Car> alobj) {
		
		boolean bool = false;
		String sql = "insert into aps_car values(" +
					 "sdii.nextval,?,?,?,to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),?,?,?)";
		
		try {
			conn = OracleConn.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			
			for(_Car c:alobj){
				ps.setString(1, c.getCbrand());
				ps.setString(2, c.getCmodel());
				ps.setString(3, c.getCorigin());
				ps.setString(4, c.getCproduce());
				ps.setString(5, c.getCbuy());
				ps.setString(6, c.getCpripal());
				ps.setString(7, c.getCvolume());
				ps.setString(8, c.getCapac());
				if(ps.executeUpdate()>0){
					bool = true;
				}
			}
			//提交
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//出错回滚
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return bool;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<_Car> doSelect() {
		ArrayList<_Car> alcar = new ArrayList<_Car>();
		/*判断用以第一次取数据库信息时候把分页信息加载进去*/
		boolean pdFp = false;
		
		try {
			/**
			 * 默认分页
			 * cid	cbrand	cmodel	corigin	cproduce	cbuy	cpripal	cvolume	capac
			 * */
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_car", "cid", "1", "5");
			
			while(rs.next()){
				_Car car = new _Car();
				car.setCid(rs.getString(1));
				car.setCbrand(rs.getString(2));
				car.setCmodel(rs.getString(3));
				car.setCorigin(rs.getString(4));
				car.setCproduce(rs.getString(5));
				car.setCbuy(rs.getString(6));
				car.setCpripal(rs.getString(7));
				car.setCvolume(rs.getString(8));
				car.setCapac(rs.getString(9));
				
				if(!pdFp){
					limit.doCount();
					car.setPageCount(limit.doCount());	//显示一共有多少条数据
					car.setPageNow("1");				//当前页为第0页
					car.setPageNum(limit.pageNum);		//每页显示的 下面的 几个数字1 2 3 4 5
					car.setPageSize(limit.pageSize);	//每页大小，既是显示出来多少条
					car.setPageS(limit.doPageS());		//显示一共能分出来多少页
					pdFp = true;
				}
				
				alcar.add(car);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alcar;
	}
	
	/**
	 * 根据条件查询信息
	 */
	@Override
	public ArrayList<_Car> doSelect(_Car car) {
		
		ArrayList<_Car> alcar = new ArrayList<_Car>();
		CopyLimit limit = new CopyLimit();
		int setstart = 1;
		/**
		 *如果这两个相成立为true表示是模糊查询
		 *但是如果为false表示是精确查询 
		 **/
		boolean pdstype = car.isStype();
		StringBuffer sbsql = new StringBuffer("select * from aps_car where ");
		if(pdstype){
			if(car.getCbrand() != null){
				sbsql.append("cbrand = ? and ") ;
			}
			if(car.getCmodel() != null){
				sbsql.append("cmodel = ? and ");
			}
			if(car.getCorigin() != null){
				sbsql.append("corigin = ? and ");
			}
			if(car.getCproduce() != null){
				sbsql.append("cproduce = ? and ");
			}
			if(car.getCbuy()!= null){
				sbsql.append("cbuy = ? and ");
			}
			if(car.getCpripal() != null){
				sbsql.append("cpripal = ? and ");
			}
			if(car.getCvolume() != null){
				sbsql.append("cvolume = ? and ");
			}
			if(car.getCapac() != null){
				sbsql.append("capac = ?");
			}else if(pdstype){
				sbsql.replace(sbsql.lastIndexOf("and"),sbsql.length()-1, "");
			}
		}else{
			sbsql.append("cbrand like ? or" +
					     " cmodel like ? or" +
					     " corigin like ? or" +
					     " cproduce like ? or" +
					     " cbuy like ? or" +
					     " cpripal like ? or" +
					     " cvolume like ? or" +
					     " capac like ?");
		}
		 System.out.println(sbsql.toString());
		try {
			ps = super.getPs(sbsql.toString());
			/**
			 *？号设置值 
			 **/
			if(pdstype){
				if(car.getCbrand()!= null){
					ps.setString(setstart, car.getCbrand());
					setstart ++;
				}
				if(car.getCmodel() != null){
					ps.setString(setstart, car.getCmodel());
					setstart ++;
				}
				if(car.getCorigin() != null){
					ps.setString(setstart, car.getCorigin());
					setstart ++;
				}
				if(car.getCproduce() != null){
					ps.setString(setstart, car.getCproduce());
					setstart ++;
				}
				if(car.getCbuy()!= null){
					ps.setString(setstart, car.getCbuy());
					setstart ++;
				}
				if(car.getCpripal() != null){
					ps.setString(setstart, car.getCpripal());
					setstart ++;
				}
				if(car.getCvolume() != null){
					ps.setString(setstart, car.getCvolume());
					setstart ++;
				}
				if(car.getCapac() != null){
					ps.setString(setstart, car.getCapac());
					setstart ++;
				}
			}else{
				ps.setString(1, "%"+car.getCbrand()+"%");
				ps.setString(2, "%"+car.getCmodel()+"%");
				ps.setString(3, "%"+car.getCorigin()+"%");
				ps.setString(4, "%"+car.getCproduce()+"%");
				ps.setString(5, "%"+car.getCbuy()+"%");
				ps.setString(6, "%"+car.getCpripal()+"%");
				ps.setString(7, "%"+car.getCvolume()+"%");
				ps.setString(8, "%"+car.getCapac()+"%");
			}
			
			rs = ps.executeQuery();
			int rssum = 0;
			boolean pdFp = false;
			
			while(rs.next()){
				_Car cars = new _Car();
				cars.setCbrand(rs.getString(2));
				cars.setCmodel(rs.getString(3));
				cars.setCorigin(rs.getString(4));
				cars.setCproduce(rs.getString(5));
				cars.setCbuy(rs.getString(6));
				cars.setCpripal(rs.getString(7));
				cars.setCvolume(rs.getString(8));
				cars.setCapac(rs.getString(9));
				/*分页信息装进去*/
				if(!pdFp){
					limit.setTable("aps_car");
					cars.setPageCount(limit.doCount());	//显示一共有多少条数据
					cars.setPageNow("1");				//当前页为第0页
					cars.setPageNum(limit.pageNum);		//每页显示的 下面的 几个数字1 2 3 4 5
					cars.setPageSize(limit.pageSize);	//每页大小，既是显示出来多少条
					cars.setPageS(limit.doPageS());		//显示一共能分出来多少页
					pdFp = true;
				}
				alcar.add(cars);
				
				/**
				 * 如果装进去10个数据了，就不在装了
				 */
				if(rssum >= 10){
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alcar;
	}

	@Override
	public boolean doUpdate(ArrayList<_Car> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 分页效果查询
	 * */
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<_Car> doSelectPage(FenPage fpage) {
		// TODO Auto-generated method stub
		ArrayList<_Car> alcar = new ArrayList<_Car>();
		/*判断用以第一次取数据库信息时候把分页信息加载进去*/
		boolean pdFp = false;
		
		try {
			/**
			 * 默认分页
			 * cid	cbrand	cmodel	corigin	cproduce	cbuy	cpripal	cvolume	capac
			 * */
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_car", "cid", fpage.getPageNow(), CopyLimit.pageSize);
			
			while(rs.next()){
				_Car car = new _Car();
				car.setCid(rs.getString(1));
				car.setCbrand(rs.getString(2));
				car.setCmodel(rs.getString(3));
				car.setCorigin(rs.getString(4));
				car.setCproduce(rs.getString(5));
				car.setCbuy(rs.getString(6));
				car.setCpripal(rs.getString(7));
				car.setCvolume(rs.getString(8));
				car.setCapac(rs.getString(9));
				
				if(!pdFp){
					limit.doCount();
					car.setPageCount(limit.doCount());										//显示一共有多少条数据
					car.setPageNow(String.valueOf(Integer.valueOf(fpage.getPageNow()) + 1));//当前页为第几页
					car.setPageNum(limit.pageNum);											//每页显示的 下面的 几个数字1 2 3 4 5
					car.setPageSize(limit.pageSize);										//每页大小，既是显示出来多少条
					car.setPageS(limit.doPageS());											//显示一共能分出来多少页
					pdFp = true;
				}
				
				alcar.add(car);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alcar;
	}

}
