/*     */ package com.sqds.util;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.DocumentException;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class FileOperate
/*     */ {
/*     */   static final int BUFFER = 2048;
/*     */ 
/*     */   public void copyFile(String src, String dest)
/*     */     throws IOException
/*     */   {
/*  35 */     FileInputStream in = new FileInputStream(src);
/*     */ 
/*  37 */     BufferedInputStream origin = null;
/*  38 */     origin = new BufferedInputStream(in, 2048);
/*     */ 
/*  40 */     File file = new File(dest);
/*  41 */     if (!file.exists()) {
/*  42 */       file.createNewFile();
/*     */     }
/*  44 */     FileOutputStream out = new FileOutputStream(file);
/*     */ 
/*  46 */     byte[] buffer = new byte[2048];
/*     */     int c;
/*  47 */     while ((c = origin.read(buffer, 0, 2048)) != -1)
/*     */     {
/*     */       int c;
/*  48 */       out.write(buffer, 0, c);
/*     */     }
/*  50 */     origin.close();
/*  51 */     in.close();
/*  52 */     out.close();
/*     */   }
/*     */ 
/*     */   public void createDir(String path, String dirname)
/*     */   {
/*  59 */     File dir = new File(path + "/" + dirname);
/*  60 */     if (!dir.exists())
/*  61 */       dir.mkdir();
/*     */   }
/*     */ 
/*     */   public void createFile(String path, String filename)
/*     */     throws IOException
/*     */   {
/*  70 */     File file = new File(path + "/" + filename);
/*  71 */     if (!file.exists())
/*  72 */       file.createNewFile();
/*     */   }
/*     */ 
/*     */   public void delFile(String path, String filename)
/*     */   {
/*  80 */     File file = new File(path + "/" + filename);
/*  81 */     if ((file.exists()) && (file.isFile()))
/*  82 */       file.delete();
/*     */   }
/*     */ 
/*     */   public void delDir(String path)
/*     */   {
/*  91 */     File dir = new File(path);
/*  92 */     if (dir.exists()) {
/*  93 */       File[] tmp = dir.listFiles();
/*  94 */       for (int i = 0; i < tmp.length; i++) {
/*  95 */         if (tmp[i].isDirectory()) {
/*  96 */           delDir(path + "/" + tmp[i].getName());
/*     */         }
/*     */         else {
/*  99 */           tmp[i].delete();
/*     */         }
/*     */       }
/* 102 */       dir.delete();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void changeDirectory(String filename, String oldpath, String newpath, boolean cover)
/*     */   {
/* 114 */     if (!oldpath.equals(newpath)) {
/* 115 */       File oldfile = new File(oldpath + "/" + filename);
/* 116 */       File newfile = new File(newpath + "/" + filename);
/* 117 */       if (newfile.exists()) {
/* 118 */         if (cover)
/* 119 */           oldfile.renameTo(newfile);
/*     */         else
/* 121 */           System.out.println("在新目录下已经存在：" + filename);
/*     */       }
/*     */       else
/* 124 */         oldfile.renameTo(newfile);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void renameFile(String path, String oldname, String newname)
/*     */   {
/* 135 */     if (!oldname.equals(newname)) {
/* 136 */       File oldfile = new File(path + "/" + oldname);
/* 137 */       File newfile = new File(path + "/" + newname);
/* 138 */       if (newfile.exists())
/* 139 */         System.out.println(newname + "已经存在！");
/*     */       else
/* 141 */         oldfile.renameTo(newfile);
/*     */     }
/*     */   }
/*     */ 
/*     */   public Document readXml(String path)
/*     */     throws DocumentException, IOException
/*     */   {
/* 154 */     File file = new File(path);
/* 155 */     BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
/* 156 */     SAXReader saxreader = new SAXReader();
/* 157 */     Document document = saxreader.read(bufferedreader);
/* 158 */     bufferedreader.close();
/* 159 */     return document;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.FileOperate
 * JD-Core Version:    0.6.2
 */