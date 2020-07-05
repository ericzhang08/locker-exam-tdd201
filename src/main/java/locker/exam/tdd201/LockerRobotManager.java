package locker.exam.tdd201;

import java.util.List;

public class   LockerRobotManager {
    private List<PrimaryLockerRobot> primaryLockerRobots;
    private List<SuperLockerRobot> superLockerRobots;
    private List<Locker> lockers;

    public LockerRobotManager(List<PrimaryLockerRobot> primaryLockerRobots,List<SuperLockerRobot> superLockerRobots, List<Locker> lockers) {
        this.primaryLockerRobots = primaryLockerRobots;
        this.superLockerRobots = superLockerRobots;
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        if (bag.getType().equals(TypeEnum.SMALL)) {
            return lockers.get(0).store(bag);
        }
        if(bag.getType().equals(TypeEnum.MEDIUM)){
            return primaryLockerRobots.get(0).store(bag);
        }
        return superLockerRobots.get(0).store(bag);
    }
}
