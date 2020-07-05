package locker.exam.tdd201;

public class LockerTypeException extends RuntimeException{
    public LockerTypeException() {
        super("locker type error");
    }
}
