package main.java.Objects;

public class Matrix {
    private int columns;
    private int rows;
    private double[][] values;

    public Matrix(int columns, int rows) {
        this.values = new double[columns][rows];
        this.columns = columns;
        this.rows = rows;
    }

    public void multiply(double value) {
        for (int i=0;i<this.values.length;i++)
            for (int j=0;j<this.values[i].length;j++)
                this.values[i][j] *= value;
    }
    public void setValue(int columns, int rows, double newValue) { this.values[columns][rows] = newValue; }
    public void setMatrix(double[][] values) {
        if (values.length > this.columns || values[0].length > this.rows)
            return;
        for (int i=0;i<this.values.length;i++)
            for (int j=0;j<this.values[i].length;j++)
                this.values[i][j] = values[i][j];
    }

    public int getColumns() { return this.columns; }
    public int getRows() { return this.rows; }
    public double getValue(int columns, int rows) { return this.values[columns][rows]; }
    public double[][] getMatrix() { return this.values; }
}