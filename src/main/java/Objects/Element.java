package main.java.Objects;

public class Element {
    private String name;
    private String title;
    private String type;
    private int quantity;
    private int number;
    private double mass;

    public Element(String name,int quantity) {
        this.name = name;
        if (quantity <= 0)
            this.quantity = 1;
        else
            this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }
    public String getTitle() {
        return this.title;
    }
    public int getQuantity() {
        return this.quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTitle(String title) { this.title = title; }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
