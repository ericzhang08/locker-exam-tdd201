package locker.exam.tdd201;

public class Locker {
    private String type;

    public Locker(int size, String type) {
        this.type = type;
    }

    public Ticket store(Bag bag) {
        return new Ticket("S");
    }
}
