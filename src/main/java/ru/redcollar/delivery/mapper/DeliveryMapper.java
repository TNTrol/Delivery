package ru.redcollar.delivery.mapper;

import org.mapstruct.Mapper;
import ru.redcollar.delivery.dto.DeliveryDto;
import ru.redcollar.delivery.entity.Delivery;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    DeliveryDto toDto(Delivery delivery);

    Delivery fromDto(DeliveryDto delivery);
}
