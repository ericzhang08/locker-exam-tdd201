package locker.exam.tdd201;

import java.util.List;

public class SuperLockerRobot {
    public SuperLockerRobot(List<Locker> lockers) {
        for (Locker locker : lockers) {
            if (!locker.isType(TypeEnum.LARGE)){
                throw new LockerTypeException();
            }
        }

    }
}
