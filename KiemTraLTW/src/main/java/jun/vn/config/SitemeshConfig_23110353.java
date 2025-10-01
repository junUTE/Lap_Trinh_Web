package jun.vn.config;

import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;

@Configuration
public class SitemeshConfig_23110353 {

	@Bean
	public Filter sitemeshFilter() {
		return new ConfigurableSiteMeshFilter();
	}
}