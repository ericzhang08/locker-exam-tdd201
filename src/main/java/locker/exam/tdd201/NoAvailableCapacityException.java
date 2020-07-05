package locker.exam.tdd201;

public class NoAvailableCapacityException extends RuntimeException{
    public NoAvailableCapacityException() {
        super("there is not enough capacity");
    }
}
