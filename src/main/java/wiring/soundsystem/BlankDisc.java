package wiring.soundsystem;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
