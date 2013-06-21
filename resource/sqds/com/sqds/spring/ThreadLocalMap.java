/*    */ package com.sqds.spring;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public abstract class ThreadLocalMap
/*    */ {
/* 14 */   protected static final ThreadLocal<Map<String, Object>> threadContext = new MapThreadLocal(null);
/*    */ 
/*    */   public static void put(String key, Object value)
/*    */   {
/* 24 */     getContextMap().put(key, value);
/*    */   }
/*    */ 
/*    */   public static Object remove(String key)
/*    */   {
/* 33 */     return getContextMap().remove(key);
/*    */   }
/*    */ 
/*    */   public static Object get(String key)
/*    */   {
/* 42 */     return getContextMap().get(key);
/*    */   }
/*    */ 
/*    */   protected static Map<String, Object> getContextMap()
/*    */   {
/* 64 */     return (Map)threadContext.get();
/*    */   }
/*    */ 
/*    */   public static void reset()
/*    */   {
/* 72 */     getContextMap().clear();
/*    */   }
/*    */ 
/*    */   private static class MapThreadLocal extends ThreadLocal<Map<String, Object>>
/*    */   {
/*    */     protected Map<String, Object> initialValue()
/*    */     {
/* 47 */       return new HashMap()
/*    */       {
/*    */         private static final long serialVersionUID = 3637958959138295593L;
/*    */ 
/*    */         public Object put(String key, Object value) {
/* 52 */           return super.put(key, value);
/*    */         }
/*    */       };
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.spring.ThreadLocalMap
 * JD-Core Version:    0.6.2
 */