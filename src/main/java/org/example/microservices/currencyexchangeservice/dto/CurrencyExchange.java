package org.example.microservices.currencyexchangeservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data
@Builder
@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {
    @Id
    private long id;
    @Column(name = "currencyFrom")
    private String from;
    @Column(name = "currencyTo")
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
