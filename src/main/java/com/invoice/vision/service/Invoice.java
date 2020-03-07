package com.invoice.vision.service;

import com.invoice.vision.dto.OcrPageDto;
import com.invoice.vision.dto.StructureDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface Invoice {

    void uploadInvoice(MultipartFile multipartFile) throws Exception;

    OcrPageDto detectText(MultipartFile multipartFile) throws Exception;
}
