package com.sample.datawarehouse.api;

import com.sample.datawarehouse.dto.CtrPerCampaignAndDatasource;
import com.sample.datawarehouse.dto.TotalClicksDto;

public interface QueryApi {

    TotalClicksDto getTotalClicksForCampaign(String campaign, String from, String to);

    CtrPerCampaignAndDatasource getCtrPerCampaignAndDatasource(String campaign, String datasource);
}
