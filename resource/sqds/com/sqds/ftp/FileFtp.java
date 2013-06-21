/*    */ package com.sqds.ftp;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class FileFtp extends BaseFtp
/*    */ {
/*    */   public boolean stortFile(String local, String remot)
/*    */     throws FtpConnectionException, IOException
/*    */   {
/* 22 */     FileInputStream fis = new FileInputStream(local);
/* 23 */     return super.stortFile(fis, remot);
/*    */   }
/*    */ 
/*    */   public boolean downFile(String local, String remot)
/*    */     throws FtpConnectionException, IOException
/*    */   {
/* 34 */     FileOutputStream fos = new FileOutputStream(local);
/* 35 */     return super.downFile(fos, remot);
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.ftp.FileFtp
 * JD-Core Version:    0.6.2
 */