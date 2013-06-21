/*     */ package com.sqds.chart;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jfree.data.CategoryDataset;
/*     */ import org.jfree.data.DefaultCategoryDataset;
/*     */ import org.jfree.data.DefaultPieDataset;
/*     */ 
/*     */ public class CreateChart
/*     */ {
/*  17 */   private PieChart pieChart = new PieChart();
/*  18 */   private BarChart barChart = new BarChart();
/*  19 */   private LineChart lineChart = new LineChart();
/*     */ 
/*  24 */   private String chartFilePath = "d:/";
/*  25 */   private String chartFileName = "temp.jpg";
/*  26 */   private String chartTitle = "ChartTitle";
/*  27 */   private Integer chartWidth = new Integer(400);
/*  28 */   private Integer chartHeight = new Integer(300);
/*     */ 
/*  30 */   private String titleFont = "黑体";
/*  31 */   private Integer titleFontSize = new Integer(20);
/*  32 */   private String legendFont = "黑体";
/*  33 */   private Integer legendFontSize = new Integer(15);
/*     */ 
/*  36 */   private String sectionFont = "黑体";
/*  37 */   private Integer sectionFontSize = new Integer(15);
/*  38 */   private Integer pieType = new Integer(6);
/*     */ 
/*  41 */   private String chartMenuTag = "MenuTag";
/*  42 */   private String chartValueTag = "ValueTag";
/*  43 */   private String chartOrientation = "V";
/*     */ 
/*  46 */   private String yLabelFont = "黑体";
/*  47 */   private Integer yLabelFontSize = new Integer(12);
/*  48 */   private String yTickLabelFont = "黑体";
/*  49 */   private Integer yTickLabelFontSize = new Integer(12);
/*  50 */   private String xLabelFont = "黑体";
/*  51 */   private Integer xLabelFontSize = new Integer(12);
/*  52 */   private String xTickLabelFont = "黑体";
/*  53 */   private Integer xTickLabelFontSize = new Integer(12);
/*  54 */   private String itemLabelFont = "黑体";
/*  55 */   private Integer itemLabelFontSize = new Integer(12);
/*     */ 
/*     */   public void CreatePieChart(List list)
/*     */     throws Exception
/*     */   {
/*  70 */     DefaultPieDataset data = new DefaultPieDataset();
/*     */ 
/*  72 */     data = DataSet.TransactData(list);
/*     */ 
/*  74 */     this.pieChart.setChartTitle(this.chartTitle);
/*  75 */     this.pieChart.setChartFilePath(this.chartFilePath);
/*  76 */     this.pieChart.setChartFileName(this.chartFileName);
/*  77 */     this.pieChart.setChartWidth(this.chartWidth);
/*  78 */     this.pieChart.setChartHeight(this.chartHeight);
/*     */ 
/*  80 */     this.pieChart.setTitleFont(this.titleFont);
/*  81 */     this.pieChart.setTitleFontSize(this.titleFontSize);
/*  82 */     this.pieChart.setSectionFont(this.sectionFont);
/*  83 */     this.pieChart.setSectionFontSize(this.sectionFontSize);
/*  84 */     this.pieChart.setLegendFont(this.legendFont);
/*  85 */     this.pieChart.setLegendFontSize(this.legendFontSize);
/*     */ 
/*  87 */     this.pieChart.setPieType(this.pieType);
/*     */ 
/*  89 */     this.pieChart.CreateChart(data);
/*     */   }
/*     */ 
/*     */   public void CreatePie3DChart(List list)
/*     */     throws Exception
/*     */   {
/* 105 */     DefaultPieDataset data = new DefaultPieDataset();
/*     */ 
/* 107 */     data = DataSet.TransactData(list);
/*     */ 
/* 109 */     this.pieChart.setChartTitle(this.chartTitle);
/* 110 */     this.pieChart.setChartFilePath(this.chartFilePath);
/* 111 */     this.pieChart.setChartFileName(this.chartFileName);
/* 112 */     this.pieChart.setChartWidth(this.chartWidth);
/* 113 */     this.pieChart.setChartHeight(this.chartHeight);
/*     */ 
/* 115 */     this.pieChart.setTitleFont(this.titleFont);
/* 116 */     this.pieChart.setTitleFontSize(this.titleFontSize);
/* 117 */     this.pieChart.setSectionFont(this.sectionFont);
/* 118 */     this.pieChart.setSectionFontSize(this.sectionFontSize);
/* 119 */     this.pieChart.setLegendFont(this.legendFont);
/* 120 */     this.pieChart.setLegendFontSize(this.legendFontSize);
/*     */ 
/* 122 */     this.pieChart.setPieType(this.pieType);
/*     */ 
/* 124 */     this.pieChart.Create3DChart(data);
/*     */   }
/*     */ 
/*     */   public void CreateBarChart3D(List list)
/*     */     throws Exception
/*     */   {
/* 139 */     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/*     */ 
/* 141 */     dataset = DataSet.TransactDataSet(list);
/*     */ 
/* 143 */     this.barChart.setChartTitle(this.chartTitle);
/* 144 */     this.barChart.setChartFilePath(this.chartFilePath);
/* 145 */     this.barChart.setChartFileName(this.chartFileName);
/* 146 */     this.barChart.setChartWidth(this.chartWidth);
/* 147 */     this.barChart.setChartHeight(this.chartHeight);
/* 148 */     this.barChart.setChartMenuTag(this.chartMenuTag);
/* 149 */     this.barChart.setChartValueTag(this.chartValueTag);
/* 150 */     this.barChart.setChartOrientation(this.chartOrientation);
/*     */ 
/* 152 */     this.barChart.setTitleFont(this.titleFont);
/* 153 */     this.barChart.setTitleFontSize(this.titleFontSize);
/* 154 */     this.barChart.setXLabelFont(this.xLabelFont);
/* 155 */     this.barChart.setXLabelFontSize(this.xLabelFontSize);
/* 156 */     this.barChart.setXTickLabelFont(this.xTickLabelFont);
/* 157 */     this.barChart.setXTickLabelFontSize(this.xTickLabelFontSize);
/* 158 */     this.barChart.setYLabelFont(this.yLabelFont);
/* 159 */     this.barChart.setYLabelFontSize(this.yLabelFontSize);
/* 160 */     this.barChart.setYTickLabelFont(this.yTickLabelFont);
/* 161 */     this.barChart.setYTickLabelFontSize(this.yTickLabelFontSize);
/* 162 */     this.barChart.setItemLabelFont(this.itemLabelFont);
/* 163 */     this.barChart.setItemLabelFontSize(this.itemLabelFontSize);
/* 164 */     this.barChart.setLegendFont(this.legendFont);
/* 165 */     this.barChart.setLegendFontSize(this.legendFontSize);
/*     */ 
/* 167 */     this.barChart.createBarChart3D(dataset);
/*     */   }
/*     */ 
/*     */   public void CreateBarChart3DCom(List list)
/*     */     throws Exception
/*     */   {
/* 193 */     CategoryDataset dataset = DataSet.TransactDataSetCom(list);
/*     */ 
/* 195 */     this.barChart.setChartTitle(this.chartTitle);
/* 196 */     this.barChart.setChartFilePath(this.chartFilePath);
/* 197 */     this.barChart.setChartFileName(this.chartFileName);
/* 198 */     this.barChart.setChartWidth(this.chartWidth);
/* 199 */     this.barChart.setChartHeight(this.chartHeight);
/* 200 */     this.barChart.setChartMenuTag(this.chartMenuTag);
/* 201 */     this.barChart.setChartValueTag(this.chartValueTag);
/* 202 */     this.barChart.setChartOrientation(this.chartOrientation);
/*     */ 
/* 204 */     this.barChart.setTitleFont(this.titleFont);
/* 205 */     this.barChart.setTitleFontSize(this.titleFontSize);
/* 206 */     this.barChart.setXLabelFont(this.xLabelFont);
/* 207 */     this.barChart.setXLabelFontSize(this.xLabelFontSize);
/* 208 */     this.barChart.setXTickLabelFont(this.xTickLabelFont);
/* 209 */     this.barChart.setXTickLabelFontSize(this.xTickLabelFontSize);
/* 210 */     this.barChart.setYLabelFont(this.yLabelFont);
/* 211 */     this.barChart.setYLabelFontSize(this.yLabelFontSize);
/* 212 */     this.barChart.setYTickLabelFont(this.yTickLabelFont);
/* 213 */     this.barChart.setYTickLabelFontSize(this.yTickLabelFontSize);
/* 214 */     this.barChart.setItemLabelFont(this.itemLabelFont);
/* 215 */     this.barChart.setItemLabelFontSize(this.itemLabelFontSize);
/* 216 */     this.barChart.setLegendFont(this.legendFont);
/* 217 */     this.barChart.setLegendFontSize(this.legendFontSize);
/*     */ 
/* 219 */     this.barChart.createBarChart3DCom(dataset);
/*     */   }
/*     */ 
/*     */   public void CreateLineChart(List list)
/*     */     throws Exception
/*     */   {
/* 228 */     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/*     */ 
/* 230 */     dataset = DataSet.TransactDataSet(list);
/*     */ 
/* 232 */     this.lineChart.setChartTitle(this.chartTitle);
/* 233 */     this.lineChart.setChartFilePath(this.chartFilePath);
/* 234 */     this.lineChart.setChartFileName(this.chartFileName);
/* 235 */     this.lineChart.setChartWidth(this.chartWidth);
/* 236 */     this.lineChart.setChartHeight(this.chartHeight);
/* 237 */     this.lineChart.setChartMenuTag(this.chartMenuTag);
/* 238 */     this.lineChart.setChartValueTag(this.chartValueTag);
/*     */ 
/* 240 */     this.lineChart.setTitleFont(this.titleFont);
/* 241 */     this.lineChart.setTitleFontSize(this.titleFontSize);
/* 242 */     this.lineChart.setXLabelFont(this.xLabelFont);
/* 243 */     this.lineChart.setXLabelFontSize(this.xLabelFontSize);
/* 244 */     this.lineChart.setXTickLabelFont(this.xTickLabelFont);
/* 245 */     this.lineChart.setXTickLabelFontSize(this.xTickLabelFontSize);
/* 246 */     this.lineChart.setYLabelFont(this.yLabelFont);
/* 247 */     this.lineChart.setYLabelFontSize(this.yLabelFontSize);
/* 248 */     this.lineChart.setYTickLabelFont(this.yTickLabelFont);
/* 249 */     this.lineChart.setYTickLabelFontSize(this.yTickLabelFontSize);
/*     */ 
/* 252 */     this.lineChart.setLegendFont(this.legendFont);
/* 253 */     this.lineChart.setLegendFontSize(this.legendFontSize);
/*     */ 
/* 255 */     this.lineChart.createXYChart(dataset);
/*     */   }
/*     */ 
/*     */   public static void main(String[] arg) throws Exception
/*     */   {
/* 260 */     List list = new ArrayList();
/* 261 */     for (int i = 0; i < 5; i++) {
/* 262 */       List tempList = new ArrayList();
/* 263 */       tempList.add(new Double(i + 1 + "00"));
/* 264 */       tempList.add("水果");
/* 265 */       tempList.add("水果" + (i + 1));
/* 266 */       list.add(tempList);
/*     */     }
/*     */ 
/* 270 */     CreateChart cc = new CreateChart();
/* 271 */     cc.setChartFilePath("d:/aaa/");
/* 272 */     cc.setChartFileName("中文.jpg");
/* 273 */     cc.setChartTitle("TITLE");
/* 274 */     cc.setChartWidth(new Integer(400));
/* 275 */     cc.setChartHeight(new Integer(300));
/*     */ 
/* 277 */     cc.setTitleFont("宋体");
/* 278 */     cc.setTitleFontSize(new Integer(20));
/* 279 */     cc.setChartOrientation("V");
/*     */ 
/* 282 */     cc.CreateBarChart3D(list);
/*     */   }
/*     */ 
/*     */   public void setChartFileName(String chartFileName)
/*     */   {
/* 289 */     this.chartFileName = chartFileName;
/*     */   }
/*     */   public void setChartFilePath(String chartFilePath) {
/* 292 */     this.chartFilePath = chartFilePath;
/*     */   }
/*     */   public void setChartHeight(Integer chartHeight) {
/* 295 */     this.chartHeight = chartHeight;
/*     */   }
/*     */   public void setChartTitle(String chartTitle) {
/* 298 */     this.chartTitle = chartTitle;
/*     */   }
/*     */   public void setChartWidth(Integer chartWidth) {
/* 301 */     this.chartWidth = chartWidth;
/*     */   }
/*     */   public void setLegendFont(String legendFont) {
/* 304 */     this.legendFont = legendFont;
/*     */   }
/*     */   public void setLegendFontSize(Integer legendFontSize) {
/* 307 */     this.legendFontSize = legendFontSize;
/*     */   }
/*     */   public void setPieChart(PieChart pieChart) {
/* 310 */     this.pieChart = pieChart;
/*     */   }
/*     */   public void setPieType(Integer pieType) {
/* 313 */     this.pieType = pieType;
/*     */   }
/*     */   public void setSectionFont(String sectionFont) {
/* 316 */     this.sectionFont = sectionFont;
/*     */   }
/*     */   public void setSectionFontSize(Integer sectionFontSize) {
/* 319 */     this.sectionFontSize = sectionFontSize;
/*     */   }
/*     */   public void setTitleFont(String titleFont) {
/* 322 */     this.titleFont = titleFont;
/*     */   }
/*     */   public void setTitleFontSize(Integer titleFontSize) {
/* 325 */     this.titleFontSize = titleFontSize;
/*     */   }
/*     */ 
/*     */   public void setChartMenuTag(String chartMenuTag) {
/* 329 */     this.chartMenuTag = chartMenuTag;
/*     */   }
/*     */   public void setChartOrientation(String chartOrientation) {
/* 332 */     this.chartOrientation = chartOrientation;
/*     */   }
/*     */   public void setChartValueTag(String chartValueTag) {
/* 335 */     this.chartValueTag = chartValueTag;
/*     */   }
/*     */   public void setItemLabelFont(String itemLabelFont) {
/* 338 */     this.itemLabelFont = itemLabelFont;
/*     */   }
/*     */   public void setItemLabelFontSize(Integer itemLabelFontSize) {
/* 341 */     this.itemLabelFontSize = itemLabelFontSize;
/*     */   }
/*     */   public void setXLabelFont(String labelFont) {
/* 344 */     this.xLabelFont = labelFont;
/*     */   }
/*     */   public void setXLabelFontSize(Integer labelFontSize) {
/* 347 */     this.xLabelFontSize = labelFontSize;
/*     */   }
/*     */   public void setXTickLabelFont(String tickLabelFont) {
/* 350 */     this.xTickLabelFont = tickLabelFont;
/*     */   }
/*     */   public void setXTickLabelFontSize(Integer tickLabelFontSize) {
/* 353 */     this.xTickLabelFontSize = tickLabelFontSize;
/*     */   }
/*     */   public void setYLabelFont(String labelFont) {
/* 356 */     this.yLabelFont = labelFont;
/*     */   }
/*     */   public void setYLabelFontSize(Integer labelFontSize) {
/* 359 */     this.yLabelFontSize = labelFontSize;
/*     */   }
/*     */   public void setYTickLabelFont(String tickLabelFont) {
/* 362 */     this.yTickLabelFont = tickLabelFont;
/*     */   }
/*     */   public void setYTickLabelFontSize(Integer tickLabelFontSize) {
/* 365 */     this.yTickLabelFontSize = tickLabelFontSize;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.chart.CreateChart
 * JD-Core Version:    0.6.2
 */