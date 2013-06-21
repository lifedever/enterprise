/*     */ package com.sqds.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class DateUtils
/*     */ {
/*     */   public static String date2String(Date date)
/*     */   {
/*  24 */     if (date != null) {
/*  25 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*  26 */       return sdf.format(date);
/*     */     }
/*  28 */     return "";
/*     */   }
/*     */ 
/*     */   public static String date2String2(Date date)
/*     */   {
/*  39 */     if (date != null) {
/*  40 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  41 */       return sdf.format(date);
/*     */     }
/*  43 */     return "";
/*     */   }
/*     */ 
/*     */   public static String date2ChineseString(Date date)
/*     */   {
/*  53 */     if (date != null) {
/*  54 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
/*  55 */       return sdf.format(date);
/*     */     }
/*  57 */     return "";
/*     */   }
/*     */ 
/*     */   public static Date string2Date(String dateStr)
/*     */   {
/*  68 */     if ((dateStr != null) && (!"".equals(dateStr))) {
/*  69 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*     */       try {
/*  71 */         return sdf.parse(dateStr);
/*     */       } catch (Exception e) {
/*  73 */         System.out.println(e);
/*     */       }
/*     */     }
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */   public static Date string2Date1(String dateStr)
/*     */   {
/*  86 */     if ((dateStr != null) && (!"".equals(dateStr))) {
/*  87 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */       try {
/*  89 */         return sdf.parse(dateStr);
/*     */       } catch (Exception e) {
/*  91 */         System.out.println(e);
/*     */       }
/*     */     }
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */   public static int getDaysBetween(Calendar d1, Calendar d2)
/*     */   {
/* 104 */     int a = -1;
/* 105 */     if (d1.after(d2)) {
/* 106 */       Calendar swap = d1;
/* 107 */       d1 = d2;
/* 108 */       d2 = swap;
/* 109 */       a = 1;
/*     */     }
/* 111 */     int days = d2.get(6) - d1.get(6);
/* 112 */     int y2 = d2.get(1);
/* 113 */     if (d1.get(1) != y2) {
/* 114 */       d1 = (Calendar)d1.clone();
/*     */       do {
/* 116 */         days += d1.getActualMaximum(6);
/* 117 */         d1.add(1, 1);
/* 118 */       }while (d1.get(1) != y2);
/*     */     }
/* 120 */     return a * days;
/*     */   }
/*     */ 
/*     */   public static Date getZeroDate(Date d)
/*     */   {
/* 131 */     Calendar c = Calendar.getInstance();
/* 132 */     c.setTime(d);
/* 133 */     c.set(14, 0);
/* 134 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static Date getAddDate(Date date, int days)
/*     */   {
/* 144 */     if (date == null) {
/* 145 */       return null;
/*     */     }
/* 147 */     Calendar c = Calendar.getInstance();
/* 148 */     c.setTime(date);
/* 149 */     c.add(6, days);
/* 150 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static int getCurrentYear()
/*     */   {
/* 158 */     Calendar calendar = Calendar.getInstance();
/* 159 */     return calendar.get(1);
/*     */   }
/*     */ 
/*     */   public static int getCurrentMonth()
/*     */   {
/* 167 */     Calendar calendar = Calendar.getInstance();
/* 168 */     return calendar.get(2) + 1;
/*     */   }
/*     */ 
/*     */   public static boolean isLeapYear(String year)
/*     */   {
/* 179 */     if (year.length() != 4) {
/* 180 */       System.out.println("传入的年份位数不对，应为四位数！");
/* 181 */       return false;
/*     */     }
/* 183 */     int temp = Integer.valueOf(year).intValue();
/* 184 */     return ((temp % 4 == 0) && (temp % 100 != 0)) || (temp % 400 == 0);
/*     */   }
/*     */ 
/*     */   public static Map getDate1To2(String year, String month)
/*     */   {
/* 197 */     int m = Integer.valueOf(month).intValue();
/*     */     int lastday;
/*     */     int lastday;
/*     */     int lastday;
/* 199 */     switch (m) {
/*     */     case 4:
/*     */     case 6:
/*     */     case 9:
/*     */     case 11:
/* 204 */       lastday = 30;
/* 205 */       break;
/*     */     case 2:
/*     */       int lastday;
/* 207 */       if (isLeapYear(year))
/* 208 */         lastday = 29;
/*     */       else {
/* 210 */         lastday = 28;
/*     */       }
/* 212 */       break;
/*     */     case 3:
/*     */     case 5:
/*     */     case 7:
/*     */     case 8:
/*     */     case 10:
/*     */     default:
/* 215 */       lastday = 31;
/*     */     }
/* 217 */     Map map = new HashMap();
/* 218 */     String beginDate = year + "-" + month + "-01 00:00:00";
/* 219 */     String endDate = year + "-" + month + "-" + lastday + " 23:59:59";
/* 220 */     map.put("beginDate", beginDate);
/* 221 */     map.put("endDate", endDate);
/* 222 */     return map;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.DateUtils
 * JD-Core Version:    0.6.2
 */