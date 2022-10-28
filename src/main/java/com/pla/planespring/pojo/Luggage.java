package com.pla.planespring.pojo;


public class Luggage {
    private int lugtype;
    private float hight;
    private float width;
    private float length;
    private float weight;

    @Override
    public String toString() {
        return "Luggage{" +
                "lugtype=" + lugtype +
                ", hight=" + hight +
                ", width=" + width +
                ", length=" + length +
                ", weight=" + weight +
                '}';
    }

    public Luggage() {
    }

    public Luggage(int lugtype, float hight, float width, float length, float weight) {
        this.lugtype = lugtype;
        this.hight = hight;
        this.width = width;
        this.length = length;
        this.weight = weight;
    }

    public int getLugtype() {
        return lugtype;
    }

    public void setLugtype(int lugtype) {
        this.lugtype = lugtype;
    }

    public float getHight() {
        return hight;
    }

    public void setHight(float hight) {
        this.hight = hight;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


}
