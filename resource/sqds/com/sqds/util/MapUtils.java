/*    */ package com.sqds.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MapUtils
/*    */ {
/*    */   public List listMap(List listMap)
/*    */   {
/* 29 */     List list = new ArrayList();
/*    */ 
/* 31 */     for (int i = 0; i < listMap.size(); i++)
/*    */     {
/* 33 */       List tempList = new ArrayList();
/* 34 */       Map map = new HashMap();
/*    */       try
/*    */       {
/* 37 */         map = (Map)listMap.get(i);
/*    */       } catch (Exception e) {
/* 39 */         e.printStackTrace(System.out);
/*    */       }
/*    */ 
/* 42 */       Set set = map.entrySet();
/* 43 */       Iterator iterSet = set.iterator();
/*    */ 
/* 45 */       while (iterSet.hasNext()) {
/* 46 */         Map.Entry entry = (Map.Entry)iterSet.next();
/* 47 */         tempList.add(entry.getValue());
/*    */       }
/*    */ 
/* 51 */       list.add(tempList);
/*    */     }
/*    */ 
/* 54 */     return list;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.MapUtils
 * JD-Core Version:    0.6.2
 */