package com.epam.weather.task.db;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.ReflectionUtils;

import com.epam.weather.core.ReportService;
import com.epam.weather.core.WeatherData;
import com.epam.weather.station.Station1;
import com.epam.weather.station.Station2;
import com.epam.weather.station.Station3;
import com.epam.weather.station.StationN;

class DBweatherTaskTest {
    
    private final String CRON = "*/1 * * * * ?"; //每隔5秒执行一次
    
    @InjectMocks
    private DBweatherTask dBweatherTask;

    @Mock
    private WeatherTaskMapper weatherTaskMapper;
    
    @Mock
    private ScheduledTaskRegistrar scheduledTaskRegistrar;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcess() {
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
        DBweatherTask dBweatherTask = new DBweatherTask();
        dBweatherTask.setReportService(reportService);
        dBweatherTask.process();
        WeatherData weatherData = reportService.getWeatherData();
        Assert.assertEquals(180f, weatherData.getPressure(), 0f);
    }
    
    @Test
    void testConfigureTasks() {
        Mockito.doNothing().when(scheduledTaskRegistrar).addTriggerTask(Mockito.any());
        Mockito.when(weatherTaskMapper.getCron(1)).thenReturn(CRON);
        dBweatherTask.configureTasks(scheduledTaskRegistrar);
        Assert.assertNotNull(scheduledTaskRegistrar);
    }
    
}
