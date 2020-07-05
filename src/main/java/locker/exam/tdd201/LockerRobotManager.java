package locker.exam.tdd201;

import java.util.List;

public class   LockerRobotManager {
    private List<PrimaryLockerRobot> primaryLockerRobots;
    private List<Locker> lockers;

    public LockerRobotManager(List<PrimaryLockerRobot> primaryLockerRobots, List<Locker> lockers) {
        this.primaryLockerRobots = primaryLockerRobots;
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        if (bag.getType().equals(TypeEnum.SMALL)) {
            return lockers.get(0).store(bag);
        }
        return primaryLockerRobots.get(0).store(bag);
    }
}
