package aspects.soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCount = new HashMap<>();

    @Pointcut("execution(* wiring.soundsystem.CompactDisc.playTrack(int)) && args(trackIndex)")
    public void trackPlayed(int trackIndex) {
    }

    @Before(value = "trackPlayed(trackIndex)", argNames = "trackIndex")
    public void countTrack(int trackIndex) {
        int count = getPlayCount(trackIndex);
        trackCount.put(trackIndex, count + 1);
    }

    int getPlayCount(int trackIndex) {
        return trackCount.containsKey(trackIndex) ? trackCount.get(trackIndex) : 0;
    }
}
