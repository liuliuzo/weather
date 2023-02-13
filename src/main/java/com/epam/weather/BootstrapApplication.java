package com.epam.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epam.weather.core.ReportService;
import com.epam.weather.station.Station1;
import com.epam.weather.station.Station2;
import com.epam.weather.station.Station3;
import com.epam.weather.station.StationN;

/**
 * 
 * @author Liuliu Zhao
 *
 */
@SpringBootApplication
public class BootstrapApplication implements CommandLineRunner {
    
    @Autowired
    private ReportService reportService ;
    
    @Autowired
    private Station1 station1 ;
    
    @Autowired
    private Station2 station2 ;
    
    @Autowired
    private Station3 station3 ;
    
    @Autowired
    private StationN stationN ;

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

    /**
     * run as SpringBoot App Directly
     */
    @Override
    public void run(String... args) throws Exception {
        reportService.registerObserver(station1);
        reportService.registerObserver(station2);
        reportService.registerObserver(station3);
        reportService.registerObserver(stationN);
    }

}
