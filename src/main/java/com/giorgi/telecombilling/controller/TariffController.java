package com.giorgi.telecombilling.controller;

import com.giorgi.telecombilling.dto.TariffRequest;
import com.giorgi.telecombilling.dto.TariffResponse;
import com.giorgi.telecombilling.service.TariffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tariffs")
public class TariffController {

    private final TariffService tariffService;

    @PostMapping
    public ResponseEntity<TariffResponse> createTariff(@Valid @RequestBody TariffRequest request) {
        TariffResponse response = tariffService.createTariff(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TariffResponse>> getAllTariffs() {
        List<TariffResponse> response = tariffService.getAllTariffs();
        return ResponseEntity.ok(response);
    }
}
