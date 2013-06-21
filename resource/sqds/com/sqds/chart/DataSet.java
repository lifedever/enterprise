/*    */ package com.sqds.chart;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Vector;
/*    */ import org.jfree.data.CategoryDataset;
/*    */ import org.jfree.data.DefaultCategoryDataset;
/*    */ import org.jfree.data.DefaultPieDataset;
/*    */ 
/*    */ public class DataSet
/*    */ {
/*    */   public static DefaultPieDataset TransactData(List list)
/*    */   {
/* 20 */     DefaultPieDataset data = new DefaultPieDataset();
/*    */ 
/* 22 */     for (int i = 0; i < list.size(); i++) {
/* 23 */       List tempList = (List)list.get(i);
/* 24 */       data.setValue(tempList.get(0).toString(), Double.valueOf(tempList.get(1).toString()).doubleValue());
/*    */     }
/*    */ 
/* 27 */     return data;
/*    */   }
/*    */ 
/*    */   public static DefaultPieDataset TransactData(Vector vector)
/*    */   {
/* 32 */     DefaultPieDataset data = new DefaultPieDataset();
/*    */ 
/* 34 */     List list = new ArrayList();
/* 35 */     for (int i = 0; i < vector.size(); i++) {
/* 36 */       List tempList = (List)vector.elementAt(i);
/* 37 */       list.add(tempList);
/*    */     }
/* 39 */     data = TransactData(list);
/*    */ 
/* 41 */     return data;
/*    */   }
/*    */ 
/*    */   public static DefaultCategoryDataset TransactDataSet(List list)
/*    */   {
/* 46 */     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/*    */ 
/* 48 */     for (int i = 0; i < list.size(); i++) {
/* 49 */       List tempList = (List)list.get(i);
/* 50 */       dataset.addValue(Double.valueOf(tempList.get(0).toString()).doubleValue(), tempList.get(1).toString(), tempList.get(2).toString());
/*    */     }
/*    */ 
/* 53 */     return dataset;
/*    */   }
/*    */ 
/*    */   public static CategoryDataset TransactDataSetCom(List list)
/*    */   {
/* 58 */     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/*    */ 
/* 61 */     for (int i = 0; i < list.size(); i++) {
/* 62 */       List tempList = (List)list.get(i);
/* 63 */       dataset.addValue(Double.valueOf(tempList.get(0).toString()).doubleValue(), tempList.get(1).toString(), tempList.get(2).toString());
/*    */     }
/*    */ 
/* 66 */     return dataset;
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.chart.DataSet
 * JD-Core Version:    0.6.2
 */