package com.sample.datawarehouse.controller;

import com.sample.datawarehouse.api.QueryApi;
import com.sample.datawarehouse.service.QueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QueryController implements QueryApi {

    private final QueryService queryService;



}
