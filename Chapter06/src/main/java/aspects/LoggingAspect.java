package aspects;

import entities.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("Method " + methodName
                + " with parameters " + Arrays.asList(arguments)
                + " will execute");

        Comment comment = new Comment();
        comment.setText("Some other text");
        Object[] newArguments = {comment};

        logger.info("Before");
        Object returnedByMethod = joinPoint.proceed(newArguments);
        logger.info("After");

        logger.info("Method executed and returned " + returnedByMethod);

        return "FAILED";
    }

}
