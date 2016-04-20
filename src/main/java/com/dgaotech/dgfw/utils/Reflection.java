package com.dgaotech.dgfw.utils;

import java.lang.reflect.Array;    
import java.lang.reflect.Constructor;    
import java.lang.reflect.Field;    
import java.lang.reflect.Method;    
/**   
1. * Java Reflection Cookbook   
2. *   
3. * @author Michael Lee   
4. * @since 2006-8-23   
5. * @version 0.1a   
6. */   
 
public class Reflection {    
    /**   
    * 得到某个对象的公共属性   
3.     *   
4.     * @param owner, fieldName   
5.     * @return 该属性对象   
6.     * @throws Exception   
7.     *   
8.     */   
    public Object getProperty(Object owner, String fieldName) throws Exception {    
       Class ownerClass = owner.getClass();    
   
       Field field = ownerClass.getField(fieldName);    
      Object property = field.get(owner);    

      return property;    
  }    
    
   /**   
     * 得到某类的静态公共属性   
     *      *   
     *           * @param className   类名   
     * @param fieldName   属性名   
24     * @return 该属性对象   
25.     * @throws Exception   
26.     */   
    public Object getStaticProperty(String className, String fieldName)    
            throws Exception {    
        Class ownerClass = Class.forName(className);    
   
        Field field = ownerClass.getField(fieldName);    
   
        Object property = field.get(ownerClass);    
   
        return property;    
    }    
      
/**   
40.     * 执行某对象方法   
41.     *   
42.     * @param owner   
43.     *            对象   
44.     * @param methodName   
45.     *            方法名   
46.     * @param args   
47.     *            参数   
48.     * @return 方法返回值   
49.     * @throws Exception   
50.     */   
    public Object invokeMethod(Object owner, String methodName, Object[] args)    
            throws Exception {    
   
        Class ownerClass = owner.getClass();    
   
        Class[] argsClass = new Class[args.length];    
   
        for (int i = 0, j = args.length; i < j; i++) {    
            argsClass[i] = args[i].getClass();    
        }    
   
        Method method = ownerClass.getMethod(methodName, argsClass);    
   
        return method.invoke(owner, args);    
    }    
   
   
      /**   
69.     * 执行某类的静态方法   
70.     *   
71.     * @param className   
72.     *            类名   
73.     * @param methodName   
74.     *            方法名   
75.     * @param args   
76.     *            参数数组   
77.     * @return 执行方法返回的结果   
78.     * @throws Exception   
79.     */   
    public Object invokeStaticMethod(String className, String methodName,    
            Object[] args) throws Exception {    
        Class ownerClass = Class.forName(className);    
   
        Class[] argsClass = new Class[args.length];    
   
        for (int i = 0, j = args.length; i < j; i++) {    
            argsClass[i] = args[i].getClass();    
        }    
   
        Method method = ownerClass.getMethod(methodName, argsClass);    
   
        return method.invoke(null, args);    
    }    
   
   
   
    /**   
98.     * 新建实例   
99.     *   
100.     * @param className   
101.     *            类名   
102.     * @param args   
103.     *            构造函数的参数   
104.     * @return 新建的实例   
105.     * @throws Exception   
106.     */   
    public Object newInstance(String className, Object[] args) throws Exception {    
        Class newoneClass = Class.forName(className);    
   
        Class[] argsClass = new Class[args.length];    
   
        for (int i = 0, j = args.length; i < j; i++) {    
            argsClass[i] = args[i].getClass();    
        }    
   
        Constructor cons = newoneClass.getConstructor(argsClass);    
   
        return cons.newInstance(args);    
   
    }  
    
    /**   
    98.     * 新建实例   
    99.     *   
    100.     * @param className   
    101.     *            类名   
    102.     * @param args   
    103.     *            构造函数的参数   
    104.     * @return 新建的实例   
    105.     * @throws Exception   
    106.     */   
        public Object newInstance(String className) throws Exception {    
            Class newoneClass = Class.forName("com.bestnet.multilweb.services.generatePage.plus."+className);
            return newoneClass.newInstance();    
       
        }   
   
        
    /**   
125.     * 是不是某个类的实例   
126.     * @param obj 实例   
127.     * @param cls 类   
128.     * @return 如果 obj 是此类的实例，则返回 true   
129.     */   
    public boolean isInstance(Object obj, Class cls) {    
        return cls.isInstance(obj);    
    }    
        
    /**   
135.     * 得到数组中的某个元素   
136.     * @param array 数组   
137.     * @param index 索引   
138.     * @return 返回指定数组对象中索引组件的值   
139.     */   
    public Object getByArray(Object array, int index) {    
        return Array.get(array,index);    
    }    
}   
