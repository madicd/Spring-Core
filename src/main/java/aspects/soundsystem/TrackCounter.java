package aspects.soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCount = new HashMap<>();

    @Pointcut("execution(* wiring.soundsystem.CompactDisc.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber) {
    }

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int count = getPlayCount(trackNumber);
        trackCount.put(trackNumber, count + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCount.containsKey(trackNumber) ? trackCount.get(trackNumber) : 0;
    }
}
