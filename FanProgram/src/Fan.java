public class Fan {
    protected static final int SLOW = 1;
    protected static final int MEDIUM = 2;
    protected static final int FAST = 3;
    private int speed = SLOW;
    private boolean isOn = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {

    }

    public Fan(int speed, boolean isOn, double radius, String color) {
        this.speed = speed;
        this.isOn = isOn;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void changePower() {
        this.isOn = !this.isOn;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.isOn) {
            return "Fan is on:\n{" +
                    "speed=" + this.speed +
                    ", radius=" + this.radius +
                    ", color='" + this.color + '\'' +
                    '}';
        }
        return "Fan is off:\n{" +
                "radius=" + this.radius +
                ", color='" + this.color + '\'' +
                '}';
    }
}
