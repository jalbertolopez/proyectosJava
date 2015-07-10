package mx.bbv.alerts.rest.services;

import java.util.ArrayList;
import java.util.List;

import mx.bbv.alerts.rest.dto.*;
import mx.bbv.alerts.rest.model.*;
import mx.bbv.alerts.rest.repository.AccountsRepository;
import mx.bbv.alerts.rest.repository.AlertsRepository;
import mx.bbv.alerts.rest.repository.ClientRepository;
import mx.bbv.alerts.rest.repository.CrsRepository;
import mx.bbv.alerts.rest.repository.OperationsRepository;
import mx.bbv.alerts.rest.repository.RelevantsRepository;
import mx.bbv.alerts.rest.transforms.Transform2DTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicesImpl implements Services{
	@Autowired
	private AlertsRepository repoAlerts;
	
	@Autowired
	private OperationsRepository repoOp;

	@Autowired
	private ClientRepository repoClients;
	
	@Autowired
	private CrsRepository repoCrs;
	
	@Autowired
	private RelevantsRepository repoRelevatns;
	
	@Autowired
	private AccountsRepository repoAcc;
	
	@Autowired
	private Transform2DTO transform;
	
	private Logger logger = LoggerFactory.getLogger(ServicesImpl.class);
	
	/*Servicio para obtener todas las alertas*/
	public List <AlertasDTO>  getAlerts(){
		List <AlertasDTO> alertasDTO = new ArrayList <AlertasDTO>();
		int noOp = 0;
		boolean relevant = false;
		// obtenemos todas las alertas
		List <AlertPOJO> allAlerts = repoAlerts.findAll();
		
		// por cada alerta sacar sus operaciones asociadas 
		for (AlertPOJO alert: allAlerts){
			
			// Obtenemos Todas las operaciones Asociadas
			List <OperationPOJO> opetaions = repoOp.findByIdAlerta(alert.getIdAlerta());		
			relevant = this.haveRelevants(opetaions);
			noOp = opetaions.size();
			alertasDTO.add(transform.alertPOJO2AlertasDTO(alert, noOp, relevant));
		}
			
		return alertasDTO;
	}
	
	
	/*Servicio para obtener todas las operaciones*/
	public List <OperacionesDTO>  getOperations(String idAlerta){
		List <OperacionesDTO> operacionesDTO = new ArrayList <OperacionesDTO>();
		
		List <OperationPOJO> opetaions = null;
		// Si el idAlerta es "" obtenemos todas las operaciones
		// de lo contrario sólo las asociadas a una Alerta
		if(idAlerta.compareTo("") == 0){
			opetaions = repoOp.findAll();
		}else{
			opetaions = repoOp.findByIdAlerta(idAlerta);
		}
		
		for (OperationPOJO op : opetaions){
			operacionesDTO.add(transform.operationPOJO2OperacionDTO(op));
		}		
		return operacionesDTO;
	}
	
	
	/*Servicio para obtener todas las Cuentas*/
	public List <CuentasDTO>  getAccounts(String idCliente){
		List <CuentasDTO> cuentasDTO = new ArrayList <CuentasDTO>();
		
		List <AccountPOJO> cuentas = null;
		// Si el idCliente es "" obtenemos todas las cuentas
		// de lo contrario sólo las asociadas a un cliente
		if(idCliente.compareTo("") == 0){
			cuentas = repoAcc.findAll();
		}else{
			cuentas = repoAcc.findByIdCliente(idCliente);
		}
		
		for (AccountPOJO acc : cuentas){
			logger.info("\n {}",acc);

			//Obtenemos la información complementaria del CR 
			List <CrPOJO> cr = repoCrs.findByCr(acc.getCr());
			logger.info("\n {}",cr);
			cuentasDTO.add(transform.accountPOJO2CuentasDTO(acc, cr.get(0)));
		}		
		return cuentasDTO;
	}
	
	/*Servicio para obtener todos los clientes*/
	public List <ClientesDTO>  getClients(String idCliente){
		List <ClientesDTO> clientesDTO = new ArrayList <ClientesDTO>();
		
		List <ClientPOJO> clients = null;
		// Si el idCliente es "" obtenemos todos los clientes
		// de lo contrario sólo las asociadas al Id
		if(idCliente.compareTo("") == 0){
			clients = repoClients.findAll();
		}else{
			clients = repoClients.findByIdCliente(idCliente);
		}
		
		for (ClientPOJO c : clients){
			clientesDTO.add(transform.clientPOJO2CrInfoDTO(c));
		}		
		return clientesDTO;
	}
	
	
	/*Servicio para obtener todos las operaciones relevantes y las asociadas a una cuenta*/
	public List <OperacionesRelevantesDTO>  getRelevatsOp(String idCuenta){
		List <OperacionesRelevantesDTO> opRelevantesDTO = new ArrayList <OperacionesRelevantesDTO>();
		
		List <OperationPOJO> operations = null;
		List <RelevantOpPOJO> relevantsOp = new ArrayList <RelevantOpPOJO>();
		// Si el idCuenta es "" obtenemos todas las operaciones relevantes
		// de lo contrario sólo las asociadas al Id
		if(idCuenta.compareTo("") == 0){
			relevantsOp = repoRelevatns.findAll();
			
			for (RelevantOpPOJO relevant : relevantsOp){
				// obtenemos la operacion por id para complementar datos del DTO
				OperationPOJO op = repoOp.findByIdOperacion(relevant.getIdOperacion());
				opRelevantesDTO.add(transform.relevantOpPOJO2OperacionesRelevantesDTO(relevant, op));
			}
		}else{
			// obtenemos operaciones asociadas a unaa cuenta
			operations = repoOp.findByCuenta(idCuenta);
			
			// Si tiene Operaciones relevantes las obtenemos 
			if (this.haveRelevants(operations)){
				for(OperationPOJO op : operations){
					RelevantOpPOJO relevant = repoRelevatns.findByIdOperacion(op.getIdOperacion());
					// si es diferente de NULL quiere decir que si es una relevante
					if (relevant != null){
						opRelevantesDTO.add(transform.relevantOpPOJO2OperacionesRelevantesDTO(relevant, op));
					}
				}
			}
			
		}	

		return opRelevantesDTO;
	}
	
	/*Servicio para obtener toda la información de los Centros responsables */
	public List <CrInfoDTO>  getCrInfo(String idCr){
		List <CrInfoDTO> crInfoDTO = new ArrayList <CrInfoDTO>();
		
		List <CrPOJO> crs = null;
		// Si el idCr es "" obtenemos todos los Crs
		// de lo contrario sólo las asociadas al Id
		if(idCr.compareTo("") == 0){
			crs = repoCrs.findAll();
		}else{
			crs = repoCrs.findByCr(idCr);
		}
		
		for (CrPOJO cr : crs){
			crInfoDTO.add(transform.crPOJO2CrInfoDTO(cr));
		}		
		return crInfoDTO;
	}
	
	
	/*Metodo para saber si de una lista de operaciones hay alguna relevante*/
	public boolean haveRelevants (List <OperationPOJO> operations){
		for (OperationPOJO op : operations){
			RelevantOpPOJO r = repoRelevatns.findByIdOperacion(op.getIdOperacion());
			if (r != null){
				return true;
			}
		}
		return false;
	}
}
