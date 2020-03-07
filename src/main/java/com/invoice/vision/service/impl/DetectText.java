package com.invoice.vision.service.impl;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.Vertex;
import com.google.protobuf.ByteString;
import com.invoice.vision.dto.OcrPageDto;
import com.invoice.vision.dto.StructureDto;
import com.invoice.vision.translators.VertexToPointTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetectText {

    @Autowired
    private VertexToPointTranslator vertexToPointTranslator;
    @Autowired
    private CropImages cropImages;

    private OcrPageDto ocrPageDto = new OcrPageDto();
    private List<StructureDto> structureDtos = new ArrayList<>();


    OcrPageDto detectText(MultipartFile file) throws Exception {
        List<AnnotateImageRequest> requests = new ArrayList<>();

        byte[] data = new byte[0];
        data = file.getBytes();
        ByteString imgBytes = ByteString.copyFrom(data);
        Image img = Image.newBuilder().setContent(imgBytes).build();



        Feature feat = Feature.newBuilder().setType(Feature.Type.DOCUMENT_TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.println("Error: %s\n" + res.getError().getMessage());
                }
                for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                    List<Vertex> vertices = annotation.getBoundingPoly().getVerticesList();
                    structureDtos.add(buildStructure(vertices, annotation.getDescription()));
                }
            }
        }
        ocrPageDto.setStructureDtoList(structureDtos);
        return ocrPageDto;
    }

    private StructureDto buildStructure(List<Vertex> vertices, String text) {
        StructureDto structureDto = new StructureDto();
        structureDto.setLeftUpVertex(vertexToPointTranslator.vertexToPosition(vertices.get(0)));
        structureDto.setRightUpVertex(vertexToPointTranslator.vertexToPosition(vertices.get(1)));
        structureDto.setRightDownVertex(vertexToPointTranslator.vertexToPosition(vertices.get(2)));
        structureDto.setLeftDownVertex(vertexToPointTranslator.vertexToPosition(vertices.get(3)));
        structureDto.setText(text);
        return structureDto;
    }

    private void cropImage(byte [] bytes){
       BufferedImage bufferedImage = cropImages.createImageFromBytes(bytes);
       cropImages.cropImage(bufferedImage, );
    }
}
