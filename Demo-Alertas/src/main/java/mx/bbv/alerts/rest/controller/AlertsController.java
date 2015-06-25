package mx.bbv.alerts.rest.controller;

import java.util.List;

import mx.bbv.alerts.model.persistence.AlertPOJO;
import mx.bbv.alerts.model.persistence.ClientPOJO;
import mx.bbv.alerts.model.persistence.TransactionPOJO;
import mx.bbv.alerts.services.AlertsDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertsController {
	
//	@Autowired
//	AlertsDataService alertsDataService;
//	
//	@RequestMapping("/clients")
//    public List<ClientPOJO> getClients() {
//        return alertsDataService.getDangerousClients();
//    }
//	
//	@RequestMapping("/alerts")
//    public List<AlertPOJO> getAlerts() {
//        return alertsDataService.getAllAlerts();
//    }
//	
//	@RequestMapping("/transactions")
//    public List<TransactionPOJO> getTransactions(@RequestParam(value="idClient") String idClient) {
//        return alertsDataService.getDangerousTransactions(idClient);
//    }
//	
    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

}
