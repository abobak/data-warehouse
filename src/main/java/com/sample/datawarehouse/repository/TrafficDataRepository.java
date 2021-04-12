package com.sample.datawarehouse.repository;

import com.sample.datawarehouse.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {

}
