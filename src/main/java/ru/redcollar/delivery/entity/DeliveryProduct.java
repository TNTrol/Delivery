package ru.redcollar.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "delivery_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public String toString(){
        return "DeliveryProduct( id=" + id + ", productId=" + productId + ")";
    }
}
