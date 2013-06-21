/*    */ package com.app.common.taglibs;
/*    */ 
/*    */ import com.app.common.model.DataDict;
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import javax.servlet.jsp.JspException;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import javax.servlet.jsp.PageContext;
/*    */ import javax.servlet.jsp.tagext.TagSupport;
/*    */ 
/*    */ public class DataDictTag extends TagSupport
/*    */ {
/*    */   private static final long serialVersionUID = -6655168769635753153L;
/*    */   private Map<String, DataDict> map;
/* 22 */   private String name = "";
/*    */ 
/*    */   public int doStartTag() throws JspException
/*    */   {
/* 26 */     JspWriter out = this.pageContext.getOut();
/*    */     try {
/* 28 */       DataDict dd = (DataDict)this.map.get(this.name);
/* 29 */       String value = "";
/* 30 */       if (dd != null) {
/* 31 */         value = dd.getAttributeName();
/*    */       }
/* 33 */       out.write(value);
/*    */     } catch (IOException e) {
/* 35 */       e.printStackTrace();
/*    */     }
/* 37 */     return 6;
/*    */   }
/*    */ 
/*    */   public void setMap(Map<String, DataDict> map)
/*    */   {
/* 45 */     this.map = map;
/*    */   }
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 52 */     this.name = name;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.app.common.taglibs.DataDictTag
 * JD-Core Version:    0.6.2
 */