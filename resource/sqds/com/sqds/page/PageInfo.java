/*     */ package com.sqds.page;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public class PageInfo<T>
/*     */ {
/*     */   public static final String ASC = "asc";
/*     */   public static final String DESC = "desc";
/*  19 */   private int pageNo = 1;
/*  20 */   private int pageSize = 15;
/*  21 */   private String orderBy = "";
/*  22 */   private String order = "desc";
/*  23 */   private boolean autoCount = true;
/*  24 */   private List<T> result = null;
/*  25 */   private int totalCount = -1;
/*     */ 
/*  27 */   private Map<String, Object> postValue = new HashMap();
/*     */ 
/*     */   public int getPageSize()
/*     */   {
/*  37 */     return this.pageSize;
/*     */   }
/*     */ 
/*     */   public void setPageSize(int pageSize) {
/*  41 */     this.pageSize = pageSize;
/*     */   }
/*     */ 
/*     */   public boolean isPageSizeSetted()
/*     */   {
/*  48 */     return this.pageSize > -1;
/*     */   }
/*     */ 
/*     */   public int getPageNo()
/*     */   {
/*  55 */     return this.pageNo;
/*     */   }
/*     */ 
/*     */   public void setPageNo(int pageNo) {
/*  59 */     this.pageNo = pageNo;
/*     */   }
/*     */ 
/*     */   public int getFirst()
/*     */   {
/*  66 */     if ((this.pageNo < 1) || (this.pageSize < 1)) {
/*  67 */       return -1;
/*     */     }
/*  69 */     return (this.pageNo - 1) * this.pageSize;
/*     */   }
/*     */ 
/*     */   public boolean isFirstSetted()
/*     */   {
/*  76 */     return (this.pageNo > 0) && (this.pageSize > 0);
/*     */   }
/*     */ 
/*     */   public String getOrderBy()
/*     */   {
/*  83 */     return this.orderBy;
/*     */   }
/*     */ 
/*     */   public void setOrderBy(String orderBy) {
/*  87 */     this.orderBy = orderBy;
/*     */   }
/*     */ 
/*     */   public boolean isOrderBySetted()
/*     */   {
/*  94 */     return StringUtils.isNotBlank(this.orderBy);
/*     */   }
/*     */ 
/*     */   public String getOrder()
/*     */   {
/* 101 */     return this.order;
/*     */   }
/*     */ 
/*     */   public void addParameter(String key, Object value)
/*     */   {
/* 109 */     this.postValue.put(key, value);
/*     */   }
/*     */ 
/*     */   public void removeParameter(String key)
/*     */   {
/* 116 */     this.postValue.remove(key);
/*     */   }
/*     */ 
/*     */   public void clearParameter()
/*     */   {
/* 122 */     this.postValue.clear();
/*     */   }
/*     */ 
/*     */   public Object getParameter(String key)
/*     */   {
/* 130 */     return this.postValue.get(key);
/*     */   }
/*     */ 
/*     */   public String getStringParameter(String key)
/*     */   {
/* 138 */     String str = (String)getParameter(key);
/* 139 */     if (str == null) {
/* 140 */       str = "";
/*     */     }
/* 142 */     return str;
/*     */   }
/*     */ 
/*     */   public void setOrder(String order)
/*     */   {
/* 151 */     if (("asc".equalsIgnoreCase(order)) || ("desc".equalsIgnoreCase(order)))
/* 152 */       this.order = order.toLowerCase();
/*     */     else
/* 154 */       throw new IllegalArgumentException("order should be 'desc' or 'asc'");
/*     */   }
/*     */ 
/*     */   public boolean isAutoCount()
/*     */   {
/* 162 */     return this.autoCount;
/*     */   }
/*     */ 
/*     */   public void setAutoCount(boolean autoCount) {
/* 166 */     this.autoCount = autoCount;
/*     */   }
/*     */ 
/*     */   public List<T> getResult()
/*     */   {
/* 173 */     return this.result;
/*     */   }
/*     */ 
/*     */   public void setResult(List<T> result) {
/* 177 */     this.result = result;
/*     */   }
/*     */ 
/*     */   public int getTotalCount()
/*     */   {
/* 184 */     return this.totalCount;
/*     */   }
/*     */ 
/*     */   public void setTotalCount(int totalCount) {
/* 188 */     this.totalCount = totalCount;
/*     */   }
/*     */ 
/*     */   public int getTotalPages()
/*     */   {
/* 196 */     if (this.totalCount == -1) {
/* 197 */       return -1;
/*     */     }
/* 199 */     int count = this.totalCount / this.pageSize;
/* 200 */     if (this.totalCount % this.pageSize > 0) {
/* 201 */       count++;
/*     */     }
/* 203 */     return count;
/*     */   }
/*     */ 
/*     */   public boolean isHasNext()
/*     */   {
/* 210 */     return this.pageNo + 1 <= getTotalPages();
/*     */   }
/*     */ 
/*     */   public int getNextPage()
/*     */   {
/* 217 */     if (isHasNext()) {
/* 218 */       return this.pageNo + 1;
/*     */     }
/* 220 */     return this.pageNo;
/*     */   }
/*     */ 
/*     */   public boolean isHasPre()
/*     */   {
/* 227 */     return this.pageNo - 1 >= 1;
/*     */   }
/*     */ 
/*     */   public int getPrePage()
/*     */   {
/* 234 */     if (isHasPre()) {
/* 235 */       return this.pageNo - 1;
/*     */     }
/* 237 */     return this.pageNo;
/*     */   }
/*     */ 
/*     */   public String getNavigation() {
/* 241 */     StringBuffer navigation = new StringBuffer();
/*     */ 
/* 243 */     navigation.append("<script language=\"JavaScript\">\n");
/* 244 */     navigation.append("function gotoPage(_pageNo){\n");
/*     */ 
/* 247 */     navigation.append("if(!/^[0-9]{1,5}$/.test(_pageNo)){alert('跳转页必须为整数！');return false;}else{");
/* 248 */     navigation.append("if(_pageNo<1){_pageNo=1;}");
/* 249 */     navigation.append("if(_pageNo>").append(getTotalPages()).append("){_pageNo=").append(getTotalPages()).append(";}");
/* 250 */     navigation.append("if(_pageNo<1){_pageNo=1;}\n");
/* 251 */     navigation.append("var pageForm = document.getElementById('PageForm');\n");
/* 252 */     navigation.append("pageForm.action.value='';\n");
/* 253 */     navigation.append("pageForm._pageNo.value=_pageNo;\n");
/* 254 */     navigation.append("pageForm._pageNoTemp.value='';\n");
/* 255 */     navigation.append("pageForm.submit();}}\n");
/* 256 */     navigation.append("</script>\n");
/*     */ 
/* 259 */     navigation.append("<form method=\"post\" id=\"PageForm\" action=\"\" name=\"PageForm\" style='margin:0px' onsubmit=\"return gotoPage(document.PageForm._pageNoTemp.value)\">");
/* 260 */     navigation.append("<input type='hidden' name='_order' value='" + getOrder() + "'><input type='hidden' name='_orderBy' value='" + getOrderBy() + "'>");
/* 261 */     if (this.postValue != null) {
/* 262 */       Iterator iter = this.postValue.keySet().iterator();
/* 263 */       while (iter.hasNext()) {
/* 264 */         String key = (String)iter.next();
/* 265 */         Object value = this.postValue.get(key);
/* 266 */         if (value != null)
/*     */         {
/* 270 */           navigation.append("<input type='hidden' name='").append(key).append("' value='").append(value).append("'").append(">");
/*     */         }
/*     */       }
/*     */     }
/* 274 */     int currentPage1 = getPageNo();
/* 275 */     if (currentPage1 > getTotalPages()) {
/* 276 */       currentPage1 = getTotalPages();
/*     */     }
/* 278 */     navigation.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n");
/* 279 */     navigation.append("<tr align=\"right\" style='text-align:right'>\n");
/* 280 */     navigation.append("<td width=\"100%\" valign=\"middle\">总数[" + getTotalCount() + "]\n");
/* 281 */     navigation.append("&nbsp;&nbsp;页数[" + currentPage1 + "/" + getTotalPages() + "]\n");
/*     */ 
/* 284 */     if (getPageNo() > 1) {
/* 285 */       navigation.append("&nbsp;&nbsp;<a href=\"javascript:gotoPage(1)\">首页</a>");
/* 286 */       navigation.append("&nbsp;&nbsp;<a href=\"javascript:gotoPage(" + (getPageNo() - 1) + ")\">上一页</a>");
/*     */     } else {
/* 288 */       navigation.append("<font color='gray'>&nbsp;&nbsp;首页</font>");
/* 289 */       navigation.append("<font color='gray'>&nbsp;&nbsp;上一页</font>");
/*     */     }
/*     */ 
/* 292 */     if (getPageNo() < getTotalPages()) {
/* 293 */       navigation.append("&nbsp;&nbsp;<a href=\"javascript:gotoPage(" + (getPageNo() + 1) + ")\">下一页</a>");
/* 294 */       navigation.append("&nbsp;&nbsp;<a href=\"javascript:gotoPage(" + getTotalPages() + ")\">末页</a>");
/*     */     } else {
/* 296 */       navigation.append("<font color='gray'>&nbsp;&nbsp;下一页</font>");
/* 297 */       navigation.append("<font color='gray'>&nbsp;&nbsp;末页</font>");
/*     */     }
/*     */ 
/* 301 */     navigation.append("<input type=\"hidden\" name=\"_pageNo\">&nbsp;&nbsp;跳转<input name=\"_pageNoTemp\" type=\"text\" size=\"4\" maxlength=5>页\n");
/*     */ 
/* 309 */     if (getTotalPages() != 0)
/* 310 */       navigation.append("<input type='button' value='执行跳转' onclick=\"javascript:gotoPage(document.PageForm._pageNoTemp.value)\">&nbsp;\n");
/*     */     else {
/* 312 */       navigation.append("<input type='button' value='执行跳转' disabled=true>&nbsp;\n");
/*     */     }
/* 314 */     navigation.append("</td>\n");
/* 315 */     navigation.append("</tr>\n");
/* 316 */     navigation.append("</table>\n</form>");
/*     */ 
/* 318 */     return navigation.toString();
/*     */   }
/*     */ 
/*     */   public Map<String, Object> getPostValue()
/*     */   {
/* 325 */     return this.postValue;
/*     */   }
/*     */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.page.PageInfo
 * JD-Core Version:    0.6.2
 */