package org.test.util;

public class StringUtil {
	public static boolean isEmpty(String a){
		if(a == null||"".equals(a.trim())){
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(String a){
		return !isEmpty(a);
	}
}
