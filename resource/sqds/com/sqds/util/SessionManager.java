/*    */ package com.sqds.util;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class SessionManager
/*    */ {
/*    */   public static void setAttribute(HttpServletRequest request, String sessionName, Object object)
/*    */   {
/* 19 */     request.getSession().setAttribute(sessionName, object);
/*    */   }
/*    */ 
/*    */   public static Object getAttribute(HttpServletRequest request, String sessionName)
/*    */   {
/* 28 */     return request.getSession().getAttribute(sessionName);
/*    */   }
/*    */ 
/*    */   public static void removeAttribute(HttpServletRequest request, String sessionName)
/*    */   {
/* 36 */     request.getSession().removeAttribute(sessionName);
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.SessionManager
 * JD-Core Version:    0.6.2
 */