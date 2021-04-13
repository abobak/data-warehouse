package com.sample.datawarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CtrPerCampaignAndDatasource {

    private Double ctr;

    private String campaign;

    private String dataSource;

}
