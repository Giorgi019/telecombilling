package com.giorgi.telecombilling.dto;

public record SubscriberResponse(
        Long id,
        String firstName,
        String lastName,
        String phoneNumber,
        Long tariffId
) {
}
