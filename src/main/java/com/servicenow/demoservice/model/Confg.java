package com.servicenow.demoservice.model;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.servicenow.demoservice.clintreq.Businesslogic;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Confg {
	
	
	
	@Bean
	public RestTemplate restTemp() {
		//restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		return new RestTemplate();
	}
	 @Primary
	    @Bean
	    public SwaggerResourcesProvider swaggerResourcesProvider() {
	        return () -> {
	            List<SwaggerResource> resources = new ArrayList<>();
	            Collections.singletonList("api")
	                    .forEach(resourceName -> resources.add(loadResource(resourceName)));
	            return resources;
	        };
	    }

	    private SwaggerResource loadResource(String resource) {
	        SwaggerResource swResource = new SwaggerResource();
	        swResource.setName(resource);
	        swResource.setSwaggerVersion("2.0");
	        swResource.setLocation("/apis/" + resource + "/ui.yaml");
	        return swResource;
	    }
	
//	   @Primary
//	    @Bean
//	    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
//	        return () -> {
//	            SwaggerResource wsResource = new SwaggerResource();
//	            wsResource.setName("new spec");
//	            wsResource.setSwaggerVersion("2.0");
//	            wsResource.setLocation("/swag.yml");
//
//	            List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
//	            resources.add(wsResource);
//	            return resources;
//	        };
//	    }
	
	
	
	
	

}
