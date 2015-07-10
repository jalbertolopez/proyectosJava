package mx.bbv.alerts.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mx.bbv.alerts.catalogs.AccountStatusEnum;
import mx.bbv.alerts.model.ClientInfoStatus;
import mx.bbv.alerts.model.TransactionRaw;
import mx.bbv.alerts.model.TransactionStatus;
import mx.bbv.alerts.model.persistence.CrPOJO;
import mx.bbv.alerts.model.persistence.RelevantOpPOJO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * Clase para las pruebas unitarias AlertsDataService
 * */
public class AlertsDataServiceTest {
	private Logger logger = LoggerFactory.getLogger(AlertsDataServiceTest.class);
	
	private ApplicationContext context;
	private AlertsDataService alertsDataService;
	
	@BeforeTest
	public void setup() {
		context = new ClassPathXmlApplicationContext(new String[] {
				"drools-xls-context.xml",
				"alertas-services-context.xml", "jms-connections-context.xml","mongodb-context.xml"});
		
		alertsDataService = context.getBean("alertsDataService",AlertsDataService.class);
		logger.info("Context: {}", context);
	}

	/**
	 * @author cruzao Prueba unitaria del Data Service para obtener el acumulado
	 *         del monto de las transacciones guardadas en MongoDB
	 * @throws IOException
	 */
	@Test
	public void getAccumulatedAmountTest() throws IOException {
		ClientInfoStatus clientInfoStatus = alertsDataService.getAccumulatedAmount("0001");
		logger.info("\n************** Monto Acumulado ************\n{}",
				clientInfoStatus);
	}

	/**
	 * @author cruzao Prueba unitaria del Data Service para persistir clientes
	 *         en POSTGRESQL
	 * @throws IOException
	 * @throws ParseException 
	 */
	@Test
	public void saveClientTest() throws IOException, ParseException {
		// Generamos una trasacción
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-2014 10:20:56";
		Date date = sdf.parse(dateInString);	
		TransactionStatus t = new TransactionStatus();
		
//		t.setAltaCuenta(date);
//		t.setApellidos("Cruz Test");
//		t.setCuenta("0000000000");
//		t.setFechaOperacion(new Date());
//		t.setIdCliente("00000");
//		t.setIdTransaccion("0000");
//		t.setMonto(0.0);
//		t.setNombres("Alan Test");
//		t.setProducto("LIBRETON");
//		t.setSucursal("COYOACAN");
//		t.setSucursalGestora("0011");
//		t.setTipoOperacion("ABONO");
//		t.setTipoPersona("FISICA");
//		t.setStatus(AccountStatusEnum.UNLOCK.toInt());
//		t.setMontoAcumulado(0.0);
//		t.setMessage("Alerta de prueba");
//		
		alertsDataService.saveClient(t);
	}

	/**
	 * @author cruzao Prueba unitaria del Data Service para persistir
	 *         Transacciones en POSTGRESQL
	 * @throws IOException
	 * @throws ParseException 
	 */
	@Test
	public void saveTransactionTest() throws IOException, ParseException {
		// Generamos una trasacción
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-2014 10:20:56";
		Date date = sdf.parse(dateInString);	
		TransactionRaw t = new TransactionRaw();
		
//		t.setAltaCuenta(date);
//		t.setApellidos("Cruz Test");
//		t.setCuenta("0000000000");
//		t.setFechaOperacion(new Date());
//		t.setIdCliente("00000");
//		t.setIdTransaccion("0000");
//		t.setMonto(0.0);
//		t.setNombres("Alan Test");
//		t.setProducto("LIBRETON");
//		t.setSucursal("COYOACAN");
//		t.setSucursalGestora("0011");
//		t.setTipoOperacion("ABONO");
//		t.setTipoPersona("FISICA");
//			
		alertsDataService.saveTransaction(t,"0001");
	}
	
	/**
	 * @author cruzao Prueba unitaria del Data Service para persistir
	 *         Transacciones en POSTGRESQL
	//		t.setAltaCuenta(date);
//		t.setApellidos("Cruz Test");
//		t.setCuenta("0000000000");
//		t.setFechaOperacion(new Date());
//		t.setIdCliente("00000");
//		t.setIdTransaccion("0000");
//		t.setMonto(0.0);
//		t.setNombres("Alan Test");
//		t.setProducto("LIBRETON");
//		t.setSucursal("COYOACAN");
//		t.setSucursalGestora("0011");
//		t.setTipoOperacion("ABONO");
//		t.setTipoPersona("FISICA");
//		t.setStatus(AccountStatusEnum.UNLOCK.toInt());
//		t.setMontoAcumulado(0.0);
//		t.setMessage("Alerta de prueba"); * @throws IOException
	 * @throws ParseException 
	 */
	@Test
	public void saveAlertTest() throws IOException, ParseException {
		// Generamos una trasacción
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-2014 10:20:56";
		Date date = sdf.parse(dateInString);	
		TransactionStatus t = new TransactionStatus();
		
//		t.setAltaCuenta(date);
//		t.setApellidos("Cruz Test");
//		t.setCuenta("0000000000");
//		t.setFechaOperacion(new Date());
//		t.setIdCliente("00000");
//		t.setIdTransaccion("0000");
//		t.setMonto(0.0);
//		t.setNombres("Alan Test");
//		t.setProducto("LIBRETON");
//		t.setSucursal("COYOACAN");
//		t.setSucursalGestora("0011");
//		t.setTipoOperacion("ABONO");
//		t.setTipoPersona("FISICA");
//		t.setStatus(AccountStatusEnum.UNLOCK.toInt());
//		t.setMontoAcumulado(0.0);
//		t.setMessage("Alerta de prueba");
		
		alertsDataService.saveAlert(t,"0001");
	}


	/**
	 * @author cruzao Prueba unitaria del Data Service para guardar crs
	 *         en mongo MONGODB
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	@Test
	public void saveCrTest() throws IOException, ParseException, InterruptedException {
		CrPOJO [] crs  = {
				new CrPOJO("0050","PLAZA LINDAVISTA","5555 DZ GUSTAVO A MADERO","DIVISION 0","DF"),
				new CrPOJO("0051","PARQUE LINDAVISTA","7777 DZ GUSTAVO A MADERO","DIVISION 0","DF"),
				new CrPOJO("0098","PLAZA ARAGON","2562 DZ ECATEPEC","DIVISION 1","ECATEPEC"),
				new CrPOJO("0696","PLAZA UNIVERSIDAD","2573 DZ BENITO JUAREZ","DIVISION 2","DF")};
		for (int i = 0 ; i < crs.length ; i++ ){
			alertsDataService.saveCentroResponsable(crs[i]);
		}		
	}
	
	/**
	 * @author cruzao Prueba unitaria del Data Service para guardar 
	 * datos de Operaciones Relevantes en mongo MONGODB
	 * @throws IOException
	 */
	@Test
	public void saveRelevantesTest() throws IOException, ParseException {
		RelevantOpPOJO [] relevantes  = {
				new RelevantOpPOJO("0001","0000000000000001","00"),
				new RelevantOpPOJO("0003","0000000000000002","00"),
				new RelevantOpPOJO("0005","0000000000000003","00"),
				new RelevantOpPOJO("0007","0000000000000004","00")
		};
		
		for (int i = 0 ; i < relevantes.length ; i++ ){
			alertsDataService.saveRelevantes(relevantes[i]);
		}		
	}

	/**
	 * @author cruzao Prueba unitaria del Data Service para obtener
	 *         Transacciones aociadas a un cliente de MONGODB
	 * @throws IOException
	 */
	@Test
	public void getTransactionsForIdMDBTest() throws IOException {
		List<TransactionRaw> trans = alertsDataService.getTransactionsForIdMDB("0001");		
		for (TransactionRaw t : trans){
			logger.info("\n{}\n",t);
		}
	}

}
