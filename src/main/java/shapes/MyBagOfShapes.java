package shapes;

public class MyBagOfShapes {
    private MyShape[] shapes = new MyShape[5]; // plasa de shapes
    private int index;

    public void addShape(MyShape s) {
        shapes[index]=s;
        index++;
    }

    public MyShape[] getShapes() {
        return shapes;
    }
}
