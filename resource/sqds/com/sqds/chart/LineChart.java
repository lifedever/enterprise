/*     */ package com.sqds.chart;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import org.jfree.chart.ChartUtilities;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.StandardLegend;
/*     */ import org.jfree.chart.TextTitle;
/*     */ import org.jfree.chart.axis.CategoryAxis;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.plot.CombinedDomainCategoryPlot;
/*     */ import org.jfree.chart.renderer.LineAndShapeRenderer;
/*     */ import org.jfree.data.DefaultCategoryDataset;
/*     */ 
/*     */ public class LineChart
/*     */ {
/*  26 */   private String chartFilePath = "";
/*  27 */   private String chartFileName = "";
/*  28 */   private String chartTitle = "";
/*  29 */   private Integer chartWidth = null;
/*  30 */   private Integer chartHeight = null;
/*  31 */   private String chartMenuTag = null;
/*  32 */   private String chartValueTag = null;
/*  33 */   private String titleFont = "";
/*  34 */   private Integer titleFontSize = null;
/*  35 */   private String yLabelFont = "";
/*  36 */   private Integer yLabelFontSize = null;
/*  37 */   private String yTickLabelFont = "";
/*  38 */   private Integer yTickLabelFontSize = null;
/*  39 */   private String xLabelFont = "";
/*  40 */   private Integer xLabelFontSize = null;
/*  41 */   private String xTickLabelFont = "";
/*  42 */   private Integer xTickLabelFontSize = null;
/*  43 */   private String legendFont = "";
/*  44 */   private Integer legendFontSize = null;
/*     */ 
/*     */   public void createXYChart(DefaultCategoryDataset dataset)
/*     */     throws IOException
/*     */   {
/*  51 */     NumberAxis rangeAxis = new NumberAxis(this.chartValueTag);
/*  52 */     rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/*  53 */     LineAndShapeRenderer renderer = new LineAndShapeRenderer();
/*  54 */     renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
/*  55 */     renderer.setItemLabelsVisible(true);
/*     */ 
/*  57 */     rangeAxis.setUpperMargin(0.5D);
/*     */ 
/*  59 */     rangeAxis.setLowerMargin(0.15D);
/*     */ 
/*  61 */     rangeAxis.setLabelFont(new Font(this.yLabelFont, 0, this.yLabelFontSize.intValue()));
/*     */ 
/*  63 */     rangeAxis.setTickLabelFont(new Font(this.yTickLabelFont, 0, this.yTickLabelFontSize.intValue()));
/*     */ 
/*  65 */     CategoryPlot subplot = new CategoryPlot(dataset, null, rangeAxis, 
/*  66 */       renderer);
/*  67 */     subplot.setDomainGridlinesVisible(true);
/*     */ 
/*  69 */     CategoryAxis domainAxis = new CategoryAxis(this.chartMenuTag);
/*     */ 
/*  71 */     domainAxis.setLabelFont(new Font(this.xLabelFont, 0, this.xLabelFontSize.intValue()));
/*     */ 
/*  73 */     domainAxis.setTickLabelFont(new Font(this.xTickLabelFont, 0, this.xTickLabelFontSize.intValue()));
/*     */ 
/*  75 */     CombinedDomainCategoryPlot plot = new CombinedDomainCategoryPlot(
/*  76 */       domainAxis);
/*  77 */     plot.add(subplot, 1);
/*     */ 
/*  79 */     JFreeChart chart = new JFreeChart(this.chartTitle, null, plot, true);
/*     */ 
/*  81 */     chart.setBackgroundPaint(Color.WHITE);
/*     */ 
/*  84 */     Font font = new Font(this.titleFont, 1, this.titleFontSize.intValue());
/*  85 */     TextTitle _title = new TextTitle(this.chartTitle);
/*  86 */     _title.setFont(font);
/*  87 */     chart.setTitle(_title);
/*     */ 
/*  90 */     StandardLegend legend = (StandardLegend)chart.getLegend();
/*     */ 
/*  92 */     legend.setItemFont(new Font(this.legendFont, 0, this.legendFontSize.intValue()));
/*     */ 
/*  95 */     FileOutputStream fos_jpg = null;
/*     */     try {
/*  97 */       fos_jpg = new FileOutputStream(this.chartFilePath + this.chartFileName);
/*     */ 
/*  99 */       ChartUtilities.writeChartAsJPEG(fos_jpg, 100.0F, chart, this.chartWidth.intValue(), this.chartHeight.intValue(), null);
/*     */     } finally {
/*     */       try {
/* 102 */         fos_jpg.close();
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setChartFileName(String chartFileName)
/*     */   {
/* 112 */     this.chartFileName = chartFileName;
/*     */   }
/*     */   public void setChartFilePath(String chartFilePath) {
/* 115 */     this.chartFilePath = chartFilePath;
/*     */   }
/*     */   public void setChartHeight(Integer chartHeight) {
/* 118 */     this.chartHeight = chartHeight;
/*     */   }
/*     */   public void setChartMenuTag(String chartMenuTag) {
/* 121 */     this.chartMenuTag = chartMenuTag;
/*     */   }
/*     */   public void setChartTitle(String chartTitle) {
/* 124 */     this.chartTitle = chartTitle;
/*     */   }
/*     */   public void setChartValueTag(String chartValueTag) {
/* 127 */     this.chartValueTag = chartValueTag;
/*     */   }
/*     */   public void setChartWidth(Integer chartWidth) {
/* 130 */     this.chartWidth = chartWidth;
/*     */   }
/*     */ 
/*     */   public void setLegendFont(String legendFont)
/*     */   {
/* 141 */     this.legendFont = legendFont;
/*     */   }
/*     */   public void setLegendFontSize(Integer legendFontSize) {
/* 144 */     this.legendFontSize = legendFontSize;
/*     */   }
/*     */   public void setTitleFont(String titleFont) {
/* 147 */     this.titleFont = titleFont;
/*     */   }
/*     */   public void setTitleFontSize(Integer titleFontSize) {
/* 150 */     this.titleFontSize = titleFontSize;
/*     */   }
/*     */   public void setXLabelFont(String labelFont) {
/* 153 */     this.xLabelFont = labelFont;
/*     */   }
/*     */   public void setXLabelFontSize(Integer labelFontSize) {
/* 156 */     this.xLabelFontSize = labelFontSize;
/*     */   }
/*     */   public void setXTickLabelFont(String tickLabelFont) {
/* 159 */     this.xTickLabelFont = tickLabelFont;
/*     */   }
/*     */   public void setXTickLabelFontSize(Integer tickLabelFontSize) {
/* 162 */     this.xTickLabelFontSize = tickLabelFontSize;
/*     */   }
/*     */   public void setYLabelFont(String labelFont) {
/* 165 */     this.yLabelFont = labelFont;
/*     */   }
/*     */   public void setYLabelFontSize(Integer labelFontSize) {
/* 168 */     this.yLabelFontSize = labelFontSize;
/*     */   }
/*     */   public void setYTickLabelFont(String tickLabelFont) {
/* 171 */     this.yTickLabelFont = tickLabelFont;
/*     */   }
/*     */   public void setYTickLabelFontSize(Integer tickLabelFontSize) {
/* 174 */     this.yTickLabelFontSize = tickLabelFontSize;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.chart.LineChart
 * JD-Core Version:    0.6.2
 */