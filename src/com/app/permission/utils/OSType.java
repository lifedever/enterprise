package com.app.permission.utils;

import java.util.regex.Pattern;

public enum OSType {
	WINDOWS,MAC,LINUX,UNIX;
	
	public static OSType getCurrentOsType(){
		 OSType osType = null;
		 String osName = System.getProperty("os.name"); 
		 if (Pattern.matches("Linux.*", osName)) {  
			 osType = OSType.LINUX;
		 }else if (Pattern.matches("Windows.*", osName)){
			 osType = OSType.WINDOWS;
		 }else if (Pattern.matches("Mac.*", osName)){
			 osType = OSType.MAC;
		 }else if (Pattern.matches("Unix.*",osName)){
			 osType = OSType.UNIX;
		 }
		 return osType;
		 
	}
}
