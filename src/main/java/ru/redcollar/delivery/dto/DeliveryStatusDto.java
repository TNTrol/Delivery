package ru.redcollar.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.redcollar.delivery.entity.StatusDelivery;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryStatusDto {

    private StatusDelivery statusDelivery;
    private Long deliveryId;
}
