/*     */ package com.sqds.menu;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ public class NodeTree extends AbstractNode
/*     */ {
/*  16 */   private String temp1 = "";
/*     */ 
/*     */   protected String indicate(int depth, String sign, int childCount, String nodeUrl, String nodeName)
/*     */   {
/*  28 */     String space = "&nbsp;";
/*  29 */     String s = "";
/*  30 */     this.temp1 = ("tree" + depth);
/*  31 */     if ((nodeUrl.equals("")) || (nodeUrl.equals("#"))) {
/*  32 */       nodeUrl = "javascript:";
/*     */     }
/*     */ 
/*  35 */     if (depth == 0)
/*     */     {
/*  37 */       List rootContent = (List)getContent();
/*  38 */       s = s + "foldersTree = gFld(\"" + space + rootContent.get(2) + "\", \"" + nodeUrl + "\")\n";
/*  39 */       s = s + "foldersTree.iconSrc = \"/images/tree/root.gif\"\n";
/*  40 */       s = s + "foldersTree.iconSrcClosed = \"/images/tree/root.gif\"\n";
/*     */     } else {
/*  42 */       String temp2 = "tree" + (depth - 1);
/*     */ 
/*  44 */       if (depth == 1) {
/*  45 */         temp2 = "foldersTree";
/*     */       }
/*  47 */       if (childCount <= 0)
/*  48 */         s = s + "insDoc(" + temp2 + ", gLnk(\"R\", \"" + space + nodeName + "\",\"" + nodeUrl + "\"))\n";
/*     */       else {
/*  50 */         s = s + this.temp1 + " = insFld(" + temp2 + ", gFld(\"" + space + nodeName + "\", \"" + nodeUrl + "\"))\n";
/*     */       }
/*     */     }
/*  53 */     return s;
/*     */   }
/*     */ 
/*     */   public String expand(int depth, String sign, int parentId)
/*     */   {
/*  69 */     StringBuffer sb = new StringBuffer();
/*     */ 
/*  71 */     if (this.childList.size() > 0)
/*     */     {
/*  73 */       for (int i = 0; i < this.childList.size(); i++) {
/*  74 */         NodeTree childNode = (NodeTree)this.childList.get(i);
/*  75 */         List childContent = (List)childNode.getContent();
/*  76 */         int childCount = childNode.getChildList().size();
/*     */ 
/*  78 */         String nodeId = (String)childContent.get(0);
/*  79 */         String nodeName = (String)childContent.get(2);
/*  80 */         String nodeUrl = (String)childContent.get(3);
/*     */ 
/*  82 */         sb.append(indicate(depth + 1, nodeId, childCount, nodeUrl, nodeName));
/*  83 */         sb.append(childNode.expand(depth + 1, nodeId, parentId));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  89 */     if (depth == 0)
/*     */     {
/*  91 */       StringBuffer sbr = new StringBuffer();
/*  92 */       sbr.append(indicate(depth, sign, this.childList.size(), "", ""));
/*  93 */       sbr.append(sb);
/*  94 */       return sbr.toString();
/*     */     }
/*  96 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String expand(int depth)
/*     */   {
/* 101 */     return expand(depth, "0", 0);
/*     */   }
/*     */ 
/*     */   public List expandToList(int depth, List list) throws Exception {
/* 105 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.menu.NodeTree
 * JD-Core Version:    0.6.2
 */