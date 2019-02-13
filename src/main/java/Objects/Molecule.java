package main.java.Objects;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
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
        canvas.setTranslateX(xOffset);
        canvas.setTranslateY(yOffset);
        int sizeBig = 40;
        int sizeSmall = 19;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.setFill(Color.GREEN);
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
        Font fontBig = new Font(gc.getFont().getName(),Font.PLAIN,sizeBig);
        Font fontSmall = new Font(gc.getFont().getName(),Font.PLAIN,sizeSmall);
        double offset = 0;
        for (int i=0;i<this.elements.size();i++) {
            Element e = this.elements.get(i);
            double widthBig = fontBig.getStringBounds(e.getName(),frc).getWidth();
            gc.setFont(new javafx.scene.text.Font(sizeBig));
            gc.fillText(e.getName(),offset,canvas.getHeight()*0.5-4);
            offset += widthBig+2;

            if (e.getQuantity() > 1) {
                gc.setFont(new javafx.scene.text.Font(sizeSmall));
                double widthSmall = fontSmall.getStringBounds(String.valueOf(e.getQuantity()),frc).getWidth();
                gc.fillText(String.valueOf(e.getQuantity()),offset-2,canvas.getHeight()*0.5+2);
                offset += widthSmall;
            }
        }
        canvas.setWidth(offset);

        return canvas;
    }
}
