package com.sample.datawarehouse.service;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.sample.datawarehouse.model.TrafficData;
import com.sample.datawarehouse.repository.TrafficDataRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class ImportDataIntegrationTest {

    @Autowired
    private ImportService importService;

    @Autowired
    private TrafficDataRepository trafficDataRepository;

    @Test
    void shouldPersistNewlyCreatedTrafficData() throws IOException {
        String payload = "Datasource,Campaign,Daily,Clicks,Impressions\n" +
                "Google Ads,Adventmarkt Touristik,11/12/19,7,22425\n" +
                "Google Ads,Adventmarkt Touristik,11/13/19,16,45452\n" +
                "Google Ads,Adventmarkt Touristik,11/14/19,147,80351\n" +
                "Google Ads,Adventmarkt Touristik,11/15/19,131,81906\n" +
                "Google Ads,Adventmarkt Touristik,11/16/19,85,43910";
        importService.importTrafficData(payload.getBytes());
        List<TrafficData> importedData = trafficDataRepository.findAll();
        assertEquals(5, importedData.size());
    }

    @Test
    void shouldNotPersistTrafficDataWithoutHeader() {
        String payload =
                "Google Ads,Adventmarkt Touristik,11/15/19,131,81906\n" +
                "Google Ads,Adventmarkt Touristik,11/16/19,85,43910";
        assertThrows(UnrecognizedPropertyException.class, () -> importService.importTrafficData(payload.getBytes()));
    }


}
