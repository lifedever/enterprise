/*     */ package com.app.common.model;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.Cache;
/*     */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*     */ 
/*     */ @javax.persistence.Entity
/*     */ @org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
/*     */ @Table(name="dataDict")
/*     */ @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
/*     */ public class DataDict
/*     */ {
/*     */   private Integer id;
/*     */   private String attributeName;
/*     */   private String attributeValue;
/*     */   private Integer orderId;
/*     */   private Integer joinFlag;
/*     */   private Integer validFlag;
/*     */   private List<DataDict> dicts;
/*     */   private DataDict parent;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   public Integer getId()
/*     */   {
/*  45 */     return this.id;
/*     */   }
/*     */   public void setId(Integer id) {
/*  48 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getAttributeName()
/*     */   {
/*  55 */     return this.attributeName;
/*     */   }
/*     */   public void setAttributeName(String attributeName) {
/*  58 */     this.attributeName = attributeName;
/*     */   }
/*     */ 
/*     */   public String getAttributeValue()
/*     */   {
/*  65 */     return this.attributeValue;
/*     */   }
/*     */   public void setAttributeValue(String attributeValue) {
/*  68 */     this.attributeValue = attributeValue;
/*     */   }
/*     */ 
/*     */   public Integer getOrderId()
/*     */   {
/*  75 */     return this.orderId;
/*     */   }
/*     */   public void setOrderId(Integer orderId) {
/*  78 */     this.orderId = orderId;
/*     */   }
/*     */ 
/*     */   public Integer getJoinFlag()
/*     */   {
/*  85 */     return this.joinFlag;
/*     */   }
/*     */   public void setJoinFlag(Integer joinFlag) {
/*  88 */     this.joinFlag = joinFlag;
/*     */   }
/*     */ 
/*     */   public Integer getValidFlag()
/*     */   {
/*  96 */     return this.validFlag;
/*     */   }
/*     */   public void setValidFlag(Integer validFlag) {
/*  99 */     this.validFlag = validFlag;
/*     */   }
/*     */ 
/*     */   @OneToMany(mappedBy="parent", fetch=FetchType.LAZY)
/*     */   public List<DataDict> getDicts()
/*     */   {
/* 107 */     return this.dicts;
/*     */   }
/*     */   public void setDicts(List<DataDict> dicts) {
/* 110 */     this.dicts = dicts;
/*     */   }
/*     */ 
/*     */   @ManyToOne
/*     */   @JoinColumn(name="parentId")
/*     */   public DataDict getParent()
/*     */   {
/* 119 */     return this.parent;
/*     */   }
/*     */   public void setParent(DataDict parent) {
/* 122 */     this.parent = parent;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.app.common.model.DataDict
 * JD-Core Version:    0.6.2
 */