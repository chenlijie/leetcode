package amazon.design.traffic;

public class Light {
    String name;

    public Light(String name) {
        this.name = name;
    }

    public void turnOn(Color color) {

    }

    public void turnOff() {

    }

    @Override
    public String toString() {
        return name;
    }
}
