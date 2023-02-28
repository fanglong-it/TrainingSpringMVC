
package com.example.java.config;

import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import com.example.java.dao.UserDAO;
import com.example.java.dao.impl.UserDAOImpl;

@EnableWebMvc
@Configuration
@ComponentScan("com.example.java")
//@Import(value = { WebSecurityConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	//CSS resource
	public void addResourceHandler(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/css/").setCachePeriod(31556926);
	}
	
	

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	



	@Autowired
	DataSource dataSource;
	
	@Bean
	public UserDAO userDAO() {
		return new UserDAOImpl(dataSource);
	}
	

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
