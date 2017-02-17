package com.gd.spring.aspects;

import com.gd.spring.components.HelloBean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class SampleAspect {
    private static final Logger logger = LoggerFactory.getLogger(SampleAspect.class);

    @Pointcut("within(com.gd.spring.components.HelloBean)")
    public void helloBean() {
    }

    @Before("helloBean()")
    public void doHelloBeanAspect(JoinPoint joinPoint) {
        HelloBean target = (HelloBean) joinPoint.getTarget();
        logger.info("-->AOP: Asspect for {} was called. The targe it: {}.", joinPoint.toString(), target);
    }

    @Pointcut("target(com.gd.spring.repositories.GreetingRepository)")
    public void allClassesThatImplementGreetingRepository() {
    }

    @After("allClassesThatImplementGreetingRepository()")
    public void doInterfaceAspect(JoinPoint joinPoint) {
        logger.info("-->AOP: Asspect for {} was called. The targe it: {}.", joinPoint.toString());
    }

    @Around(value = "execution(com.gd.spring.dto.GreetingDTO com.gd.spring.services.GreetingService.getGreeting(..)) && args(name)")
    public Object doAroundWithArgument(ProceedingJoinPoint proceedingJoinPoint, String name) throws Throwable {
        logger.warn("--> AOP Around START: For: {} with argument name={}.", proceedingJoinPoint.getTarget(), name);
        Object returnVal = proceedingJoinPoint.proceed();
        logger.warn("--> AOP Around END: For: {} with argument name={}. Result={}.", proceedingJoinPoint.getTarget(), name, returnVal);
        return returnVal;

    }

    @Around("@annotation(com.gd.spring.annotations.Loggable)")
    public Object doArroundWithAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.warn("--> AOP Around START Loggable Annotation: For: {}.", proceedingJoinPoint.getTarget());
        Object returnVal = proceedingJoinPoint.proceed();
        logger.warn("--> AOP Around END Loggable Annotation: For: {}. Result={}.", proceedingJoinPoint.getTarget(), returnVal);
        return returnVal;
    }
}
