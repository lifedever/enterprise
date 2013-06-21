/*    */ package com.sqds.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Calendar;
/*    */ import org.junit.Test;
/*    */ 
/*    */ public class DateUtilsTest
/*    */ {
/*    */   @Test
/*    */   public void testGetDaysBetween()
/*    */   {
/* 12 */     Calendar c1 = Calendar.getInstance();
/* 13 */     Calendar c2 = Calendar.getInstance();
/* 14 */     c2.set(2008, 1, 1);
/* 15 */     System.out.println(DateUtils.getDaysBetween(c2, c1));
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.util.DateUtilsTest
 * JD-Core Version:    0.6.2
 */