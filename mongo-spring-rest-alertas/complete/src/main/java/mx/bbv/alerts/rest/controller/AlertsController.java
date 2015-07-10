package mx.bbv.alerts.rest.controller;

import java.util.List;

import mx.bbv.alerts.rest.dto.AlertasDTO;
import mx.bbv.alerts.rest.dto.ClientesDTO;
import mx.bbv.alerts.rest.dto.CrInfoDTO;
import mx.bbv.alerts.rest.dto.CuentasDTO;
import mx.bbv.alerts.rest.dto.OperacionesDTO;
import mx.bbv.alerts.rest.dto.OperacionesRelevantesDTO;
import mx.bbv.alerts.rest.repository.AccountsRepository;
import mx.bbv.alerts.rest.repository.AlertsRepository;
import mx.bbv.alerts.rest.repository.ClientRepository;
import mx.bbv.alerts.rest.repository.CrsRepository;
import mx.bbv.alerts.rest.repository.OperationsRepository;
import mx.bbv.alerts.rest.repository.RelevantsRepository;
import mx.bbv.alerts.rest.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alertasPld")
public class AlertsController {

	@Autowired
	ServicesImpl servicesImpl;
	
	@RequestMapping("/alertas")
	 public List <AlertasDTO> getAlert(@RequestParam(value="idAlerta", defaultValue=" ") String idAlerta, @RequestParam(value="status", defaultValue=" ") String status){
		return servicesImpl.getAlerts();
	 }
	 
	 @RequestMapping("/transacciones")
	 public List <OperacionesDTO> getTransactions(@RequestParam(value="idAlerta", defaultValue="") String idAlerta){
	    return servicesImpl.getOperations(idAlerta);
	 }
	 
	 @RequestMapping("/cuentas")
	 public List <CuentasDTO> getAccounts(@RequestParam(value="idCliente", defaultValue="") String idCliente){		 
	    return servicesImpl.getAccounts(idCliente);
	 }
	 
	 @RequestMapping("/clientes")
	 public List <ClientesDTO> getClients(@RequestParam(value="idCliente", defaultValue="") String idCliente){
	    return servicesImpl.getClients(idCliente);
	 }
	 
	 @RequestMapping("/transaccionesR")
	 public List <OperacionesRelevantesDTO> getTransRelevantes(@RequestParam(value="idCuenta", defaultValue="") String idCuenta){
	    return servicesImpl.getRelevatsOp(idCuenta);
	 }
	 
	 @RequestMapping("/crOpInfo")
	 public List <CrInfoDTO> getCrInfo(@RequestParam(value="idCr", defaultValue="") String idCr){
	    return  servicesImpl.getCrInfo(idCr);
	 }
	  
	 /* 
	  * REST SERVICE DE PRUEBA 
	  * */
	 
	 @RequestMapping("/alertasTest")
	 public String getAlertTest(@RequestParam(value="idAlerta", defaultValue=" ") String idAlerta, @RequestParam(value="status", defaultValue=" ") String status){
		 String json1 = "{"
		 		+ "\"idAlerta\":\"0001\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"idCliente\":\"A0000079\","
		 		+ "\"cuenta\":\"007400984144436490\","
		 		+ "\"motivo\":\"MONTO NO PERMITIDO\","
		 		+ "\"montoAcumulado\":\"515000\","
		 		+ "\"estatus\":\"NO RESUELTA\","
		 		+ "\"relevante\":true,"
		 		+ "\"noOperaciones\":\"5\""
		 		+ "}";
		 
		 String json2 = "{"
			 		+ "\"idAlerta\":\"0002\","
			 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
			 		+ "\"idCliente\":\"A0000086\","
			 		+ "\"cuenta\":\"007406966652405272\","
			 		+ "\"motivo\":\"MONTO PERMITIDO SUPERADO\","
			 		+ "\"montoAcumulado\":\"520000\","
			 		+ "\"estatus\":\"NO RESUELTA\","
			 		+ "\"relevante\":true,"
			 		+ "\"noOperaciones\":\"3\""
			 		+ "}";
		 
		 if(idAlerta.compareTo("0001") == 0){
			 return  "["+json1+"]";
		 }
		 else if(idAlerta.compareTo("0002") == 0){
			 return  "["+json2+"]";
		 }else if(status.compareTo("RESUELTA") == 0){
			 return "Todas las alertas Resueltas";
		 }		 
	    return  "["+json1+","+json2+"]";
	 }
	 
	 @RequestMapping("/transaccionesTest")
	 public String getTransactionsTest(@RequestParam(value="idAlerta", defaultValue=" ") String idAlerta){
		 // transacciones correspondioentes a la alerta 1
		 String json1 = "{"
		 		+ "\"idOperacion\":\"0001\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"cuenta\":\"007400984144436490\","
		 		+ "\"monto\":\"110000\","
		 		+ "\"crOp\":\"0050\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"relevante\":true,"
		 		+ "\"idAlerta\":\"0001\""
		 		+ "},{"
		 		+ "\"idOperacion\":\"0002\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"cuenta\":\"007400984144436490\","
		 		+ "\"monto\":\"100000\","
		 		+ "\"crOp\":\"0050\","
		 		+ "\"relevante\":false,"
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"idAlerta\":\"0001\""
		 		+ "},{"
		 		+ "\"idOperacion\":\"0003\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"cuenta\":\"007400984144436490\","
		 		+ "\"monto\":\"101000\","
		 		+ "\"crOp\":\"0050\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"relevante\":true,"
		 		+ "\"idAlerta\":\"0001\""
		 		+ "},{"
		 		+ "\"idOperacion\":\"0004\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"cuenta\":\"007400984144436490\","
		 		+ "\"monto\":\"100000\","
		 		+ "\"crOp\":\"0050\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"relevante\":false,"
		 		+ "\"idAlerta\":\"0001\""
		 		+ "},{"
		 		+ "\"idOperacion\":\"0005\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"cuenta\":\"007400984144436490\","
		 		+ "\"monto\":\"104000\","
		 		+ "\"crOp\":\"0050\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"relevante\":true,"
		 		+ "\"idAlerta\":\"0001\""
		 		+ "}";
		 
		// transacciones correspondioentes a la alerta 2
		 String json2 = "{"
		 		+ "\"idOperacion\":\"0006\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"cuenta\":\"007406966652405272\","
		 		+ "\"monto\":\"100000\","
		 		+ "\"crOp\":\"0051\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"relevante\":false,"
		 		+ "\"idAlerta\":\"0002\""
		 		+ "},{"
		 		+ "\"idOperacion\":\"0007\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"cuenta\":\"007406966652405272\","
		 		+ "\"monto\":\"400000\","
		 		+ "\"crOp\":\"0051\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"relevante\":true,"
		 		+ "\"idAlerta\":\"0002\""
		 		+ "},{"
		 		+ "\"idOperacion\":\"0008\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"cuenta\":\"007406966652405272\","
		 		+ "\"monto\":\"20000\","
		 		+ "\"crOp\":\"0051\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"relevante\":false,"
		 		+ "\"idAlerta\":\"0002\""
		 		+ "}";
		
		 if(idAlerta.compareTo("0001") == 0){
			 return  "["+json1+"]";
		 }
		 else if(idAlerta.compareTo("0002") == 0){
			 return  "["+json2+"]";
		 }		 
	    return  "["+json1+","+json2+"]";
	 }
	 
	 @RequestMapping("/cuentasTest")
	 public String getAccountsTest(@RequestParam(value="idCliente", defaultValue=" ") String idCliente){
		 String json1 = "{"
		 		+ "\"idCuenta\":\"007400984144436490\","
		 		+ "\"idCliente\":\"A0000079\","
		 		+ "\"fechaGen\":\"2015-06-19\","
		 		+ "\"crGestor\":\"0098\","
		 		+ "\"nomSucursal\":\"PLAZA ARAGON\","
		 		+ "\"cenSup\":\"2562 DZ ECATEPEC\","
		 		+ "\"division\":\"division 1\","
		 		+ "\"estado\":\"ECATEPEC\""
		 		+ "},{"
		 		+ "\"idCuenta\":\"007400989801225804\","
		 		+ "\"idCliente\":\"A0000079\","
		 		+ "\"fechaGen\":\"2015-06-19\","
		 		+ "\"crGestor\":\"0098\","
		 		+ "\"nomSucursal\":\"PLAZA ARAGON\","
		 		+ "\"cenSup\":\"2562 DZ ECATEPEC\","
		 		+ "\"division\":\"division 1\","
		 		+ "\"estado\":\"ECATEPEC\""
		 		+ "}";
		 
		 String json2 = "{"
			 		+ "\"idCuenta\":\"007406966652405272\","
			 		+ "\"idCliente\":\"A0000086\","
			 		+ "\"fechaGen\":\"2015-06-22\","
			 		+ "\"crGestor\":\"0696\","
			 		+ "\"nomSucursal\":\"PLAZA UNIVERSIDAD\","
			 		+ "\"cenSup\":\"2573 DZ BENITO JUAREZ 1 \","
			 		+ "\"division\":\"division 2\","
			 		+ "\"estado\":\"DF\""
			 		+ "}";
		 
		 if(idCliente.compareTo("A0000079") == 0){
			 return  "["+json1+"]";
		 }
		 else if(idCliente.compareTo("A0000086") == 0){
			 return  "["+json2+"]";
		 }		 
	    return  "["+json1+","+json2+"]";
	 }
	 
	 @RequestMapping("/clientesTest")
	 public String getClientsTest(@RequestParam(value="idCliente", defaultValue=" ") String idCliente){
		 String json1 = "{"
		 		+ "\"idCliente\":\"A0000079\","
		 		+ "\"nombres\":\"ADRIANA\","
		 		+ "\"apellidos\":\"NAJERA MARTINEZ\","
		 		+ "\"tipoPersona\":\"FISICA\","
		 		+ "\"fechaAlta\":\"2015-06-19\""
		 		+ "}";
		 
		 String json2 = "{"
			 		+ "\"idCliente\":\"A0000086\","
			 		+ "\"nombres\":\"PEDRO\","
			 		+ "\"apellidos\":\"GUILLEN TORRES\","
			 		+ "\"tipoPersona\":\"FISICA\","
			 		+ "\"fechaAlta\":\"2015-06-22\""
			 		+ "}";
		 
		 String json3 = "{"
			 		+ "\"idCliente\":\"A0000087\","
			 		+ "\"nombres\":\"PABLO\","
			 		+ "\"apellidos\":\"AGUIAR RAZURA\","
			 		+ "\"tipoPersona\":\"FISICA\","
			 		+ "\"fechaAlta\":\"2015-06-23\""
			 		+ "}";
		 
		 if(idCliente.compareTo("A0000079") == 0){
			 return  "["+json1+"]";
		 }
		 else if(idCliente.compareTo("A0000086") == 0){
			 return  "["+json2+"]";
		 }
		 else if(idCliente.compareTo("A0000087") == 0){
			 return  "["+json3+"]";
		 }
	    return  "["+json1+","+json2+","+json3+"]";
	 }
	 
	 @RequestMapping("/transaccionesRTest")
	 public String getTransRelevantesTest(@RequestParam(value="idCuenta", defaultValue=" ") String idCuenta){
		 String json1 = "{"
		 		+ "\"idCuenta\":\"007400984144436490\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"folio\":\"0000000000000001\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"oficina\":\"0050\","
		 		+ "\"transaccion\":\"0001\","
		 		+ "\"clasificacion\":\"00\","
		 		+ "\"monto\":\"110000\""
		 		+ "},{"
		 		+ "\"idCuenta\":\"007400984144436490\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"folio\":\"0000000000000002\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"oficina\":\"0050\","
		 		+ "\"transaccion\":\"0003\","
		 		+ "\"clasificacion\":\"00\","
		 		+ "\"monto\":\"101000\""
		 		+ "},{"
		 		+ "\"idCuenta\":\"007400984144436490\","
		 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
		 		+ "\"folio\":\"0000000000000003\","
		 		+ "\"tipo\":\"ABONO\","
		 		+ "\"oficina\":\"0050\","
		 		+ "\"transaccion\":\"0005\","
		 		+ "\"clasificacion\":\"00\","
		 		+ "\"monto\":\"104000\""
		 		+ "}";
		 
		 String json2 = "{"
				 	+ "\"idCuenta\":\"007406966652405272\","
			 		+ "\"fechaGen\":\"2015-06-11 17:59:32\","
			 		+ "\"folio\":\"0000000000000004\","
			 		+ "\"tipo\":\"ABONO\","
			 		+ "\"oficina\":\"0051\","
			 		+ "\"transaccion\":\"0007\","
			 		+ "\"clasificacion\":\"00\","
			 		+ "\"monto\":\"400000\""
			 		+ "}";
		 if(idCuenta.compareTo("007400984144436490") == 0){
			 return  "["+json1+"]";
		 }
		 else if(idCuenta.compareTo("007406966652405272") == 0){
			 return  "["+json2+"]";
		 }		 
	    return  "["+json1+","+json2+"]";
	 }
	 
	 @RequestMapping("/crOpInfoTest")
	 public String getCrInfoTest(@RequestParam(value="idCr", defaultValue=" ") String idCr){
		 String json1 = "{"
				+ "\"idCr\":\"0050\","
		 		+ "\"nomSucursal\":\"PLAZA LINDAVISTA\","
		 		+ "\"cenSup\":\"5555 DZ GUSTAVO A MADERO\","
		 		+ "\"division\":\"division 0\","
		 		+ "\"estado\":\"DF\""
		 		+ "}";
		 
		 String json2 = "{"
			 		+ "\"idCr\":\"0051\","
			 		+ "\"nomSucursal\":\"PARQUE LINDAVISTA\","
			 		+ "\"cenSup\":\"7777 DZ GUSTAVO A MADERO \","
			 		+ "\"division\":\"division 0\","
			 		+ "\"estado\":\"DF\""
			 		+ "}";
		 
		 if(idCr.compareTo("0050") == 0){
			 return  "["+json1+"]";
		 }
		 else if(idCr.compareTo("0051") == 0){
			 return  "["+json2+"]";
		 }		 
	    return  "["+json1+","+json2+"]";
	 }
}
