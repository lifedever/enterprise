/*     */ package com.sqds.util;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ public class StringUtils
/*     */ {
/*     */   public static String toHtml(String s)
/*     */   {
/*  17 */     s = ReplaceAll.replace(s, "&", "&amp;");
/*  18 */     s = ReplaceAll.replace(s, "<", "&lt;");
/*  19 */     s = ReplaceAll.replace(s, ">", "&gt;");
/*  20 */     s = ReplaceAll.replace(s, "\t", "    ");
/*  21 */     s = ReplaceAll.replace(s, "\r\n", "\n");
/*  22 */     s = ReplaceAll.replace(s, "\n", "<br>");
/*  23 */     s = ReplaceAll.replace(s, "  ", " &nbsp;");
/*  24 */     s = ReplaceAll.replace(s, "'", "&#39;");
/*  25 */     s = ReplaceAll.replace(s, "\\", "&#92;");
/*  26 */     s = ReplaceAll.replace(s, "\"", "&quot;");
/*  27 */     return s;
/*     */   }
/*     */ 
/*     */   public static String unHtml(String s)
/*     */   {
/*  36 */     s = ReplaceAll.replace(s, "<br>", "\n");
/*  37 */     s = ReplaceAll.replace(s, "&nbsp;", " ");
/*  38 */     return s;
/*     */   }
/*     */ 
/*     */   public static String[] split(String source, String div)
/*     */   {
/*  48 */     int arynum = 0; int intIdx = 0; int intIdex = 0; int div_length = div.length();
/*  49 */     if (source.compareTo("") != 0) {
/*  50 */       if (source.indexOf(div) != -1) {
/*  51 */         intIdx = source.indexOf(div);
/*  52 */         for (int intCount = 1; ; intCount++) {
/*  53 */           if (source.indexOf(div, intIdx + div_length) != -1) {
/*  54 */             intIdx = source.indexOf(div, intIdx + div_length);
/*  55 */             arynum = intCount;
/*     */           } else {
/*  57 */             arynum += 2;
/*  58 */             break;
/*     */           }
/*     */         }
/*     */       }
/*  62 */       arynum = 1;
/*     */     }
/*     */     else {
/*  65 */       arynum = 0;
/*     */     }
/*     */ 
/*  68 */     intIdx = 0;
/*  69 */     intIdex = 0;
/*  70 */     String[] returnStr = new String[arynum];
/*     */ 
/*  72 */     if (source.compareTo("") != 0) {
/*  73 */       if (source.indexOf(div) != -1) {
/*  74 */         intIdx = source.indexOf(div);
/*  75 */         returnStr[0] = source.substring(0, intIdx);
/*  76 */         for (int intCount = 1; ; intCount++) {
/*  77 */           if (source.indexOf(div, intIdx + div_length) != -1) {
/*  78 */             intIdex = source.indexOf(div, intIdx + div_length);
/*  79 */             returnStr[intCount] = source.substring(intIdx + div_length, intIdex);
/*  80 */             intIdx = source.indexOf(div, intIdx + div_length);
/*     */           } else {
/*  82 */             returnStr[intCount] = source.substring(intIdx + div_length, source.length());
/*  83 */             break;
/*     */           }
/*     */         }
/*     */       }
/*  87 */       returnStr[0] = source.substring(0, source.length());
/*  88 */       return returnStr;
/*     */     }
/*     */ 
/*  91 */     return returnStr;
/*     */ 
/*  93 */     return returnStr;
/*     */   }
/*     */ 
/*     */   public static String getNotNullString(String src)
/*     */   {
/* 102 */     if ((src != null) && (!"null".equals(src))) {
/* 103 */       return src;
/*     */     }
/* 105 */     return "";
/*     */   }
/*     */ 
/*     */   public static String getNotNullInt(Integer i)
/*     */   {
/* 115 */     if (i != null) {
/* 116 */       return String.valueOf(i.intValue());
/*     */     }
/* 118 */     return "";
/*     */   }
/*     */ 
/*     */   public static String getNotNullLong(Long l)
/*     */   {
/* 128 */     if (l != null) {
/* 129 */       return String.valueOf(l.longValue());
/*     */     }
/* 131 */     return "";
/*     */   }
/*     */ 
/*     */   public static String getNotNullFloat(Float f)
/*     */   {
/* 141 */     if (f != null) {
/* 142 */       float tempFloat = f.floatValue();
/* 143 */       int tempInt = (int)tempFloat;
/* 144 */       if (tempInt == tempFloat) {
/* 145 */         return String.valueOf(tempInt);
/*     */       }
/* 147 */       return String.valueOf(f.floatValue());
/*     */     }
/*     */ 
/* 150 */     return "";
/*     */   }
/*     */ 
/*     */   public static String getNotNullDecimal(BigDecimal bd)
/*     */   {
/* 160 */     if (bd == null) {
/* 161 */       return "0.00";
/*     */     }
/* 163 */     return bd.toString();
/*     */   }
/*     */ 
/*     */   public static String getNotNullDecimalStr(BigDecimal bd)
/*     */   {
/* 172 */     if (bd == null) {
/* 173 */       return "";
/*     */     }
/* 175 */     String t = bd.toString();
/* 176 */     if (t.endsWith(".00")) {
/* 177 */       return bd.intValue();
/*     */     }
/* 179 */     return t;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.StringUtils
 * JD-Core Version:    0.6.2
 */