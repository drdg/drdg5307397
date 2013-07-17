package com.aps.db.model;

/**
 * 此vo包括：配送点、配送范围、路线、路线途经点、员工（司机）
 * @author 付政委
 */
public class CapacityS {

	private _Dpoint 	dpoint;			//配送点
	private _Drange 	drange;			//配送范围
	private _Route 		route;			//路线
	private _Rw 		rw;				//路线途经点
	private _Car 		car;			//车辆
	private V_EmpDetail empDetail;		//员工详细信息
	
	public _Dpoint getDpoint() {
		return dpoint;
	}
	public void setDpoint(_Dpoint dpoint) {
		this.dpoint = dpoint;
	}
	public _Drange getDrange() {
		return drange;
	}
	public void setDrange(_Drange drange) {
		this.drange = drange;
	}
	public _Route getRoute() {
		return route;
	}
	public void setRoute(_Route route) {
		this.route = route;
	}
	public _Rw getRw() {
		return rw;
	}
	public void setRw(_Rw rw) {
		this.rw = rw;
	}
	public V_EmpDetail getEmpDetail() {
		return empDetail;
	}
	public void setEmpDetail(V_EmpDetail empDetail) {
		this.empDetail = empDetail;
	}
	public _Car getCar() {
		return car;
	}
	public void setCar(_Car car) {
		this.car = car;
	}
}
