package aspects.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    
    @Pointcut("execution(* aspects.concert.Performance.perform(..))")
    public void performance() {}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Silencing cell phones.");
            System.out.println("Taking a seat.");
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch(Throwable throwable) {
            System.out.println("Demanding refund.");
        }
    }
}
