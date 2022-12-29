package shapes;

public class MySquare extends MyShape{
    MyPoint startpoint;
    int length;


    public MySquare(MyPoint startpoint,int length)
    {
        this.startpoint = startpoint;
        this.length = length;
    }

    public MySquare() {

    }

    public MyPoint getStartpoint(){return this.startpoint;}
    public void setStartpoint(MyPoint startpoint) {
        this.startpoint = startpoint;
    }

    public int getLength(){return this.length;}
    public void setLength(int length){this.length = length;}
}
