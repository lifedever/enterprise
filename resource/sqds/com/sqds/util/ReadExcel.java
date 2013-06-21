/*     */ package com.sqds.util;
/*     */ 
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
/*     */ import jxl.Cell;
/*     */ import jxl.Sheet;
/*     */ import jxl.Workbook;
/*     */ 
/*     */ public class ReadExcel
/*     */ {
/*     */   public static List read(String filePath)
/*     */     throws Exception
/*     */   {
/*  37 */     FileInputStream fileInputStream = new FileInputStream(filePath);
/*  38 */     return read(fileInputStream, 0, false);
/*     */   }
/*     */ 
/*     */   public static List read(String filePath, int sheetIndex)
/*     */     throws Exception
/*     */   {
/*  49 */     FileInputStream fileInputStream = new FileInputStream(filePath);
/*  50 */     return read(fileInputStream, sheetIndex, false);
/*     */   }
/*     */ 
/*     */   public static List read(String filePath, int sheetIndex, boolean ignoreFirstRow)
/*     */     throws Exception
/*     */   {
/*  63 */     FileInputStream fileInputStream = new FileInputStream(filePath);
/*  64 */     return read(fileInputStream, sheetIndex, ignoreFirstRow);
/*     */   }
/*     */ 
/*     */   public static List read(InputStream inputStream, int sheetIndex, boolean ignoreFirstRow)
/*     */     throws Exception
/*     */   {
/*  80 */     List result = new Vector();
/*     */ 
/*  82 */     Workbook workbook = Workbook.getWorkbook(inputStream);
/*  83 */     Sheet sheet = workbook.getSheet(sheetIndex);
/*  84 */     int firstNum = 0;
/*  85 */     int rowNum = sheet.getRows();
/*  86 */     int cellNum = sheet.getColumns();
/*     */ 
/*  88 */     if (ignoreFirstRow) {
/*  89 */       firstNum++;
/*     */     }
/*     */ 
/*  93 */     for (int i = firstNum; i < rowNum; i++) {
/*  94 */       Vector rowList = new Vector();
/*     */ 
/*  96 */       for (int ii = 0; ii < cellNum; ii++) {
/*  97 */         Cell cell = sheet.getCell(ii, i);
/*  98 */         String content = cell.getContents();
/*  99 */         rowList.add(content);
/*     */       }
/* 101 */       result.add(rowList);
/*     */     }
/* 103 */     workbook.close();
/* 104 */     inputStream.close();
/* 105 */     return result;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 109 */     List list = read("E:/work_new/excel/ccc.xls", 0, false);
/*     */ 
/* 111 */     for (int i = 0; i < list.size(); i++) {
/* 112 */       List row = (List)list.get(i);
/* 113 */       for (int ii = 0; ii < row.size(); ii++) {
/* 114 */         String value = (String)row.get(ii);
/* 115 */         System.out.print(value + " ");
/*     */       }
/* 117 */       System.out.println("");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.ReadExcel
 * JD-Core Version:    0.6.2
 */