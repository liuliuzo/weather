package com.epam.weather.core;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import com.epam.weather.station.Station1;
import com.epam.weather.station.Station2;
import com.epam.weather.station.Station3;
import com.epam.weather.station.StationN;
import com.google.common.collect.Lists;

/**
 * 
 * @author liuliu
 *
 */
class ReportServiceTest {
    
    @Test
    void testRegisterObserver() {
        ReportService reportService = new ReportService();
        Station1 station1 = new Station1();
        Station2 station2 = new Station2();
        Station3 station3 = new Station3();
        StationN stationN = new StationN();
        reportService.registerObserver(station1);
        reportService.registerObserver(station2);
        reportService.registerObserver(station3);
        reportService.registerObserver(stationN);
        Assert.assertEquals(4,reportService.getObservers().size());
   }
    
    @Test
    void testRemoveObserver() {
        ReportService reportService = new ReportService();
        Station1 station1 = new Station1();
        Station2 station2 = new Station2();
        StationN stationN = new StationN();
        reportService.registerObserver(station1);
        reportService.registerObserver(station2);
        reportService.registerObserver(stationN);
        reportService.removeObserver(stationN);
        Assert.assertEquals(2,reportService.getObservers().size());
   }
    
    @Test
    void testNotifyObservers() {
        ReportService reportService = new ReportService();
        Station1 station1 = new Station1();
        Station2 station2 = new Station2();
        Station3 station3 = new Station3();
        StationN stationN = new StationN();
        Field field1 = ReflectionUtils.findField(Station1.class, "reportService");
        Field field2 = ReflectionUtils.findField(Station2.class, "reportService");
        Field field3 = ReflectionUtils.findField(Station3.class, "reportService");
        Field fieldN = ReflectionUtils.findField(StationN.class, "reportService");
        field1.setAccessible(true);
        field2.setAccessible(true);
        field3.setAccessible(true);
        fieldN.setAccessible(true);
        ReflectionUtils.setField(field1, station1, reportService);
        ReflectionUtils.setField(field2, station2, reportService);
        ReflectionUtils.setField(field3, station3, reportService);
        ReflectionUtils.setField(fieldN, stationN, reportService);
        reportService.registerObserver(station1);
        reportService.registerObserver(station2);
        reportService.registerObserver(station3);
        reportService.registerObserver(stationN);
        WeatherData weatherData1 = new WeatherData();
        weatherData1.setTemperature(31f);
        weatherData1.setHumidity(60f);
        weatherData1.setPressure(180f);
        reportService.setWeatherData(weatherData1);
        reportService.notifyObservers();
        Field field = ReflectionUtils.findField(Station1.class, "weatherData");
        field.setAccessible(true);
        WeatherData weatherData = (WeatherData) ReflectionUtils.getField(field, station1);
        Assert.assertEquals(180f, weatherData.getPressure(), 0f);
    }

    @Test
    void testGetObservers() {
        ReportService reportService = new ReportService();
        Station1 station1 = new Station1();
        reportService.registerObserver(station1);
        Assert.assertEquals(station1, reportService.getObservers().get(0));
    }

    @Test
    void testSetObservers() {
        ReportService reportService = new ReportService();
        List<IObserver> observers = Lists.newArrayList();
        Station1 station1 = new Station1();
        observers.add(station1);
        reportService.setObservers(observers);
        Assert.assertEquals(station1, reportService.getObservers().get(0));
    }

    @Test
    void testGetWeatherData() {
        ReportService reportService = new ReportService();
        WeatherData weatherData1 = new WeatherData();
        weatherData1.setTemperature(31f);
        weatherData1.setHumidity(60f);
        weatherData1.setPressure(180f);
        reportService.setWeatherData(weatherData1);
        Assert.assertEquals(weatherData1, reportService.getWeatherData());
    }


}
