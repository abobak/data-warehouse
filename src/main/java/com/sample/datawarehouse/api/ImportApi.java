package com.sample.datawarehouse.api;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImportApi {

    void importTrafficData(MultipartFile f) throws IOException;

    void resetTrafficData();
}
