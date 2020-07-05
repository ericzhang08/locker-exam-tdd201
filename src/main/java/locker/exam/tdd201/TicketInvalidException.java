package locker.exam.tdd201;

public class TicketInvalidException extends RuntimeException{
    public TicketInvalidException() {
        super("ticket not exist");
    }
}
