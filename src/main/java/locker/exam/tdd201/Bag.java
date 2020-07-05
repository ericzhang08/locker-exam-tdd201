package locker.exam.tdd201;

public class Bag {
    private TypeEnum type;

    public Bag(TypeEnum type) {

        this.type = type;
    }

    public TypeEnum getType() {
        return type;
    }

    public boolean isType(TypeEnum type) {
        return this.type.equals(type);
    }
}
