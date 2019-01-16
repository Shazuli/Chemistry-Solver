package main.java.Objects;

import java.util.ArrayList;
import java.util.List;

public class Molecule {
    private List<Element> elements;

    public void Molecule(List<Element> elements) {
        if (elements != null) {
            this.elements = elements;
        } else {
            this.elements = new ArrayList<>();
        }
    }

    public List<Element> getElements() {
        return this.elements;
    }

    public void addElement(Element element) {
        this.elements.add(element);
    }
    public boolean removeElement(int entry) {
        try {
            this.elements.remove(entry);
            return true;
        } catch (Exception err) {
            System.out.print(err);
            return false;
        }
    }
}
