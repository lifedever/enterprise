/*     */ package com.sqds.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class IdentityCardUtils
/*     */ {
/*     */   public static int getAge(String idCard)
/*     */     throws Exception
/*     */   {
/*  19 */     String idCard18 = idCard15To18(idCard);
/*  20 */     String birthday = idCard18.substring(6, 14);
/*  21 */     birthday = birthday.substring(0, 4) + "-" + birthday.substring(4, 6) + "-" + birthday.substring(4, 8);
/*  22 */     Date bd = string2Date(birthday);
/*  23 */     return getBirthDayToAge(bd);
/*     */   }
/*     */ 
/*     */   public static String idCard15To18(String idCard)
/*     */   {
/*  32 */     String Pid = "";
/*     */ 
/*  34 */     if ((idCard.length() == 15) && (isN(idCard)) && (idCard != null)) {
/*  35 */       idCard = idCard.substring(0, 6) + "19" + idCard.substring(6, 15);
/*     */ 
/*  37 */       int[] a = new int[17];
/*  38 */       for (int i = 0; i < 17; i++) {
/*  39 */         a[i] = Integer.valueOf(idCard.charAt(i)).intValue();
/*     */       }
/*  41 */       int[] b = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
/*  42 */       int c = 0;
/*  43 */       int d = 0;
/*  44 */       for (int i = 0; i < 17; i++) {
/*  45 */         c = a[i] * b[i];
/*  46 */         d += c;
/*     */       }
/*  48 */       d %= 11;
/*  49 */       String lastNumber = "";
/*  50 */       switch (d) {
/*     */       case 0:
/*  52 */         lastNumber = "1";
/*  53 */         break;
/*     */       case 1:
/*  55 */         lastNumber = "0";
/*  56 */         break;
/*     */       case 2:
/*  58 */         lastNumber = "X";
/*  59 */         break;
/*     */       case 3:
/*  61 */         lastNumber = "9";
/*  62 */         break;
/*     */       case 4:
/*  64 */         lastNumber = "8";
/*  65 */         break;
/*     */       case 5:
/*  67 */         lastNumber = "7";
/*  68 */         break;
/*     */       case 6:
/*  70 */         lastNumber = "6";
/*  71 */         break;
/*     */       case 7:
/*  73 */         lastNumber = "5";
/*  74 */         break;
/*     */       case 8:
/*  76 */         lastNumber = "4";
/*  77 */         break;
/*     */       case 9:
/*  79 */         lastNumber = "3";
/*  80 */         break;
/*     */       case 10:
/*  82 */         lastNumber = "2";
/*     */       }
/*     */ 
/*  86 */       Pid = idCard + lastNumber;
/*     */     } else {
/*  88 */       Pid = idCard;
/*     */     }
/*  90 */     return Pid;
/*     */   }
/*     */ 
/*     */   public static String idCard18To15(String idCard)
/*     */   {
/*  98 */     if ((idCard == null) || (idCard.length() != 18)) {
/*  99 */       return idCard;
/*     */     }
/* 101 */     return idCard.substring(0, 6) + idCard.substring(8, 17);
/*     */   }
/*     */ 
/*     */   public static boolean isN(String num)
/*     */   {
/* 112 */     boolean isNum = num.matches("\\d*");
/* 113 */     return isNum;
/*     */   }
/*     */ 
/*     */   public static boolean IsOdd(int n)
/*     */   {
/* 121 */     return n % 2 == 1;
/*     */   }
/*     */ 
/*     */   public static boolean isDate(String str_input)
/*     */   {
/* 131 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/* 132 */     formatter.setLenient(false);
/*     */     try {
/* 134 */       formatter.format(formatter.parse(str_input));
/*     */     } catch (Exception e) {
/* 136 */       return false;
/*     */     }
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */   public static int getBirthDayToAge(Date birthDay)
/*     */     throws Exception
/*     */   {
/* 148 */     Calendar cal = Calendar.getInstance();
/*     */ 
/* 150 */     if (cal.before(birthDay)) {
/* 151 */       throw new IllegalArgumentException(
/* 152 */         "The birthDay is before Now.It's unbelievable!");
/*     */     }
/*     */ 
/* 155 */     int yearNow = cal.get(1);
/* 156 */     int monthNow = cal.get(2);
/* 157 */     int dayOfMonthNow = cal.get(5);
/* 158 */     cal.setTime(birthDay);
/*     */ 
/* 160 */     int yearBirth = cal.get(1);
/* 161 */     int monthBirth = cal.get(2);
/* 162 */     int dayOfMonthBirth = cal.get(5);
/*     */ 
/* 164 */     int age = yearNow - yearBirth;
/*     */ 
/* 166 */     if (monthNow <= monthBirth) {
/* 167 */       if (monthNow == monthBirth)
/*     */       {
/* 169 */         if (dayOfMonthNow < dayOfMonthBirth) {
/* 170 */           age--;
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 176 */         age--;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 183 */     return age;
/*     */   }
/*     */ 
/*     */   public static Date string2Date(String dateStr)
/*     */   {
/* 193 */     if ((dateStr != null) && (!"".equals(dateStr))) {
/* 194 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*     */       try {
/* 196 */         return sdf.parse(dateStr);
/*     */       } catch (Exception e) {
/* 198 */         System.out.println(e);
/*     */       }
/*     */     }
/* 201 */     return null;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 205 */     String id = "110108800127491";
/* 206 */     String id18 = idCard15To18(id);
/* 207 */     System.out.println(id18);
/* 208 */     String id1 = idCard18To15(id18);
/* 209 */     System.out.println(id1);
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.IdentityCardUtils
 * JD-Core Version:    0.6.2
 */