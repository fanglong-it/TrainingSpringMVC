
package com.example.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.example.java.excel.SubjectListExcelView;

@Configuration
@EnableWebMvc
@ComponentScan("com.example.java")
//@Import(value = { WebSecurityConfig.class })
public class WebConfig{

	@Bean(name = "viewResolver2")
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// CSS resource
	public void addResourceHandler(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/css/").setCachePeriod(31556926);
	}
	
	@Bean(name = "viewResolver1")
	public ResourceBundleViewResolver resolver() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setOrder(1);
		resolver.setBasename("views");
		return resolver;
	}
	
	

//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer.favorPathExtension(false).favorParameter(true)
//			.parameterName("mediaType")
//			.ignoreAcceptHeader(true)
//			.useJaf(false).defaultContentType(MediaType.APPLICATION_JSON)
//			.mediaType("xml", MediaType.APPLICATION_XML)
//			.mediaType("json", MediaType.APPLICATION_JSON);
//	}
	
	
	
	

//
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
//	

//	@Autowired
//	DataSource dataSource;

//	@Bean
//	public UserDAO userDAO() {
//		return new UserDAOImpl(dataSource);
//	}

//	@Bean
//	public AuthoritiesDAO authoritiesDAO(){
//		return new AuthoritiesDAOImpl(dataSource);
//	}

//	

//	@Autowired
//	private ApplicationContext applicationContext;
//
//
//	    public MVCconfig() {
//	        super();
//	    }
//
//
//	    public void setApplicationContext(final ApplicationContext applicationContext)
//	            throws BeansException {
//	        this.applicationContext = applicationContext;
//	    }
//
//
//	    @Override
//	    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//	        super.addResourceHandlers(registry);
//	        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
//	        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
//	        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
//	    }
//

//
//	  
//	@Bean
//	public SpringResourceTemplateResolver templateResolver() {
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setApplicationContext(this.applicationContext);
//		templateResolver.setPrefix("/WEB-INF/templates/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode(TemplateMode.HTML);
//		templateResolver.setCacheable(true);
//		return templateResolver;
//	}
//
//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver());
//		templateEngine.setEnableSpringELCompiler(true);
//		return templateEngine;
//	}
//
////
//	@Bean
//	public ThymeleafViewResolver viewResolver() {
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(templateEngine());
//		return viewResolver;
//	}
//	

//	@Autowired
//	DataSource dataSource;

//	@Bean
//	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
//		return new NamedParameterJdbcTemplate(dataSource);
//	}

//	
}
