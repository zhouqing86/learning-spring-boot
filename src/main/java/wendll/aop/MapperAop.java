package wendll.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class MapperAop {

    @Pointcut("execution(* wendll.mapper..*.*(..))")
    public void executeMapper(){
    }

    @Pointcut("execution(* wendll.controllers..*.*(..))")
    public void executeControllerMethod(){
    }

    @Before("executeMapper()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        System.out.println("我是前置通知!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        System.out.println(signature.getName());
        //AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = new HashMap<>();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String str = JSON.toJSONString(parameterMap);
        if(obj.length > 0) {
            System.out.println("请求的参数信息为："+str);
        }
    }

    @Around("executeControllerMethod()")
    public Object doAroundControllerMethod(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("执行Controller目标方法之前...");
        // 获取目标方法原始的调用参数
        Object[] args = jp.getArgs();
        // 以改变后的参数去执行目标方法，并保存目标方法执行后的返回值
        Object rvt = jp.proceed(args);
        System.out.println("执行Controller目标方法之后...");
        // 如果rvt的类型是Integer，将rvt改为它的平方
        if(rvt != null && rvt instanceof Integer)
            rvt = (Integer)rvt * (Integer)rvt;
        return rvt;
    }

}
