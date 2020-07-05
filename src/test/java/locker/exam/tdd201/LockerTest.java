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
}
