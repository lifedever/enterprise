/*     */ package com.sqds.util;
/*     */ 
/*     */ import com.sqds.exception.SqdsException;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import jxl.Workbook;
/*     */ import jxl.WorkbookSettings;
/*     */ import jxl.format.Alignment;
/*     */ import jxl.format.Border;
/*     */ import jxl.format.BorderLineStyle;
/*     */ import jxl.format.VerticalAlignment;
/*     */ import jxl.write.DateFormats;
/*     */ import jxl.write.DateTime;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.Number;
/*     */ import jxl.write.WritableCellFormat;
/*     */ import jxl.write.WritableFont;
/*     */ import jxl.write.WritableSheet;
/*     */ import jxl.write.WritableWorkbook;
/*     */ 
/*     */ public class WriteExcel
/*     */ {
/*     */   public static WriteExcel getInstance()
/*     */   {
/*  44 */     return new WriteExcel();
/*     */   }
/*     */ 
/*     */   public void write(String sheetName, String realFilePathAndName)
/*     */     throws SqdsException
/*     */   {
/*  55 */     write(sheetName, new ArrayList(), 0, new ArrayList(), 1, 
/*  56 */       realFilePathAndName);
/*     */   }
/*     */ 
/*     */   public void write(String sheetName, List titleList, List contentList, String realFilePathAndName)
/*     */     throws SqdsException
/*     */   {
/*  69 */     write(sheetName, titleList, 0, contentList, 1, realFilePathAndName);
/*     */   }
/*     */ 
/*     */   public void write(String sheetName, List titleList, int titleRowNum, List contentList, int contentStartRowNum, String realFilePathAndName)
/*     */     throws SqdsException
/*     */   {
/*  85 */     WorkbookSettings ws = new WorkbookSettings();
/*  86 */     ws.setLocale(new Locale("zh", "CN"));
/*     */     try
/*     */     {
/*  89 */       WritableWorkbook workbook = Workbook.createWorkbook(new File(
/*  90 */         realFilePathAndName), ws);
/*  91 */       WritableSheet sheet = null;
/*     */ 
/*  93 */       if (sheetName != null)
/*  94 */         sheet = workbook.createSheet(sheetName, 0);
/*     */       else {
/*  96 */         sheet = workbook.createSheet("sheet", 0);
/*     */       }
/*     */ 
/* 100 */       if (titleRowNum < 0) {
/* 101 */         titleRowNum = 0;
/*     */       }
/*     */ 
/* 104 */       if (contentStartRowNum <= titleRowNum) {
/* 105 */         contentStartRowNum = titleRowNum + 1;
/*     */       }
/*     */ 
/* 109 */       if (titleList == null) {
/* 110 */         titleList = new ArrayList();
/*     */       }
/*     */ 
/* 113 */       if (contentList == null) {
/* 114 */         contentList = new ArrayList();
/*     */       }
/*     */ 
/* 117 */       WritableCellFormat wcf = new WritableCellFormat();
/* 118 */       wcf.setAlignment(Alignment.CENTRE);
/*     */ 
/* 121 */       for (int i = 0; i < titleList.size(); i++) {
/* 122 */         Label label = new Label(i, titleRowNum, 
/* 123 */           String.valueOf(titleList.get(i)), wcf);
/* 124 */         sheet.addCell(label);
/*     */       }
/*     */ 
/* 127 */       for (int ii = 0; ii < contentList.size(); ii++)
/*     */       {
/* 129 */         List list = (List)contentList.get(ii);
/*     */ 
/* 131 */         for (int i = 0; i < list.size(); i++) {
/* 132 */           Object value = list.get(i);
/*     */ 
/* 134 */           if ((value instanceof Integer)) {
/* 135 */             Integer valueInt = (Integer)value;
/* 136 */             Number n = new Number(i, contentStartRowNum, 
/* 137 */               valueInt.intValue());
/* 138 */             sheet.addCell(n);
/* 139 */           } else if ((value instanceof Double)) {
/* 140 */             Double valueDouble = (Double)value;
/* 141 */             Number n = new Number(contentStartRowNum, i, 
/* 142 */               valueDouble.doubleValue());
/* 143 */             sheet.addCell(n);
/* 144 */           } else if ((value instanceof java.lang.Boolean)) {
/* 145 */             java.lang.Boolean valueBoolean = (java.lang.Boolean)value;
/* 146 */             jxl.write.Boolean b = new jxl.write.Boolean(contentStartRowNum, 
/* 147 */               i, valueBoolean.booleanValue());
/* 148 */             sheet.addCell(b);
/* 149 */           } else if ((value instanceof Date)) {
/* 150 */             Date valueDate = (Date)value;
/* 151 */             WritableCellFormat cf1 = new WritableCellFormat(DateFormats.FORMAT9);
/* 152 */             DateTime dt = new DateTime(i, contentStartRowNum, 
/* 153 */               valueDate, cf1);
/* 154 */             sheet.addCell(dt);
/*     */           } else {
/* 156 */             Label l = new Label(i, contentStartRowNum, 
/* 157 */               String.valueOf(value));
/* 158 */             sheet.addCell(l);
/*     */           }
/*     */         }
/*     */ 
/* 162 */         contentStartRowNum++;
/*     */       }
/*     */ 
/* 165 */       workbook.write();
/* 166 */       workbook.close();
/*     */     } catch (Exception e) {
/* 168 */       throw new SqdsException(e.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void write(String sheetName, String tableName, String tableLeftHead, String tableRightHead, String tableLeftTail, String tableRightTail, int[] colWidth, List titleList, int titleRowNum, List contentList, int contentStartRowNum, String realFilePathAndName)
/*     */     throws SqdsException
/*     */   {
/* 202 */     WorkbookSettings ws = new WorkbookSettings();
/* 203 */     ws.setLocale(new Locale("zh", "CN"));
/*     */     try
/*     */     {
/* 206 */       WritableWorkbook workbook = Workbook.createWorkbook(new File(
/* 207 */         realFilePathAndName), ws);
/* 208 */       WritableSheet sheet = null;
/*     */ 
/* 210 */       if (sheetName != null)
/* 211 */         sheet = workbook.createSheet(sheetName, 0);
/*     */       else {
/* 213 */         sheet = workbook.createSheet("sheet", 0);
/*     */       }
/*     */ 
/* 217 */       if (titleRowNum < 0) {
/* 218 */         titleRowNum = 0;
/*     */       }
/*     */ 
/* 221 */       if (contentStartRowNum <= titleRowNum) {
/* 222 */         contentStartRowNum = titleRowNum + 1;
/*     */       }
/*     */ 
/* 226 */       if (titleList == null) {
/* 227 */         titleList = new ArrayList();
/*     */       }
/*     */ 
/* 230 */       if (contentList == null) {
/* 231 */         contentList = new ArrayList();
/*     */       }
/*     */ 
/* 235 */       boolean cwb = false;
/* 236 */       if (colWidth.length == titleList.size()) {
/* 237 */         cwb = true;
/*     */       }
/*     */ 
/* 242 */       WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 16, WritableFont.BOLD);
/* 243 */       WritableCellFormat tableNameWcf = new WritableCellFormat();
/* 244 */       tableNameWcf.setAlignment(Alignment.CENTRE);
/* 245 */       tableNameWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
/* 246 */       tableNameWcf.setFont(wf);
/* 247 */       sheet.mergeCells(0, 0, titleList.size() - 1, 0);
/* 248 */       Label nameLabel = new Label(0, 0, tableName, tableNameWcf);
/* 249 */       sheet.addCell(nameLabel);
/* 250 */       sheet.setRowView(0, 500);
/*     */ 
/* 284 */       WritableFont wft = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
/* 285 */       WritableCellFormat wcf = new WritableCellFormat();
/* 286 */       wcf.setFont(wft);
/* 287 */       wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
/* 288 */       wcf.setAlignment(Alignment.CENTRE);
/* 289 */       wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 290 */       wcf.setWrap(true);
/* 291 */       for (int i = 0; i < titleList.size(); i++) {
/* 292 */         Label label = new Label(i, titleRowNum, 
/* 293 */           String.valueOf(titleList.get(i)), wcf);
/* 294 */         sheet.addCell(label);
/* 295 */         if ((cwb) && (colWidth[i] != 0)) {
/* 296 */           sheet.setColumnView(i, colWidth[i]);
/*     */         }
/*     */       }
/* 299 */       sheet.setRowView(titleRowNum, 400);
/*     */ 
/* 301 */       WritableFont contentWft = new WritableFont(WritableFont.createFont("宋体"), 10);
/* 302 */       WritableCellFormat contentWcf = new WritableCellFormat();
/* 303 */       contentWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 304 */       contentWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
/* 305 */       contentWcf.setFont(contentWft);
/* 306 */       contentWcf.setWrap(true);
/* 307 */       for (int ii = 0; ii < contentList.size(); ii++)
/*     */       {
/* 309 */         List list = (List)contentList.get(ii);
/*     */ 
/* 311 */         for (int i = 0; i < list.size(); i++) {
/* 312 */           Object value = list.get(i);
/*     */ 
/* 314 */           if ((value instanceof Integer)) {
/* 315 */             Integer valueInt = (Integer)value;
/* 316 */             Number n = new Number(i, contentStartRowNum, 
/* 317 */               valueInt.intValue(), contentWcf);
/* 318 */             sheet.addCell(n);
/* 319 */           } else if ((value instanceof Double)) {
/* 320 */             Double valueDouble = (Double)value;
/* 321 */             Number n = new Number(i, contentStartRowNum, 
/* 322 */               valueDouble.doubleValue(), contentWcf);
/* 323 */             sheet.addCell(n);
/* 324 */           } else if ((value instanceof java.lang.Boolean)) {
/* 325 */             java.lang.Boolean valueBoolean = (java.lang.Boolean)value;
/* 326 */             jxl.write.Boolean b = new jxl.write.Boolean(i, contentStartRowNum, 
/* 327 */               valueBoolean.booleanValue(), contentWcf);
/* 328 */             sheet.addCell(b);
/* 329 */           } else if ((value instanceof Date)) {
/* 330 */             Date valueDate = (Date)value;
/* 331 */             WritableCellFormat cf1 = new WritableCellFormat(DateFormats.FORMAT9);
/* 332 */             cf1.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 333 */             DateTime dt = new DateTime(i, contentStartRowNum, 
/* 334 */               valueDate, cf1);
/* 335 */             sheet.addCell(dt);
/*     */           } else {
/* 337 */             Label l = new Label(i, contentStartRowNum, 
/* 338 */               String.valueOf(value), contentWcf);
/* 339 */             sheet.addCell(l);
/*     */           }
/*     */         }
/* 342 */         sheet.setRowView(contentStartRowNum, 400);
/* 343 */         contentStartRowNum++;
/*     */       }
/*     */ 
/* 377 */       workbook.write();
/* 378 */       workbook.close();
/*     */     } catch (Exception e) {
/* 380 */       throw new SqdsException(e.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void writeExcel(String sheetName, String tableName, List titleList, int titleRowNum, List contentList, int contentStartRowNum, String realFilePathAndName)
/*     */     throws SqdsException
/*     */   {
/* 408 */     WorkbookSettings ws = new WorkbookSettings();
/* 409 */     ws.setLocale(new Locale("zh", "CN"));
/*     */     try
/*     */     {
/* 412 */       WritableWorkbook workbook = Workbook.createWorkbook(new File(
/* 413 */         realFilePathAndName), ws);
/* 414 */       WritableSheet sheet = null;
/*     */ 
/* 416 */       if (sheetName != null)
/* 417 */         sheet = workbook.createSheet(sheetName, 0);
/*     */       else {
/* 419 */         sheet = workbook.createSheet("sheet", 0);
/*     */       }
/*     */ 
/* 423 */       if (titleRowNum < 0) {
/* 424 */         titleRowNum = 0;
/*     */       }
/*     */ 
/* 427 */       if (contentStartRowNum <= titleRowNum) {
/* 428 */         contentStartRowNum = titleRowNum + 1;
/*     */       }
/*     */ 
/* 432 */       if (titleList == null) {
/* 433 */         titleList = new ArrayList();
/*     */       }
/*     */ 
/* 436 */       if (contentList == null) {
/* 437 */         contentList = new ArrayList();
/*     */       }
/*     */ 
/* 442 */       WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 16, WritableFont.BOLD);
/* 443 */       WritableCellFormat tableNameWcf = new WritableCellFormat();
/* 444 */       tableNameWcf.setAlignment(Alignment.CENTRE);
/* 445 */       tableNameWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
/* 446 */       tableNameWcf.setFont(wf);
/* 447 */       sheet.mergeCells(0, 0, titleList.size() - 1, 0);
/* 448 */       Label nameLabel = new Label(0, 0, tableName, tableNameWcf);
/* 449 */       sheet.addCell(nameLabel);
/* 450 */       sheet.setRowView(0, 500);
/*     */ 
/* 453 */       WritableFont wft = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
/* 454 */       WritableCellFormat wcf = new WritableCellFormat();
/* 455 */       wcf.setFont(wft);
/* 456 */       wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
/* 457 */       wcf.setAlignment(Alignment.CENTRE);
/* 458 */       wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 459 */       wcf.setWrap(true);
/* 460 */       for (int i = 0; i < titleList.size(); i++) {
/* 461 */         Label label = new Label(i, titleRowNum, 
/* 462 */           String.valueOf(titleList.get(i)), wcf);
/* 463 */         sheet.addCell(label);
/*     */       }
/* 465 */       sheet.setRowView(titleRowNum, 400);
/*     */ 
/* 467 */       WritableFont contentWft = new WritableFont(WritableFont.createFont("宋体"), 10);
/* 468 */       WritableCellFormat contentWcf = new WritableCellFormat();
/* 469 */       contentWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 470 */       contentWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
/* 471 */       contentWcf.setFont(contentWft);
/* 472 */       contentWcf.setWrap(true);
/* 473 */       for (int ii = 0; ii < contentList.size(); ii++)
/*     */       {
/* 475 */         List list = (List)contentList.get(ii);
/*     */ 
/* 477 */         for (int i = 0; i < list.size(); i++) {
/* 478 */           Object value = list.get(i);
/*     */ 
/* 480 */           if ((value instanceof Integer)) {
/* 481 */             Integer valueInt = (Integer)value;
/* 482 */             Number n = new Number(i, contentStartRowNum, 
/* 483 */               valueInt.intValue(), contentWcf);
/* 484 */             sheet.addCell(n);
/* 485 */           } else if ((value instanceof Double)) {
/* 486 */             Double valueDouble = (Double)value;
/* 487 */             Number n = new Number(i, contentStartRowNum, 
/* 488 */               valueDouble.doubleValue(), contentWcf);
/* 489 */             sheet.addCell(n);
/* 490 */           } else if ((value instanceof java.lang.Boolean)) {
/* 491 */             java.lang.Boolean valueBoolean = (java.lang.Boolean)value;
/* 492 */             jxl.write.Boolean b = new jxl.write.Boolean(i, contentStartRowNum, 
/* 493 */               valueBoolean.booleanValue(), contentWcf);
/* 494 */             sheet.addCell(b);
/* 495 */           } else if ((value instanceof Date)) {
/* 496 */             Date valueDate = (Date)value;
/* 497 */             WritableCellFormat cf1 = new WritableCellFormat(DateFormats.FORMAT9);
/* 498 */             cf1.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 499 */             DateTime dt = new DateTime(i, contentStartRowNum, 
/* 500 */               valueDate, cf1);
/* 501 */             sheet.addCell(dt);
/*     */           } else {
/* 503 */             Label l = new Label(i, contentStartRowNum, 
/* 504 */               String.valueOf(value), contentWcf);
/* 505 */             sheet.addCell(l);
/*     */           }
/*     */         }
/* 508 */         sheet.setRowView(contentStartRowNum, 400);
/* 509 */         contentStartRowNum++;
/*     */       }
/*     */ 
/* 512 */       workbook.write();
/* 513 */       workbook.close();
/*     */     } catch (Exception e) {
/* 515 */       throw new SqdsException(e.toString());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.WriteExcel
 * JD-Core Version:    0.6.2
 */