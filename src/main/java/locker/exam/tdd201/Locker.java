package locker.exam.tdd201;

import java.util.HashMap;

public class Locker {
    private int size;
    private TypeEnum type;
    private HashMap<Ticket, Bag> bagRepository = new HashMap<>();
    public Locker(int size, TypeEnum type) {
        this.size = size;
        this.type = type;
    }

    public Ticket store(Bag bag) {
        if (bagRepository.size() >= size) {
            throw new NoAvailableCapacityException();
        }
        Ticket ticket = new Ticket(this.type);
        bagRepository.put(ticket, bag);
        return ticket;
    }

    public Bag pickUp(Ticket ticket) {
        if (!ticket.isType(type)) {
            throw new TicketTypeException();
        }
        if (!bagRepository.containsKey(ticket)) {
            throw new TicketInvalidException();
        }
        return bagRepository.get(ticket);
    }

    public boolean isType(TypeEnum medium) {
        return this.type.equals(medium);
    }

    public boolean hasAvailableCapacity() {
        return bagRepository.size() < size;
    }

    public boolean hasTicket(Ticket ticket) {
        return bagRepository.containsKey(ticket);
    }

    public double emptyRatio() {
        return (double)(size - bagRepository.size())/(double)size;
    }
}
