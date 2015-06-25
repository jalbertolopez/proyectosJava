package mx.bbv.alertas.jms;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import junit.framework.Assert;
import mx.bbv.alerts.model.TransactionRaw;
import mx.bbv.alerts.utils.JsonConverter;
import mx.bbv.alerts.utils.QueueUtilProperties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabbitMQTest {

	private Logger logger = LoggerFactory.getLogger(RabbitMQTest.class);
	private ApplicationContext context;
	private AmqpTemplate template = null;	
	QueueUtilProperties queueProperties;
	
	@BeforeTest
	public void setup() {
		context = new ClassPathXmlApplicationContext(new String[] {
				//"drools-context.xml",
				"drools-xls-context.xml",
				"alertas-services-context.xml", "jms-connections-context.xml","mongodb-context.xml"});
		template = context.getBean(AmqpTemplate.class);
		queueProperties = context.getBean("queueUtilProperties", QueueUtilProperties.class);			
		logger.info("Context: {}", context);
	}

	/**
	 * @author cruzao Prueba unitaria para publicar en la queue ALERTAS.OUT
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws InterruptedException 
	 */
	@Test
	public void pushAlertTest() throws IOException, ParseException, InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-2014 10:20:56";
		Date date = sdf.parse(dateInString);
		//int i = 0;
		for(int i = 0;; i++){		
			String jsonFormat = JsonConverter.toJson(new TransactionRaw("Alan Orlando","Cruz Manrique", "FISICA", "0011", date , new Date(),"ABONO", 1000.0, "0001", "000" + i, "12345678", "LIBRETON","DF"));
			//String jsonFormat = JsonConverter.toJson(new Transaction("Pedro qwertyu","qwer asdf", "FISICA", "Coyoacan", date , new Date(),"ABONO", 1000.0, "0002", "000" + i, "12345678", "LIBRETON","DF"));
			logger.info("\n\n\tEnviando mensaje a la queue \n\n[{}]", jsonFormat);
			template.convertAndSend(queueProperties.getByName("alertas.out.queue"), jsonFormat);
			Thread.sleep(10000);
		}		
	}
	
	/**
	 * @author cruzao Prueba unitaria para publicar en la queue ALERTAS.OUT
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws InterruptedException 
	 */
	@Test
	public void pushAlertFileTest() throws IOException, ParseException, InterruptedException {
	    String cadena;
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	    FileReader f = new FileReader("/home/alan/Escritorio/transacciones.csv");
	    BufferedReader b = new BufferedReader(f);
	    TransactionRaw tr = new TransactionRaw();
	    boolean first = true;
	    
	    while((cadena = b.readLine())!=null) {	         	    	 
	    	 if(!first)
	    	 {
		         String [] attr = cadena.split(",");
		         tr.setNombres(attr[0]);
		         tr.setApellidos(attr[1]);
		         tr.setTipoPersona(attr[2]);
		         tr.setSucursalGestora(attr[3]);
		         tr.setAltaCuenta(sdf.parse(attr[4]));
		         tr.setTipoOperacion(attr[5]);
		         tr.setMonto(Double.parseDouble(attr[6]));
		         tr.setIdCliente(attr[7]);
		         tr.setIdTransaccion(attr[8]);
		         tr.setCuenta(attr[9]);
		         tr.setProducto(attr[10]);
		         tr.setSucursal(attr[11]);	         
		         tr.setFechaOperacion(new Date());
		         
		         String jsonFormat = JsonConverter.toJson(tr);
		         logger.info("\n\n\tEnviando mensaje a la queue \n\n[{}]", jsonFormat);
				 template.convertAndSend(queueProperties.getByName("alertas.out.queue"), jsonFormat);
				 Thread.sleep(10000);
		     }
	    	 first = false;
	    }
	    b.close();		
	}
	
	/**
	 * @author cruzao Prueba unitaria para leer de la queue ALERTAS.OUT
	 * @throws IOException 
	 */
	@Test
	public void popAlertTest() throws IOException {
		for (;;){
			String message = (String) template.receiveAndConvert(queueProperties.getByName("alertas.out.queue"));
			logger.info("\n\n Mensaje recibido: \n {}", message);
		}
		
		//Transaction t1 = JsonConverter.fromJson(message , Transaction.class);
		//logger.info("Mensaje recibido: \n\n {}", t1);
	}
}
