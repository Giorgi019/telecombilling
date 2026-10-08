package com.giorgi.telecombilling.service;

import com.giorgi.telecombilling.dto.TariffRequest;
import com.giorgi.telecombilling.dto.TariffResponse;
import com.giorgi.telecombilling.model.Tariff;
import com.giorgi.telecombilling.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TariffService {

    private final TariffRepository tariffRepository;

    public TariffResponse createTariff(TariffRequest request) {
        Tariff tariff = Tariff.builder()
                .name(request.name())
                .monthlyFee(request.monthlyFee())
                .includedMinutes(request.includedMinutes())
                .build();

        Tariff savedTariff = tariffRepository.save(tariff);

        return new TariffResponse(
                savedTariff.getId(),
                savedTariff.getName(),
                savedTariff.getMonthlyFee(),
                savedTariff.getIncludedMinutes()
        );
    }

    public List<TariffResponse> getAllTariffs() {
        List<Tariff> tariffs = tariffRepository.findAll();
        return tariffs.stream()
                .map(tariff -> new TariffResponse(
                        tariff.getId(),
                        tariff.getName(),
                        tariff.getMonthlyFee(),
                        tariff.getIncludedMinutes()
                ))
                .toList();
    }
}
