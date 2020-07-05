package locker.exam.tdd201;

public class TicketTypeException extends RuntimeException{
    public TicketTypeException() {
        super("ticket type error");
    }
}
