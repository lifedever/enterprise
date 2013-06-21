/*     */ package com.sqds.util;
/*     */ 
/*     */ import com.sqds.spring.SpringUtils;
/*     */ import java.net.URLDecoder;
/*     */ import java.net.URLEncoder;
/*     */ import javax.servlet.http.Cookie;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ public class CookieUtils
/*     */ {
/*     */   public static Cookie getCookie(HttpServletRequest request, String name)
/*     */   {
/*  28 */     Cookie cookie = new Cookie("", "");
/*     */ 
/*  30 */     Cookie[] cookies = request.getCookies();
/*     */ 
/*  32 */     if ((cookies == null) || (name == null) || (name.length() == 0)) {
/*  33 */       return cookie;
/*     */     }
/*     */ 
/*  36 */     for (int i = 0; i < cookies.length; i++) {
/*  37 */       if (cookies[i].getName().equals(name))
/*     */       {
/*  41 */         cookie = cookies[i];
/*     */ 
/*  43 */         break;
/*     */       }
/*     */     }
/*  46 */     return cookie;
/*     */   }
/*     */ 
/*     */   public static Cookie getCookie(String name)
/*     */   {
/*  54 */     return getCookie(SpringUtils.getRequest(), name);
/*     */   }
/*     */ 
/*     */   public static String getCookieValue(HttpServletRequest request, String name)
/*     */   {
/*     */     try
/*     */     {
/*  64 */       return URLDecoder.decode(getCookie(request, name).getValue(), 
/*  65 */         "utf-8"); } catch (Exception e) {
/*     */     }
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */   public static String getCookieValue(String name)
/*     */   {
/*  77 */     return getCookieValue(SpringUtils.getRequest(), name);
/*     */   }
/*     */ 
/*     */   public static void deleteCookie(HttpServletResponse response, Cookie cookie)
/*     */   {
/*  85 */     if (cookie != null) {
/*  86 */       cookie.setMaxAge(0);
/*  87 */       response.addCookie(cookie);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void deleteCookie(Cookie cookie)
/*     */   {
/*  95 */     deleteCookie(SpringUtils.getResponse(), cookie);
/*     */   }
/*     */ 
/*     */   public static void deleteCookie(HttpServletResponse response, String name)
/*     */   {
/* 103 */     Cookie cookie = new Cookie(name, "");
/*     */ 
/* 105 */     deleteCookie(response, cookie);
/*     */   }
/*     */ 
/*     */   public static void deleteCookie(String name)
/*     */   {
/* 112 */     deleteCookie(SpringUtils.getResponse(), name);
/*     */   }
/*     */ 
/*     */   public static void setCookie(HttpServletResponse response, String name, String value)
/*     */   {
/* 123 */     setCookie(response, name, value, 0);
/*     */   }
/*     */ 
/*     */   public static void setCookie(String name, String value)
/*     */   {
/* 132 */     setCookie(name, value, 0);
/*     */   }
/*     */ 
/*     */   public static void setCookie(HttpServletResponse response, String name, String value, int maxAge)
/*     */   {
/* 144 */     if (value == null) {
/* 145 */       value = "";
/*     */     }
/*     */     try
/*     */     {
/* 149 */       Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
/*     */ 
/* 151 */       if (maxAge != 0) {
/* 152 */         cookie.setMaxAge(maxAge);
/*     */       }
/*     */ 
/* 155 */       cookie.setPath("/");
/* 156 */       response.addCookie(cookie);
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void setCookie(String name, String value, int maxAge)
/*     */   {
/* 167 */     setCookie(SpringUtils.getResponse(), name, value, maxAge);
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.CookieUtils
 * JD-Core Version:    0.6.2
 */