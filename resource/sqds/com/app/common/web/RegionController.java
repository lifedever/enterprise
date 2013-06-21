/*     */ package com.app.common.web;
/*     */ 
/*     */ import com.app.common.model.Region;
/*     */ import com.app.common.service.RegionManager;
/*     */ import com.sqds.spring.SpringUtils;
/*     */ import com.sqds.spring.annotation.GlobalAutowired;
/*     */ import com.sqds.util.ParamUtils;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ @GlobalAutowired
/*     */ @RequestMapping({"/common/region/*.do"})
/*     */ public class RegionController
/*     */ {
/*     */   private RegionManager regionManager;
/*     */ 
/*     */   @RequestMapping
/*     */   public void list(ModelMap model)
/*     */   {
/*  34 */     String code = ParamUtils.getString("code", "");
/*  35 */     List list = null;
/*  36 */     Region region = null;
/*  37 */     if (code.equals("")) {
/*  38 */       list = this.regionManager.getRootList();
/*     */     } else {
/*  40 */       list = this.regionManager.getAllListByParentCode(code);
/*  41 */       region = (Region)this.regionManager.get(code);
/*     */     }
/*  43 */     String[] codes = new String[list.size()];
/*  44 */     for (int i = 0; i < list.size(); i++) {
/*  45 */       codes[i] = ((Region)list.get(i)).getCode();
/*     */     }
/*  47 */     Map nums = null;
/*  48 */     if (codes.length == 0)
/*  49 */       nums = new HashMap();
/*     */     else {
/*  51 */       nums = this.regionManager.countSonNum(codes);
/*     */     }
/*  53 */     model.addAttribute("code", code);
/*  54 */     model.addAttribute("list", list);
/*  55 */     model.addAttribute("region", region);
/*  56 */     model.addAttribute("nums", nums);
/*     */   }
/*     */ 
/*     */   @RequestMapping
/*     */   public void form(ModelMap model)
/*     */   {
/*  64 */     String parentCode = ParamUtils.getString("parentCode", "");
/*  65 */     String code = ParamUtils.getString("code", "");
/*  66 */     Region parentRegion = null;
/*  67 */     Region region = null;
/*  68 */     if (!parentCode.equals("")) {
/*  69 */       parentRegion = (Region)this.regionManager.get(parentCode);
/*     */     }
/*  71 */     if (code.equals(""))
/*  72 */       region = new Region();
/*     */     else {
/*  74 */       region = (Region)this.regionManager.get(code);
/*     */     }
/*  76 */     model.addAttribute("parentCode", parentCode);
/*  77 */     model.addAttribute("code", code);
/*  78 */     model.addAttribute("parentRegion", parentRegion);
/*  79 */     model.addAttribute("region", region);
/*     */   }
/*     */ 
/*     */   @RequestMapping
/*     */   public String save(ModelMap model)
/*     */   {
/*  88 */     String parentCode = ParamUtils.getString("parentCode", "");
/*  89 */     String code = ParamUtils.getString("code", "");
/*  90 */     Region parentRegion = null;
/*  91 */     Region region = null;
/*  92 */     if (!parentCode.equals("")) {
/*  93 */       parentRegion = (Region)this.regionManager.get(parentCode);
/*     */     }
/*  95 */     if (code.equals("")) {
/*  96 */       region = new Region();
/*     */     }
/*     */     else
/*     */     {
/* 100 */       region = (Region)this.regionManager.get(code);
/*     */     }
/* 102 */     if (region == null) {
/* 103 */       region = new Region();
/*     */     }
/* 105 */     SpringUtils.bind(region);
/* 106 */     region.setParent(parentRegion);
/* 107 */     this.regionManager.save(region);
/* 108 */     return "redirect:list.do?code=" + parentCode;
/*     */   }
/*     */ 
/*     */   @RequestMapping
/*     */   public String del()
/*     */   {
/* 116 */     String parentCode = ParamUtils.getString("parentCode", "");
/* 117 */     String code = ParamUtils.getString("code", "");
/* 118 */     this.regionManager.delete(code);
/* 119 */     return "redirect:list.do?code=" + parentCode;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.app.common.web.RegionController
 * JD-Core Version:    0.6.2
 */