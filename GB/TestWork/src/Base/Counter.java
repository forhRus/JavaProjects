package Base;

public class Counter {
    private int count;

    public Counter(int maxID) {
        this.count = maxID;
    }

    public Counter() {
        this(0);
    }

    public void Increase(){
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
