package cn.bruce.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 记录日志的工具类
 */
public class Logger {

    public void printLog(){
        System.out.println("Logger类中的printLog方法执行，并开始记录日志。。。。");
    }

    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知beforePrintLog方法执行，开始记录日志。。。。");
    }
    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知afterReturningPrintLog方法执行，开始记录日志。。。。");
    }
    /**
     * 异常置通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知afterThrowingPrintLog方法执行，开始记录日志。。。。");
    }
    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知afterPrintLog方法执行，开始记录日志。。。。");
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();// 换取方法的执行参数

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。前置");

            rtValue = pjp.proceed(args);// 明确调用业务层方法（切入点方法）

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。后置");

            return rtValue;
        } catch (Throwable t) {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        } finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。最终");
        }
    }
}
