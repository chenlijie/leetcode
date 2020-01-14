package amazon.design.pocker;

public class Card {
    Value value;
    Type type;
    Color color;

    public Card(Value value, Type type) {
        this.value = value;
        this.type = type;
    }

    public Card(Value value, Type type, Color color) {
        this.value = value;
        this.type = type;
        this.color = color;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Card{");
        sb.append("value=").append(value);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
