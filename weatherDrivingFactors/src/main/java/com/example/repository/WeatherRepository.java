package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.infrastructure.schema.WeatherSchema;

/**
 * WeatherRepository
 */
public interface WeatherRepository extends JpaRepository<WeatherSchema, Long> {

}
