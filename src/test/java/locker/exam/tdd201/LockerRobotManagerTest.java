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
    void should_throw_noAvailableCapacityException_when_store_given_a_full_small_locker_and_a_small_bag() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        locker.store(new Bag(TypeEnum.SMALL));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));

        assertThrows(NoAvailableCapacityException.class, ()->lockerRobotManager.store(new Bag(TypeEnum.SMALL)) );
    }

    @Test
    void should_throw_noAvailableCapacityException_when_store_given_a_full_primaryLockerRobot_and_a_medium_Bag() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        primaryLockerRobot.store(new Bag(TypeEnum.SMALL));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));

        assertThrows(NoAvailableCapacityException.class, ()->lockerRobotManager.store(new Bag(TypeEnum.MEDIUM)) );
    }

    @Test
    void should_throw_noAvailableCapacityException_when_store_given_a_full_SuperLockerRobot_and_a_large_Bag() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        superLockerRobot.store(new Bag(TypeEnum.SMALL));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));

        assertThrows(NoAvailableCapacityException.class, ()->lockerRobotManager.store(new Bag(TypeEnum.LARGE)) );
    }

    @Test
    void should_throw_LockerTypeException_when_create_LockerRobotManager_given_a_locker_is_not_small_type() {
        Locker locker = new Locker(1, TypeEnum.MEDIUM);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));

        assertThrows(LockerTypeException.class, () -> new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker)));
    }

    @Test
    void should_get_bag_when_pick_up_given_a_valid_small_ticket() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));

        Bag bag = new Bag(TypeEnum.SMALL);
        Ticket ticket = lockerRobotManager.store(bag);
        assertEquals(bag, lockerRobotManager.pickUp(ticket));
    }

    @Test
    void should_get_bag_when_pick_up_given_a_valid_medium_ticket() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));
        Bag bag = new Bag(TypeEnum.MEDIUM);
        Ticket ticket = lockerRobotManager.store(bag);

        assertEquals(bag, lockerRobotManager.pickUp(ticket));
    }

    @Test
    void should_get_bag_when_pick_up_given_a_valid_large_ticket() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(primaryLockerRobot),Collections.singletonList(superLockerRobot),
                Collections.singletonList(locker));
        Bag bag = new Bag(TypeEnum.LARGE);
        Ticket ticket = lockerRobotManager.store(bag);

        assertEquals(bag, lockerRobotManager.pickUp(ticket));
    }

}
