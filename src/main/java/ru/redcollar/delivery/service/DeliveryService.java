package ru.redcollar.delivery.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.redcollar.delivery.dto.DeliveryDto;
import ru.redcollar.delivery.dto.DeliveryStatusDto;
import ru.redcollar.delivery.entity.Delivery;
import ru.redcollar.delivery.entity.StatusDelivery;
import ru.redcollar.delivery.mapper.DeliveryMapper;
import ru.redcollar.delivery.repository.DeliveryRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryService {

    private final DeliveryMapper deliveryMapper;
    private final DeliveryRepository deliveryRepository;

    public void updateStatusOfDelivery(DeliveryStatusDto status) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(status.getDeliveryId());
        if (deliveryOptional.isEmpty()) {
            throw new NullPointerException();
        }
        Delivery delivery = deliveryOptional.get();
        delivery.setStatusDelivery(status.getStatusDelivery());
        deliveryRepository.save(delivery);
    }

    @RabbitListener(queues = "${message.topic.name}")
    public void receive(@Payload DeliveryDto dto) {
        Delivery delivery = deliveryMapper.fromDto(dto);
        delivery.getProducts().forEach(p -> p.setDelivery(delivery));
        delivery.setStatusDelivery(StatusDelivery.ON_WAY);
        deliveryRepository.save(delivery);
    }
}
