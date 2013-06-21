/*    */ package com.sqds.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class Token
/*    */ {
/*    */   private static final String TOKEN_LIST_NAME = "tokenList";
/*    */   public static final String TOKEN_STRING_NAME = "token";
/*    */ 
/*    */   private static ArrayList getTokenList(HttpSession session)
/*    */   {
/* 26 */     Object obj = session.getAttribute("tokenList");
/* 27 */     if (obj != null) {
/* 28 */       return (ArrayList)obj;
/*    */     }
/* 30 */     ArrayList tokenList = new ArrayList();
/* 31 */     session.setAttribute("tokenList", tokenList);
/* 32 */     return tokenList;
/*    */   }
/*    */ 
/*    */   private static void saveTokenString(String tokenStr, HttpSession session)
/*    */   {
/* 37 */     ArrayList tokenList = getTokenList(session);
/* 38 */     tokenList.add(tokenStr);
/* 39 */     session.setAttribute("tokenList", tokenList);
/*    */   }
/*    */ 
/*    */   private static String generateTokenString() {
/* 43 */     return new Long(System.currentTimeMillis()).toString();
/*    */   }
/*    */ 
/*    */   public static String getTokenString(HttpSession session)
/*    */   {
/* 54 */     String tokenStr = generateTokenString();
/* 55 */     saveTokenString(tokenStr, session);
/* 56 */     return tokenStr;
/*    */   }
/*    */ 
/*    */   public static boolean isTokenStringValid(String tokenStr, HttpSession session)
/*    */   {
/* 70 */     boolean valid = false;
/* 71 */     if (session != null) {
/* 72 */       ArrayList tokenList = getTokenList(session);
/* 73 */       if (tokenList.contains(tokenStr)) {
/* 74 */         valid = true;
/* 75 */         tokenList.remove(tokenStr);
/*    */       }
/*    */     }
/* 78 */     return valid;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.Token
 * JD-Core Version:    0.6.2
 */