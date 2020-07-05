package locker.exam.tdd201;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperLockerRobotTest {
    @Test
    void should_throw_LockerTypeException_when_create_SuperLockerRobot_given_a_locker_is_not_large_type() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        assertThrows(LockerTypeException.class, () -> new SuperLockerRobot(Collections.singletonList(locker)));
    }

    @Test
    void should_return_ticket_and_save_bag_in_the_most_empty_ratio_locker_when_store_given_two_large_type_locker_is_not_full() {
        Locker firstLocker = new Locker(2, TypeEnum.LARGE);
        Locker secondLocker = new Locker(3, TypeEnum.LARGE);
        firstLocker.store(new Bag());
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(firstLocker,
                secondLocker));
        Bag bagExpected = new Bag();
        Ticket ticket = superLockerRobot.store(bagExpected);
        assertEquals(bagExpected, secondLocker.pickUp(ticket));
    }

    @Test
    void should_return_ticket_and_save_bag_in_the_first_most_empty_ratio_locker_when_store_given_two_large_type_locker_have_the_same_empty_ratio() {
        Locker firstLocker = new Locker(1, TypeEnum.LARGE);
        Locker secondLocker = new Locker(1, TypeEnum.LARGE);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(firstLocker,
                secondLocker));
        Bag bagExpected = new Bag();
        Ticket ticket = superLockerRobot.store(bagExpected);
        assertEquals(bagExpected, firstLocker.pickUp(ticket));
    }

    @Test
    void should_throw_NoAvailableCapacityException_when_store_given_two_large_type_locker_and_both_are_full() {
        Locker firstLocker = new Locker(1, TypeEnum.LARGE);
        Locker secondLocker = new Locker(1, TypeEnum.LARGE);
        firstLocker.store(new Bag());
        secondLocker.store(new Bag());

        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(firstLocker,
                secondLocker));
        assertThrows(NoAvailableCapacityException.class, () -> superLockerRobot.store(new Bag()));
    }

    @Test
    void should_get_bag_when_pick_up_given_a_valid_large_ticket() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        Bag bagExpected = new Bag();
        Ticket ticket = superLockerRobot.store(bagExpected);
        assertEquals(bagExpected, superLockerRobot.pickUp(ticket));
    }

    @Test
    void should_throw_InvalidTicketException_when_pick_up_given_an_invalid_large_ticket() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1, TypeEnum.LARGE)));
        assertThrows(TicketInvalidException.class,() -> superLockerRobot.pickUp(new Ticket(TypeEnum.LARGE)));
    }
}
