package locker.exam.tdd201;

import java.util.List;

public class   LockerRobotManager {
    private List<Locker> lockers;

    public LockerRobotManager(List<Locker> lockers) {

        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        return lockers.get(0).store(bag);
    }
}
