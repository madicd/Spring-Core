package aspects.concert;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Before("execution(* aspects.concert.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones.");
    }

    @Before("execution(* aspects.concert.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Silencing cell phones.");
    }

    @AfterReturning("execution(* aspects.concert.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(* aspects.concert.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding refund.");
    }
}
