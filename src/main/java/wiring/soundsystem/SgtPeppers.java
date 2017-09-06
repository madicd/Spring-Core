package wiring.soundsystem;

public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely hearts club band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
