/*    */ package com.app.common.taglibs;
/*    */ 
/*    */ import com.app.common.model.Region;
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import javax.servlet.jsp.JspException;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import javax.servlet.jsp.PageContext;
/*    */ import javax.servlet.jsp.tagext.TagSupport;
/*    */ 
/*    */ public class RegionTag extends TagSupport
/*    */ {
/*    */   private static final long serialVersionUID = -3899123672356930131L;
/*    */   private String code;
/*    */   private Map<String, Region> map;
/*    */ 
/*    */   public int doStartTag()
/*    */     throws JspException
/*    */   {
/* 25 */     JspWriter out = this.pageContext.getOut();
/*    */     try {
/* 27 */       Region region = (Region)this.map.get(this.code);
/* 28 */       String value = "";
/* 29 */       if (region != null) {
/* 30 */         value = region.getName();
/*    */       }
/* 32 */       out.write(value);
/*    */     } catch (IOException e) {
/* 34 */       e.printStackTrace();
/*    */     }
/* 36 */     return 6;
/*    */   }
/*    */ 
/*    */   public void setCode(String code)
/*    */   {
/* 43 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public void setMap(Map<String, Region> map)
/*    */   {
/* 50 */     this.map = map;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.app.common.taglibs.RegionTag
 * JD-Core Version:    0.6.2
 */