package com.resumed.sqtwin.configurer;


import com.resumed.sqtwin.core.Result;
import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @auther Super
 * @data 2018/4/10 0010
 * @time 下午 15:24
 */
@Component
@Aspect
public class DynamicDataSourceAspect {


    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);
    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("execution(public * com.resumed.*.web..*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容

        logger.info("WebLogAspect.doBefore()");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

//        long start = System.currentTimeMillis();
        // 记录下请求内容


        logger.info("URL : " + request.getRequestURL().toString());

        logger.info("HTTP_METHOD : " + request.getMethod());

        logger.info("IP : " + request.getRemoteAddr());

        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        //获取所有参数方法一：
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headParaName = headerNames.nextElement();
            logger.info("HeadParaName : " + headParaName + "  :  " + request.getHeader(headParaName));

        }


        Enumeration<String> enu = request.getParameterNames();

        while (enu.hasMoreElements()) {

            String paraName = (String) enu.nextElement();
            logger.info("paraName : " + paraName + "  :  " + request.getParameter(paraName));
//            System.out.println(paraName+": "+request.getParameter(paraName));

        }

        Object proceed = joinPoint.proceed();
        logger.info("Response：" + (proceed instanceof Result ? (Result) proceed : proceed));
        return proceed;
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("WebLogAspect.doBefore()");


    }


    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint) {
        // 处理完请求，返回内容
        logger.info("WebLogAspect.doAfterReturning()");
        logger.info("耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));
    }


    @Before("@annotation(DS)")
    public void beforeSwitchDS(JoinPoint point) {
        logger.info("===============上下文赋值完成:进入到切面开始");
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();

        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;

        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);

//            method.get
            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
                logger.info("===============上下文赋值完成:{}", dataSource + "--------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 切换数据源
        DataSourceContextHolder.setType(dataSource);
    }

    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point) {

        DataSourceContextHolder.clear();

    }

   /* @Pointcut("execution (* com.resumed.sqtwin.dao.*.addSove*(..))")
    public void readMethodPointcut() {
    }

    @Pointcut("execution (* com.resumed.sqtwin.dao.*.addSoveMajor*(..)) ")
    public void writeMethodPointcut() {
    }

    @Before("readMethodPointcut()")
    public void switchReadDataSource() {
        System.out.println("============切换到读数据源===========");
        DataSourceContextHolder.setType(DataSourceContextHolder.Two);
    }

    @Before("writeMethodPointcut()")
    public void switchWriteDataSource() {
        System.out.println("=============切换到写数据源==========");
        DataSourceContextHolder.setType(DataSourceContextHolder.Two);
    }*/


}
