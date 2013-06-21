/*    */ package com.sqds.spring.annotation;
/*    */ 
/*    */ import java.beans.PropertyDescriptor;
/*    */ import java.lang.reflect.Field;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.BeansException;
/*    */ import org.springframework.beans.PropertyValues;
/*    */ import org.springframework.beans.factory.BeanFactory;
/*    */ import org.springframework.beans.factory.BeanFactoryAware;
/*    */ import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
/*    */ import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
/*    */ import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class GlobalAutowiredAnnotationBeanPostProcessor extends InitDestroyAnnotationBeanPostProcessor
/*    */   implements InstantiationAwareBeanPostProcessor, BeanFactoryAware
/*    */ {
/*    */   private static final long serialVersionUID = 8872458695070178553L;
/* 27 */   protected final Log logger = LogFactory.getLog(GlobalAutowiredAnnotationBeanPostProcessor.class);
/*    */   private ConfigurableListableBeanFactory beanFactory;
/*    */ 
/*    */   public Object postProcessBeforeInstantiation(Class beanClass, String beanName)
/*    */     throws BeansException
/*    */   {
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */   public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException
/*    */   {
/* 38 */     return pvs;
/*    */   }
/*    */ 
/*    */   public boolean postProcessAfterInstantiation(Object bean, String beanName)
/*    */     throws BeansException
/*    */   {
/* 44 */     if (bean.getClass().isAnnotationPresent(GlobalAutowired.class)) {
/* 45 */       Field[] fields = bean.getClass().getDeclaredFields();
/* 46 */       for (Field field : fields) {
/* 47 */         Object o = this.beanFactory.getBean(field.getName());
/* 48 */         if (o != null) {
/* 49 */           field.setAccessible(true);
/*    */           try {
/* 51 */             field.set(bean, o);
/*    */           } catch (Exception e) {
/* 53 */             e.printStackTrace();
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 58 */     return true;
/*    */   }
/*    */ 
/*    */   public void setBeanFactory(BeanFactory beanFactory)
/*    */     throws BeansException
/*    */   {
/* 65 */     if (this.logger.isDebugEnabled()) {
/* 66 */       this.logger.debug("注入beanFactory");
/*    */     }
/* 68 */     if (!(beanFactory instanceof ConfigurableListableBeanFactory)) {
/* 69 */       throw new IllegalArgumentException(
/* 70 */         "GlobeAutowiredAnnotationBeanPostProcessor requires a ConfigurableListableBeanFactory");
/*    */     }
/* 72 */     this.beanFactory = ((ConfigurableListableBeanFactory)beanFactory);
/*    */   }
/*    */ }

/* Location:           C:\Users\gefangshuai\Desktop\sqds2.0.jar
 * Qualified Name:     com.sqds.spring.annotation.GlobalAutowiredAnnotationBeanPostProcessor
 * JD-Core Version:    0.6.2
 */