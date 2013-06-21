/*     */ package com.sqds.menu;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class Node2 extends AbstractNode
/*     */ {
/*  18 */   private Log log = LogFactory.getLog(getClass());
/*     */ 
/*  20 */   protected final String icon_folderopen = "<img src=\"/images/menu/open.gif\" align=\"middle\">";
/*  21 */   protected final String icon_folderclose = "<img src=\"/images/menu/close.gif\" align=\"middle\">";
/*  22 */   protected final String icon_pageopen = "<img src=\"/images/menu/open_page.gif\" align=\"middle\">";
/*  23 */   protected final String icon_pageclose = "<img src=\"/images/menu/closed_page.gif\" align=\"middle\">";
/*  24 */   protected final String icon_minus = "<img src=\"/images/menu/minus.gif\" align=\"middle\">";
/*     */ 
/*     */   protected String indicate(int depth, int childCount, String url)
/*     */   {
/*  36 */     String s = "";
/*     */ 
/*  38 */     if (depth == 0)
/*     */     {
/*  40 */       s = s + "<img src=\"/images/menu/minus.gif\" align=\"middle\">" + "<img src=\"/images/menu/open.gif\" align=\"middle\">";
/*     */     }
/*     */     else {
/*  43 */       s = s + "<img src=\"/images/menu/invisible.gif\" width=\"" + 22 * depth + "\" height=\"1\">";
/*     */ 
/*  45 */       if (childCount <= 0) {
/*  46 */         if ("".equals(url))
/*  47 */           s = s + "<img src=\"/images/menu/minus.gif\" align=\"middle\">" + "<img src=\"/images/menu/open.gif\" align=\"middle\">";
/*     */         else
/*  49 */           s = s + "<img src=\"/images/menu/invisible.gif\" width=\"18\" height=\"1\">" + "<img src=\"/images/menu/closed_page.gif\" align=\"middle\">";
/*     */       }
/*     */       else {
/*  52 */         s = s + "<img src=\"/images/menu/minus.gif\" align=\"middle\">" + "<img src=\"/images/menu/open.gif\" align=\"middle\">";
/*     */       }
/*     */     }
/*  55 */     return s;
/*     */   }
/*     */ 
/*     */   public String expand(int depth)
/*     */   {
/*  63 */     StringBuffer sb = new StringBuffer();
/*  64 */     if (this.log.isDebugEnabled()) {
/*  65 */       this.log.debug("childList=" + this.childList);
/*  66 */       this.log.debug("current Node Info=" + getContent());
/*     */     }
/*  68 */     if (this.childList.size() > 0) {
/*  69 */       sb.append("<tr>\n");
/*  70 */       sb.append("<td>\n");
/*  71 */       sb.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"node" + (depth + 1) + "\">\n");
/*  72 */       for (int i = 0; i < this.childList.size(); i++) {
/*  73 */         Node2 childNode = (Node2)this.childList.get(i);
/*  74 */         List childContent = (List)childNode.getContent();
/*  75 */         if (this.log.isDebugEnabled()) {
/*  76 */           this.log.debug(childNode);
/*  77 */           this.log.debug(childNode.getChildList());
/*     */         }
/*  79 */         String checkedFlag = "";
/*  80 */         if (childContent.get(6).equals("true")) {
/*  81 */           checkedFlag = "checked";
/*     */         }
/*  83 */         sb.append("<tr>\n");
/*  84 */         sb.append("<td width=\"100%\" valign=\"middle\"> <input type=\"checkbox\" name=\"menuId\" value=\"" + childContent.get(0) + "\"" + checkedFlag + "/>" + indicate(depth + 1, childNode.getChildList().size(), childContent.get(3).toString()) + childContent.get(2) + "</td>\n");
/*  85 */         sb.append("</tr>\n");
/*  86 */         sb.append(childNode.expand(depth + 1));
/*     */       }
/*  88 */       sb.append("</table>\n");
/*  89 */       sb.append("</td>\n");
/*  90 */       sb.append("</tr>\n");
/*     */     }
/*     */ 
/*  93 */     if (depth == 0)
/*     */     {
/*  95 */       List rootContent = (List)getContent();
/*     */ 
/*  97 */       StringBuffer sbr = new StringBuffer();
/*  98 */       sbr.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"node" + depth + "\">");
/*  99 */       sbr.append("<tr>\n");
/* 100 */       String checkedFlag = "";
/* 101 */       if (rootContent.get(6).equals("true")) {
/* 102 */         checkedFlag = "checked";
/*     */       }
/* 104 */       sbr.append("<td width=\"100%\" valign=\"middle\"><input type=\"checkbox\" name=\"menuId\" value=\"" + rootContent.get(0) + "\"" + checkedFlag + "/>" + indicate(depth, this.childList.size(), rootContent.get(3).toString()) + rootContent.get(2) + "</td>\n");
/* 105 */       sbr.append("</tr>");
/* 106 */       sbr.append(sb);
/* 107 */       sbr.append("</table>");
/*     */ 
/* 109 */       return sbr.toString();
/*     */     }
/* 111 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public List expandToList(int depth, List list)
/*     */     throws Exception
/*     */   {
/* 119 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.menu.Node2
 * JD-Core Version:    0.6.2
 */