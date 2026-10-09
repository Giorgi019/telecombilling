package com.giorgi.telecombilling.controller;

import com.giorgi.telecombilling.dto.InvoiceRequest;
import com.giorgi.telecombilling.dto.InvoiceResponse;
import com.giorgi.telecombilling.service.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceResponse> createInvoice(@Valid @RequestBody InvoiceRequest request) {
        InvoiceResponse response = invoiceService.createInvoice(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}/pay")
    public ResponseEntity<InvoiceResponse> payInvoice(@PathVariable Long id){
        InvoiceResponse response = invoiceService.payInvoice(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
