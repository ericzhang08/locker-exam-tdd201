package locker.exam.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class LockerRobotManagerTest {
    @Test
    void should_return_small_type_ticket_when_store_given_a_locker_robot_manager_manage_a_not_full_small_locker() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));

        Bag bag = new Bag(TypeEnum.SMALL);
        Ticket ticket = lockerRobotManager.store(bag);
        assertTrue(ticket.isType(TypeEnum.SMALL));
        assertEquals(bag, locker.pickUp(ticket));
    }
    @Test
    void should_return_medium_type_ticket_when_store_given_a_locker_robot_manager_manage_a_not_full_small_locker_and_a_primaryLockerRobot() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));
        Bag bag = new Bag(TypeEnum.MEDIUM);
        Ticket ticket = lockerRobotManager.store(bag);
        assertTrue(ticket.isType(TypeEnum.MEDIUM));
        assertEquals(bag, primaryLockerRobot.pickUp(ticket));
    }

    @Test
    void should_return_large_type_ticket_when_store_given_a_locker_robot_manager_manage_a_not_full_small_locker_and_a_primaryLockerRobot_and_a_superLockerRobot() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));

        Bag bag = new Bag(TypeEnum.LARGE);
        Ticket ticket = lockerRobotManager.store(bag);
        assertTrue(ticket.isType(TypeEnum.LARGE));
        assertEquals(bag, superLockerRobot.pickUp(ticket));
    }

    @Test
    void should_throw_noAvailableCapacityException_when_store_given_a_full_small_locker() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        locker.store(new Bag(TypeEnum.SMALL));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));

        assertThrows(NoAvailableCapacityException.class, ()->lockerRobotManager.store(new Bag(TypeEnum.SMALL)) );
    }
}
