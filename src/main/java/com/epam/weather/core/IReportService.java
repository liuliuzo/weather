package com.epam.weather.core;

/**
 * the 
 * 
 * @author Liuliu Zhao
 *
 */
public interface IReportService {
    void registerObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();
}