package aspects.soundsystem;

import java.util.HashMap;
import java.util.Map;

public class TrackCounter {
    private Map<Integer, Integer> trackCount = new HashMap<>();

    public void trackPlayed(int trackIndex) {
    }

    public void countTrack(int trackIndex) {
        int count = getPlayCount(trackIndex);
        trackCount.put(trackIndex, count + 1);
    }

    int getPlayCount(int trackIndex) {
        return trackCount.containsKey(trackIndex) ? trackCount.get(trackIndex) : 0;
    }
}
