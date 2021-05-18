package br.com.helisson.resilientsdi.featureretriever.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BoundBox {
    private Double xMin;
    private Double yMin;
    private Double xMax;
    private Double yMax;

    public String getBoundBoxString() {
        return String.format("%.2f,%.2f,%.2f,%.2f", xMin, yMin, xMax, yMax);
    }
}
