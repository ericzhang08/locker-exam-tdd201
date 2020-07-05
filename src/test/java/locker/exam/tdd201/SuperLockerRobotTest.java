package locker.exam.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperLockerRobotTest {
    @Test
    void should_throw_LockerTypeException_when_create_SuperLockerRobot_given_a_locker_is_not_large_type() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        assertThrows(LockerTypeException.class, () -> new SuperLockerRobot(Collections.singletonList(locker)));
    }
}
