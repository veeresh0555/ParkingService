package com.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.parking.config.RibbonConfiguration;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name="parkingspaceservice",configuration = RibbonConfiguration.class)
public class ParkingspaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingspaceServiceApplication.class, args);
	}

}
