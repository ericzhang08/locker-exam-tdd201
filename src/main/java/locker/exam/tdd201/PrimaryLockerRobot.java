package locker.exam.tdd201;

import java.util.List;

public class PrimaryLockerRobot extends LockerRobot{
    public PrimaryLockerRobot(List<Locker> lockers) {
        super(lockers, TypeEnum.MEDIUM);
    }

    public Ticket store(Bag bag) {
        return lockerRepository.stream().filter(Locker::hasAvailableCapacity).findFirst().orElseThrow(NoAvailableCapacityException::new).store(bag);
    }
}
