/*    */ package com.app.common.model;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.Cache;
/*    */ import org.hibernate.annotations.CacheConcurrencyStrategy;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="region")
/*    */ @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
/*    */ public class Region
/*    */ {
/*    */   private String code;
/*    */   private String name;
/*    */   private Integer activeFlag;
/*    */   private List<Region> regions;
/*    */   private Region parent;
/*    */   private String abbr;
/*    */ 
/*    */   @Id
/*    */   public String getCode()
/*    */   {
/* 33 */     return this.code;
/*    */   }
/*    */   public void setCode(String code) {
/* 36 */     this.code = code;
/*    */   }
/*    */   @Column(name="name", length=50)
/*    */   public String getName() {
/* 40 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 43 */     this.name = name;
/*    */   }
/*    */   public Integer getActiveFlag() {
/* 46 */     return this.activeFlag;
/*    */   }
/*    */   public void setActiveFlag(Integer activeFlag) {
/* 49 */     this.activeFlag = activeFlag;
/*    */   }
/*    */   @OneToMany(mappedBy="parent")
/*    */   public List<Region> getRegions() {
/* 53 */     return this.regions;
/*    */   }
/*    */   public void setRegions(List<Region> regions) {
/* 56 */     this.regions = regions;
/*    */   }
/* 61 */   @ManyToOne
/*    */   @JoinColumn(name="parentRegionCode")
/*    */   public Region getParent() { return this.parent; }
/*    */ 
/*    */   public void setParent(Region parent) {
/* 64 */     this.parent = parent;
/*    */   }
/*    */ 
/*    */   public String getAbbr()
/*    */   {
/* 71 */     return this.abbr;
/*    */   }
/*    */   public void setAbbr(String abbr) {
/* 74 */     this.abbr = abbr;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.app.common.model.Region
 * JD-Core Version:    0.6.2
 */