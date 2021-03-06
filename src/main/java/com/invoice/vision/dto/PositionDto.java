package com.invoice.vision.dto;

public class PositionDto {

    private int x;
    private int y;

    public PositionDto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PositionDto() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PositionDto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
