/*     */ package com.sqds.menu;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class NodeProductor
/*     */ {
/*     */   protected static void sendError(String msg, String sql, Exception e)
/*     */     throws Exception
/*     */   {
/*  28 */     throw new RuntimeException(e);
/*     */   }
/*     */ 
/*     */   protected static void sendError(String msg, Exception e)
/*     */     throws Exception
/*     */   {
/*  39 */     throw new RuntimeException(e);
/*     */   }
/*     */ 
/*     */   public AbstractNode getRoot(List list, int selfIndex, int parentIndex, AbstractNode targetNode)
/*     */     throws Exception
/*     */   {
/*  53 */     AbstractNode node = null;
/*  54 */     AbstractNode parentNode = null;
/*  55 */     AbstractNode rootNode = null;
/*  56 */     Map map = new HashMap();
/*     */ 
/*  58 */     Class nodeClass = targetNode.getClass();
/*     */     try
/*     */     {
/*  61 */       if (list != null)
/*     */       {
/*  63 */         for (int i = 0; i < list.size(); i++)
/*     */         {
/*  65 */           List row = (List)list.get(i);
/*     */ 
/*  67 */           String id = (String)row.get(selfIndex);
/*  68 */           String parentId = (String)row.get(parentIndex);
/*     */ 
/*  70 */           if ((parentId != null) && (!"-1".equals(parentId)))
/*     */           {
/*  72 */             if (map.get(id) == null)
/*     */             {
/*  74 */               node = (AbstractNode)nodeClass.newInstance();
/*  75 */               node.setContent(row);
/*  76 */               map.put(id, node);
/*     */             }
/*  79 */             else if (((AbstractNode)map.get(id)).getContent() == null) {
/*  80 */               ((AbstractNode)map.get(id)).setContent(row);
/*     */             }
/*     */ 
/*  83 */             if (map.get(parentId) == null)
/*     */             {
/*  85 */               parentNode = (AbstractNode)nodeClass.newInstance();
/*  86 */               parentNode.add((AbstractNode)map.get(id));
/*  87 */               map.put(parentId, parentNode);
/*     */             }
/*     */             else {
/*  90 */               ((AbstractNode)map.get(parentId)).add((AbstractNode)map.get(id));
/*     */             }
/*     */ 
/*     */           }
/*  94 */           else if (map.get(id) == null)
/*     */           {
/*  96 */             rootNode = (AbstractNode)nodeClass.newInstance();
/*  97 */             rootNode.setContent(row);
/*  98 */             map.put(id, rootNode);
/*     */           }
/* 101 */           else if (((AbstractNode)map.get(id)).getContent() == null) {
/* 102 */             ((AbstractNode)map.get(id)).setContent(row);
/* 103 */             rootNode = (AbstractNode)map.get(id);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 110 */       sendError("取得根节点树错误", e);
/*     */     }
/* 112 */     return rootNode;
/*     */   }
/*     */ 
/*     */   public AbstractNode getAppointNode(List list, String NodeId, int selfIndex, int parentIndex, AbstractNode targetNode)
/*     */     throws Exception
/*     */   {
/* 127 */     AbstractNode node = null;
/* 128 */     AbstractNode parentNode = null;
/* 129 */     Map map = new HashMap();
/*     */ 
/* 131 */     Class nodeClass = targetNode.getClass();
/*     */     try
/*     */     {
/* 134 */       if (list != null)
/*     */       {
/* 136 */         for (int i = 0; i < list.size(); i++) {
/* 137 */           List row = (List)list.get(i);
/*     */ 
/* 139 */           String id = (String)row.get(selfIndex);
/* 140 */           String parentId = (String)row.get(parentIndex);
/*     */ 
/* 142 */           if (map.get(id) == null)
/*     */           {
/* 144 */             node = (AbstractNode)nodeClass.newInstance();
/* 145 */             node.setContent(row);
/*     */ 
/* 147 */             map.put(id, node);
/*     */           }
/* 150 */           else if (((AbstractNode)map.get(id)).getContent() == null) {
/* 151 */             ((AbstractNode)map.get(id)).setContent(row);
/*     */           }
/*     */ 
/* 154 */           if (map.get(parentId) == null)
/*     */           {
/* 156 */             parentNode = (AbstractNode)nodeClass.newInstance();
/* 157 */             parentNode.add((AbstractNode)map.get(id));
/* 158 */             map.put(parentId, parentNode);
/*     */           }
/*     */           else {
/* 161 */             ((AbstractNode)map.get(parentId)).add((AbstractNode)map.get(id));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 167 */       sendError("取得指定节点数错误", e);
/*     */     }
/*     */ 
/* 170 */     return (AbstractNode)map.get(NodeId);
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.menu.NodeProductor
 * JD-Core Version:    0.6.2
 */