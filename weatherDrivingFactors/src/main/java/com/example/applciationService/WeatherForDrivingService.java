package com.example.applciationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.command.ComputeWeather;
import com.example.domain.entity.Weather;
import com.example.infrastructure.schema.WeatherSchema;
import com.example.repository.WeatherRepositoryRedis;

/**
 * WeatherForDrivingService
 */
@Service
public class WeatherForDrivingService {
  @Autowired
  private WeatherRepositoryRedis redisWeatherRepository;
  
  public boolean isFoggy(ComputeWeather computeWeatherCmd){
    Weather weather = new Weather(computeWeatherCmd.getTemperature(), computeWeatherCmd.getHumidity());
    WeatherSchema weatherSchema = new WeatherSchema(computeWeatherCmd.getCity(),computeWeatherCmd.getPrecipitationForTheNextOneHour(),computeWeatherCmd.getSnowForTheNextOneHour(),computeWeatherCmd.getVisibility(),weather.isFoggy(),computeWeatherCmd.getWeatherDescriptions());
    redisWeatherRepository.saveWeatherData(weatherSchema);

    return weather.isFoggy();
  }
  
}
