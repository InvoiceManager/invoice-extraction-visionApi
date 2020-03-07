package com.invoice.vision.translators;

import com.google.cloud.vision.v1.Vertex;
import com.invoice.vision.dto.PositionDto;
import org.springframework.stereotype.Component;

@Component
public class VertexToPointTranslator {


    public PositionDto vertexToPosition(Vertex vertex){
        PositionDto positionDto = new PositionDto();
        positionDto.setX(vertex.getX());
        positionDto.setY(vertex.getY());
        return positionDto;
    }
}
