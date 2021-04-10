package com.sample.datawarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TrafficDataDto {

    private String dataSource;

    private String campaign;

    private LocalDate daily;

    private Integer clicks;

    private Integer impressions;

}
