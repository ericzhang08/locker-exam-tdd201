package locker.exam.tdd201;

public class Ticket {
    private TypeEnum type;

    public Ticket(TypeEnum type) {
        this.type = type;
    }
    public TypeEnum getType() {
        return type;
    }
}
