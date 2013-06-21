/*    */ package com.sqds.util;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Properties;
/*    */ 
/*    */ public class InIFile
/*    */ {
/* 20 */   protected HashMap sections = new HashMap();
/*    */   private transient String currentSecion;
/*    */   private transient Properties current;
/*    */ 
/*    */   public InIFile(String filename)
/*    */     throws IOException
/*    */   {
/* 31 */     BufferedReader reader = new BufferedReader(new FileReader(filename));
/* 32 */     read(reader);
/* 33 */     reader.close();
/*    */   }
/*    */ 
/*    */   protected void read(BufferedReader reader)
/*    */     throws IOException
/*    */   {
/*    */     String line;
/* 42 */     while ((line = reader.readLine()) != null)
/*    */     {
/*    */       String line;
/* 43 */       parseLine(line);
/*    */     }
/*    */   }
/*    */ 
/*    */   protected void parseLine(String line)
/*    */   {
/* 51 */     line = line.trim();
/* 52 */     if (line.matches("\\[.*\\]")) {
/* 53 */       this.currentSecion = line.replaceFirst("\\[(.*)\\]", "$1");
/* 54 */       this.current = new Properties();
/* 55 */     } else if (line.matches(".*=.*")) {
/* 56 */       int i = line.indexOf('=');
/* 57 */       String name = line.substring(0, i);
/* 58 */       String value = line.substring(i + 1);
/* 59 */       this.current.setProperty(name, value);
/*    */     }
/* 61 */     if (this.current != null)
/* 62 */       this.sections.put(this.currentSecion, this.current);
/*    */   }
/*    */ 
/*    */   public String getValue(String section, String name)
/*    */   {
/* 72 */     Properties p = (Properties)this.sections.get(section);
/*    */ 
/* 74 */     if (p == null) {
/* 75 */       return null;
/*    */     }
/*    */ 
/* 78 */     String value = p.getProperty(name);
/* 79 */     return value;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.InIFile
 * JD-Core Version:    0.6.2
 */