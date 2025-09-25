package uz.pdp.g56_online_market.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutcomeDTO {

    private Integer id;           // Outcome id
    private Integer quantity;     // Outcome miqdori

    // Products bilan bog‘liq ma’lumotlar
    private Integer productId;
    private String productName;

}

