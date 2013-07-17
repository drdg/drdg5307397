package com.aps.servlet;
/*
 * 总公司
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.conn.OracleConn;
import com.aps.db.dao.itfc.imp.CarDAO;
import com.aps.db.dao.itfc.imp.V_PdLoginDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_PdLogin;
import com.aps.db.model._Car;
import com.aps.log.imp.UserLog;
import com.aps.servlet.methods.AuthorityServlet;
import com.aps.servlet.methods.CapacityServlet;
import com.aps.servlet.methods.CustomerServlet;
import com.aps.servlet.methods.DpointServlet;
import com.aps.servlet.methods.DrangeServlet;
import com.aps.servlet.methods.EirServlet;
import com.aps.servlet.methods.EmpServlet;
import com.aps.servlet.methods.OlistServlet;
import com.aps.servlet.methods.RouteServlet;
import com.aps.servlet.methods.SparameterServlet;
import com.dhls.factory.control.Main;

public class Corporation extends HttpServlet {

	private V_PdLoginDAO vpdDAO;
	private CarDAO carDAO;
	private UserLog userLog;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 获得传过来的type值，用以确定用户要执行什么操作
		 * 0表示登录
		 * 1 1 表示 car增加
		 * 1 4 表示 car查看
		 * 1 5 代表 car分页
		 * 1 6代表  car搜索
		 * 
		 * 2 1 表示route增加
		 * 3 1 表示dpoint增加
		 * ....
		 * */
		int type = Integer.parseInt(request.getParameter("type"));
		
		try {
			
			switch (type) {
			
			//验证登录
			case 0:
				empLogin(request,response);
				break;
			
			//车辆管理
			case 1:
				int key = Integer.valueOf(request.getParameter("key"));
				switch (key) {
				/*增加车辆*/
				case 1:
					doAddCar(request,response);
					break;
				/*删除车辆*/
				case 2:
					
					break;
				/*修改车辆*/	
				case 3:
					
					break;
				/*查看车辆*/
				case 4:
					doListCar(request,response);
					break;
				/*每次点击分页执行*/
				case 5:
					//获得要跳转的页
					doCarPage(request,response);
					break;
				/*搜索车辆*/
				case 6:
					doCarSelect(request,response);
					break;
				default:
					break;
				}
				break;
				
			//路线管理
			case 2:
				int key2 = Integer.valueOf(request.getParameter("key"));
				switch (key2) {
				/*添加*/
				case 1:
					RouteServlet.doAddRoute(request,response);
					break;
				/*删除*/
				case 2:
					break;
				/*修改*/	
				case 3:
					break;
				/*查看*/
				case 4:
					RouteServlet.doListRoute(request, response);
					break;
				/*执行分页*/
				case 5:
					RouteServlet.doPageRoute(request, response);
					break;
				/*把路线起点数据封装好到路线途经点处*/
				case 6:
					RouteServlet.doGetPointToRw(request,response);
					break;
				/*设置路线途经点*/
				case 7:
					RouteServlet.doInsertRw(request,response);
					break;
				default:
					break;
				}
				break;
				
			//配送点管理
			case 3:
				int key3 = Integer.valueOf(request.getParameter("key"));
				switch (key3) {
				/*增加*/
				case 1:
					DpointServlet.doAddRoute(request,response);
					break;
				/*删除*/
				case 2:
					break;
				/*修改*/
				case 3:
					break;
				/*查看*/
				case 4:
					DpointServlet.doListRoute(request, response);
					break;
				/*分页*/
				case 5:
					DpointServlet.doPageRoute(request, response);
					break;
				/*搜索*/
				case 6:
					break;
				/*详情视图多信息查看*/
				case 7:
					DpointServlet.doV_empDetail(request,response);
					break;
				default:
					break;
				}
				break;
			/*运力管理*/
			case 4:
				int key4 = Integer.valueOf(request.getParameter("key"));
				switch (key4) {
				/*增加运力*/
				case 1:
					CapacityServlet.doAddCapacity(request,response);
					break;
				/*删除运力*/
				case 2:
					break;
				/*修改运力*/
				case 3:
					break;
				/*查看运力*/
				case 4:
					CapacityServlet.doSelectAllPage(request,response);
					break;
				/*搜索运力*/
				case 5:
					break;
				/*为运力设置页面装载信息*/	
				case 6:
					CapacityServlet.doGetMessageToCorPage(request,response);
					break;
				default:
					break;
				}
				break;
			/*系统参数设置*/
			case 5:
				int key5 = Integer.valueOf(request.getParameter("key"));
				switch (key5) {
				//增加系统参数
				case 1:
					SparameterServlet.doAddSparameter(request,response);
					break;

				default:
					break;
				}
				break;
			/*员工管理*/
			case 6:
				int key6 = Integer.valueOf(request.getParameter("key"));
				switch (key6) {
				//增加员工
				case 1:
					EmpServlet.doAddEmp(request,response);
					break;
				//删除
				case 2:
					break;
				//修改
				case 3:
					break;
				//查看
				case 4:
					break;
				//分页
				case 5:
					EmpServlet.doPageRoute(request, response);
					break;
				//搜索
				case 6:
//					EmpServlet
					break;
				//扩充项
				case 7:
					
					break;
					
				default:
					break;
				}
				break;
			/*配送范围管理*/
			case 7:
				int key7 = Integer.valueOf(request.getParameter("key"));
				switch (key7) {
				//增加
				case 1:
					DrangeServlet.doAddDranger(request,response);
					break;
				//删除
				case 2:
					break;
				//修改
				case 3:
					
					break;
				//查看-直接分页方式就查看
				case 4:
					DrangeServlet.doPageDrange(request,response);
					break;
				//搜索-搜索到具体信息
				case 5:
					
					break;
				//组装信息到增加配送点范围页面
				case 6:
					DrangeServlet.addDpointToPage(request,response);
					break;
				default:
					break;
				}
				
				break;
			case 8:
				break;
			case 9:
				break;
			/*订单管理*/
			case 10:
				int key10 = Integer.valueOf(request.getParameter("key"));
				switch (key10) {
				//增加订单
				case 1:
					
					break;
				//删除订单
				case 2:
					
					break;
				//修改订单
				case 3:
					
					break;
				//查看订单
				case 4:
					OlistServlet.doSelectOnPage(request,response);
					break;
				//搜索订单
				case 5:
					
					break;
				default:
					break;
				}
				break;
			/*交接单管理*/
			case 11:
				int key11 = Integer.valueOf(request.getParameter("key"));
				switch (key11) {
				//增加交接单
				case 1:
					
					break;
				//删除交接单
				case 2:
					
					break;
				//修改交接单
				case 3:
					
					break;
				//查看交接单
				case 4:
					EirServlet.doSelectOnPage(request,response);
					break;
				default:
					break;
				}
				break;
			case 12:
				Main.doDownHtml(request,response);
				break;
			/*权限管理*/
			case 13:
				int key13 = Integer.valueOf(request.getParameter("key"));
				switch (key13) {
				/*增加权限*/
				case 1:
					AuthorityServlet.doAddAuthority(request,response);
					break;
				/*删除*/
				case 2:
					break;
				/*修改*/
				case 3:
					break;
				/*查看以分页方式*/
				case 4:
					AuthorityServlet.doSelect(request,response);
					break;
				/*授权*/
				case 5:
					AuthorityServlet.doGrantTo(request,response);
					break;
				/*查看信息给授权页面*/
				case 6:
					AuthorityServlet.doSelectAll(request,response);
					break;
				default:
					break;
				}
				break;
			/*客户管理*/
			case 14:
				int key14 = Integer.valueOf(request.getParameter("key"));
				switch (key14) {
				//增加客户
				case 1:
					CustomerServlet.doAddCustomer(request,response);
					break;
				//删除
				case 2:
					CustomerServlet.doDeleteCustomerById(request,response);
					break;
				//修改
				case 3:
					CustomerServlet.doUpdateCustomer(request,response);
					break;
				//查看
				case 4:
					CustomerServlet.doSelectOnPage(request,response);
					break;
				//搜索	
				case 5:
					break;
				default:
					break;
				}
				break;
			case 15:
				break;
			case 16:
				break;
			default:
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 根据条件进行查询
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doCarSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 分析传递过来串的信息
		 * 并对应的组合起来
		 * */
		String str = request.getParameter("sosotext");
		String regex = "([\u4E00-\u9FA5]{2,5})[：](.*?)、";
		Matcher mc = Pattern.compile(regex).matcher(str);
		_Car carsoso = new _Car();
		
		if(str.matches(regex)){
			//高级搜索
			carsoso.setStype(true);
			while(mc.find()){
				
				if("车牌号".equals(mc.group(1))){
					carsoso.setCbrand(mc.group(2));
				}
				if("型号".equals(mc.group(1))){
					carsoso.setCmodel(mc.group(2));
				}
				if("产地".equals(mc.group(1))){
					carsoso.setCorigin(mc.group(2));
				}
				if("出厂时间".equals(mc.group(1))){
					carsoso.setCpripal(mc.group(2));
				}
				if("购车时间".equals(mc.group(1))){
					carsoso.setCbuy(mc.group(2));
				}
				if("购车负责人".equals(mc.group(1))){
					carsoso.setCpripal(mc.group(2));
				}
				if("体积".equals(mc.group(1))){
					carsoso.setCvolume(mc.group(2));
				}
				if("容量".equals(mc.group(1))){
					carsoso.setCapac(mc.group(2));
				}
			}
		}else{
			//普通搜索
			str = str.replace("、", "");
			carsoso.setStype(false);
			carsoso.setCbrand(str);
			carsoso.setCmodel(str);
			carsoso.setCorigin(str);
			carsoso.setCproduce(str);
			carsoso.setCbuy(str);
			carsoso.setCpripal(str);
			carsoso.setCvolume(str);
			carsoso.setCapac(str);
		}
	
		/*调用搜索函数*/
		request.setAttribute("alcar", carDAO.doSelect(carsoso));
		request.getRequestDispatcher("ZzCorporation/car/car_list.jsp").forward(request, response);
	}
	/****************************
	 * 查询车辆并且分页分出来
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 ****************************/
	private void doCarPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FenPage fpage = new FenPage();
		fpage.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("alcar", carDAO.doSelectPage(fpage));
		request.getRequestDispatcher("ZzCorporation/car/car_list.jsp").forward(request, response);
	}
	/*****************
	 * 查看车辆
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 *****************/
	private void doListCar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("alcar", carDAO.doSelect());
		request.getRequestDispatcher("ZzCorporation/car/car_list.jsp").forward(request, response);
		
	}

	/*******************
	 * 增加车辆的一个方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 *******************/
	private void doAddCar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		_Car car = new _Car();
		car.setCbrand(request.getParameter("cbrand"));
		car.setCmodel(request.getParameter("cmodel"));
		car.setCorigin(request.getParameter("tid1")+request.getParameter("tid2")+request.getParameter("tid3"));
		car.setCproduce(request.getParameter("cproduce"));
		car.setCbuy(request.getParameter("cbuy"));
		car.setCpripal(request.getParameter("cpripal"));
		car.setCvolume(request.getParameter("cvolume"));
		car.setCapac(request.getParameter("capac"));
		
		ArrayList<_Car> alc = new ArrayList<_Car>();
		alc.add(car);
		
		/*执行插入函数，并验证插入是否正确*/
		if(carDAO.doInster(alc)){
			//插入成功
			System.out.println("ok");
			//跳转到查询页面
			doListCar(request,response);
		}else{
			//插入失败
			System.out.println("error");
			//插入失败就进入提示页面
		}
	}

	/***************
	 * 验证员工登录
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException 
	 ***************/
	private void empLogin(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		V_PdLogin vpl = new V_PdLogin();
		
		vpl.setEid(request.getParameter("vid"));
		vpl.setEname(request.getParameter("vname"));
		/*执行登录验证操作*/
		vpl = vpdDAO.doLogin(vpl);
		
		if(!vpl.getDpid().equals("0")){
			System.out.println("登录成功");
			//如果权限为2说明是总公司管理员
			if("2".equals(vpl.getAuno())){
				request.getSession().setAttribute("vpl", vpl);
				response.sendRedirect("ZzCorporation/index.jsp");
				//写入日志
				userLog.doSaveLog("登录人："+vpl.getEname());
		
				//如果权限为3则说明是配送点管理员
			}else if("3".equals(vpl.getAuno())){
				request.getSession().setAttribute("vpl", vpl);
				response.sendRedirect("ZzBranch/index.jsp");
				
				//写入日志
				userLog.doSaveLog("登录人："+vpl.getEname());
			}
			
		}else{
			System.out.println("登录失败");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void destroy() {
		/*
		 * 销毁后，关闭数据库资源
		 * */
		OracleConn.CloseConn();
	}
	/*初始化*/
	public void init() throws ServletException {
		vpdDAO = new V_PdLoginDAO();
		carDAO = new CarDAO();
		userLog = UserLog.getUserLogSingleton();
	}
}
