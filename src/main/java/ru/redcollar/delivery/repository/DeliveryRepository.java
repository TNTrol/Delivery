package ru.redcollar.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcollar.delivery.entity.Delivery;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
