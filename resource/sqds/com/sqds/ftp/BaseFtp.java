/*     */ package com.sqds.ftp;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.commons.net.ftp.FTPClient;
/*     */ 
/*     */ public abstract class BaseFtp
/*     */ {
/*     */   private String hostname;
/*     */   private String username;
/*     */   private String password;
/*     */ 
/*     */   protected boolean stortFile(InputStream input, String filename)
/*     */     throws FtpConnectionException
/*     */   {
/*  29 */     StortFileInner stortFileInner = new StortFileInner();
/*  30 */     stortFileInner.setHostname(getHostname());
/*  31 */     stortFileInner.setUsername(getUsername());
/*  32 */     stortFileInner.setPassword(getPassword());
/*  33 */     stortFileInner.setInput(input);
/*  34 */     stortFileInner.setName(filename);
/*  35 */     boolean ok = stortFileInner.execute();
/*  36 */     return ok;
/*     */   }
/*     */ 
/*     */   protected boolean downFile(OutputStream out, String filename)
/*     */     throws FtpConnectionException
/*     */   {
/*  46 */     DownFileInner downFileInner = new DownFileInner();
/*  47 */     downFileInner.setHostname(getHostname());
/*  48 */     downFileInner.setUsername(getUsername());
/*  49 */     downFileInner.setPassword(getPassword());
/*  50 */     downFileInner.setOut(out);
/*  51 */     downFileInner.setName(filename);
/*  52 */     boolean ok = downFileInner.execute();
/*  53 */     return ok;
/*     */   }
/*     */ 
/*     */   public boolean delFile(String filename)
/*     */     throws FtpConnectionException
/*     */   {
/*  64 */     DelFileInner delFileInner = new DelFileInner();
/*  65 */     delFileInner.setHostname(getHostname());
/*  66 */     delFileInner.setUsername(getUsername());
/*  67 */     delFileInner.setPassword(getPassword());
/*  68 */     delFileInner.setName(filename);
/*  69 */     boolean ok = delFileInner.execute();
/*  70 */     return ok;
/*     */   }
/*     */ 
/*     */   public boolean makeDir(String pathName)
/*     */     throws FtpConnectionException
/*     */   {
/*  81 */     MakeDirInner makeDirInner = new MakeDirInner();
/*  82 */     makeDirInner.setHostname(getHostname());
/*  83 */     makeDirInner.setUsername(getUsername());
/*  84 */     makeDirInner.setPassword(getPassword());
/*  85 */     makeDirInner.setName(pathName);
/*  86 */     boolean ok = makeDirInner.execute();
/*  87 */     return ok;
/*     */   }
/*     */ 
/*     */   public boolean removeDir(String pathName)
/*     */     throws FtpConnectionException
/*     */   {
/*  98 */     RemoveDirInner removeDirInner = new RemoveDirInner();
/*  99 */     removeDirInner.setHostname(getHostname());
/* 100 */     removeDirInner.setUsername(getUsername());
/* 101 */     removeDirInner.setPassword(getPassword());
/* 102 */     removeDirInner.setName(pathName);
/* 103 */     boolean ok = removeDirInner.execute();
/* 104 */     return ok;
/*     */   }
/*     */ 
/*     */   public String getHostname()
/*     */   {
/* 113 */     return this.hostname;
/*     */   }
/*     */ 
/*     */   public void setHostname(String hostname)
/*     */   {
/* 122 */     this.hostname = hostname;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 131 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/* 140 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getUsername()
/*     */   {
/* 149 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username)
/*     */   {
/* 158 */     this.username = username;
/*     */   }
/*     */ 
/*     */   protected class DelFileInner extends FtpOrerate
/*     */   {
/* 197 */     String name = "";
/*     */ 
/*     */     protected DelFileInner() {  } 
/* 200 */     protected boolean setCommand(FTPClient ftpClient) throws IOException { boolean ok = ftpClient.deleteFile(this.name);
/* 201 */       return ok; }
/*     */ 
/*     */     protected void setName(String name)
/*     */     {
/* 205 */       this.name = name;
/*     */     }
/*     */   }
/*     */ 
/*     */   protected class DownFileInner extends FtpOrerate
/*     */   {
/* 181 */     String name = "";
/*     */     OutputStream out;
/*     */ 
/*     */     protected DownFileInner()
/*     */     {
/*     */     }
/*     */ 
/*     */     protected boolean setCommand(FTPClient ftpClient)
/*     */       throws IOException
/*     */     {
/* 184 */       boolean ok = ftpClient.retrieveFile(this.name, this.out);
/* 185 */       return ok;
/*     */     }
/*     */ 
/*     */     protected void setName(String name) {
/* 189 */       this.name = name;
/*     */     }
/*     */     protected void setOut(OutputStream out) {
/* 192 */       this.out = out;
/*     */     }
/*     */   }
/*     */ 
/*     */   protected class MakeDirInner extends BaseFtp.DelFileInner
/*     */   {
/*     */     protected MakeDirInner()
/*     */     {
/* 210 */       super();
/*     */     }
/* 212 */     protected boolean setCommand(FTPClient ftpClient) throws IOException { boolean ok = ftpClient.makeDirectory(this.name);
/* 213 */       return ok; }
/*     */   }
/*     */ 
/*     */   protected class RemoveDirInner extends BaseFtp.DelFileInner {
/*     */     protected RemoveDirInner() {
/* 218 */       super();
/*     */     }
/* 220 */     protected boolean setCommand(FTPClient ftpClient) throws IOException { boolean ok = ftpClient.removeDirectory(this.name);
/* 221 */       return ok;
/*     */     }
/*     */   }
/*     */ 
/*     */   protected class StortFileInner extends FtpOrerate
/*     */   {
/* 165 */     String name = "";
/*     */     InputStream input;
/*     */ 
/*     */     protected StortFileInner()
/*     */     {
/*     */     }
/*     */ 
/*     */     protected boolean setCommand(FTPClient ftpClient)
/*     */       throws IOException
/*     */     {
/* 168 */       boolean ok = ftpClient.storeFile(this.name, this.input);
/* 169 */       return ok;
/*     */     }
/*     */ 
/*     */     protected void setName(String name) {
/* 173 */       this.name = name;
/*     */     }
/*     */     protected void setInput(InputStream input) {
/* 176 */       this.input = input;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.ftp.BaseFtp
 * JD-Core Version:    0.6.2
 */