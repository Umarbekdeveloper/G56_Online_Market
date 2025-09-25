package uz.pdp.g56_online_market.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "outcome")
@Data                 // Getter, Setter, toString, equals, hashCode
@Builder              // Builder pattern
@NoArgsConstructor     // Default constructor
@AllArgsConstructor    // All args constructor
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double amount;          // yangi maydon

    @Column(length = 500)
    private String description;     // yangi maydon

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;
}
