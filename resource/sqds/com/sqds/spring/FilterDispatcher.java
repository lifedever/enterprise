/*    */ package com.sqds.spring;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ 
/*    */ public class FilterDispatcher
/*    */   implements Filter
/*    */ {
/*    */   public void destroy()
/*    */   {
/* 20 */     ThreadLocalMap.reset();
/*    */   }
/*    */ 
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*    */     throws IOException, ServletException
/*    */   {
/* 28 */     ThreadLocalMap.put(SpringUtils.HTTP_SERVLET_REQUEST, request);
/* 29 */     ThreadLocalMap.put(SpringUtils.HTTP_SERVLET_RESPONSE, response);
/*    */     try {
/* 31 */       chain.doFilter(request, response);
/*    */     } finally {
/* 33 */       ThreadLocalMap.remove(SpringUtils.HTTP_SERVLET_REQUEST);
/* 34 */       ThreadLocalMap.remove(SpringUtils.HTTP_SERVLET_RESPONSE);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void init(FilterConfig config)
/*    */     throws ServletException
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.spring.FilterDispatcher
 * JD-Core Version:    0.6.2
 */