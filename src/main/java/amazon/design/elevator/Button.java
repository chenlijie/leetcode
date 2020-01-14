package amazon.design.elevator;

public class Button {
    public String label;
    public boolean isLightOn;
    public ActionListener listener;

    public Button(String label, ActionListener listener) {
        this.label = label;
        this.listener = listener;
    }

    public Button(ActionListener listener) {
        this.listener = listener;
    }

    public void addActionListener(ActionListener listener) {
        this.listener = listener;
    }

    public void pressButton() {
        listener.performAction();
    }
}
