package com.sample.datawarehouse.controller;

import com.sample.datawarehouse.api.ImportApi;
import com.sample.datawarehouse.service.ImportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ImportController implements ImportApi {

    private final ImportService importService;

    @PostMapping(path = "/api-internal/v1/import/traffic-data")
    public void importTrafficData(@RequestParam("file") MultipartFile f) throws IOException {
        importService.importTrafficData(f.getBytes());
    }

    @GetMapping(path = "/api-internal/v1/reset")
    public void resetTrafficData() {
        importService.reset();
    }


}
