package locker.exam.tdd201;

import java.util.Comparator;
import java.util.List;

public class SuperLockerRobot {
    private List<Locker> lockerRepository;
    public SuperLockerRobot(List<Locker> lockers) {
        for (Locker locker : lockers) {
            if (!locker.isType(TypeEnum.LARGE)){
                throw new LockerTypeException();
            }
        }
        this.lockerRepository = lockers;

    }

    public Ticket store(Bag bag) {
        return lockerRepository.stream().max(Comparator.comparingDouble(locker -> locker.emptyRatio())).get().store(bag);
    }

    public Bag pickUp(Ticket ticket) {
        return lockerRepository.stream().filter(locker -> locker.hasTicket(ticket)).findFirst().orElseThrow(TicketInvalidException::new).pickUp(ticket);
    }
}
