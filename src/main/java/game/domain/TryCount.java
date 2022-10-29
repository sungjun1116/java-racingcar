package game.domain;

public class TryCount {

    private final int count;

    public TryCount(final int count) {
        this.count = count;
    }

    public TryCount minusCount() {
        return new TryCount(this.count - 1);
    }

    public boolean isEnd() {
        return this.count == 0;
    }
}
