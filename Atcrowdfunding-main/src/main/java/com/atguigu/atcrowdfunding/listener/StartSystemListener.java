package com.atguigu.atcrowdfunding.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 用APP_PATH代替原路径
 *
 * @author chen
 * @date 2019/1/12
 */
public class StartSystemListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent ser){
        ServletContext application = ser.getServletContext();
        String contextPath = application.getContextPath();
        application.setAttribute("APP_PATH",contextPath);
    }
    @Override
    public void contextDestroyed(ServletContextEvent ser){

    }
}
