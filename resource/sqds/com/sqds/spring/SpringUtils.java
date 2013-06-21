/*     */ package com.sqds.spring;
/*     */ 
/*     */ import com.sqds.exception.SqdsException;
/*     */ import com.sqds.page.PageInfo;
/*     */ import com.sqds.util.DateUtils;
/*     */ import com.sqds.util.ParamUtils;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.springframework.beans.BeansException;
/*     */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*     */ import org.springframework.beans.propertyeditors.CustomNumberEditor;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.ServletRequestDataBinder;
/*     */ import org.springframework.web.context.WebApplicationContext;
/*     */ import org.springframework.web.context.support.WebApplicationContextUtils;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.multipart.MultipartHttpServletRequest;
/*     */ 
/*     */ public abstract class SpringUtils
/*     */ {
/*  37 */   public static String HTTP_SERVLET_REQUEST = "sqds_request";
/*  38 */   public static String HTTP_SERVLET_RESPONSE = "sqds_response";
/*     */ 
/*     */   public static BindingResult bind(Object command)
/*     */   {
/*  46 */     HttpServletRequest request = getRequest();
/*  47 */     ServletRequestDataBinder binder = new ServletRequestDataBinder(command);
/*  48 */     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*  49 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*  50 */     binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
/*  51 */     binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
/*  52 */     binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(Long.class, true));
/*  53 */     binder.registerCustomEditor(Float.class, null, new CustomNumberEditor(Float.class, true));
/*  54 */     binder.registerCustomEditor(BigDecimal.class, null, new CustomNumberEditor(BigDecimal.class, true));
/*  55 */     binder.registerCustomEditor(Byte.class, null, new CustomNumberEditor(Byte.class, true));
/*     */ 
/*  57 */     binder.bind(request);
/*  58 */     BindingResult bindingResult = binder.getBindingResult();
/*  59 */     List list = bindingResult.getAllErrors();
/*  60 */     for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object error = localIterator.next();
/*  61 */       System.out.println(error);
/*     */     }
/*  63 */     if (bindingResult.hasErrors()) {
/*  64 */       throw new SqdsException("您输入的数据有误。");
/*     */     }
/*  66 */     return bindingResult;
/*     */   }
/*     */ 
/*     */   public static void initPageInfo(PageInfo pageInfo)
/*     */   {
/*  74 */     HttpServletRequest request = getRequest();
/*  75 */     pageInfo.setPageNo(1);
/*  76 */     pageInfo.setPageSize(15);
/*  77 */     Enumeration enumeration = request.getParameterNames();
/*  78 */     while (enumeration.hasMoreElements()) {
/*  79 */       String name = (String)enumeration.nextElement();
/*  80 */       if (name.startsWith("_")) {
/*  81 */         if (name.equals("_pageNo"))
/*  82 */           pageInfo.setPageNo(ParamUtils.getInt(name, 1));
/*  83 */         else if (name.equals("_pageSize"))
/*  84 */           pageInfo.setPageSize(ParamUtils.getInt(name, 15));
/*  85 */         else if (name.equals("_orderBy"))
/*  86 */           pageInfo.setOrderBy(ParamUtils.getString(name, ""));
/*  87 */         else if (name.equals("_order")) {
/*  88 */           pageInfo.setOrder(ParamUtils.getString(name, "desc"));
/*     */         }
/*     */       }
/*  91 */       else if (name.startsWith("d_")) {
/*  92 */         String value = ParamUtils.getString(name, "");
/*  93 */         pageInfo.addParameter(name, DateUtils.string2Date(value));
/*  94 */       } else if (name.startsWith("i_")) {
/*  95 */         pageInfo.addParameter(name, ParamUtils.getInteger(name, 0));
/*  96 */       } else if (name.startsWith("l_")) {
/*  97 */         pageInfo.addParameter(name, Long.valueOf(ParamUtils.getLong(name, 0L)));
/*  98 */       } else if (name.startsWith("deci_")) {
/*  99 */         pageInfo.addParameter(name, ParamUtils.getDecimal(name, 0.0D));
/*     */       } else {
/* 101 */         pageInfo.addParameter(name, ParamUtils.getString(name, ""));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static WebApplicationContext getWebApplicationContext()
/*     */   {
/* 112 */     HttpServletRequest request = getRequest();
/* 113 */     return getWebApplicationContext(request);
/*     */   }
/*     */ 
/*     */   public static WebApplicationContext getWebApplicationContext(HttpServletRequest request)
/*     */   {
/* 122 */     WebApplicationContext webAppCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
/* 123 */     return webAppCtx;
/*     */   }
/*     */ 
/*     */   public static Object getBean(String name)
/*     */     throws BeansException
/*     */   {
/* 133 */     return getWebApplicationContext().getBean(name);
/*     */   }
/*     */ 
/*     */   public static HttpServletRequest getRequest()
/*     */   {
/* 141 */     return (HttpServletRequest)ThreadLocalMap.get(HTTP_SERVLET_REQUEST);
/*     */   }
/*     */ 
/*     */   public static HttpServletResponse getResponse()
/*     */   {
/* 149 */     return (HttpServletResponse)ThreadLocalMap.get(HTTP_SERVLET_RESPONSE);
/*     */   }
/*     */ 
/*     */   public static void disableResponseCaching()
/*     */   {
/* 156 */     HttpServletResponse response = getResponse();
/* 157 */     response.setHeader("Expires", "Sat, 1 January 2000 12:00:00 GMT");
/* 158 */     response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
/* 159 */     response.addHeader("Cache-Control", "post-check=0, pre-check=0");
/* 160 */     response.setHeader("Pragma", "no-cache");
/*     */   }
/*     */ 
/*     */   public static String uploadFile(HttpServletRequest request, String uploadDir, String parameterName, String saveFileName)
/*     */   {
/* 172 */     String fileRelativePath = "";
/* 173 */     String realPath = System.getProperty("project.root") + "/" + uploadDir;
/* 174 */     MultipartHttpServletRequest multipartRequest = null;
/*     */     try
/*     */     {
/* 177 */       multipartRequest = (MultipartHttpServletRequest)request;
/*     */     } catch (ClassCastException e) {
/* 179 */       return fileRelativePath;
/*     */     }
/* 181 */     File file = new File(realPath);
/*     */     try {
/* 183 */       if (!file.exists()) {
/* 184 */         file.mkdirs();
/*     */       }
/* 186 */       MultipartFile multipartFile = multipartRequest.getFile(parameterName);
/* 187 */       if (StringUtils.isNotEmpty(multipartFile.getOriginalFilename())) {
/* 188 */         String fileName = multipartFile.getOriginalFilename();
/* 189 */         String extName = "";
/* 190 */         if (fileName.lastIndexOf(".") != -1) {
/* 191 */           extName = fileName.substring(fileName.lastIndexOf("."));
/*     */         }
/* 193 */         String fileRealPath = file + File.separator + saveFileName + extName;
/* 194 */         File file1 = new File(fileRealPath);
/* 195 */         multipartFile.transferTo(file1);
/* 196 */         fileRelativePath = uploadDir + "/" + saveFileName + extName;
/*     */       }
/*     */     } catch (IOException e) {
/* 199 */       throw new SqdsException(e.getMessage());
/*     */     }
/* 201 */     return fileRelativePath;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.spring.SpringUtils
 * JD-Core Version:    0.6.2
 */