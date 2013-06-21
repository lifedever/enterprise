/*     */ package com.app.common.web;
/*     */ 
/*     */ import com.app.common.model.DataDict;
/*     */ import com.app.common.service.DataDictManager;
/*     */ import com.sqds.spring.annotation.GlobalAutowired;
/*     */ import com.sqds.util.ParamUtils;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Vector;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ @GlobalAutowired
/*     */ @RequestMapping({"/dataDict/*.do"})
/*     */ public class DataDictController
/*     */ {
/*     */   private DataDictManager dataDictManager;
/*     */ 
/*     */   @RequestMapping
/*     */   public void list(ModelMap model)
/*     */   {
/*  34 */     List list = this.dataDictManager.getClassList();
/*  35 */     Map data = new HashMap();
/*  36 */     for (int i = 0; i < list.size(); i++) {
/*  37 */       DataDict dd = (DataDict)list.get(i);
/*  38 */       List items = this.dataDictManager.getAllList(dd.getId().intValue());
/*  39 */       data.put(dd.getId(), items);
/*     */     }
/*  41 */     model.addAttribute("list", list);
/*  42 */     model.addAttribute("data", data);
/*     */   }
/*     */ 
/*     */   @RequestMapping
/*     */   public void form(Integer id, ModelMap model)
/*     */   {
/*  52 */     if (id == null) {
/*  53 */       model.addAttribute(new DataDict());
/*  54 */       model.addAttribute("items", new Vector());
/*     */     } else {
/*  56 */       DataDict dd = (DataDict)this.dataDictManager.get(id);
/*  57 */       List items = this.dataDictManager.getAllList(dd.getId().intValue());
/*  58 */       model.addAttribute(dd);
/*  59 */       model.addAttribute("items", items);
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping
/*     */   public String save(Integer id)
/*     */   {
/*  71 */     int num = ParamUtils.getInt("num", 10);
/*  72 */     int joinFlag = ParamUtils.getInt("joinFlag", 0);
/*  73 */     String parentName = ParamUtils.getString("parentName", "");
/*     */ 
/*  75 */     DataDict parent = null;
/*  76 */     if (id == null)
/*  77 */       parent = new DataDict();
/*     */     else {
/*  79 */       parent = (DataDict)this.dataDictManager.get(id);
/*     */     }
/*  81 */     parent.setJoinFlag(Integer.valueOf(joinFlag));
/*  82 */     parent.setAttributeName(parentName);
/*  83 */     parent.setAttributeValue(parentName);
/*  84 */     parent.setValidFlag(Integer.valueOf(1));
/*  85 */     parent.setOrderId(new Integer(999));
/*     */ 
/*  89 */     List items = new Vector();
/*  90 */     for (int i = 0; i < num; i++) {
/*  91 */       String attributeName = ParamUtils.getString("attributeName" + i, "");
/*  92 */       String attributeValue = ParamUtils.getString("attributeValue" + i, "");
/*  93 */       int validFlag = ParamUtils.getInt("validFlag" + i, 0);
/*  94 */       int orderId = ParamUtils.getInt("orderId" + i, 0);
/*     */ 
/*  96 */       if ((!"".equals(attributeName)) && (!"".equals(attributeValue))) {
/*  97 */         DataDict item = new DataDict();
/*  98 */         item.setAttributeName(attributeName);
/*  99 */         item.setAttributeValue(attributeValue);
/* 100 */         item.setValidFlag(Integer.valueOf(validFlag));
/* 101 */         item.setOrderId(Integer.valueOf(orderId));
/* 102 */         item.setParent(parent);
/* 103 */         items.add(item);
/*     */       }
/*     */     }
/* 106 */     parent.setDicts(items);
/* 107 */     this.dataDictManager.saveDataDictAndItems(parent);
/* 108 */     return "redirect:list.do";
/*     */   }
/*     */ 
/*     */   @RequestMapping
/*     */   public String del(Integer id)
/*     */   {
/* 120 */     this.dataDictManager.delete(id);
/* 121 */     return "redirect:list.do";
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.app.common.web.DataDictController
 * JD-Core Version:    0.6.2
 */