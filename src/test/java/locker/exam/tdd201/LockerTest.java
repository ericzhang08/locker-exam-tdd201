package locker.exam.tdd201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {
    @Test
    void should_return_small_bag_ticket_when_store_given_a_not_full_small_bag() {
        Locker smallLocker = new Locker(1 , "S");
        Ticket ticket = smallLocker.store(new Bag());
        assertEquals("S",ticket.getType());
    }

    @Test
    void should_throw_LockerIsFullException_when_store_given_a_full_small_locker() {
        Locker smallLocker = new Locker(1, "S");
        smallLocker.store(new Bag());

        assertThrows(LockerIsFullException.class, () -> smallLocker.store(new Bag()));
    }

    @Test
    void should_get_bag_when_pick_up_given_a_valid_small_ticket() {
        Locker smallLocker = new Locker(1, "S");
        Bag bagExpected = new Bag();
        Ticket ticket = smallLocker.store(bagExpected);
        Bag bag = smallLocker.pickUp(ticket);
        assertEquals(bagExpected, bag);
    }

    @Test
    void should_throw_TicketInvalidException_when_pick_up_given_a_not_exist_small_ticket_and_a_small_locker() {
        Locker locker = new Locker(1, "S");
        assertThrows(TicketInvalidException.class, () -> locker.pickUp(new Ticket("S")));
    }

    @Test
    void should_throw_TicketTypeException_when_pick_up_given_a_medium_type_ticket_and_a_small_locker() {
        Locker locker = new Locker(1, "S");
        assertThrows(TicketTypeException.class, () -> locker.pickUp(new Ticket("M")));
    }
}
