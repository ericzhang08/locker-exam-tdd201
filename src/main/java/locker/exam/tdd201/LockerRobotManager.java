package locker.exam.tdd201;

import java.util.List;

public class   LockerRobotManager {
    private List<PrimaryLockerRobot> primaryLockerRobots;
    private List<SuperLockerRobot> superLockerRobots;
    private List<Locker> lockers;

    public LockerRobotManager(List<PrimaryLockerRobot> primaryLockerRobots,List<SuperLockerRobot> superLockerRobots, List<Locker> lockers) {
        for (Locker locker : lockers) {
            if (!locker.isType(TypeEnum.SMALL)) {
                throw new LockerTypeException();
            }
        }
        this.primaryLockerRobots = primaryLockerRobots;
        this.superLockerRobots = superLockerRobots;
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        if (bag.isType(TypeEnum.SMALL)) {
            return lockers.get(0).store(bag);
        }
        if(bag.isType(TypeEnum.MEDIUM)){
            return primaryLockerRobots.get(0).store(bag);
        }
        return superLockerRobots.get(0).store(bag);
    }

    public Bag pickUp(Ticket ticket) {
        if (ticket.isType(TypeEnum.SMALL)) {
            return lockers.get(0).pickUp(ticket);
        }
        return primaryLockerRobots.get(0).pickUp(ticket);

    }
}
