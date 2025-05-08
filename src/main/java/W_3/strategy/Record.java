package W_3.strategy;

public class Record {
    private final long nsTime;
    private final long msTime;
    private final SortingStrategy sortingStrategy;

    public Record(SortingStrategy sortingStrategy, long nsTime) {
        this.sortingStrategy = sortingStrategy;
        this.nsTime = nsTime;
        this.msTime = nsTime / 1000000;
    }

    public void displayRecord(){
        System.out.printf("%16s | %12s ns | %8s ms\n",
                sortingStrategy.getName(),
                this.nsTime,
                this.msTime);
    }
}
