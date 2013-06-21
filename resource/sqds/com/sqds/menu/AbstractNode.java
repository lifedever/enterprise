/*    */ package com.sqds.menu;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public abstract class AbstractNode
/*    */ {
/* 17 */   protected List childList = new ArrayList();
/* 18 */   protected Object content = null;
/*    */ 
/*    */   protected static void sendError(String msg, String sql, Exception e)
/*    */     throws Exception
/*    */   {
/* 29 */     throw new RuntimeException(e);
/*    */   }
/*    */ 
/*    */   protected static void sendError(String msg, Exception e)
/*    */     throws Exception
/*    */   {
/* 40 */     throw new RuntimeException(e);
/*    */   }
/*    */ 
/*    */   public void add(AbstractNode node)
/*    */   {
/* 47 */     this.childList.add(node);
/*    */   }
/*    */ 
/*    */   public abstract String expand(int paramInt);
/*    */ 
/*    */   public abstract List expandToList(int paramInt, List paramList)
/*    */     throws Exception;
/*    */ 
/*    */   public List getChildList()
/*    */   {
/* 68 */     return this.childList;
/*    */   }
/*    */   public Object getContent() {
/* 71 */     return this.content;
/*    */   }
/*    */   public void setContent(Object content) {
/* 74 */     this.content = content;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.menu.AbstractNode
 * JD-Core Version:    0.6.2
 */