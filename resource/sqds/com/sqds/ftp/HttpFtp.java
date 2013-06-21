/*    */ package com.sqds.ftp;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class HttpFtp extends BaseFtp
/*    */ {
/*    */   public boolean stortFile(byte[] bytes, String remot)
/*    */     throws FtpConnectionException, IOException
/*    */   {
/* 22 */     ByteArrayInputStream inStream = new ByteArrayInputStream(bytes);
/* 23 */     return super.stortFile(inStream, remot);
/*    */   }
/*    */ 
/*    */   public byte[] downFile(String remot)
/*    */     throws FtpConnectionException, IOException
/*    */   {
/* 34 */     ByteArrayOutputStream outStream = new ByteArrayOutputStream();
/* 35 */     super.downFile(outStream, remot);
/* 36 */     byte[] bytes = new byte[outStream.size()];
/* 37 */     bytes = outStream.toByteArray();
/* 38 */     return bytes;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.ftp.HttpFtp
 * JD-Core Version:    0.6.2
 */