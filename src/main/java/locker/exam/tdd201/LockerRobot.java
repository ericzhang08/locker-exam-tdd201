package locker.exam.tdd201;

import java.util.List;

public abstract class LockerRobot {
    protected List<Locker> lockerRepository;
    private TypeEnum type;
    public LockerRobot(List<Locker> lockers, TypeEnum type) {
        this.type = type;
        for (Locker locker : lockers) {
            if (!locker.isType(type)){
                throw new LockerTypeException();
            }
        }
        this.lockerRepository = lockers;
    }

    public abstract Ticket store(Bag bag) ;

    public Bag pickUp(Ticket ticket) {
        if (!ticket.isType(type)) {
            throw new TicketTypeException();
        }
        return lockerRepository.stream().filter(locker -> locker.hasTicket(ticket)).findFirst().orElseThrow(TicketInvalidException::new).pickUp(ticket);
    }
}
