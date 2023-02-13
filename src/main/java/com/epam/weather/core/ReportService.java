package com.epam.weather.core;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

/**
 * core report service hold basic weather metrics info and manage all of observer
 * 
 * @author liuliu
 * 
 */
@Service
public class ReportService implements IReportService {

    private final Logger logger = LoggerFactory.getLogger(ReportService.class);

    /**
     * basic weather metrics
     */
    private WeatherData weatherData;

    /**
     * manage all of observer
     */
    private List<IObserver> observers;

    public ReportService() {
        this.observers = Lists.newArrayList();
    }

    public List<IObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<IObserver> observers) {
        this.observers = observers;
    }
    
    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        logger.info("notify all observers");
        for (IObserver observer : observers) {
            observer.update();
        }
    }
}
