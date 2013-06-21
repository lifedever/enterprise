/*    */ package com.sqds.util;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public class BeanUtils
/*    */ {
/* 13 */   protected static Logger logger = LoggerFactory.getLogger(BeanUtils.class);
/*    */ 
/*    */   public static Object getFieldValue(Object object, String fieldName)
/*    */     throws NoSuchFieldException
/*    */   {
/* 22 */     Field field = getDeclaredField(object, fieldName);
/* 23 */     if (!field.isAccessible()) {
/* 24 */       field.setAccessible(true);
/*    */     }
/*    */ 
/* 27 */     Object result = null;
/*    */     try {
/* 29 */       result = field.get(object);
/*    */     } catch (IllegalAccessException e) {
/* 31 */       logger.error("不可能抛出的异常{}", e.getMessage());
/*    */     }
/* 33 */     return result;
/*    */   }
/*    */ 
/*    */   public static void setFieldValue(Object object, String fieldName, Object value)
/*    */     throws NoSuchFieldException
/*    */   {
/* 40 */     Field field = getDeclaredField(object, fieldName);
/* 41 */     if (!field.isAccessible())
/* 42 */       field.setAccessible(true);
/*    */     try
/*    */     {
/* 45 */       field.set(object, value);
/*    */     } catch (IllegalAccessException e) {
/* 47 */       logger.error("不可能抛出的异常:{}", e.getMessage());
/*    */     }
/*    */   }
/*    */ 
/*    */   public static Field getDeclaredField(Object object, String fieldName)
/*    */     throws NoSuchFieldException
/*    */   {
/* 55 */     return getDeclaredField(object.getClass(), fieldName);
/*    */   }
/*    */ 
/*    */   public static Field getDeclaredField(Class clazz, String fieldName)
/*    */     throws NoSuchFieldException
/*    */   {
/* 63 */     for (Class superClass = clazz; superClass != Object.class; ) {
/*    */       try {
/* 65 */         return superClass.getDeclaredField(fieldName);
/*    */       }
/*    */       catch (NoSuchFieldException localNoSuchFieldException)
/*    */       {
/* 63 */         superClass = superClass.getSuperclass();
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 70 */     throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + fieldName);
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.BeanUtils
 * JD-Core Version:    0.6.2
 */