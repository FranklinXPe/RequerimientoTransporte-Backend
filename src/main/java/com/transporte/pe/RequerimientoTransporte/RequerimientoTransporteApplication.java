package com.transporte.pe.RequerimientoTransporte;

import com.transporte.pe.RequerimientoTransporte.dao.*;
import com.transporte.pe.RequerimientoTransporte.domain.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.transporte.pe.RequerimientoTransporte")

public class RequerimientoTransporteApplication  {

	public static void main(String[] args) {
		SpringApplication.run(RequerimientoTransporteApplication.class, args);
	}


}
