package locker.exam.tdd201;

import java.util.List;

public class PrimaryLockerRobot {


    public PrimaryLockerRobot(List<Locker> lockers) {
        for (Locker locker : lockers) {
            if (!locker.isType(TypeEnum.MEDIUM)){
                throw new LockerTypeException();
            }
        }
    }
}
