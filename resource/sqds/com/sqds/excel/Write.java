/*    */ package com.sqds.excel;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.sql.ResultSet;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
/*    */ import jxl.Workbook;
/*    */ import jxl.WorkbookSettings;
/*    */ import jxl.format.Alignment;
/*    */ import jxl.write.DateFormats;
/*    */ import jxl.write.DateTime;
/*    */ import jxl.write.Label;
/*    */ import jxl.write.Number;
/*    */ import jxl.write.WritableCellFormat;
/*    */ import jxl.write.WritableSheet;
/*    */ import jxl.write.WritableWorkbook;
/*    */ 
/*    */ public class Write
/*    */ {
/*    */   public static Write getInstance()
/*    */   {
/* 47 */     return new Write();
/*    */   }
/*    */ 
/*    */   public void write(String sheetName, String realFilePathAndName)
/*    */     throws WriteExcelException
/*    */   {
/* 57 */     write(sheetName, new ArrayList(), 0, new ArrayList(), 1, 
/* 58 */       realFilePathAndName);
/*    */   }
/*    */ 
/*    */   public void write(String sheetName, List titleList, List contentList, String realFilePathAndName)
/*    */     throws WriteExcelException
/*    */   {
/* 71 */     write(sheetName, titleList, 0, contentList, 1, realFilePathAndName);
/*    */   }
/*    */ 
/*    */   public void write(String sheetName, List titleList, int titleRowNum, List contentList, int contentStartRowNum, String realFilePathAndName)
/*    */     throws WriteExcelException
/*    */   {
/* 87 */     WorkbookSettings ws = new WorkbookSettings();
/* 88 */     ws.setLocale(new Locale("zh", "CN"));
/*    */     try
/*    */     {
/* 91 */       WritableWorkbook workbook = Workbook.createWorkbook(new File(
/* 92 */         realFilePathAndName), ws);
/* 93 */       WritableSheet sheet = null;
/*    */ 
/* 95 */       if (sheetName != null)
/* 96 */         sheet = workbook.createSheet(sheetName, 0);
/*    */       else {
/* 98 */         sheet = workbook.createSheet("sheet", 0);
/*    */       }
/*    */ 
/* 102 */       if (titleRowNum < 0) {
/* 103 */         titleRowNum = 0;
/*    */       }
/*    */ 
/* 106 */       if (contentStartRowNum <= titleRowNum) {
/* 107 */         contentStartRowNum = titleRowNum + 1;
/*    */       }
/*    */ 
/* 111 */       if (titleList == null) {
/* 112 */         titleList = new ArrayList();
/*    */       }
/*    */ 
/* 115 */       if (contentList == null) {
/* 116 */         contentList = new ArrayList();
/*    */       }
/*    */ 
/* 119 */       WritableCellFormat wcf = new WritableCellFormat();
/* 120 */       wcf.setAlignment(Alignment.CENTRE);
/*    */ 
/* 123 */       for (int i = 0; i < titleList.size(); i++) {
/* 124 */         Label label = new Label(i, titleRowNum, 
/* 125 */           String.valueOf(titleList.get(i)), wcf);
/* 126 */         sheet.addCell(label);
/*    */       }
/*    */ 
/* 129 */       for (int ii = 0; ii < contentList.size(); ii++)
/*    */       {
/* 131 */         List list = (List)contentList.get(ii);
/*    */ 
/* 133 */         for (int i = 0; i < list.size(); i++) {
/* 134 */           Object value = list.get(i);
/*    */ 
/* 136 */           if ((value instanceof Integer)) {
/* 137 */             Integer valueInt = (Integer)value;
/* 138 */             Number n = new Number(i, contentStartRowNum, 
/* 139 */               valueInt.intValue());
/* 140 */             sheet.addCell(n);
/* 141 */           } else if ((value instanceof Double)) {
/* 142 */             Double valueDouble = (Double)value;
/* 143 */             Number n = new Number(contentStartRowNum, i, 
/* 144 */               valueDouble.doubleValue());
/* 145 */             sheet.addCell(n);
/* 146 */           } else if ((value instanceof java.lang.Boolean)) {
/* 147 */             java.lang.Boolean valueBoolean = (java.lang.Boolean)value;
/* 148 */             jxl.write.Boolean b = new jxl.write.Boolean(contentStartRowNum, 
/* 149 */               i, valueBoolean.booleanValue());
/* 150 */             sheet.addCell(b);
/* 151 */           } else if ((value instanceof Date)) {
/* 152 */             Date valueDate = (Date)value;
/* 153 */             WritableCellFormat cf1 = new WritableCellFormat(DateFormats.FORMAT9);
/* 154 */             DateTime dt = new DateTime(i, contentStartRowNum, 
/* 155 */               valueDate, cf1);
/* 156 */             sheet.addCell(dt);
/*    */           } else {
/* 158 */             Label l = new Label(i, contentStartRowNum, 
/* 159 */               String.valueOf(value));
/* 160 */             sheet.addCell(l);
/*    */           }
/*    */         }
/*    */ 
/* 164 */         contentStartRowNum++;
/*    */       }
/*    */ 
/* 167 */       workbook.write();
/* 168 */       workbook.close();
/*    */     } catch (Exception e) {
/* 170 */       throw new WriteExcelException(e.toString());
/*    */     }
/*    */   }
/*    */ 
/*    */   public void write(String sheetName, List titleList, ResultSet contentResultSet, String realFilePathAndName)
/*    */     throws WriteExcelException
/*    */   {
/*    */   }
/*    */ 
/*    */   public void write(String sheetName, List titleList, int titleRowNum, ResultSet contentResultSet, int contentStartRowNum, String realFilePathAndName)
/*    */     throws WriteExcelException
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.excel.Write
 * JD-Core Version:    0.6.2
 */