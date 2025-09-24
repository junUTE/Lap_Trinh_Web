package jun.vn.configs;

import lombok.Data;

import java.net.URI;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("storage")
public class StorageProperties {
	private String location;

	public URI getLocation() {
		// TODO Auto-generated method stub
		return null;
	}
}
