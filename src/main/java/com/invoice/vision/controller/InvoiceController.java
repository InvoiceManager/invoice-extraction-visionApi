package com.invoice.vision.controller;

import com.invoice.vision.dto.OcrPageDto;
import com.invoice.vision.dto.StructureDto;
import com.invoice.vision.service.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private Invoice invoiceService;

    @Autowired
    public InvoiceController(Invoice invoiceService) {
        this.invoiceService = invoiceService;
    }

    @RequestMapping(
            value = "/upload",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<OcrPageDto> uploadInvoice(@RequestParam("invoice") MultipartFile invoice) throws Exception {
        return ResponseEntity.ok(invoiceService.detectText(invoice));
    }

    @RequestMapping(
            value = "/info",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private void getInfo(@RequestParam("invoice") MultipartFile invoice) throws Exception {
        invoiceService.uploadInvoice(invoice);
    }
}
