package com.epam.weather.core;

/**
 * 
 * @author Liuliu Zhao
 *
 */
public interface IReportService {
    void registerObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();
}