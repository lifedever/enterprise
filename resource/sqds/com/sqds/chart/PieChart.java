/*     */ package com.sqds.chart;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartUtilities;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.StandardLegend;
/*     */ import org.jfree.chart.TextTitle;
/*     */ import org.jfree.chart.labels.StandardPieToolTipGenerator;
/*     */ import org.jfree.chart.plot.PiePlot;
/*     */ import org.jfree.chart.urls.StandardPieURLGenerator;
/*     */ import org.jfree.data.DefaultPieDataset;
/*     */ 
/*     */ public class PieChart
/*     */ {
/*  23 */   private String chartFilePath = "";
/*  24 */   private String chartFileName = "";
/*  25 */   private String chartTitle = "";
/*  26 */   private Integer chartWidth = null;
/*  27 */   private Integer chartHeight = null;
/*     */ 
/*  29 */   private String titleFont = "";
/*  30 */   private Integer titleFontSize = null;
/*  31 */   private String sectionFont = "";
/*  32 */   private Integer sectionFontSize = null;
/*  33 */   private String legendFont = "";
/*  34 */   private Integer legendFontSize = null;
/*     */ 
/*  36 */   private Integer pieType = null;
/*     */ 
/*     */   public void CreateChart(DefaultPieDataset data) throws IOException {
/*  39 */     JFreeChart chart = ChartFactory.createPieChart(this.chartTitle, data, true, true, false);
/*     */ 
/*  42 */     chart.setBackgroundPaint(Color.white);
/*  43 */     PiePlot plot = (PiePlot)chart.getPlot();
/*     */ 
/*  45 */     plot.setSectionLabelType(this.pieType.intValue());
/*     */ 
/*  47 */     plot.setPercentFormatString("#,###0.0#%");
/*     */ 
/*  49 */     plot.setSectionLabelFont(new Font(this.sectionFont, 0, this.sectionFontSize.intValue()));
/*     */ 
/*  51 */     plot.setBackgroundAlpha(0.6F);
/*     */ 
/*  53 */     plot.setForegroundAlpha(0.9F);
/*     */ 
/*  55 */     plot.setInteriorGap(0.4D);
/*     */ 
/*  57 */     plot.setSectionLabelGap(0.02D);
/*     */ 
/*  59 */     plot.setURLGenerator(
/*  60 */       new StandardPieURLGenerator("link.jsp", "section"));
/*  61 */     plot.setToolTipGenerator(new StandardPieToolTipGenerator());
/*     */ 
/*  63 */     Font font = new Font(this.titleFont, 1, this.titleFontSize.intValue());
/*  64 */     TextTitle _title = new TextTitle(this.chartTitle);
/*  65 */     _title.setFont(font);
/*  66 */     chart.setTitle(_title);
/*     */ 
/*  69 */     StandardLegend legend = (StandardLegend)chart.getLegend();
/*     */ 
/*  71 */     legend.setItemFont(new Font(this.legendFont, 0, this.legendFontSize.intValue()));
/*     */ 
/*  74 */     FileOutputStream fos_jpg = null;
/*     */     try {
/*  76 */       fos_jpg = new FileOutputStream(this.chartFilePath + this.chartFileName);
/*     */ 
/*  78 */       ChartUtilities.writeChartAsJPEG(
/*  79 */         fos_jpg, 
/*  80 */         100.0F, 
/*  81 */         chart, 
/*  82 */         this.chartWidth.intValue(), 
/*  83 */         this.chartHeight.intValue(), 
/*  84 */         null);
/*     */     } finally {
/*     */       try {
/*  87 */         fos_jpg.close();
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void Create3DChart(DefaultPieDataset data) throws IOException {
/*  96 */     JFreeChart chart = ChartFactory.createPie3DChart(this.chartTitle, data, true, true, false);
/*     */ 
/*  99 */     chart.setBackgroundPaint(Color.white);
/* 100 */     PiePlot plot = (PiePlot)chart.getPlot();
/*     */ 
/* 102 */     plot.setSectionLabelType(this.pieType.intValue());
/*     */ 
/* 104 */     plot.setPercentFormatString("#,###0.0#%");
/*     */ 
/* 106 */     plot.setSectionLabelFont(new Font(this.sectionFont, 0, this.sectionFontSize.intValue()));
/*     */ 
/* 108 */     plot.setBackgroundAlpha(0.6F);
/*     */ 
/* 110 */     plot.setForegroundAlpha(0.9F);
/*     */ 
/* 112 */     plot.setInteriorGap(0.4D);
/*     */ 
/* 114 */     plot.setSectionLabelGap(0.02D);
/*     */ 
/* 116 */     plot.setURLGenerator(
/* 117 */       new StandardPieURLGenerator("link.jsp", "section"));
/* 118 */     plot.setToolTipGenerator(new StandardPieToolTipGenerator());
/*     */ 
/* 120 */     Font font = new Font(this.titleFont, 1, this.titleFontSize.intValue());
/* 121 */     TextTitle _title = new TextTitle(this.chartTitle);
/* 122 */     _title.setFont(font);
/* 123 */     chart.setTitle(_title);
/*     */ 
/* 126 */     StandardLegend legend = (StandardLegend)chart.getLegend();
/*     */ 
/* 128 */     legend.setItemFont(new Font(this.legendFont, 0, this.legendFontSize.intValue()));
/*     */ 
/* 131 */     FileOutputStream fos_jpg = null;
/*     */     try {
/* 133 */       fos_jpg = new FileOutputStream(this.chartFilePath + this.chartFileName);
/*     */ 
/* 135 */       ChartUtilities.writeChartAsJPEG(
/* 136 */         fos_jpg, 
/* 137 */         100.0F, 
/* 138 */         chart, 
/* 139 */         this.chartWidth.intValue(), 
/* 140 */         this.chartHeight.intValue(), 
/* 141 */         null);
/*     */     } finally {
/*     */       try {
/* 144 */         fos_jpg.close();
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setChartFileName(String chartFileName) {
/* 153 */     this.chartFileName = chartFileName;
/*     */   }
/*     */   public void setChartFilePath(String chartFilePath) {
/* 156 */     this.chartFilePath = chartFilePath;
/*     */   }
/*     */   public void setChartHeight(Integer chartHeight) {
/* 159 */     this.chartHeight = chartHeight;
/*     */   }
/*     */   public void setChartTitle(String chartTitle) {
/* 162 */     this.chartTitle = chartTitle;
/*     */   }
/*     */   public void setChartWidth(Integer chartWidth) {
/* 165 */     this.chartWidth = chartWidth;
/*     */   }
/*     */   public void setLegendFont(String legendFont) {
/* 168 */     this.legendFont = legendFont;
/*     */   }
/*     */   public void setLegendFontSize(Integer legendFontSize) {
/* 171 */     this.legendFontSize = legendFontSize;
/*     */   }
/*     */   public void setPieType(Integer pieType) {
/* 174 */     this.pieType = pieType;
/*     */   }
/*     */   public void setSectionFont(String sectionFont) {
/* 177 */     this.sectionFont = sectionFont;
/*     */   }
/*     */   public void setSectionFontSize(Integer sectionFontSize) {
/* 180 */     this.sectionFontSize = sectionFontSize;
/*     */   }
/*     */   public void setTitleFont(String titleFont) {
/* 183 */     this.titleFont = titleFont;
/*     */   }
/*     */   public void setTitleFontSize(Integer titleFontSize) {
/* 186 */     this.titleFontSize = titleFontSize;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.chart.PieChart
 * JD-Core Version:    0.6.2
 */