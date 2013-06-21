/*    */ package com.sqds.taglibs;
/*    */ 
/*    */ import com.sqds.page.PageInfo;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.jsp.JspException;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import javax.servlet.jsp.PageContext;
/*    */ import javax.servlet.jsp.tagext.TagSupport;
/*    */ 
/*    */ public class GridTag extends TagSupport
/*    */ {
/*    */   private String column;
/*    */   private String name;
/*    */ 
/*    */   public int doStartTag()
/*    */     throws JspException
/*    */   {
/* 26 */     HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();
/* 27 */     PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
/*    */ 
/* 29 */     String orderby = pageInfo.getOrderBy();
/* 30 */     String order = pageInfo.getOrder();
/* 31 */     JspWriter out = this.pageContext.getOut();
/*    */     try {
/* 33 */       out.write(getGridTitle(this.name, this.column, orderby, order));
/*    */     } catch (IOException e) {
/* 35 */       e.printStackTrace();
/*    */     }
/* 37 */     return 6;
/*    */   }
/*    */ 
/*    */   public void setColumn(String column) {
/* 41 */     this.column = column;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 45 */     this.name = name;
/*    */   }
/*    */ 
/*    */   private String getGridTitle(String title, String field, String orderby, String orderType)
/*    */   {
/* 50 */     StringBuffer sb = new StringBuffer();
/* 51 */     sb.append("<a href=\"javascript:orderby('");
/* 52 */     sb.append(field);
/* 53 */     sb.append("','");
/* 54 */     if (orderType.toLowerCase().equals("asc"))
/* 55 */       sb.append("desc");
/*    */     else {
/* 57 */       sb.append("asc");
/*    */     }
/*    */ 
/* 60 */     sb.append("');\" class='orderby'>");
/* 61 */     sb.append(title);
/* 62 */     if (!orderby.equals("")) {
/* 63 */       if ((orderby.equals(field)) && (orderType.equals("asc")))
/* 64 */         sb.append("<img src='/images/down1.gif' border=0>");
/* 65 */       else if ((orderby.equals(field)) && (orderType.equals("desc"))) {
/* 66 */         sb.append("<img src='/images/up1.gif' border=0>");
/*    */       }
/*    */     }
/* 69 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.taglibs.GridTag
 * JD-Core Version:    0.6.2
 */