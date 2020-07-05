package locker.exam.tdd201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {
    @Test
    void should_return_small_bag_ticket_when_store_given_a_not_full_small_bag() {
        Locker smallLocker = new Locker(1 , TypeEnum.SMALL);
        Ticket ticket = smallLocker.store(new Bag());
        assertTrue(ticket.isType(TypeEnum.SMALL));
    }

    @Test
    void should_throw_NoAvailableCapacityException_when_store_given_a_full_small_locker() {
        Locker smallLocker = new Locker(1, TypeEnum.SMALL);
        smallLocker.store(new Bag());

        assertThrows(NoAvailableCapacityException.class, () -> smallLocker.store(new Bag()));
    }

    @Test
    void should_get_bag_when_pick_up_given_a_valid_small_ticket() {
        Locker smallLocker = new Locker(1, TypeEnum.SMALL);
        Bag bagExpected = new Bag();
        Ticket ticket = smallLocker.store(bagExpected);
        Bag bag = smallLocker.pickUp(ticket);
        assertEquals(bagExpected, bag);
    }

    @Test
    void should_throw_TicketInvalidException_when_pick_up_given_a_not_exist_small_ticket_and_a_small_locker() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        assertThrows(TicketInvalidException.class, () -> locker.pickUp(new Ticket(TypeEnum.SMALL)));
    }

    @Test
    void should_throw_TicketTypeException_when_pick_up_given_a_medium_type_ticket_and_a_small_locker() {
        Locker locker = new Locker(1, TypeEnum.SMALL);
        assertThrows(TicketTypeException.class, () -> locker.pickUp(new Ticket(TypeEnum.MEDIUM)));
    }
}
