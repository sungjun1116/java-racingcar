package game.domain;

public class TryCount {

    private int count;

    public TryCount(final int count) {
        this.count = count;
    }

    public void minusCount() {
        count--;
    }

    public boolean isEnd() {
        return this.count == 0;
    }
}
