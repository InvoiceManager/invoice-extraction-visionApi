package com.invoice.vision.dto;

public class StructureDto {

    private PositionDto leftUpVertex;
    private PositionDto rightUpVertex;
    private PositionDto leftDownVertex;
    private PositionDto rightDownVertex;
    private String text;

    public StructureDto(PositionDto leftUpVertex, PositionDto rightUpVertex, PositionDto leftDownVertex, PositionDto rightDownVertex, String text) {
        this.leftUpVertex = leftUpVertex;
        this.rightUpVertex = rightUpVertex;
        this.leftDownVertex = leftDownVertex;
        this.rightDownVertex = rightDownVertex;
        this.text = text;
    }

    public StructureDto() {
    }

    public PositionDto getLeftUpVertex() {
        return leftUpVertex;
    }

    public void setLeftUpVertex(PositionDto leftUpVertex) {
        this.leftUpVertex = leftUpVertex;
    }

    public PositionDto getRightUpVertex() {
        return rightUpVertex;
    }

    public void setRightUpVertex(PositionDto rightUpVertex) {
        this.rightUpVertex = rightUpVertex;
    }

    public PositionDto getLeftDownVertex() {
        return leftDownVertex;
    }

    public void setLeftDownVertex(PositionDto leftDownVertex) {
        this.leftDownVertex = leftDownVertex;
    }

    public PositionDto getRightDownVertex() {
        return rightDownVertex;
    }

    public void setRightDownVertex(PositionDto rightDownVertex) {
        this.rightDownVertex = rightDownVertex;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
