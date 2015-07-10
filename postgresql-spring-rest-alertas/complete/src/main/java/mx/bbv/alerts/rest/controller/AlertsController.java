package mx.bbv.alerts.rest.controller;

import java.util.List;


import mx.bbv.alerts.rest.model.AlertaDAO;
import mx.bbv.alerts.rest.repository.AlertsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alertasPld")
public class AlertsController {
	private Logger logger = LoggerFactory.getLogger(AlertsController.class);
	
	@Autowired
	private AlertsRepository repoAlerts;


	 @RequestMapping("/alertas")
	 public void setAlerta(){
		 logger.info("Presistiendo");
		 repoAlerts.save(new AlertaDAO("1","2","3","4","5","6","7"));
		 
		 logger.info("->" + repoAlerts.findOne("1"));
	 }
	 
}
