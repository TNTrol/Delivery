package ru.redcollar.delivery.service.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.redcollar.delivery.dto.DeliveryDto;
import ru.redcollar.delivery.service.DeliveryService;

@Service
@RequiredArgsConstructor
public class DeliveryListener {

    private final DeliveryService deliveryService;

    @RabbitListener(queues = "${message.topic.name}")
    public void receive(@Payload DeliveryDto dto) {
        deliveryService.receive(dto);
    }
}
