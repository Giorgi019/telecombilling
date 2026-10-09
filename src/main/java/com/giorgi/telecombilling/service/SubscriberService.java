package com.giorgi.telecombilling.service;

import com.giorgi.telecombilling.dto.SubscriberRequest;
import com.giorgi.telecombilling.dto.SubscriberResponse;
import com.giorgi.telecombilling.model.Subscriber;
import com.giorgi.telecombilling.model.Tariff;
import com.giorgi.telecombilling.repository.SubscriberRepository;
import com.giorgi.telecombilling.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SubscriberService {

    private final TariffRepository tariffRepository;
    private final SubscriberRepository subscriberRepository;

    public SubscriberResponse createSubscriber(SubscriberRequest request) {

        Tariff tariff = tariffRepository.findById(request.tariffId())
                .orElseThrow();

        Subscriber subscriber = Subscriber.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .phoneNumber(request.phoneNumber())
                .tariff(tariff)
                .build();

        Subscriber savedSubscriber = subscriberRepository.save(subscriber);

        return new SubscriberResponse(
                savedSubscriber.getId(),
                savedSubscriber.getFirstName(),
                savedSubscriber.getLastName(),
                savedSubscriber.getPhoneNumber(),
                savedSubscriber.getTariff().getId()
        );
    }

    public List<SubscriberResponse> findAllSubscribers() {
        List<Subscriber> subscribers = subscriberRepository.findAll();

        return subscribers.stream()
                .map(subscriber -> new SubscriberResponse(
                        subscriber.getId(),
                        subscriber.getFirstName(),
                        subscriber.getLastName(),
                        subscriber.getPhoneNumber(),
                        subscriber.getTariff().getId()
                ))
                .toList();
    }

    public SubscriberResponse getSubscriberBySubscriberId(Long subscriberId) {
        Subscriber subscriber = subscriberRepository.findById(subscriberId)
                .orElseThrow();

        return new SubscriberResponse(
                subscriber.getId(),
                subscriber.getFirstName(),
                subscriber.getLastName(),
                subscriber.getPhoneNumber(),
                subscriber.getTariff().getId()
        );
    }

    public SubscriberResponse updateSubscriber(Long subscriberId, SubscriberRequest request) {
        Subscriber subscriber = subscriberRepository.findById(subscriberId)
                .orElseThrow();

        Tariff tariff = tariffRepository.findById(request.tariffId())
                .orElseThrow();

        subscriber.setFirstName(request.firstName());
        subscriber.setLastName(request.lastName());
        subscriber.setPhoneNumber(request.phoneNumber());
        subscriber.setTariff(tariff);
        Subscriber updatedSubscriber = subscriberRepository.save(subscriber);

        return new SubscriberResponse(
                updatedSubscriber.getId(),
                updatedSubscriber.getFirstName(),
                updatedSubscriber.getLastName(),
                updatedSubscriber.getPhoneNumber(),
                updatedSubscriber.getTariff().getId()
        );
    }

    public void deleteSubscriber(Long subscriberId) {
        subscriberRepository.deleteById(subscriberId);
    }
}
