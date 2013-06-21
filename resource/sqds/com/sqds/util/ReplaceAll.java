/*    */ package com.sqds.util;
/*    */ 
/*    */ public class ReplaceAll
/*    */ {
/*    */   public static String replace(String source, String oldString, String newString)
/*    */   {
/* 15 */     if (source == null) {
/* 16 */       return null;
/*    */     }
/* 18 */     StringBuffer output = new StringBuffer();
/* 19 */     int lengOfsource = source.length();
/* 20 */     int lengOfold = oldString.length();
/* 21 */     int posStart = 0;
/*    */     int pos;
/* 23 */     while ((pos = source.indexOf(oldString, posStart)) >= 0)
/*    */     {
/*    */       int pos;
/* 24 */       output.append(source.substring(posStart, pos));
/* 25 */       output.append(newString);
/* 26 */       posStart = pos + lengOfold;
/*    */     }
/* 28 */     if (posStart < lengOfsource) {
/* 29 */       output.append(source.substring(posStart));
/*    */     }
/* 31 */     return output.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.ReplaceAll
 * JD-Core Version:    0.6.2
 */