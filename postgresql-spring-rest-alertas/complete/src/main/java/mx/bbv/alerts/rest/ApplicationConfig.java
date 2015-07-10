package mx.bbv.alerts.rest;



public class ApplicationConfig {
//	@Configuration
//	@ComponentScan("mx.bbv.alerts.rest")
//	@PropertySource("classpath:application.properties")
//	@EnableJpaRepositories("com.spr.repository")
//	public class WebAppConfig {
//	 
//	    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
//	    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
//	    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
//	    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
//	 
//	    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
//	    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
//	    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
//	 
//	    @Resource
//	    private Environment env;
//	 
//	    @Bean
//	    public DataSource dataSource() {
//	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	 
//	        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
//	        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
//	        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
//	        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
//	 
//	        return dataSource;
//	    }
//	 
//	    @Bean
//	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//	        entityManagerFactoryBean.setDataSource(dataSource());
//	        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
//	        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
//	         
//	        entityManagerFactoryBean.setJpaProperties(hibProperties());
//	         
//	        return entityManagerFactoryBean;
//	    }
//	 
//	    private Properties hibProperties() {
//	        Properties properties = new Properties();
//	        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
//	        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
//	        return properties;
//	    }
//	  
}
