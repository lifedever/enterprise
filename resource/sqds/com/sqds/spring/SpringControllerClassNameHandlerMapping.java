/*     */ package com.sqds.spring;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.springframework.util.ClassUtils;
/*     */ import org.springframework.util.StringUtils;
/*     */ import org.springframework.web.servlet.mvc.support.AbstractControllerUrlHandlerMapping;
/*     */ 
/*     */ public class SpringControllerClassNameHandlerMapping extends AbstractControllerUrlHandlerMapping
/*     */ {
/*     */   private static final String CONTROLLER_SUFFIX = "Controller";
/*  27 */   private boolean caseSensitive = false;
/*     */   private String pathPrefix;
/*     */   private String[] basePackage;
/*  33 */   private static Map<String, String> chacheMap = new HashMap();
/*     */ 
/*     */   public void setCaseSensitive(boolean caseSensitive)
/*     */   {
/*  42 */     this.caseSensitive = caseSensitive;
/*     */   }
/*     */ 
/*     */   public void setPathPrefix(String prefixPath)
/*     */   {
/*  52 */     this.pathPrefix = prefixPath;
/*  53 */     if (StringUtils.hasLength(this.pathPrefix)) {
/*  54 */       if (!this.pathPrefix.startsWith("/")) {
/*  55 */         this.pathPrefix = ("/" + this.pathPrefix);
/*     */       }
/*  57 */       if (this.pathPrefix.endsWith("/"))
/*  58 */         this.pathPrefix = this.pathPrefix.substring(0, this.pathPrefix.length() - 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setBasePackage(String[] basePackage)
/*     */   {
/*  77 */     this.basePackage = basePackage;
/*     */   }
/*     */ 
/*     */   protected String[] buildUrlsForHandler(String beanName, Class beanClass)
/*     */   {
/*  82 */     return generatePathMappings(beanClass);
/*     */   }
/*     */ 
/*     */   protected String[] generatePathMappings(Class beanClass)
/*     */   {
/*  93 */     StringBuffer pathMapping = buildPathPrefix(beanClass);
/*  94 */     String className = ClassUtils.getShortName(beanClass);
/*  95 */     String path = className.endsWith("Controller") ? 
/*  96 */       className.substring(0, className.indexOf("Controller")) : className;
/*  97 */     if (path.length() > 0) {
/*  98 */       if (this.caseSensitive) {
/*  99 */         pathMapping.append(path.substring(0, 1).toLowerCase()).append(path.substring(1));
/*     */       }
/*     */       else {
/* 102 */         pathMapping.append(path.toLowerCase());
/*     */       }
/*     */     }
/* 105 */     if (isMultiActionControllerType(beanClass)) {
/* 106 */       return new String[] { pathMapping.toString(), pathMapping.toString() + "/*" };
/*     */     }
/*     */ 
/* 109 */     return new String[] { pathMapping.toString() + "*" };
/*     */   }
/*     */ 
/*     */   private StringBuffer buildPathPrefix(Class beanClass)
/*     */   {
/* 120 */     String packageName = ClassUtils.getPackageName(beanClass);
/* 121 */     String pathMappingStr = (String)chacheMap.get(packageName);
/* 122 */     if (pathMappingStr != null) {
/* 123 */       return new StringBuffer(pathMappingStr);
/*     */     }
/* 125 */     StringBuffer pathMapping = new StringBuffer();
/* 126 */     if (this.pathPrefix != null) {
/* 127 */       pathMapping.append(this.pathPrefix);
/* 128 */       pathMapping.append("/");
/*     */     }
/*     */     else {
/* 131 */       pathMapping.append("/");
/*     */     }
/*     */ 
/* 134 */     if (this.basePackage != null) {
/* 135 */       for (String bp : this.basePackage)
/*     */       {
/* 137 */         Pattern pattern = Pattern.compile(bp);
/* 138 */         Matcher matcher = pattern.matcher(packageName);
/* 139 */         if (matcher.find()) {
/* 140 */           String subPackage = packageName.replaceAll(bp, "").replace('.', '/');
/* 141 */           pathMapping.append(this.caseSensitive ? subPackage : subPackage.toLowerCase());
/* 142 */           pathMapping.append("/");
/* 143 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 147 */     chacheMap.put(packageName, pathMapping.toString());
/* 148 */     return pathMapping;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.spring.SpringControllerClassNameHandlerMapping
 * JD-Core Version:    0.6.2
 */