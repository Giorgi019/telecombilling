package com.giorgi.telecombilling.service;

import com.giorgi.telecombilling.dto.InvoiceRequest;
import com.giorgi.telecombilling.dto.InvoiceResponse;
import com.giorgi.telecombilling.model.Invoice;
import com.giorgi.telecombilling.model.Subscriber;
import com.giorgi.telecombilling.model.Tariff;
import com.giorgi.telecombilling.repository.InvoiceRepository;
import com.giorgi.telecombilling.repository.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final SubscriberRepository subscriberRepository;

    public InvoiceResponse createInvoice(InvoiceRequest request) {

        Subscriber subscriber = subscriberRepository.findById(request.subscriberId())
                .orElseThrow();

        Tariff tariff =  subscriber.getTariff();

        int extraMinutes = Math.max(0, request.usedMinutes() - tariff.getIncludedMinutes());

        BigDecimal extraCharge = BigDecimal.valueOf(extraMinutes)
                .multiply(BigDecimal.valueOf(0.10));

        BigDecimal totalAmount = tariff.getMonthlyFee().add(extraCharge);

        Invoice invoice = Invoice.builder()
                .subscriber(subscriber)
                .month(request.month())
                .totalAmount(totalAmount)
                .build();

        Invoice savedInvoice = invoiceRepository.save(invoice);
        return new InvoiceResponse(
                savedInvoice.getId(),
                savedInvoice.getSubscriber().getId(),
                savedInvoice.getMonth(),
                savedInvoice.getTotalAmount(),
                savedInvoice.isPaid()
        );
    }
}
