public class Rectangle {
    private double width;
    private double height;

    Rectangle() {

    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public void display() {
        System.out.println("I'm a rectangle.");
        System.out.println("My width is " + this.width);
        System.out.println("My height is " + this.height);
        System.out.println("Area is " + this.getArea() + "; Perimeter is " + this.getPerimeter());
    }
}
