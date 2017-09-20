package aspects.concert;

public class DefaultEncorable implements Encorable {
    @Override
    public void performEncore() {
        System.out.println("Performing encore.");
    }
}
