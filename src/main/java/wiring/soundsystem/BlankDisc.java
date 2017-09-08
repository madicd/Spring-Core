package wiring.soundsystem;

import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> trackList;

    public void setTrackList(List<String> trackList) {
        this.trackList = trackList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        playAllTracks();
    }

    private void playAllTracks() {
        if (trackList != null) {
            for (int i = 0; i < trackList.size(); i++) {
                playTrack(i);
            }
        }
    }

    public void playTrack(int index) {
        if (index >= trackList.size()) {
            return;
        }
        String trackName = trackList.get(index);
        System.out.println("Playing " + trackName);
    }
}
