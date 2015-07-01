
package mx.bbv.alerts.rest;

import java.util.Date;

import mx.bbv.alerts.rest.model.Alert;
import mx.bbv.alerts.rest.repository.AlertsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application{
	
	//@Autowired 
	//private AlertRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
