package locker.exam.tdd201;

import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> lockerRepository;
    public PrimaryLockerRobot(List<Locker> lockers) {
        for (Locker locker : lockers) {
            if (!locker.isType(TypeEnum.MEDIUM)){
                throw new LockerTypeException();
            }
        }
        this.lockerRepository = lockers;
    }

    public Ticket store(Bag bag) {
        return lockerRepository.stream().filter(Locker::hasAvailableCapacity).findFirst().orElseThrow(LockerIsFullException::new).store(bag);
    }
}
