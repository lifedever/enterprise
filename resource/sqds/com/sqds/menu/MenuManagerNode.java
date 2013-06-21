/*     */ package com.sqds.menu;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ public class MenuManagerNode extends AbstractNode
/*     */ {
/*  16 */   protected final String icon_folderopen = "<img src=\"/images/menu/open.gif\" align=\"middle\">";
/*  17 */   protected final String icon_folderclose = "<img src=\"/images/menu/close.gif\" align=\"middle\">";
/*  18 */   protected final String icon_pageopen = "<img src=\"/images/menu/open_page.gif\" align=\"middle\">";
/*  19 */   protected final String icon_pageclose = "<img src=\"/images/menu/closed_page.gif\" align=\"middle\">";
/*  20 */   protected final String icon_minus = "<img src=\"/images/menu/minus.gif\" align=\"middle\">";
/*     */ 
/*     */   protected String indicate(int depth, int childCount, String url)
/*     */   {
/*  30 */     String s = "";
/*     */ 
/*  32 */     if (depth == 0)
/*     */     {
/*  34 */       s = s + "<img src=\"/images/menu/minus.gif\" align=\"middle\">" + "<img src=\"/images/menu/open.gif\" align=\"middle\">";
/*     */     }
/*     */     else {
/*  37 */       s = s + "<img src=\"/images/menu/invisible.gif\" width=\"" + 22 * depth + "\" height=\"1\">";
/*     */ 
/*  39 */       if (childCount <= 0) {
/*  40 */         if ("".equals(url))
/*  41 */           s = s + "<img src=\"/images/menu/minus.gif\" align=\"middle\">" + "<img src=\"/images/menu/open.gif\" align=\"middle\">";
/*     */         else
/*  43 */           s = s + "<img src=\"/images/menu/invisible.gif\" width=\"18\" height=\"1\">" + "<img src=\"/images/menu/closed_page.gif\" align=\"middle\">";
/*     */       }
/*     */       else {
/*  46 */         s = s + "<img src=\"/images/menu/minus.gif\" align=\"middle\">" + "<img src=\"/images/menu/open.gif\" align=\"middle\">";
/*     */       }
/*     */     }
/*  49 */     return s;
/*     */   }
/*     */ 
/*     */   public String expand(int depth)
/*     */   {
/*  57 */     StringBuffer sb = new StringBuffer();
/*  58 */     if (this.childList.size() > 0) {
/*  59 */       sb.append("<tr>\n");
/*  60 */       sb.append("<td colspan=\"4\">\n");
/*  61 */       sb.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"node" + (depth + 1) + "\" id=\"list_table" + (depth + 1) + "\">\n");
/*  62 */       for (int i = 0; i < this.childList.size(); i++) {
/*  63 */         MenuManagerNode childNode = (MenuManagerNode)this.childList.get(i);
/*  64 */         List childContent = (List)childNode.getContent();
/*     */ 
/*  66 */         sb.append("<tr height='23' bgcolor='#FFFFFF' onmouseover=this.bgColor='#F7F7F7'; onmouseout=this.bgColor='#FFFFFF';  id=" + childContent.get(0) + ">\n");
/*  67 */         sb.append("<td width=\"62%\" valign=\"middle\"><input type='radio' alt=\"menuForm.do?parentId=" + childContent.get(0) + "&height=400&width=600&inlineId=myOnPageContent\" title=\"添加菜单\" class=\"thickbox\" name='menu_id' value='" + childContent.get(0) + "' />" + indicate(depth + 1, childNode.getChildList().size(), childContent.get(3).toString()) + "<span title=\"" + childContent.get(6) + "\">" + childContent.get(2) + "</span>" + "</td>\n");
/*     */ 
/*  70 */         sb.append("<td width=\"5%\"><a href=\"menuForm.do?id=" + childContent.get(0) + "&height=400&width=600\" title=\"修改菜单\" class=\"thickbox\"><img src=\"/images/edit.gif\" border='0'></a></td>\n");
/*     */ 
/*  72 */         sb.append("<td width=\"5%\"><a href=\"menuDel.do?id=" + childContent.get(0) + "\" onclick=\"confirm('确认删除吗？')\"><img src=\"/images/del.gif\" border='0'></a></td>\n");
/*  73 */         sb.append("</tr>\n");
/*  74 */         sb.append(childNode.expand(depth + 1));
/*     */       }
/*  76 */       sb.append("</table>\n");
/*  77 */       sb.append("</td>\n");
/*  78 */       sb.append("</tr>\n");
/*     */     }
/*     */ 
/*  81 */     if (depth == 0)
/*     */     {
/*  83 */       List rootContent = (List)getContent();
/*     */ 
/*  86 */       StringBuffer sbr = new StringBuffer();
/*  87 */       sbr.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_data_style\">");
/*  88 */       sbr.append("<tr  bgcolor='#FFFFFF' onmouseover=this.bgColor='#F7F7F7'; onmouseout=this.bgColor='#FFFFFF';>\n");
/*  89 */       sbr.append("<td width=\"62%\" valign=\"middle\"><input type='radio' alt=\"menuForm.do?parentId=" + rootContent.get(0) + "&height=400&width=600&inlineId=myOnPageContent\" title=\"添加菜单\" class=\"thickbox\" name='menu_id' value='" + rootContent.get(0) + "' />" + indicate(depth, this.childList.size(), rootContent.get(3).toString()) + rootContent.get(2) + "</td>\n");
/*     */ 
/*  91 */       sbr.append("<td width=\"5%\"><a href=\"menuForm.do?id=" + rootContent.get(0) + "&height=400&width=600\" title=\"修改菜单\" class=\"thickbox\"><img src=\"/images/edit.gif\" border='0'></a></td>\n");
/*  92 */       sbr.append("<td width=\"5%\">&nbsp;</td>\n");
/*     */ 
/*  94 */       sbr.append("</tr>");
/*  95 */       sbr.append(sb);
/*  96 */       sbr.append("</table>");
/*     */ 
/*  98 */       return sbr.toString();
/*     */     }
/* 100 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public List expandToList(int depth, List list)
/*     */     throws Exception
/*     */   {
/* 108 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.menu.MenuManagerNode
 * JD-Core Version:    0.6.2
 */