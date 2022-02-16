package ru.redcollar.delivery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.redcollar.delivery.dto.DeliveryStatusDto;
import ru.redcollar.delivery.service.DeliveryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PutMapping
    public ResponseEntity<Void> updateStatusOfDelivery(DeliveryStatusDto status) {
        deliveryService.updateStatusOfDelivery(status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
