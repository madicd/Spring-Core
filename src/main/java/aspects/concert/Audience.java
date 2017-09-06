package aspects.concert;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    
    @Pointcut("execution(* aspects.concert.Performance.perform(..))")
    public void performance() {}
    
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones.");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Silencing cell phones.");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding refund.");
    }
}
