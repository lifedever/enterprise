/*     */ package com.app.common.service;
/*     */ 
/*     */ import com.app.common.model.Region;
/*     */ import com.sqds.hibernate.HibernateDao;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service
/*     */ public class RegionManager extends HibernateDao<Region>
/*     */ {
/*     */   public List<Region> getActiveList()
/*     */   {
/*  25 */     String hql = "from Region r where r.activeFlag=1 order by r.code";
/*  26 */     Query query = super.getSession().createQuery(hql);
/*  27 */     query.setCacheable(true);
/*  28 */     return query.list();
/*     */   }
/*     */ 
/*     */   public List<Region> getAllList()
/*     */   {
/*  35 */     String hql = "from Region r order by r.code";
/*  36 */     Query query = super.getSession().createQuery(hql);
/*  37 */     query.setCacheable(true);
/*  38 */     return query.list();
/*     */   }
/*     */ 
/*     */   public List<Region> getListByParentCode(String parentCode)
/*     */   {
/*  46 */     String hql = "from Region r where r.parent.code=:parentCode and r.activeFlag=1 order by r.code";
/*  47 */     Query query = super.getSession().createQuery(hql);
/*  48 */     query.setString("parentCode", parentCode);
/*  49 */     query.setCacheable(true);
/*  50 */     return query.list();
/*     */   }
/*     */ 
/*     */   public List<Region> getAllListByParentCode(String parentCode)
/*     */   {
/*  58 */     String hql = "from Region r where r.parent.code=:parentCode order by r.code";
/*  59 */     Query query = super.getSession().createQuery(hql);
/*  60 */     query.setString("parentCode", parentCode);
/*  61 */     query.setCacheable(true);
/*  62 */     return query.list();
/*     */   }
/*     */ 
/*     */   public List<Region> getRootList()
/*     */   {
/*  69 */     String hql = "from Region r where r.parent is null and r.activeFlag=1 order by r.code";
/*  70 */     Query query = super.getSession().createQuery(hql);
/*  71 */     query.setCacheable(true);
/*  72 */     return query.list();
/*     */   }
/*     */ 
/*     */   public Map<String, Long> countSonNum(String[] codes)
/*     */   {
/*  82 */     String hql = "select r.parent.code, count(*) from Region r where r.parent.code in (:codes) group by r.parent.code";
/*  83 */     Query query = super.getSession().createQuery(hql);
/*  84 */     query.setParameterList("codes", codes);
/*  85 */     query.setCacheable(true);
/*  86 */     List list = query.list();
/*  87 */     Map data = new HashMap();
/*  88 */     for (int i = 0; i < list.size(); i++) {
/*  89 */       Object[] o = (Object[])list.get(i);
/*  90 */       data.put((String)o[0], (Long)o[1]);
/*     */     }
/*  92 */     return data;
/*     */   }
/*     */ 
/*     */   public List<Region> getRegionList(String[] codes)
/*     */   {
/* 103 */     String hql = "from Region r where r.code in (:codes) and r.activeFlag = 1 order by r.code";
/* 104 */     Query query = super.getSession().createQuery(hql);
/* 105 */     query.setParameterList("codes", codes);
/* 106 */     query.setCacheable(true);
/* 107 */     return query.list();
/*     */   }
/*     */ 
/*     */   public Map<String, Region> getAllRegionMap()
/*     */   {
/* 117 */     return regionListToMap();
/*     */   }
/*     */ 
/*     */   public Map<String, Region> getActiveRegionMap()
/*     */   {
/* 124 */     return activeRegionListToMap();
/*     */   }
/*     */ 
/*     */   public String getMaxCode(String code)
/*     */   {
/* 132 */     String hql = "select max(r.code) from Region r where r.parent.code=?";
/* 133 */     List list = super.list(hql, new Object[] { code });
/* 134 */     String maxcode = "";
/* 135 */     if (list.size() == 1) {
/* 136 */       maxcode = (String)list.get(0);
/*     */     }
/* 138 */     return maxcode;
/*     */   }
/*     */ 
/*     */   public Region getRegionByName(String name)
/*     */   {
/* 147 */     String hql = "from Region where name=?";
/* 148 */     return (Region)super.findUnique(hql, new Object[] { name });
/*     */   }
/*     */ 
/*     */   private Map<String, Region> regionListToMap() {
/* 152 */     List list = getAllList();
/* 153 */     Map data = new HashMap();
/* 154 */     for (int i = 0; i < list.size(); i++) {
/* 155 */       Region region = (Region)list.get(i);
/* 156 */       data.put(region.getCode(), region);
/*     */     }
/* 158 */     return data;
/*     */   }
/*     */   private Map<String, Region> activeRegionListToMap() {
/* 161 */     List list = getActiveList();
/* 162 */     Map data = new HashMap();
/* 163 */     for (int i = 0; i < list.size(); i++) {
/* 164 */       Region region = (Region)list.get(i);
/* 165 */       data.put(region.getCode(), region);
/*     */     }
/* 167 */     return data;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.app.common.service.RegionManager
 * JD-Core Version:    0.6.2
 */