/*    */ package com.sqds.taglibs;
/*    */ 
/*    */ import javax.servlet.jsp.JspException;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import javax.servlet.jsp.PageContext;
/*    */ import javax.servlet.jsp.tagext.TagSupport;
/*    */ 
/*    */ public class CalendarTag extends TagSupport
/*    */ {
/*    */   public int doStartTag()
/*    */     throws JspException
/*    */   {
/*    */     try
/*    */     {
/* 22 */       JspWriter out = this.pageContext.getOut();
/* 23 */       out.write("<img src=\"/images/date.gif\" border=\"0\" alt=\"请点击图标选择日期\" id=\"" + this.id + "Ico\" style=\"cursor:hand\"><script type=\"text/javascript\">Calendar.setup(  { inputField:\"" + this.id + "\",ifFormat: \"%Y-%m-%d\",button:\"" + this.id + "Ico\"});</script>");
/*    */     } catch (Exception e) {
/* 25 */       throw new JspException(e.getMessage());
/*    */     }
/* 27 */     return 6;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.taglibs.CalendarTag
 * JD-Core Version:    0.6.2
 */