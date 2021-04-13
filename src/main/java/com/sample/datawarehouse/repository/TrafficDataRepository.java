package com.sample.datawarehouse.repository;

import com.sample.datawarehouse.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {

    @Query("select sum(td.clicks) " +
            "from TrafficData td " +
            "where td.campaign = :campaign and td.daily >= :from and td.daily <= :to")
    Integer getTotalClicks(@Param("campaign") String campaing, @Param("from") LocalDate from, @Param("to") LocalDate to);

    @Query("select avg(td.ctr) from TrafficData td where td.campaign = :campaign and td.dataSource = :dataSource")
    Double getAverageCtr(@Param("campaign") String campaign, @Param("dataSource") String datasource);
}
