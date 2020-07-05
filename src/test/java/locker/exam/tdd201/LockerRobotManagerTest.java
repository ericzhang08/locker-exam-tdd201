package locker.exam.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LockerRobotManagerTest {
    @Test
    void should_return_small_type_ticket_when_store_given_a_locker_robot_manager_manage_a_not_full_small_locker() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(locker));
        Bag bag = new Bag(TypeEnum.SMALL);
        Ticket ticket = lockerRobotManager.store(bag);
        assertTrue(ticket.isType(TypeEnum.SMALL));
        assertEquals(bag, locker.pickUp(ticket));
    }
}
