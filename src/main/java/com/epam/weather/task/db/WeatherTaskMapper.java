package com.epam.weather.task.db;

/**
 * manage task from DB
 * 
 * @author liuliu
 *
 */
//@Mapper //If we have database
public interface WeatherTaskMapper {
    String getCron(int id);
}
