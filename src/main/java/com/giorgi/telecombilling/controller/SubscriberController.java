package com.giorgi.telecombilling.controller;

import com.giorgi.telecombilling.dto.SubscriberRequest;
import com.giorgi.telecombilling.dto.SubscriberResponse;
import com.giorgi.telecombilling.service.SubscriberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subscribers")
public class SubscriberController {

    private final SubscriberService subscriberService;

    @PostMapping
    public ResponseEntity <SubscriberResponse> createSubscriber(@Valid @RequestBody SubscriberRequest request) {
        SubscriberResponse response = subscriberService.createSubscriber(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity <List<SubscriberResponse>> getAllSubscribers() {
        List <SubscriberResponse> response = subscriberService.findAllSubscribers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity <SubscriberResponse> getSubscriberBySubscriberId(@PathVariable Long id) {
        return ResponseEntity.ok(subscriberService.getSubscriberBySubscriberId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <SubscriberResponse> updateSubscriber(@PathVariable Long id, @Valid @RequestBody SubscriberRequest request) {
        SubscriberResponse response = subscriberService.updateSubscriber(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscriberBySubscriberId(@PathVariable Long id) {
        subscriberService.deleteSubscriber(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
