package ru.redcollar.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.redcollar.delivery.dto.DeliveryDto;
import ru.redcollar.delivery.entity.Delivery;
import ru.redcollar.delivery.mapper.DeliveryMapper;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryMapper deliveryMapper;

    @KafkaListener(topics = "${message.topic.name}", groupId = "jcg-group")
    public void listen(String message) {
        System.out.println(message);
    }
}
