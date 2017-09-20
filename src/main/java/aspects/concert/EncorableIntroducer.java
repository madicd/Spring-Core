package aspects.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncorableIntroducer {

    @DeclareParents(value = "aspects.concert.Performance+", defaultImpl = DefaultEncorable.class)
    public static Encorable encorable;
}
