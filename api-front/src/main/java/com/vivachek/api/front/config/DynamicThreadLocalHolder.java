package com.vivachek.api.front.config;

/**
 * @Description ThreadLocal保存数据源，保持线程隔离
 * @Author CJB
 * @Date 2020/3/12 14:29
 */
public class DynamicThreadLocalHolder {
    //本地线程保存数据源
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
     * 设置线程数据源
     */
    public static void setDataSource(String dataSource){
        threadLocal.set(dataSource);
    }

    /**
     * 获取本地线程的数据源，这里只是数据源的key
     * @return
     */
    public static String getDataSource(){
        return threadLocal.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDataSource(){
        threadLocal.remove();
    }
}