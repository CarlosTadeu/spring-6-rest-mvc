package guru.springframework.spring6restmvc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class BeerDTO {
    private UUID id;
    private Integer version;

    @NotBlank @NotNull
    private String beerName;

    @NotNull
    private BeerStyle beerStyle;

    @NotBlank @NotNull
    private String upc;

    private Integer quantityOnHand;

    @NotNull @Positive
    private BigDecimal price;

    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
