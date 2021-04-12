package com.sample.datawarehouse.api;

import com.sample.datawarehouse.dto.TotalClicksDto;

public interface QueryApi {

    TotalClicksDto getTotalClicksForCampaign(String campaign, String from, String to);
}
