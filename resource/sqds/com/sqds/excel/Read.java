/*     */ package com.sqds.excel;
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
/*     */ public class Read
/*     */ {
/*     */   public static List read(String filePath)
/*     */     throws Exception
/*     */   {
/*  38 */     FileInputStream fileInputStream = new FileInputStream(filePath);
/*  39 */     return read(fileInputStream, 0, false);
/*     */   }
/*     */ 
/*     */   public static List read(String filePath, int sheetIndex)
/*     */     throws Exception
/*     */   {
/*  50 */     FileInputStream fileInputStream = new FileInputStream(filePath);
/*  51 */     return read(fileInputStream, sheetIndex, false);
/*     */   }
/*     */ 
/*     */   public static List read(String filePath, int sheetIndex, boolean ignoreFirstRow)
/*     */     throws Exception
/*     */   {
/*  64 */     FileInputStream fileInputStream = new FileInputStream(filePath);
/*  65 */     return read(fileInputStream, sheetIndex, ignoreFirstRow);
/*     */   }
/*     */ 
/*     */   public static List read(InputStream inputStream, int sheetIndex, boolean ignoreFirstRow)
/*     */     throws Exception
/*     */   {
/*  81 */     List result = new Vector();
/*     */ 
/*  83 */     Workbook workbook = Workbook.getWorkbook(inputStream);
/*  84 */     Sheet sheet = workbook.getSheet(sheetIndex);
/*  85 */     int firstNum = 0;
/*  86 */     int rowNum = sheet.getRows();
/*  87 */     int cellNum = sheet.getColumns();
/*     */ 
/*  89 */     if (ignoreFirstRow) {
/*  90 */       firstNum++;
/*     */     }
/*     */ 
/*  94 */     for (int i = firstNum; i < rowNum; i++) {
/*  95 */       Vector rowList = new Vector();
/*     */ 
/*  97 */       for (int ii = 0; ii < cellNum; ii++) {
/*  98 */         Cell cell = sheet.getCell(ii, i);
/*  99 */         String content = cell.getContents();
/* 100 */         rowList.add(content);
/*     */       }
/* 102 */       result.add(rowList);
/*     */     }
/* 104 */     workbook.close();
/* 105 */     inputStream.close();
/* 106 */     return result;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 110 */     List list = read("E:/work_new/excel/ccc.xls", 0, false);
/*     */ 
/* 112 */     for (int i = 0; i < list.size(); i++) {
/* 113 */       List row = (List)list.get(i);
/* 114 */       for (int ii = 0; ii < row.size(); ii++) {
/* 115 */         String value = (String)row.get(ii);
/* 116 */         System.out.print(value + " ");
/*     */       }
/* 118 */       System.out.println("");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.excel.Read
 * JD-Core Version:    0.6.2
 */