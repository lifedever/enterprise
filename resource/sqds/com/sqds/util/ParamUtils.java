/*     */ package com.sqds.util;
/*     */ 
/*     */ import com.sqds.spring.SpringUtils;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigDecimal;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ 
/*     */ public class ParamUtils
/*     */ {
/*     */   public static String getString(String field, String defaultString)
/*     */   {
/*  27 */     HttpServletRequest request = SpringUtils.getRequest();
/*  28 */     return getString(request, field, defaultString);
/*     */   }
/*     */ 
/*     */   public static String getString(HttpServletRequest request, String field, String defaultString)
/*     */   {
/*  38 */     String s1 = getStringValues(request, field);
/*  39 */     if (s1 == null) {
/*  40 */       return defaultString;
/*     */     }
/*  42 */     return s1.trim();
/*     */   }
/*     */ 
/*     */   public static int getInt(String field, int defaultInt)
/*     */   {
/*  52 */     HttpServletRequest request = SpringUtils.getRequest();
/*  53 */     return getInt(request, field, defaultInt);
/*     */   }
/*     */ 
/*     */   public static int getInt(HttpServletRequest request, String field, int defaultInt)
/*     */   {
/*  63 */     int j = 0;
/*     */     try {
/*  65 */       String temp = getString(request, field);
/*  66 */       if (temp == null)
/*  67 */         j = defaultInt;
/*  68 */       else if (temp.trim().equals(""))
/*  69 */         j = defaultInt;
/*     */       else
/*  71 */         j = Integer.parseInt(temp);
/*     */     }
/*     */     catch (NumberFormatException e) {
/*  74 */       j = 0;
/*     */     }
/*  76 */     return j;
/*     */   }
/*     */ 
/*     */   public static Integer getInteger(String field, int defaultInt)
/*     */   {
/*  88 */     int v = getInt(field, defaultInt);
/*  89 */     if (v == defaultInt) {
/*  90 */       return null;
/*     */     }
/*  92 */     return new Integer(v);
/*     */   }
/*     */ 
/*     */   public static Integer getInteger(HttpServletRequest request, String field, int defaultInt)
/*     */   {
/*  97 */     int v = getInt(request, field, defaultInt);
/*  98 */     if (v == defaultInt) {
/*  99 */       return null;
/*     */     }
/* 101 */     return new Integer(v);
/*     */   }
/*     */ 
/*     */   public static long getLong(String field, long defaultLong)
/*     */   {
/* 114 */     HttpServletRequest request = SpringUtils.getRequest();
/* 115 */     return getLong(request, field, defaultLong);
/*     */   }
/*     */ 
/*     */   public static long getLong(HttpServletRequest request, String field, long defaultLong) {
/* 119 */     long l = 0L;
/*     */     try {
/* 121 */       String temp = getString(request, field);
/* 122 */       if (temp == null)
/* 123 */         l = defaultLong;
/*     */       else
/* 125 */         l = Long.parseLong(temp);
/*     */     }
/*     */     catch (NumberFormatException e) {
/* 128 */       l = 0L;
/*     */     }
/* 130 */     return l;
/*     */   }
/*     */ 
/*     */   public static float getFloat(String field, float defaultFloat)
/*     */   {
/* 142 */     HttpServletRequest request = SpringUtils.getRequest();
/* 143 */     return getFloat(request, field, defaultFloat);
/*     */   }
/*     */   public static float getFloat(HttpServletRequest request, String field, float defaultFloat) {
/* 146 */     float l = 0.0F;
/*     */     try {
/* 148 */       String temp = getString(request, field);
/* 149 */       if (temp == null)
/* 150 */         l = defaultFloat;
/*     */       else
/* 152 */         l = Float.parseFloat(temp);
/*     */     }
/*     */     catch (NumberFormatException e) {
/* 155 */       l = 0.0F;
/*     */     }
/* 157 */     return l;
/*     */   }
/*     */ 
/*     */   public static double getDouble(String field, double defaultDouble)
/*     */   {
/* 167 */     HttpServletRequest request = SpringUtils.getRequest();
/* 168 */     return getDouble(request, field, defaultDouble);
/*     */   }
/*     */ 
/*     */   public static double getDouble(HttpServletRequest request, String field, double defaultDouble) {
/* 172 */     double l = 0.0D;
/*     */     try {
/* 174 */       String temp = getString(request, field);
/* 175 */       if (temp == null)
/* 176 */         l = defaultDouble;
/*     */       else
/* 178 */         l = Double.parseDouble(temp);
/*     */     }
/*     */     catch (NumberFormatException e) {
/* 181 */       l = 0.0D;
/*     */     }
/* 183 */     return l;
/*     */   }
/*     */ 
/*     */   public static BigDecimal getDecimal(String field, double defaultDouble)
/*     */   {
/* 194 */     HttpServletRequest request = SpringUtils.getRequest();
/* 195 */     return getDecimal(request, field, defaultDouble);
/*     */   }
/*     */   public static BigDecimal getDecimal(HttpServletRequest request, String field, double defaultDouble) {
/* 198 */     BigDecimal l = null;
/*     */     try {
/* 200 */       String temp = getString(request, field);
/* 201 */       if (temp == null)
/*     */       {
/* 203 */         l = null;
/*     */       }
/* 205 */       else l = new BigDecimal(temp);
/*     */     }
/*     */     catch (NumberFormatException localNumberFormatException)
/*     */     {
/*     */     }
/* 210 */     return l;
/*     */   }
/*     */ 
/*     */   public static String[] getStringParameters(String name)
/*     */   {
/* 218 */     return getStringParameters(SpringUtils.getRequest(), name);
/*     */   }
/*     */ 
/*     */   public static String[] getStringParameters(HttpServletRequest request, String name) {
/* 222 */     String[] array = request.getParameterValues(name);
/* 223 */     if (array == null) {
/* 224 */       return new String[0];
/*     */     }
/* 226 */     return array;
/*     */   }
/*     */ 
/*     */   public static int[] getIntParameters(String name)
/*     */   {
/* 235 */     String[] array = getStringParameters(name);
/* 236 */     int[] intArray = new int[array.length];
/* 237 */     for (int i = 0; i < array.length; i++) {
/* 238 */       intArray[i] = Integer.parseInt(array[i]);
/*     */     }
/* 240 */     return intArray;
/*     */   }
/*     */ 
/*     */   public static int[] getIntParameters(HttpServletRequest request, String name) {
/* 244 */     String[] array = getStringParameters(request, name);
/* 245 */     int[] intArray = new int[array.length];
/* 246 */     for (int i = 0; i < array.length; i++) {
/* 247 */       intArray[i] = Integer.parseInt(array[i]);
/*     */     }
/* 249 */     return intArray;
/*     */   }
/*     */ 
/*     */   private static String getString(HttpServletRequest request, String s) {
/* 253 */     String temp = null;
/*     */     try {
/* 255 */       temp = request.getParameter(s);
/*     */     } catch (Exception exception) {
/* 257 */       System.out.println(exception);
/*     */     }
/* 259 */     return temp;
/*     */   }
/*     */   private static String getStringValues(HttpServletRequest request, String s) {
/* 262 */     String[] temp = (String[])null;
/*     */     try {
/* 264 */       temp = request.getParameterValues(s);
/*     */     } catch (Exception exception) {
/* 266 */       System.out.println(exception);
/*     */     }
/* 268 */     String s1 = "";
/* 269 */     for (int i = 0; (temp != null) && (i < temp.length); i++) {
/* 270 */       s1 = s1 + temp[i] + ",";
/*     */     }
/* 272 */     if (s1.endsWith(",")) {
/* 273 */       s1 = s1.substring(0, s1.length() - 1);
/*     */     }
/* 275 */     return s1;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.ParamUtils
 * JD-Core Version:    0.6.2
 */