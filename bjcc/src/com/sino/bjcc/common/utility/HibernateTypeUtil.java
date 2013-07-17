package com.sino.bjcc.common.utility;

import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

public class HibernateTypeUtil {

	@SuppressWarnings("deprecation")
	public static Type matchHibernateType(java.lang.reflect.Type jType){
		if(Byte.TYPE == jType){
			return Hibernate.BYTE;
		}
		if(Character.TYPE== jType){
			return Hibernate.CHARACTER;
		}
		if(Short.TYPE == jType){
			return Hibernate.SHORT;
		}
		if(Integer.TYPE == jType){
			return Hibernate.INTEGER;
		}
		if(Long.TYPE == jType){
			return Hibernate.LONG;
		}
		if(Float.TYPE == jType){
			return Hibernate.FLOAT;
		}
		if(Double.TYPE == jType){
			return Hibernate.DOUBLE;
		}
		if(Date.class == jType){
			return Hibernate.DATE;
		}
		if(String.class == jType){
			return Hibernate.STRING;
		}
		return null;
	}
	
}
