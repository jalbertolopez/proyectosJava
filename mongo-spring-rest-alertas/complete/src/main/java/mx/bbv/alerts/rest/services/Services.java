package mx.bbv.alerts.rest.services;


import java.util.List;

import mx.bbv.alerts.rest.dto.AlertasDTO;
import mx.bbv.alerts.rest.dto.ClientesDTO;
import mx.bbv.alerts.rest.dto.CrInfoDTO;
import mx.bbv.alerts.rest.dto.CuentasDTO;
import mx.bbv.alerts.rest.dto.OperacionesDTO;
import mx.bbv.alerts.rest.dto.OperacionesRelevantesDTO;
import mx.bbv.alerts.rest.model.OperationPOJO;

import org.springframework.stereotype.Component;

public interface Services {

	List <AlertasDTO>  getAlerts();
	List <OperacionesDTO>  getOperations(String idAlerta);
	List <CuentasDTO>  getAccounts(String idCliente);
	List <ClientesDTO>  getClients(String idCliente);
	List <OperacionesRelevantesDTO>  getRelevatsOp(String idCuenta);
	List <CrInfoDTO>  getCrInfo(String idCr);
}
