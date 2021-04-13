package com.sample.datawarehouse.service;

import com.sample.datawarehouse.dto.CtrPerCampaignAndDatasource;
import com.sample.datawarehouse.dto.TotalClicksDto;
import com.sample.datawarehouse.repository.TrafficDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class QueryService {

    private final TrafficDataRepository trafficDataRepository;

    public TotalClicksDto getTotalClicksForCampaign(String campaign, LocalDate from, LocalDate to) {
        return new TotalClicksDto(trafficDataRepository.getTotalClicks(campaign, from, to));
    }

    public CtrPerCampaignAndDatasource getCtrPerCampaignAndDatasource(String campaign, String datasource) {
        Double avgCtr = trafficDataRepository.getAverageCtr(campaign, datasource);
        return new CtrPerCampaignAndDatasource(avgCtr, campaign, datasource);
    }
}
