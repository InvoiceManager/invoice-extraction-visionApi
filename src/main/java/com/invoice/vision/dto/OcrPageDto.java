package com.invoice.vision.dto;

import java.util.List;

public class OcrPageDto {

    private List<StructureDto> structureDtoList;

    public OcrPageDto(List<StructureDto> structureDtoList) {
        this.structureDtoList = structureDtoList;
    }

    public OcrPageDto() {
    }

    public List<StructureDto> getStructureDtoList() {
        return structureDtoList;
    }

    public void setStructureDtoList(List<StructureDto> structureDtoList) {
        this.structureDtoList = structureDtoList;
    }
}
