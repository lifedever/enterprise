/*     */ package com.sqds.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class SimpleMoneyFormat
/*     */ {
/*     */   public static final String EMPTY = "";
/*     */   public static final String ZERO = "零";
/*     */   public static final String ONE = "壹";
/*     */   public static final String TWO = "贰";
/*     */   public static final String THREE = "叁";
/*     */   public static final String FOUR = "肆";
/*     */   public static final String FIVE = "伍";
/*     */   public static final String SIX = "陆";
/*     */   public static final String SEVEN = "柒";
/*     */   public static final String EIGHT = "捌";
/*     */   public static final String NINE = "玖";
/*     */   public static final String TEN = "拾";
/*     */   public static final String HUNDRED = "佰";
/*     */   public static final String THOUSAND = "仟";
/*     */   public static final String TEN_THOUSAND = "万";
/*     */   public static final String HUNDRED_MILLION = "亿";
/*     */   public static final String YUAN = "元";
/*     */   public static final String JIAO = "角";
/*     */   public static final String FEN = "分";
/*     */   public static final String DOT = ".";
/*  41 */   private static SimpleMoneyFormat formatter = null;
/*     */ 
/*  43 */   private HashMap chineseNumberMap = new HashMap();
/*  44 */   private HashMap chineseMoneyPattern = new HashMap();
/*     */ 
/*  46 */   private NumberFormat numberFormat = NumberFormat.getInstance();
/*     */ 
/*     */   private SimpleMoneyFormat() {
/*  49 */     this.numberFormat.setMaximumFractionDigits(4);
/*  50 */     this.numberFormat.setMinimumFractionDigits(2);
/*  51 */     this.numberFormat.setGroupingUsed(false);
/*     */ 
/*  53 */     this.chineseNumberMap.put("0", "零");
/*  54 */     this.chineseNumberMap.put("1", "壹");
/*  55 */     this.chineseNumberMap.put("2", "贰");
/*  56 */     this.chineseNumberMap.put("3", "叁");
/*  57 */     this.chineseNumberMap.put("4", "肆");
/*  58 */     this.chineseNumberMap.put("5", "伍");
/*  59 */     this.chineseNumberMap.put("6", "陆");
/*  60 */     this.chineseNumberMap.put("7", "柒");
/*  61 */     this.chineseNumberMap.put("8", "捌");
/*  62 */     this.chineseNumberMap.put("9", "玖");
/*  63 */     this.chineseNumberMap.put(".", ".");
/*     */ 
/*  65 */     this.chineseMoneyPattern.put("1", "拾");
/*  66 */     this.chineseMoneyPattern.put("2", "佰");
/*  67 */     this.chineseMoneyPattern.put("3", "仟");
/*  68 */     this.chineseMoneyPattern.put("4", "万");
/*  69 */     this.chineseMoneyPattern.put("5", "拾");
/*  70 */     this.chineseMoneyPattern.put("6", "佰");
/*  71 */     this.chineseMoneyPattern.put("7", "仟");
/*  72 */     this.chineseMoneyPattern.put("8", "亿");
/*     */   }
/*     */ 
/*     */   public static SimpleMoneyFormat getInstance() {
/*  76 */     if (formatter == null)
/*  77 */       formatter = new SimpleMoneyFormat();
/*  78 */     return formatter;
/*     */   }
/*     */ 
/*     */   public String format(String moneyStr) {
/*  82 */     checkPrecision(moneyStr);
/*     */ 
/*  84 */     String result = convertToChineseNumber(moneyStr);
/*  85 */     result = addUnitsToChineseMoneyString(result);
/*  86 */     return result;
/*     */   }
/*     */ 
/*     */   public String format(double moneyDouble) {
/*  90 */     return format(this.numberFormat.format(moneyDouble));
/*     */   }
/*     */ 
/*     */   public String format(int moneyInt) {
/*  94 */     return format(this.numberFormat.format(moneyInt));
/*     */   }
/*     */ 
/*     */   public String format(long moneyLong) {
/*  98 */     return format(this.numberFormat.format(moneyLong));
/*     */   }
/*     */ 
/*     */   public String format(Number moneyNum) {
/* 102 */     return format(this.numberFormat.format(moneyNum));
/*     */   }
/*     */ 
/*     */   private String convertToChineseNumber(String moneyStr)
/*     */   {
/* 107 */     StringBuffer cMoneyStringBuffer = new StringBuffer();
/* 108 */     for (int i = 0; i < moneyStr.length(); i++) {
/* 109 */       cMoneyStringBuffer.append(this.chineseNumberMap.get(moneyStr.substring(i, i + 1)));
/*     */     }
/*     */ 
/* 112 */     int indexOfDot = cMoneyStringBuffer.indexOf(".");
/* 113 */     int moneyPatternCursor = 1;
/* 114 */     for (int i = indexOfDot - 1; i > 0; i--) {
/* 115 */       cMoneyStringBuffer.insert(i, this.chineseMoneyPattern.get(moneyPatternCursor));
/* 116 */       moneyPatternCursor = moneyPatternCursor == 8 ? 1 : moneyPatternCursor + 1;
/*     */     }
/*     */ 
/* 119 */     String fractionPart = cMoneyStringBuffer.substring(cMoneyStringBuffer.indexOf("."));
/* 120 */     cMoneyStringBuffer.delete(cMoneyStringBuffer.indexOf("."), cMoneyStringBuffer.length());
/* 121 */     while (cMoneyStringBuffer.indexOf("零拾") != -1) {
/* 122 */       cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零拾"), cMoneyStringBuffer.indexOf("零拾") + 2, "零");
/*     */     }
/* 124 */     while (cMoneyStringBuffer.indexOf("零佰") != -1) {
/* 125 */       cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零佰"), cMoneyStringBuffer.indexOf("零佰") + 2, "零");
/*     */     }
/* 127 */     while (cMoneyStringBuffer.indexOf("零仟") != -1) {
/* 128 */       cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零仟"), cMoneyStringBuffer.indexOf("零仟") + 2, "零");
/*     */     }
/* 130 */     while (cMoneyStringBuffer.indexOf("零万") != -1) {
/* 131 */       cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零万"), cMoneyStringBuffer.indexOf("零万") + 2, "万");
/*     */     }
/* 133 */     while (cMoneyStringBuffer.indexOf("零亿") != -1) {
/* 134 */       cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零亿"), cMoneyStringBuffer.indexOf("零亿") + 2, "亿");
/*     */     }
/* 136 */     while (cMoneyStringBuffer.indexOf("零零") != -1) {
/* 137 */       cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零零"), cMoneyStringBuffer.indexOf("零零") + 2, "零");
/*     */     }
/* 139 */     if (cMoneyStringBuffer.lastIndexOf("零") == cMoneyStringBuffer.length() - 1)
/* 140 */       cMoneyStringBuffer.delete(cMoneyStringBuffer.length() - 1, cMoneyStringBuffer.length());
/* 141 */     cMoneyStringBuffer.append(fractionPart);
/*     */ 
/* 143 */     String result = cMoneyStringBuffer.toString();
/* 144 */     return result;
/*     */   }
/*     */ 
/*     */   private String addUnitsToChineseMoneyString(String moneyStr)
/*     */   {
/* 150 */     StringBuffer cMoneyStringBuffer = new StringBuffer(moneyStr);
/* 151 */     int indexOfDot = cMoneyStringBuffer.indexOf(".");
/* 152 */     cMoneyStringBuffer.replace(indexOfDot, indexOfDot + 1, "元");
/* 153 */     cMoneyStringBuffer.insert(cMoneyStringBuffer.length() - 1, "角");
/* 154 */     cMoneyStringBuffer.insert(cMoneyStringBuffer.length(), "分");
/* 155 */     if (cMoneyStringBuffer.indexOf("零角零分") != -1) {
/* 156 */       cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零角零分"), cMoneyStringBuffer.length(), "整");
/*     */     }
/* 158 */     else if (cMoneyStringBuffer.indexOf("零分") != -1) {
/* 159 */       cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("零分"), cMoneyStringBuffer.length(), "整");
/*     */     }
/* 161 */     else if (cMoneyStringBuffer.indexOf("零角") != -1) {
/* 162 */       cMoneyStringBuffer.delete(cMoneyStringBuffer.indexOf("零角"), cMoneyStringBuffer.indexOf("零角") + 2);
/*     */     }
/*     */ 
/* 165 */     String result = cMoneyStringBuffer.toString();
/* 166 */     return result;
/*     */   }
/*     */ 
/*     */   private void checkPrecision(String moneyStr) {
/* 170 */     int fractionDigits = moneyStr.length() - moneyStr.indexOf(".") - 1;
/* 171 */     if (fractionDigits > 2)
/* 172 */       throw new RuntimeException("金额" + moneyStr + "的小数位多于两位。");
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 176 */     System.out.println(getInstance().format(new Double(10010001.01D)));
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.SimpleMoneyFormat
 * JD-Core Version:    0.6.2
 */