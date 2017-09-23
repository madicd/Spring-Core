package aspects.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

public class Audience {
    
    public void performance() {}

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
