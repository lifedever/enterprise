/*     */ package com.app.common.service;
/*     */ 
/*     */ import com.app.common.model.DataDict;
/*     */ import com.sqds.hibernate.HibernateDao;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service
/*     */ public class DataDictManager extends HibernateDao<DataDict>
/*     */ {
/*     */   public List<DataDict> getList()
/*     */   {
/*  24 */     String hql = "from DataDict d where d.validFlag=1 order by d.orderId";
/*  25 */     return super.list(hql, new Object[0]);
/*     */   }
/*     */ 
/*     */   public DataDict getDataDict(String attributeName)
/*     */   {
/*  33 */     String hql = "from DataDict d where d.attributeName=? and d.validFlag=1";
/*  34 */     return (DataDict)super.findUnique(hql, new Object[] { attributeName });
/*     */   }
/*     */ 
/*     */   public List<DataDict> getList(int parentId)
/*     */   {
/*  42 */     String hql = "from DataDict d where d.parent.id=? and d.validFlag=1 order by d.orderId ,d.id asc";
/*  43 */     return super.list(hql, new Object[] { Integer.valueOf(parentId) });
/*     */   }
/*     */ 
/*     */   public List<DataDict> getListByParentAttributeName(String attributeName)
/*     */   {
/*  51 */     DataDict dd = getDataDict(attributeName);
/*  52 */     if (dd != null) {
/*  53 */       return getList(dd.getId().intValue());
/*     */     }
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */   public Map<String, DataDict> getMapByParentAttributeName(String attributeName)
/*     */   {
/*  64 */     List list = getListByParentAttributeName(attributeName);
/*  65 */     Map map = new HashMap();
/*  66 */     if (list != null) {
/*  67 */       for (DataDict dd : list) {
/*  68 */         map.put(dd.getAttributeValue(), dd);
/*     */       }
/*     */     }
/*  71 */     return map;
/*     */   }
/*     */ 
/*     */   public List<DataDict> getClassList()
/*     */   {
/*  78 */     String hql = "from DataDict d where d.parent.id is null and d.validFlag=1 order by d.orderId,id";
/*  79 */     return list(hql, new Object[0]);
/*     */   }
/*     */ 
/*     */   public Map getSonNum()
/*     */   {
/*  88 */     String hql = "select d.parent.id, count(*) from DataDict d group by d.parent.id";
/*  89 */     Query query = super.getSession().createQuery(hql);
/*  90 */     List list = query.list();
/*  91 */     Map data = new HashMap();
/*  92 */     for (int i = 0; i < list.size(); i++) {
/*  93 */       Object[] o = (Object[])list.get(i);
/*  94 */       data.put(o[0], o[1]);
/*     */     }
/*  96 */     return data;
/*     */   }
/*     */ 
/*     */   public List<DataDict> getAllList(int parentId)
/*     */   {
/* 103 */     String hql = "from DataDict d where d.parent.id=? order by d.orderId,d.id";
/* 104 */     return super.list(hql, new Object[] { Integer.valueOf(parentId) });
/*     */   }
/*     */ 
/*     */   public void delItems(int parentId)
/*     */   {
/* 111 */     String hql = "delete DataDict where parent.id=:id";
/* 112 */     Query query = super.getSession().createQuery(hql);
/* 113 */     query.setInteger("id", parentId);
/* 114 */     query.executeUpdate();
/*     */   }
/*     */   public void saveDataDictAndItems(DataDict parent) {
/* 117 */     save(parent);
/* 118 */     delItems(parent.getId().intValue());
/* 119 */     List list = parent.getDicts();
/* 120 */     for (int i = 0; (list != null) && (i < list.size()); i++)
/* 121 */       save((DataDict)list.get(i));
/*     */   }
/*     */ 
/*     */   public List<DataDict> getAllJoinClassList()
/*     */   {
/* 129 */     String hql = "from DataDict d where d.parent.id is null and d.validFlag=1 and joinFlag = 1 order by d.orderId,id";
/* 130 */     return list(hql, new Object[0]);
/*     */   }
/*     */ 
/*     */   public Map<Integer, DataDict> getAllJoinClassMap() {
/* 134 */     List list = getAllJoinClassList();
/* 135 */     Map map = new HashMap();
/* 136 */     for (DataDict dataDict : list) {
/* 137 */       map.put(dataDict.getId(), dataDict);
/*     */     }
/* 139 */     return map;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.app.common.service.DataDictManager
 * JD-Core Version:    0.6.2
 */