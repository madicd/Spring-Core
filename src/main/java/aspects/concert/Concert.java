package aspects.concert;

public class Concert implements Performance {
    @Override
    public void perform() {
        System.out.println("LA LA LA Concert performance.");
    }
}
