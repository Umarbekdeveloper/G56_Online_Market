package uz.pdp.g56_online_market.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Qaysi mahsulot uchun chiqim qilindi
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    // Miqdor (nechta tovar chiqim qilindi)
    @Column(nullable = false)
    private Integer quantity;

    // Summasi
    @Column(nullable = false)
    private Double amount;

    // Chiqim sanasi
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Qo‘shimcha izoh
    private String description;
}

