package br.com.helisson.servicefinder.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class SearchEngineRequestDto {
    private Double xmin;
    private Double ymin;
    private Double xmax;
    private Double ymax;
    private Date start_date;
    private Date end_date;
    private String theme;

    public String getBoundBoxString() {
        return String.format("%.2f,%.2f,%.2f,%.2f", xmin, ymin, xmax, ymax);
    }
}
