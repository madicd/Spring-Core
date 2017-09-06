package wiring.soundsystem;

public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
