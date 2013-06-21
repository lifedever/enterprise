/*    */ package com.sqds.util;
/*    */ 
/*    */ import java.lang.reflect.ParameterizedType;
/*    */ import java.lang.reflect.Type;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class GenericsUtils
/*    */ {
/* 15 */   private static final Log log = LogFactory.getLog(GenericsUtils.class);
/*    */ 
/*    */   public static Class getSuperClassGenricType(Class clazz)
/*    */   {
/* 27 */     return getSuperClassGenricType(clazz, 0);
/*    */   }
/*    */ 
/*    */   public static Class getSuperClassGenricType(Class clazz, int index)
/*    */   {
/* 39 */     Type genType = clazz.getGenericSuperclass();
/*    */ 
/* 41 */     if (!(genType instanceof ParameterizedType)) {
/* 42 */       log.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
/* 43 */       return Object.class;
/*    */     }
/*    */ 
/* 46 */     Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
/*    */ 
/* 48 */     if ((index >= params.length) || (index < 0)) {
/* 49 */       log.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + 
/* 50 */         params.length);
/* 51 */       return Object.class;
/*    */     }
/* 53 */     if (!(params[index] instanceof Class)) {
/* 54 */       log.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
/* 55 */       return Object.class;
/*    */     }
/* 57 */     return (Class)params[index];
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.GenericsUtils
 * JD-Core Version:    0.6.2
 */