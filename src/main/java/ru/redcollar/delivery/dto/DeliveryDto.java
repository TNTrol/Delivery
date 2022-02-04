package ru.redcollar.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto {

    @NotNull
    private String fromAddress;

    @NotNull
    private String toAddress;

    @NotNull
    private String email;

    private List<DeliveryProductDto> products;
}
