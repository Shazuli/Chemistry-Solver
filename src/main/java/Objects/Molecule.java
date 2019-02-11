package main.java.Objects;

import java.util.ArrayList;
import java.util.List;

public class Molecule {
    private List<Element> elements;
    private String title;

    public Molecule(/*List<Element> elements*/) {
        this.title = null;
        this.elements = new ArrayList<>();
        /*if (elements != null) {
            this.elements = elements;
        } else {
            this.elements = new ArrayList<>();
        }*/
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
}
