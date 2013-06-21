/*     */ package com.sqds.util;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ 
/*     */ public class ZipBean
/*     */ {
/*     */   static final int BUFFER = 2048;
/*     */   private String filePath;
/*     */   private ZipOutputStream out;
/*     */   private File fromFile;
/*     */ 
/*     */   public ZipBean(File fromFile, File toFile)
/*     */   {
/*     */     try
/*     */     {
/*  35 */       FileOutputStream fos = new FileOutputStream(toFile);
/*  36 */       this.out = new ZipOutputStream(new BufferedOutputStream(fos));
/*  37 */       this.filePath = (fromFile.getAbsolutePath() + "\\");
/*  38 */       this.fromFile = fromFile;
/*     */     }
/*     */     catch (Exception e) {
/*  41 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void start() throws Exception {
/*  46 */     makeZip(this.fromFile);
/*  47 */     this.out.close();
/*     */   }
/*     */ 
/*     */   private void makeZip(File fromFile) {
/*     */     try {
/*  52 */       if (fromFile.isDirectory()) {
/*  53 */         File[] fileList = fromFile.listFiles();
/*  54 */         for (int i = 0; i < fileList.length; i++) {
/*  55 */           File _f = fileList[i];
/*  56 */           if (_f.isDirectory()) {
/*  57 */             makeZip(_f);
/*     */           } else {
/*  59 */             String path = _f.getAbsolutePath();
/*  60 */             path = getAbsolutePath(path);
/*     */ 
/*  62 */             writeEntry(path, _f, this.out);
/*     */           }
/*     */         }
/*     */       } else {
/*  66 */         String path = fromFile.getAbsolutePath();
/*  67 */         path = getAbsolutePath(path, path.lastIndexOf("\\") + 1);
/*     */ 
/*  69 */         writeEntry(path, fromFile, this.out);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  73 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void writeEntry(String EntryName, File file, ZipOutputStream out) throws Exception
/*     */   {
/*  79 */     ZipEntry entry = new ZipEntry(EntryName);
/*  80 */     out.putNextEntry(entry);
/*  81 */     FileInputStream fi = new FileInputStream(file);
/*  82 */     BufferedInputStream origin = null;
/*  83 */     origin = new BufferedInputStream(fi, 2048);
/*     */ 
/*  86 */     byte[] data = new byte[2048];
/*     */     int count;
/*  87 */     while ((count = origin.read(data, 0, 2048)) != -1)
/*     */     {
/*     */       int count;
/*  88 */       out.write(data, 0, count);
/*     */     }
/*  90 */     origin.close();
/*     */   }
/*     */ 
/*     */   private String getAbsolutePath(String strPath)
/*     */   {
/*  95 */     return strPath.substring(this.filePath.length(), strPath.length());
/*     */   }
/*     */ 
/*     */   private String getAbsolutePath(String strPath, int index) {
/*  99 */     return strPath.substring(index, strPath.length());
/*     */   }
/*     */ 
/*     */   public File getFromFile() {
/* 103 */     return this.fromFile;
/*     */   }
/*     */ 
/*     */   public void setFromFile(File fromFile) {
/* 107 */     this.fromFile = fromFile;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 111 */     File fromFile = new File("c:\\test");
/* 112 */     File toFile = new File("c:\\test2.zip");
/* 113 */     ZipBean zip = new ZipBean(fromFile, toFile);
/*     */     try {
/* 115 */       zip.start();
/*     */     } catch (Exception ex) {
/* 117 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.ZipBean
 * JD-Core Version:    0.6.2
 */