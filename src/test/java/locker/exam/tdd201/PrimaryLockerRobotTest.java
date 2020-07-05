package locker.exam.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimaryLockerRobotTest {
    @Test
    void should_throw_LockerTypeException_when_create_PrimaryLockerRobot_given_a_locker_is_not_Medium_type() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        assertThrows(LockerTypeException.class, () -> new PrimaryLockerRobot(Collections.singletonList(locker)));
    }
}
