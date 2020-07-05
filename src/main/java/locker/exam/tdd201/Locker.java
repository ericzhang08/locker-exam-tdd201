package locker.exam.tdd201;

import java.util.HashMap;

public class Locker {
    private int size;
    private String type;
    private HashMap<Ticket, Bag> bagRepository = new HashMap<>();
    public Locker(int size, String type) {
        this.size = size;
        this.type = type;
    }

    public Ticket store(Bag bag) {
        if (bagRepository.size() >= size) {
            throw new LockerIsFullException();
        }
        Ticket t = new Ticket("S");
        bagRepository.put(t, bag);
        return t;
    }

    public Bag pickUp(Ticket ticket) {
        return bagRepository.get(ticket);
    }
}
