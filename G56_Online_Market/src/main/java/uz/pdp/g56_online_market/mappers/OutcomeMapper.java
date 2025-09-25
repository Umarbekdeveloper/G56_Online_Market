package uz.pdp.g56_online_market.mappers;

import uz.pdp.g56_online_market.dtos.OutcomeDTO;
import uz.pdp.g56_online_market.entities.Outcome;

public class OutcomeMapper {

    public static OutcomeDTO outcomeToOutcomeDTO(Outcome outcome) {
        return OutcomeDTO.builder()
                .id(Math.toIntExact(outcome.getId()))
                .quantity(outcome.getQuantity())
                .productId(outcome.getProduct() != null ? outcome.getProduct().getId() : null)
                .productName(outcome.getProduct() != null ? outcome.getProduct().getName() : null)
                .build();
    }
}
