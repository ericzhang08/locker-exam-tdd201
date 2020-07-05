package locker.exam.tdd201;

public class Ticket {
    private TypeEnum type;

    public Ticket(TypeEnum type) {
        this.type = type;
    }

    public boolean isType(TypeEnum type) {
        return this.type.equals(type);
    }
}
