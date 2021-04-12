package com.sample.datawarehouse.mapper;

import com.sample.datawarehouse.dto.TrafficDataDto;
import com.sample.datawarehouse.model.TrafficData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TrafficDataMapperTest {

    @Autowired
    private TrafficDataMapper mapper;

    @Test
    void shouldPopulateCtrFromClicksAndImpressions() {
        TrafficDataDto dto = new TrafficDataDto("a", "b", LocalDate.of(11, 11, 11), 10, 500);
        TrafficData data = mapper.dtoToEntity(dto);
        assertEquals(2.0, data.getCtr());
    }

    @Test
    void shouldPopulateTrafficDataFromDto() {
        TrafficDataDto dto = new TrafficDataDto("a", "b", LocalDate.of(11, 11, 11), 10, 500);
        TrafficData data = mapper.dtoToEntity(dto);
        assertEquals(2.0, data.getCtr());
        assertEquals("a", data.getDataSource());
        assertEquals("b", data.getCampaign());
        assertEquals(LocalDate.of(11, 11, 11), data.getDaily());
        assertEquals(10, data.getClicks());
        assertEquals(500, data.getImpressions());
    }

}
