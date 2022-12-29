package shapes;

public class MyCircle extends MyShape implements StatusOnDisk {
    MyPoint center;
    int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void save() {

    }
    public void open() {

    }
}
