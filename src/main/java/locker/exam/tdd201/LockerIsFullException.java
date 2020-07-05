package locker.exam.tdd201;

public class LockerIsFullException  extends RuntimeException{
    public LockerIsFullException() {
        super("there is not enough capacity");
    }
}
