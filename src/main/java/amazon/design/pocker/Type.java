package amazon.design.pocker;

public enum Type {
    HEARTS("RED"), DIAMONDS("RED"), CLUBS("BLACK"), SPADES("BLACK");

    private String color;

    Type(String color) {
        this.color = color;
    }
}
