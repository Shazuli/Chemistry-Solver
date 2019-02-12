package main.java.Objects;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class Molecule {
    private List<Element> elements;
    private String title;
    private Color color;

    public Molecule(/*List<Element> elements*/) {
        this.title = null;
        this.elements = new ArrayList<>();
    }

    public Element[] getElements() { return this.elements.toArray(new Element[this.elements.size()]); }
    public Element getElement(int index) { return this.elements.get(index); }

    public void setTitle(String title) { this.title = title; }
    public void addElement(Element element) {
        this.elements.add(element);
    }
    public boolean removeElement(int index) {
        try {
            this.elements.remove(index);
            return true;
        } catch (NullPointerException err) {
            System.out.print(err);
            return false;
        }
    }
    public Canvas draw(int xOffset, int yOffset) {
        Canvas canvas = new Canvas(400,70);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.setFill(Color.GREEN);
        double offset = 0;
        for (int i=0;i<this.elements.size();i++) {
            Element e = this.elements.get(i);
            double x = i*30+offset;
            double y = canvas.getHeight()*0.5-4;
            gc.setFont(new Font(40));
            gc.fillText(e.getName(),x,y);
            if (e.getQuantity() > 1) {
                gc.setFont(new Font(17));
                gc.fillText(e.getQuantity() + "", x + 27, y + 2);
                offset += 8*String.valueOf(e.getQuantity()).length()+2;
            }
            //newX = (x+offset)*8;
        }
        //canvas.setWidth(newX);

        return canvas;
    }
}
