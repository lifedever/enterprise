/*     */ package com.sqds.hibernate;
/*     */ 
/*     */ import com.sqds.page.PageInfo;
/*     */ import com.sqds.util.BeanUtils;
/*     */ import com.sqds.util.GenericsUtils;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.hibernate.Criteria;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.criterion.CriteriaSpecification;
/*     */ import org.hibernate.criterion.Criterion;
/*     */ import org.hibernate.criterion.Order;
/*     */ import org.hibernate.criterion.Projection;
/*     */ import org.hibernate.criterion.Projections;
/*     */ import org.hibernate.criterion.Restrictions;
/*     */ import org.hibernate.impl.CriteriaImpl;
/*     */ import org.hibernate.transform.ResultTransformer;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ 
/*     */ public class HibernateDao<T>
/*     */ {
/*  40 */   protected Logger logger = LoggerFactory.getLogger(getClass());
/*     */   protected Class<T> entityClass;
/*     */   protected SessionFactory sessionFactory;
/*     */ 
/*     */   @Autowired
/*     */   public void setSessionFactory(SessionFactory sessionFactory)
/*     */   {
/*  47 */     this.sessionFactory = sessionFactory;
/*  48 */     this.entityClass = GenericsUtils.getSuperClassGenricType(getClass());
/*     */   }
/*     */ 
/*     */   public Session getSession()
/*     */   {
/*  56 */     return this.sessionFactory.getCurrentSession();
/*     */   }
/*     */ 
/*     */   public SessionFactory getSessionFactory() {
/*  60 */     return this.sessionFactory;
/*     */   }
/*     */ 
/*     */   public void save(T entity)
/*     */   {
/*  68 */     if (entity != null)
/*  69 */       getSession().saveOrUpdate(entity);
/*     */   }
/*     */ 
/*     */   public void update(T entity)
/*     */   {
/*  78 */     save(entity);
/*     */   }
/*     */ 
/*     */   public void delete(Serializable id)
/*     */   {
/*  86 */     if (id != null)
/*  87 */       deleteObject(get(id));
/*     */   }
/*     */ 
/*     */   public void deleteObject(T entity)
/*     */   {
/*  92 */     if (entity != null)
/*  93 */       getSession().delete(entity);
/*     */   }
/*     */ 
/*     */   public List<T> listAll()
/*     */   {
/* 102 */     return findByCriteria(new Criterion[0]);
/*     */   }
/*     */ 
/*     */   public PageInfo<T> list(PageInfo<T> page)
/*     */   {
/* 111 */     return findByCriteria(page, new Criterion[0]);
/*     */   }
/*     */ 
/*     */   public T get(Serializable id)
/*     */   {
/* 118 */     return getSession().get(this.entityClass, id);
/*     */   }
/*     */ 
/*     */   public List<T> list(String hql, Object[] values)
/*     */   {
/* 128 */     return createQuery(hql, values).list();
/*     */   }
/*     */ 
/*     */   public PageInfo<T> list(PageInfo<T> page, String hql, Object[] values)
/*     */   {
/* 142 */     if (page.isAutoCount()) {
/* 143 */       long total = countQueryResult(hql, values);
/* 144 */       page.setTotalCount((int)total);
/*     */ 
/* 146 */       if (total == 0L) {
/* 147 */         page.setResult(new Vector());
/* 148 */         return page;
/*     */       }
/*     */     }
/* 151 */     Query q = createQuery(hql, values);
/* 152 */     if (page.isFirstSetted()) {
/* 153 */       q.setFirstResult(page.getFirst());
/*     */     }
/* 155 */     if (page.isPageSizeSetted()) {
/* 156 */       q.setMaxResults(page.getPageSize());
/*     */     }
/* 158 */     page.setResult(q.list());
/* 159 */     return page;
/*     */   }
/*     */ 
/*     */   public long countQueryResult(String hql, Object[] values) {
/* 163 */     String newHql = removeFetch(removeOrders(hql));
/* 164 */     String regex = "select\\s*(distinct[^,]*)(.*) from (.*)";
/* 165 */     Pattern p = Pattern.compile(regex, 2);
/* 166 */     Matcher m = p.matcher(newHql);
/* 167 */     if (m.find())
/* 168 */       newHql = newHql.replaceAll(regex, "select count($1) from $3");
/*     */     else {
/* 170 */       newHql = "select count(*) " + removeSelect(newHql);
/*     */     }
/* 172 */     return findLong(newHql, values).longValue();
/*     */   }
/*     */ 
/*     */   public T findUnique(String hql, Object[] values)
/*     */   {
/* 178 */     return createQuery(hql, values).uniqueResult();
/*     */   }
/*     */ 
/*     */   public Integer findInt(String hql, Object[] values)
/*     */   {
/* 185 */     return (Integer)findUnique(hql, values);
/*     */   }
/*     */ 
/*     */   public Long findLong(String hql, Object[] values)
/*     */   {
/* 192 */     return (Long)findUnique(hql, values);
/*     */   }
/*     */ 
/*     */   public List<T> findByCriteria(Criterion[] criterion)
/*     */   {
/* 200 */     return createCriteria(criterion).list();
/*     */   }
/*     */ 
/*     */   public PageInfo<T> findByCriteria(PageInfo pageInfo, Criterion[] criterion)
/*     */   {
/* 213 */     Criteria c = createCriteria(criterion);
/* 214 */     return findByCriteria(pageInfo, c, criterion);
/*     */   }
/*     */ 
/*     */   public PageInfo<T> findByCriteria(PageInfo pageInfo, Criteria c, Criterion[] criterion)
/*     */   {
/* 225 */     if (pageInfo.isAutoCount()) {
/* 226 */       int total = countQueryResult(pageInfo, c);
/* 227 */       pageInfo.setTotalCount(total);
/*     */ 
/* 229 */       if (total == 0) {
/* 230 */         pageInfo.setResult(new Vector());
/* 231 */         return pageInfo;
/*     */       }
/*     */     }
/* 234 */     if (pageInfo.isFirstSetted()) {
/* 235 */       c.setFirstResult(pageInfo.getFirst());
/*     */     }
/* 237 */     if (pageInfo.isPageSizeSetted()) {
/* 238 */       c.setMaxResults(pageInfo.getPageSize());
/*     */     }
/* 240 */     if (pageInfo.isOrderBySetted()) {
/* 241 */       if (pageInfo.getOrder().endsWith("asc"))
/* 242 */         c.addOrder(Order.asc(pageInfo.getOrderBy()));
/*     */       else {
/* 244 */         c.addOrder(Order.desc(pageInfo.getOrderBy()));
/*     */       }
/*     */     }
/* 247 */     pageInfo.setResult(c.list());
/* 248 */     return pageInfo;
/*     */   }
/*     */ 
/*     */   public List<T> listByProperty(String propertyName, Object value)
/*     */   {
/* 255 */     return createCriteria(new Criterion[] { Restrictions.eq(propertyName, value) }).list();
/*     */   }
/*     */ 
/*     */   public T findUniqueByProperty(String propertyName, Object value)
/*     */   {
/* 262 */     return createCriteria(new Criterion[] { Restrictions.eq(propertyName, value) }).uniqueResult();
/*     */   }
/*     */ 
/*     */   public Query createQuery(String queryString, Object[] values)
/*     */   {
/* 269 */     Query queryObject = getSession().createQuery(queryString);
/* 270 */     if (values != null) {
/* 271 */       for (int i = 0; i < values.length; i++) {
/* 272 */         queryObject.setParameter(i, values[i]);
/*     */       }
/*     */     }
/* 275 */     return queryObject;
/*     */   }
/*     */ 
/*     */   public void saveOjbects(Collection entities)
/*     */   {
/* 281 */     Session session = getSession();
/* 282 */     for (Iterator it = entities.iterator(); it.hasNext(); )
/* 283 */       session.saveOrUpdate(it.next());
/*     */   }
/*     */ 
/*     */   public void removeObjects(Collection entities)
/*     */   {
/* 293 */     Session session = getSession();
/* 294 */     for (Iterator it = entities.iterator(); it.hasNext(); )
/* 295 */       session.delete(it.next());
/*     */   }
/*     */ 
/*     */   public void updateObjects(Collection entities)
/*     */   {
/* 303 */     saveOjbects(entities);
/*     */   }
/*     */ 
/*     */   private Criteria createCriteria(Criterion[] criterions)
/*     */   {
/* 310 */     Criteria criteria = getSession().createCriteria(this.entityClass);
/* 311 */     for (Criterion c : criterions) {
/* 312 */       if (c != null)
/* 313 */         criteria.add(c);
/*     */     }
/* 315 */     return criteria;
/*     */   }
/*     */ 
/*     */   private boolean isPropertyUnique(String propertyName, Object newValue, Object orgValue)
/*     */   {
/* 325 */     if ((newValue == null) || (newValue.equals(orgValue))) {
/* 326 */       return true;
/*     */     }
/* 328 */     Object object = findUniqueByProperty(propertyName, newValue);
/* 329 */     return object == null;
/*     */   }
/*     */ 
/*     */   protected int countQueryResult(PageInfo<T> page, Criteria c)
/*     */   {
/* 337 */     CriteriaImpl impl = (CriteriaImpl)c;
/*     */ 
/* 340 */     Projection projection = impl.getProjection();
/* 341 */     ResultTransformer transformer = impl.getResultTransformer();
/*     */ 
/* 343 */     List orderEntries = null;
/*     */     try {
/* 345 */       orderEntries = (List)BeanUtils.getFieldValue(impl, "orderEntries");
/* 346 */       BeanUtils.setFieldValue(impl, "orderEntries", new ArrayList());
/*     */     } catch (Exception e) {
/* 348 */       this.logger.error("不可能抛出的异常:{}", e.getMessage());
/*     */     }
/*     */ 
/* 353 */     int totalCount = ((Integer)c.setProjection(Projections.rowCount()).uniqueResult()).intValue();
/*     */ 
/* 356 */     c.setProjection(projection);
/*     */ 
/* 358 */     if (projection == null) {
/* 359 */       c.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
/*     */     }
/* 361 */     if (transformer != null) {
/* 362 */       c.setResultTransformer(transformer);
/*     */     }
/*     */     try
/*     */     {
/* 366 */       BeanUtils.setFieldValue(impl, "orderEntries", orderEntries);
/*     */     } catch (Exception e) {
/* 368 */       this.logger.error("不可能抛出的异常:{}", e.getMessage());
/*     */     }
/*     */ 
/* 371 */     return totalCount;
/*     */   }
/*     */ 
/*     */   private static String removeOrders(String hql)
/*     */   {
/* 378 */     Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", 2);
/* 379 */     Matcher m = p.matcher(hql);
/* 380 */     StringBuffer sb = new StringBuffer();
/* 381 */     while (m.find()) {
/* 382 */       m.appendReplacement(sb, "");
/*     */     }
/* 384 */     m.appendTail(sb);
/* 385 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   private static String removeFetch(String hql) {
/* 389 */     Pattern p = Pattern.compile("join\\s*fetch*", 2);
/* 390 */     Matcher m = p.matcher(hql);
/* 391 */     StringBuffer sb = new StringBuffer();
/* 392 */     while (m.find()) {
/* 393 */       m.appendReplacement(sb, "join");
/*     */     }
/* 395 */     m.appendTail(sb);
/* 396 */     return sb.toString();
/*     */   }
/*     */   private static String removeSelect(String hql) {
/* 399 */     int beginPos = hql.toLowerCase().indexOf("from");
/* 400 */     return hql.substring(beginPos);
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.hibernate.HibernateDao
 * JD-Core Version:    0.6.2
 */