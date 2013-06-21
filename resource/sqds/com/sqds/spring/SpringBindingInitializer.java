/*    */ package com.sqds.spring;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*    */ import org.springframework.beans.propertyeditors.CustomNumberEditor;
/*    */ import org.springframework.web.bind.WebDataBinder;
/*    */ import org.springframework.web.bind.support.WebBindingInitializer;
/*    */ import org.springframework.web.context.request.WebRequest;
/*    */ 
/*    */ public class SpringBindingInitializer
/*    */   implements WebBindingInitializer
/*    */ {
/*    */   public void initBinder(WebDataBinder binder, WebRequest request)
/*    */   {
/* 20 */     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 21 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/* 22 */     binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
/* 23 */     binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
/* 24 */     binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(Long.class, true));
/* 25 */     binder.registerCustomEditor(Float.class, null, new CustomNumberEditor(Float.class, true));
/* 26 */     binder.registerCustomEditor(BigDecimal.class, null, new CustomNumberEditor(BigDecimal.class, true));
/* 27 */     binder.registerCustomEditor(Byte.class, null, new CustomNumberEditor(Byte.class, true));
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.spring.SpringBindingInitializer
 * JD-Core Version:    0.6.2
 */