package locker.exam.tdd201;

import java.util.Comparator;
import java.util.List;

public class SuperLockerRobot extends LockerRobot {
    public SuperLockerRobot(List<Locker> lockers) {
        super(lockers, TypeEnum.LARGE);
    }

    public Ticket store(Bag bag) {
        return lockerRepository.stream().max(Comparator.comparingDouble(Locker::emptyRatio)).get().store(bag);
    }
}
