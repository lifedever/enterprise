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
/*     */ import org.jfree.chart.axis.AxisLocation;
/*     */ import org.jfree.chart.axis.CategoryAxis;
/*     */ import org.jfree.chart.axis.ValueAxis;
/*     */ import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.renderer.BarRenderer3D;
/*     */ import org.jfree.data.CategoryDataset;
/*     */ import org.jfree.data.DefaultCategoryDataset;
/*     */ 
/*     */ public class BarChart
/*     */ {
/*  28 */   private String chartFilePath = "";
/*  29 */   private String chartFileName = "";
/*  30 */   private String chartTitle = "";
/*  31 */   private Integer chartWidth = null;
/*  32 */   private Integer chartHeight = null;
/*  33 */   private String chartMenuTag = null;
/*  34 */   private String chartValueTag = null;
/*  35 */   private String chartOrientation = null;
/*  36 */   private String titleFont = "";
/*  37 */   private Integer titleFontSize = null;
/*  38 */   private String yLabelFont = "";
/*  39 */   private Integer yLabelFontSize = null;
/*  40 */   private String yTickLabelFont = "";
/*  41 */   private Integer yTickLabelFontSize = null;
/*  42 */   private String xLabelFont = "";
/*  43 */   private Integer xLabelFontSize = null;
/*  44 */   private String xTickLabelFont = "";
/*  45 */   private Integer xTickLabelFontSize = null;
/*  46 */   private String legendFont = "";
/*  47 */   private Integer legendFontSize = null;
/*  48 */   private String itemLabelFont = "";
/*  49 */   private Integer itemLabelFontSize = null;
/*     */ 
/*     */   public void createBarChart3D(DefaultCategoryDataset dataset)
/*     */     throws IOException
/*     */   {
/*  54 */     PlotOrientation po = PlotOrientation.VERTICAL;
/*  55 */     if ("V".equals(this.chartOrientation)) {
/*  56 */       po = PlotOrientation.VERTICAL;
/*     */     }
/*  58 */     if ("H".equals(this.chartOrientation)) {
/*  59 */       po = PlotOrientation.HORIZONTAL;
/*     */     }
/*     */ 
/*  62 */     JFreeChart chart = ChartFactory.createBarChart3D(this.chartTitle, 
/*  63 */       this.chartMenuTag, 
/*  64 */       this.chartValueTag, 
/*  65 */       dataset, 
/*  66 */       po, 
/*  67 */       true, 
/*  68 */       false, 
/*  69 */       false);
/*     */ 
/*  72 */     chart.setBackgroundPaint(Color.WHITE);
/*  73 */     CategoryPlot plot = chart.getCategoryPlot();
/*     */ 
/*  75 */     CategoryAxis domainAxis = plot.getDomainAxis();
/*  76 */     domainAxis.setVerticalCategoryLabels(false);
/*     */ 
/*  78 */     domainAxis.setLabelFont(new Font(this.yLabelFont, 0, this.yLabelFontSize.intValue()));
/*     */ 
/*  80 */     domainAxis.setTickLabelFont(new Font(this.yTickLabelFont, 0, this.yTickLabelFontSize.intValue()));
/*  81 */     plot.setDomainAxis(domainAxis);
/*     */ 
/*  84 */     Font font = new Font(this.titleFont, 1, this.titleFontSize.intValue());
/*  85 */     TextTitle _title = new TextTitle(this.chartTitle);
/*  86 */     _title.setFont(font);
/*  87 */     chart.setTitle(_title);
/*     */ 
/*  93 */     ValueAxis rangeAxis = plot.getRangeAxis();
/*     */ 
/*  95 */     rangeAxis.setUpperMargin(0.15D);
/*     */ 
/*  97 */     rangeAxis.setLowerMargin(0.15D);
/*     */ 
/*  99 */     rangeAxis.setLabelFont(new Font(this.xLabelFont, 0, this.xLabelFontSize.intValue()));
/*     */ 
/* 101 */     rangeAxis.setTickLabelFont(new Font(this.xTickLabelFont, 0, this.xTickLabelFontSize.intValue()));
/* 102 */     plot.setRangeAxis(rangeAxis);
/*     */ 
/* 104 */     BarRenderer3D renderer = new BarRenderer3D();
/* 105 */     renderer.setBaseOutlinePaint(Color.BLACK);
/*     */ 
/* 108 */     renderer.setWallPaint(Color.gray);
/*     */ 
/* 119 */     renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
/* 120 */     renderer.setItemLabelsVisible(true);
/* 121 */     renderer.setItemLabelFont(new Font(this.itemLabelFont, 0, this.itemLabelFontSize.intValue()));
/* 122 */     plot.setRenderer(renderer);
/*     */ 
/* 125 */     plot.setForegroundAlpha(0.6F);
/*     */ 
/* 128 */     plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
/* 129 */     plot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
/*     */ 
/* 132 */     StandardLegend legend = (StandardLegend)chart.getLegend();
/*     */ 
/* 134 */     legend.setItemFont(new Font(this.legendFont, 0, this.legendFontSize.intValue()));
/*     */ 
/* 137 */     FileOutputStream fos_jpg = null;
/*     */     try {
/* 139 */       fos_jpg = new FileOutputStream(this.chartFilePath + this.chartFileName);
/*     */ 
/* 141 */       ChartUtilities.writeChartAsJPEG(fos_jpg, 100.0F, chart, this.chartWidth.intValue(), this.chartHeight.intValue(), null);
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 147 */         fos_jpg.close();
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void createBarChart3DCom(CategoryDataset dataset) throws IOException {
/* 156 */     PlotOrientation po = PlotOrientation.VERTICAL;
/* 157 */     if ("V".equals(this.chartOrientation)) {
/* 158 */       po = PlotOrientation.VERTICAL;
/*     */     }
/* 160 */     if ("H".equals(this.chartOrientation)) {
/* 161 */       po = PlotOrientation.HORIZONTAL;
/*     */     }
/*     */ 
/* 164 */     JFreeChart chart = ChartFactory.createBarChart3D(
/* 165 */       this.chartTitle, 
/* 166 */       this.chartMenuTag, 
/* 167 */       this.chartValueTag, 
/* 168 */       dataset, 
/* 169 */       po, 
/* 170 */       true, 
/* 171 */       false, 
/* 172 */       false);
/*     */ 
/* 175 */     chart.setBackgroundPaint(Color.WHITE);
/* 176 */     CategoryPlot plot = chart.getCategoryPlot();
/*     */ 
/* 178 */     CategoryAxis domainAxis = plot.getDomainAxis();
/* 179 */     domainAxis.setVerticalCategoryLabels(false);
/*     */ 
/* 181 */     domainAxis.setLabelFont(new Font(this.yLabelFont, 0, this.yLabelFontSize.intValue()));
/*     */ 
/* 183 */     domainAxis.setTickLabelFont(new Font(this.yTickLabelFont, 0, this.yTickLabelFontSize.intValue()));
/* 184 */     plot.setDomainAxis(domainAxis);
/*     */ 
/* 187 */     Font font = new Font(this.titleFont, 1, this.titleFontSize.intValue());
/* 188 */     TextTitle _title = new TextTitle(this.chartTitle);
/* 189 */     _title.setFont(font);
/* 190 */     chart.setTitle(_title);
/*     */ 
/* 196 */     ValueAxis rangeAxis = plot.getRangeAxis();
/*     */ 
/* 198 */     rangeAxis.setUpperMargin(0.15D);
/*     */ 
/* 200 */     rangeAxis.setLowerMargin(0.15D);
/*     */ 
/* 202 */     rangeAxis.setLabelFont(new Font(this.xLabelFont, 0, this.xLabelFontSize.intValue()));
/*     */ 
/* 204 */     rangeAxis.setTickLabelFont(new Font(this.xTickLabelFont, 0, this.xTickLabelFontSize.intValue()));
/* 205 */     plot.setRangeAxis(rangeAxis);
/*     */ 
/* 207 */     BarRenderer3D renderer = new BarRenderer3D();
/* 208 */     renderer.setBaseOutlinePaint(Color.BLACK);
/*     */ 
/* 211 */     renderer.setWallPaint(Color.gray);
/*     */ 
/* 222 */     renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
/* 223 */     renderer.setItemLabelsVisible(true);
/* 224 */     renderer.setItemLabelFont(new Font(this.itemLabelFont, 0, this.itemLabelFontSize.intValue()));
/* 225 */     plot.setRenderer(renderer);
/*     */ 
/* 228 */     plot.setForegroundAlpha(0.6F);
/*     */ 
/* 231 */     plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
/* 232 */     plot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
/*     */ 
/* 235 */     StandardLegend legend = (StandardLegend)chart.getLegend();
/*     */ 
/* 237 */     legend.setItemFont(new Font(this.legendFont, 0, this.legendFontSize.intValue()));
/*     */ 
/* 240 */     FileOutputStream fos_jpg = null;
/*     */     try {
/* 242 */       fos_jpg = new FileOutputStream(this.chartFilePath + this.chartFileName);
/*     */ 
/* 244 */       ChartUtilities.writeChartAsJPEG(fos_jpg, 100.0F, chart, this.chartWidth.intValue(), this.chartHeight.intValue(), null);
/*     */     } finally {
/*     */       try {
/* 247 */         fos_jpg.close();
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setChartFileName(String chartFileName) {
/* 256 */     this.chartFileName = chartFileName;
/*     */   }
/*     */   public void setChartFilePath(String chartFilePath) {
/* 259 */     this.chartFilePath = chartFilePath;
/*     */   }
/*     */   public void setChartHeight(Integer chartHeight) {
/* 262 */     this.chartHeight = chartHeight;
/*     */   }
/*     */   public void setChartMenuTag(String chartMenuTag) {
/* 265 */     this.chartMenuTag = chartMenuTag;
/*     */   }
/*     */   public void setChartOrientation(String chartOrientation) {
/* 268 */     this.chartOrientation = chartOrientation;
/*     */   }
/*     */   public void setChartTitle(String chartTitle) {
/* 271 */     this.chartTitle = chartTitle;
/*     */   }
/*     */   public void setChartValueTag(String chartValueTag) {
/* 274 */     this.chartValueTag = chartValueTag;
/*     */   }
/*     */   public void setChartWidth(Integer chartWidth) {
/* 277 */     this.chartWidth = chartWidth;
/*     */   }
/*     */   public void setItemLabelFont(String itemLabelFont) {
/* 280 */     this.itemLabelFont = itemLabelFont;
/*     */   }
/*     */   public void setItemLabelFontSize(Integer itemLabelFontSize) {
/* 283 */     this.itemLabelFontSize = itemLabelFontSize;
/*     */   }
/*     */   public void setLegendFont(String legendFont) {
/* 286 */     this.legendFont = legendFont;
/*     */   }
/*     */   public void setLegendFontSize(Integer legendFontSize) {
/* 289 */     this.legendFontSize = legendFontSize;
/*     */   }
/*     */   public void setTitleFont(String titleFont) {
/* 292 */     this.titleFont = titleFont;
/*     */   }
/*     */   public void setTitleFontSize(Integer titleFontSize) {
/* 295 */     this.titleFontSize = titleFontSize;
/*     */   }
/*     */   public void setXLabelFont(String labelFont) {
/* 298 */     this.xLabelFont = labelFont;
/*     */   }
/*     */   public void setXLabelFontSize(Integer labelFontSize) {
/* 301 */     this.xLabelFontSize = labelFontSize;
/*     */   }
/*     */   public void setXTickLabelFont(String tickLabelFont) {
/* 304 */     this.xTickLabelFont = tickLabelFont;
/*     */   }
/*     */   public void setXTickLabelFontSize(Integer tickLabelFontSize) {
/* 307 */     this.xTickLabelFontSize = tickLabelFontSize;
/*     */   }
/*     */   public void setYLabelFont(String labelFont) {
/* 310 */     this.yLabelFont = labelFont;
/*     */   }
/*     */   public void setYLabelFontSize(Integer labelFontSize) {
/* 313 */     this.yLabelFontSize = labelFontSize;
/*     */   }
/*     */   public void setYTickLabelFont(String tickLabelFont) {
/* 316 */     this.yTickLabelFont = tickLabelFont;
/*     */   }
/*     */   public void setYTickLabelFontSize(Integer tickLabelFontSize) {
/* 319 */     this.yTickLabelFontSize = tickLabelFontSize;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.chart.BarChart
 * JD-Core Version:    0.6.2
 */