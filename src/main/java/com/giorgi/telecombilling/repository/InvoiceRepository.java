package com.giorgi.telecombilling.repository;

import com.giorgi.telecombilling.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findBySubscriberId(Long subscriberId);
}
