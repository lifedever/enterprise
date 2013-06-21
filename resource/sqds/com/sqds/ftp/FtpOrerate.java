/*     */ package com.sqds.ftp;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import org.apache.commons.net.ftp.FTPClient;
/*     */ 
/*     */ public abstract class FtpOrerate
/*     */ {
/*     */   public String hostname;
/*     */   public String username;
/*     */   public String password;
/*     */ 
/*     */   public boolean execute()
/*     */     throws FtpConnectionException
/*     */   {
/*  28 */     boolean isOK = false;
/*  29 */     FTPClient ftp = null;
/*     */     try {
/*  31 */       ftp = new FTPClient();
/*  32 */       ftp.connect(this.hostname);
/*  33 */       boolean blogin = ftp.login(this.username, this.password);
/*     */ 
/*  35 */       if (!blogin) {
/*  36 */         throw new FtpConnectionException();
/*     */       }
/*     */ 
/*  40 */       ftp.setFileType(2);
/*     */ 
/*  43 */       isOK = setCommand(ftp);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  47 */       System.err.println(e);
/*     */     }
/*     */     finally {
/*  50 */       if (ftp != null) {
/*     */         try {
/*  52 */           ftp.logout();
/*     */         }
/*     */         catch (Exception localException3)
/*     */         {
/*     */         }
/*     */       }
/*  58 */       if (ftp != null)
/*     */         try {
/*  60 */           ftp.disconnect();
/*     */         }
/*     */         catch (Exception localException4)
/*     */         {
/*     */         }
/*  65 */       ftp = null;
/*     */     }
/*     */ 
/*  68 */     return isOK;
/*     */   }
/*     */ 
/*     */   protected abstract boolean setCommand(FTPClient paramFTPClient)
/*     */     throws IOException;
/*     */ 
/*     */   public void setHostname(String hostname)
/*     */   {
/*  86 */     this.hostname = hostname;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/*  95 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username)
/*     */   {
/* 104 */     this.username = username;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.ftp.FtpOrerate
 * JD-Core Version:    0.6.2
 */