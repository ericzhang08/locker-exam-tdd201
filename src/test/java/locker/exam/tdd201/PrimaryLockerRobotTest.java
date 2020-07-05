package locker.exam.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class PrimaryLockerRobotTest {
    @Test
    void should_throw_LockerTypeException_when_create_PrimaryLockerRobot_given_a_locker_is_not_Medium_type() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        assertThrows(LockerTypeException.class, () -> new PrimaryLockerRobot(Collections.singletonList(locker)));
    }

    @Test
    void should_return_ticket_and_save_bag_in_1st_locker_when_store_given_two_medium_type_locker_is_not_full() {
        Locker firstLocker = new Locker(1, TypeEnum.MEDIUM);
        Locker secondLocker = new Locker(2, TypeEnum.MEDIUM);
        secondLocker.store(new Bag());
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(firstLocker,
                secondLocker));
        Bag bagExpected = new Bag();
        Ticket ticket = primaryLockerRobot.store(bagExpected);
        assertEquals(bagExpected, firstLocker.pickUp(ticket));
    }

    @Test
    void should_return_ticket_and_save_bag_in_second_locker_when_store_given_two_medium_type_locker_and_first_is_full() {
        Locker firstLocker = new Locker(1, TypeEnum.MEDIUM);
        Locker secondLocker = new Locker(1, TypeEnum.MEDIUM);
        firstLocker.store(new Bag());

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(firstLocker,
                secondLocker));

        Bag bagExpected = new Bag();
        Ticket ticket = primaryLockerRobot.store(bagExpected);
        assertEquals(bagExpected, secondLocker.pickUp(ticket));
    }

    @Test
    void should_throw_NoAvailableCapacityException_when_store_given_two_medium_type_locker_and_both_are_full() {
        Locker firstLocker = new Locker(1, TypeEnum.MEDIUM);
        Locker secondLocker = new Locker(1, TypeEnum.MEDIUM);
        firstLocker.store(new Bag());
        secondLocker.store(new Bag());

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(firstLocker,
                secondLocker));

        assertThrows(NoAvailableCapacityException.class, () -> primaryLockerRobot.store(new Bag()));
    }

    @Test
    void should_get_bag_when_pick_up_given_a_valid_medium_ticket() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        Bag bagExpected = new Bag();
        Ticket ticket = primaryLockerRobot.store(bagExpected);
        assertEquals(bagExpected, primaryLockerRobot.pickUp(ticket));
    }

    @Test
    void should_throw_InvalidTicketException_when_pick_up_given_an_invalid_medium_ticket() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        assertThrows(TicketInvalidException.class,() -> primaryLockerRobot.pickUp(new Ticket(TypeEnum.MEDIUM)));
    }

    @Test
    void should_throw_TicketTypeException_when_pick_up_given_an_error_type_ticket() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.MEDIUM)));
        assertThrows(TicketTypeException.class,() -> primaryLockerRobot.pickUp(new Ticket(TypeEnum.SMALL)));
    }
}
