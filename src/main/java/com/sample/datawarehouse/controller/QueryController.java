package com.sample.datawarehouse.controller;

import com.sample.datawarehouse.api.QueryApi;
import com.sample.datawarehouse.dto.TotalClicksDto;
import com.sample.datawarehouse.service.QueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QueryController implements QueryApi {

    private final QueryService queryService;

    @GetMapping("/api/v1/campaign-clicks")
    public TotalClicksDto getTotalClicksForCampaign(@RequestParam String campaign, @RequestParam String from, @RequestParam String to) {
        return queryService.getTotalClicksForCampaign(
                campaign,
                LocalDate.parse(from, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                LocalDate.parse(to, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}
