package com.app.permission.utils;

import java.util.ArrayList;
import java.util.List;

/** SQL或HQL相关查询语句的工具类
 * @author sindTom
 *
 */
public class QlUtils {
	
	public static final String OP_LIKE = "like";
	
	public static final String OP_EQ = "eq";
	
	public static final String OP_LT = "lt";
	
	public static final String OP_LE = "le";
	
	public static final String OP_GT = "gt";
	
	public static final String OP_GE = "ge";
	
	public static final String LINK_AND = "and";
	
	public static final String LINK_OR = "or";
	
	private static List<String> operators;
	
	static {
		operators = new ArrayList<String>();
		operators.add(OP_LIKE);
		operators.add(OP_EQ);
		operators.add(OP_EQ);
		operators.add(OP_LT);
		operators.add(OP_LE);
		operators.add(OP_GT);
		operators.add(OP_GE);
	}
	
	public static boolean isOperator(String value){
		return operators.contains(value);
	}
	
	 
	
	
}
