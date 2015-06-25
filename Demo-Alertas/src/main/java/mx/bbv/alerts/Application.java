package mx.bbv.alerts;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {
	
	
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
				"drools-xls-context.xml",
				"alertas-services-context.xml", 
				"jms-connections-context.xml","mongodb-context.xml"});
    	SpringApplication.run(Application.class, args);
    }
}