package com.example.mypaint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import shapes.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        MyBagOfShapes mbs = new MyBagOfShapes();


        MyCircle circle1 = new MyCircle(new MyPoint(300,300), 200);
        MyRectangle myr1 = new MyRectangle(new MyPoint(30,700), 500, 100);
        myr1.setFillC(1);
        MyRectangle myr2 = new MyRectangle(new MyPoint(450,500), 150, 400);
        myr2.setFillC(2);
        MyPoly tri = new MyPoly(new MyPoint(10,10), new MyPoint(50,50), new MyPoint(50,100));
        MySquare square = new MySquare(new MyPoint(700 , 700), 100);

        mbs.addShape(square);
        mbs.addShape(circle1);
        mbs.addShape(myr1);
        mbs.addShape(myr2);
        mbs.addShape(tri);
        drawShapeInJavaFx(mbs, stage);


    }

    private void drawShapeInJavaFx(MyBagOfShapes mbs, Stage stage) {
        // set the scene, as found on internet for java fx
        Group group=new Group();


        // aici trebuie sa lucrez eu cu mbs in context de javafx

        MyShape[] shape = mbs.getShapes();
        for(int i = 0;i<shape.length;i++) {
            if(shape[i] instanceof MyCircle) {
                Circle circle = new Circle();
                circle.setCenterX(((MyCircle) shape[i]).getCenter().getX());
                circle.setCenterY(((MyCircle) shape[i]).getCenter().getY());
                circle.setRadius(((MyCircle) shape[i]).getRadius());
                group.getChildren().add(circle); // asta de pe net
            }
            else
                if(shape[i] instanceof MyRectangle)
                {
                    Rectangle rectangle = new Rectangle();
                    rectangle.setX(((MyRectangle) shape[i]).getStart().getX());
                    rectangle.setY(((MyRectangle) shape[i]).getStart().getY());
                    rectangle.setWidth(((MyRectangle) shape[i]).getWidth());
                    rectangle.setHeight(((MyRectangle) shape[i]).getHeight());

                    if(((MyRectangle) shape[i]).getFillC()==1)
                        rectangle.setFill(Color.RED);
                        else
                    if(((MyRectangle) shape[i]).getFillC()==2)
                        rectangle.setFill(Color.GREEN);
                        else
                    if(((MyRectangle) shape[i]).getFillC()==3)
                        rectangle.setFill(Color.BLUE);


                    group.getChildren().add(rectangle); // asta de pe net
                }

                else
                if(shape[i] instanceof MyPoly)
                {
                    Polygon p = new Polygon();

                    p.getPoints().addAll(new Double[]{
                            Double.valueOf(((MyPoly) shape[i]).getPoint1().getX()), Double.valueOf(((MyPoly) shape[i]).getPoint1().getY()),
                            Double.valueOf(((MyPoly) shape[i]).getPoint2().getX()), Double.valueOf(((MyPoly) shape[i]).getPoint2().getY()),
                            Double.valueOf(((MyPoly) shape[i]).getPoint3().getX()), Double.valueOf(((MyPoly) shape[i]).getPoint3().getY())});

                    group.getChildren().add(p); // asta de pe net
                }
                else
                    if(shape[i] instanceof MySquare)
                    {

                        MySquare square = new MySquare();
                        square.setStartpoint(((MySquare) shape[i]).getStartpoint());
                        square.setLength(((MySquare) shape[i]).getLength());

                    }
        }




        // set the scene, as found on internet for java fx
        Scene scene = new Scene(group, 1000, 1000);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}