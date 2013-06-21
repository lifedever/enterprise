package com.app.permission.utils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

/**业务中常用的字符串处理工具类
 * @author sindTom
 *
 */
public class StrUtils {
	
	
	/**
	 * 将字符用双引号包括
	 * 
	 * @param string
	 *            字符串
	 * @return 添加双引号后的字符
	 */
	public static String quoteString(String string) {
		return new StringBuffer().append("\"").append(string).append("\"")
				.toString();
	}
	

	/**
	 * 用指定字符 将传入的字符串包括
	 * 
	 * @param string
	 *            字符串
	 * @param c1
	 *            左字符
	 * @param c2
	 *            右字符
	 * @return String
	 */
	public static String quoteString(String string, char c1, char c2) {
		return new StringBuffer().append(c1).append(string).append(c2)
				.toString();
	}

	/**
	 * 用指定字符 将传入的字符串包括
	 * 
	 * @param string
	 *            字符串
	 * @param c
	 *            包括字符 如（单引号，双引号）;
	 * @return String
	 */
	public static String quoteString(String string, char c) {
		return new StringBuffer().append(c).append(string).append(c).toString();
	}
	
	public static String quoteString(String string, String c) {
		return new StringBuffer().append(c).append(string).append(c).toString();
	}
	
	
	
	/**
	 * 获取字符串文件路径 (已放弃，建议使用FilenameUtils)
	 * 
	 * @param fileName
	 * @param delimiter
	 * @return
	 */
	@Deprecated
	public static String getFilePath(String fileName) {
		int pos = fileName.lastIndexOf(File.pathSeparator);
		if (pos != -1)
			return fileName.substring(0, pos);
		else
			return fileName;
	}
	
	/**获取文件后缀 
	 * @param fileName
	 * @return
	 */
	public static String getFileExtension(String fileName){
		String fileType = fileName.substring(fileName.lastIndexOf("."),fileName.length());
		return fileType;
	}
	
	/** 将字符串的首字母大写
	 * @param str
	 * @return
	 */
	public static String upperFirst(String str){
		String result = str;
		if (str!=null){
			result = str.substring(0,1).toUpperCase() + str.substring(1);
		}
		return result;
	}
	
	/** 将字符串的首字母小写
	 * @param str
	 * @return
	 */
	public static String lowerFirst(String str){
		String result = str;
		if (str!=null){
			result = str.substring(0,1).toLowerCase() + str.substring(1);
		}
		return result;
	}
	
	/**将单词中的大写字母替换成下划线加小写字母 例如: ArchiveInfo -> archive_info
	 * @param str
	 * @return
	 */
	public static String replaceUpperToUnderline(String str){
		char[] chars = str.toCharArray();
		String outs = "";
		for(int i = 0; i<chars.length;i++){
			char c = chars[i];
			if (Character.isUpperCase(c)){
				char lc = Character.toLowerCase(c);
				if (i>0) outs+='_';
				outs+=lc;
			}else{
				outs+=c;
			}
		}
		
		return outs;
	}
	
	/**将单词中的下划线及后面的字母替换成大写字母 例如 archive_info  -> ArchiveInfo
	 * @param str
	 * @return
	 */
	public static String replaceUnderlineToUpper(String str){
		char[] chars = str.toCharArray();
		String outs = "";
		for(int i = 0; i<chars.length;i++){
			char c = chars[i];
			if (c=='_'){
				if (i<chars.length-1){
					char uc = Character.toUpperCase(chars[i+1]);
					outs+=uc;
				}
				
			}else{
				if (i==0||chars[i-1]!='_'){
					outs+=c;
				}
				
			}
		}
		
		return outs;
	}
	
	
	 /** 用于替换有开始结束符指定的大段文本
	 * @param strSource 原文本
	 * @param startFlag 开始标识(正则表达式)
	 * @param endFlag  结束标识（正则表达式）
	 * @param replaceStr  替换文本
	 * @param lineBreak 文本是否以换行形式存在
	 * @return 替换后的文本
	 */
	public static String replaceByFlag(String strSource, String startFlag, String endFlag, String replaceStr,boolean lineBreak){ 
		 
		 String reg = "(" + startFlag + ").*(" + endFlag + ")"; 
		 Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
		 Matcher matcher = pattern.matcher(strSource);
		 String g1 = lineBreak?"$1\r":"$1";
		 String g2 = lineBreak?"\r$2":"$2";
		 
		 String result = matcher.replaceAll(g1 + replaceStr + g2);
		 return result;
		 
	 } 
	
	public static String substringByFlag(String strSource, String startFlag, String endFlag){
		 String subString = null;
		 String reg = startFlag + "(.*)" + endFlag; 
		 Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
		 Matcher matcher = pattern.matcher(strSource);
		 if (matcher.find()){
			 subString= matcher.group(1); 
		 }
		 return subString;
	}

	
	public static void main(String[] args) throws IOException{
		//System.out.println(String.format("dsf %d", 1));
//		System.out.println(upperFirst("showme"));
//		System.out.println(replaceUpperToUnderline("ArchiveInfoExample"));
//		System.out.println(replaceUnderlineToUpper("archive_info_example"));
		
		String s = FileUtils.readFileToString(new File("/Users/sindtom/j2ee-project-maven/smartFramework/smart-common/src/main/webapp/WEB-INF/views/template/fawen/css.jsp"));
		
		System.out.println(replaceByFlag(s, "/\\*list-table\\*/", "/\\*list-table-end\\*/", "abcd{}",true)); 
	}

	
	
	
}
