/*     */ package com.sqds.util;
/*     */ 
/*     */ import com.sqds.exception.SqdsException;
/*     */ import com.sun.crypto.provider.SunJCE;
/*     */ import java.io.PrintStream;
/*     */ import java.security.Security;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.spec.IvParameterSpec;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ 
/*     */ public class Des
/*     */ {
/*     */   public static String encoding(String src)
/*     */     throws SqdsException
/*     */   {
/*  27 */     if ((src == null) || ("".equals(src))) {
/*  28 */       return src;
/*     */     }
/*  30 */     Security.addProvider(new SunJCE());
/*  31 */     String Algorithm = "DES/CBC/PKCS5Padding";
/*  32 */     byte[] bytes = new String("qwertyu1").getBytes();
/*  33 */     byte[] key = new String("h@o*^ccj").getBytes();
/*     */ 
/*  35 */     SecretKey deskey = new SecretKeySpec(key, "DES");
/*  36 */     byte[] cipherByte = (byte[])null;
/*     */     try {
/*  38 */       Cipher c1 = Cipher.getInstance("DES/CBC/PKCS5Padding");
/*  39 */       IvParameterSpec ivSpec = new IvParameterSpec(bytes);
/*  40 */       c1.init(1, deskey, ivSpec);
/*  41 */       cipherByte = c1.doFinal(src.getBytes());
/*     */     } catch (Exception e) {
/*  43 */       throw new SqdsException(e.getMessage());
/*     */     }
/*  45 */     return byte2hex(cipherByte);
/*     */   }
/*     */ 
/*     */   public static String unEncoding(String code)
/*     */     throws SqdsException
/*     */   {
/*  57 */     if ((code == null) || ("".equals(code))) {
/*  58 */       return code;
/*     */     }
/*  60 */     Security.addProvider(new SunJCE());
/*  61 */     String Algorithm = "DES/CBC/PKCS5Padding";
/*  62 */     byte[] bytes = new String("qwertyu1").getBytes();
/*  63 */     byte[] key = new String("h@o*^ccj").getBytes();
/*     */ 
/*  65 */     SecretKey deskey = new SecretKeySpec(key, "DES");
/*  66 */     byte[] clearByte = (byte[])null;
/*     */     try {
/*  68 */       Cipher c1 = Cipher.getInstance("DES/CBC/PKCS5Padding");
/*  69 */       IvParameterSpec ivSpec = new IvParameterSpec(bytes);
/*  70 */       c1.init(2, deskey, ivSpec);
/*  71 */       clearByte = c1.doFinal(hex2byte(code));
/*     */     } catch (Exception e) {
/*  73 */       throw new SqdsException(e.getMessage());
/*     */     }
/*  75 */     return new String(clearByte);
/*     */   }
/*     */ 
/*     */   private static String byte2hex(byte[] b)
/*     */   {
/*  80 */     String hs = "";
/*  81 */     String stmp = "";
/*  82 */     for (int i = 0; i < b.length; i++) {
/*  83 */       stmp = Integer.toHexString(b[i] & 0xFF);
/*  84 */       if (stmp.length() == 1)
/*  85 */         hs = hs + "0" + stmp;
/*     */       else
/*  87 */         hs = hs + stmp;
/*     */     }
/*  89 */     return hs.toUpperCase();
/*     */   }
/*     */ 
/*     */   private static byte[] hex2byte(String hex) throws IllegalArgumentException {
/*  93 */     if (hex.length() % 2 != 0)
/*  94 */       throw new IllegalArgumentException();
/*  95 */     char[] arr = hex.toCharArray();
/*  96 */     byte[] b = new byte[hex.length() / 2];
/*  97 */     int i = 0; int j = 0; for (int l = hex.length(); i < l; j++) {
/*  98 */       String swap = arr[(i++)] + arr[i];
/*  99 */       int byteint = Integer.parseInt(swap, 16) & 0xFF;
/* 100 */       b[j] = new Integer(byteint).byteValue();
/*     */ 
/*  97 */       i++;
/*     */     }
/*     */ 
/* 102 */     return b;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 106 */     String src = "fina";
/* 107 */     String e = encoding(src);
/* 108 */     System.out.println(e);
/* 109 */     System.out.println(unEncoding(e));
/*     */   }
/*     */ 
/*     */   class Key
/*     */   {
/*     */     public static final String key = "h@o*^ccj";
/*     */     public static final String ivSpec = "qwertyu1";
/*     */ 
/*     */     Key()
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.Des
 * JD-Core Version:    0.6.2
 */