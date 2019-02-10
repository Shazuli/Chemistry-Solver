package main.java.Objects;

public class Matrix {
    private int columns;
    private int rows;
    private double[][] values;

    public Matrix(int columns, int rows) {
        this.values = new double[columns][rows];
    }

    public void setValue(int columns, int rows, double newValue) {
        this.values[columns][rows] = newValue;
    }

    public double getValue(int columns, int rows) {
        return this.values[columns][rows];
    }
}