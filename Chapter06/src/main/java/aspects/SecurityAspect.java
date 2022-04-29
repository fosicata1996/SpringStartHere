package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(1)
@Component
public class SecurityAspect {
    private static final Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("-------------------------- Security Aspect: Before the intercepted method");
        Object returnedValue = joinPoint.proceed();
        logger.info("-------------------------- Security Aspect: Method executed and returned " + returnedValue);

        return returnedValue;
    }
}
