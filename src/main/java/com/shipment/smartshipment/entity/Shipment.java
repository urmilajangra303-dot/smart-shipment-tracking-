package com.shipment.smartshipment.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "shipments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    @Column(unique = true,nullable = false)
private String trackingNumber;
    @Column(nullable = false)
private String senderName;
    @Column(nullable = false)
private String receiverName;
    @Column(nullable = false)
private String origin;
    @Column(nullable = false)
private String destination;
    @Column(nullable = false)
private String  status;

private LocalDateTime createdAt;


}
