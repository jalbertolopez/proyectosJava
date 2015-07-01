package mx.bbv.alerts.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;



@Configuration
@EnableMongoRepositories("mx.bbv.alerts.rest.repository")
class ApplicationConfig extends AbstractMongoConfiguration {

  @Override
  protected String getDatabaseName() {
    return "alertas-pld";
  }

  @Override
  public Mongo mongo() throws Exception {
    return new Mongo();
  }
}

