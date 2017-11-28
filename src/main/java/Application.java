
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.function.context.FunctionScan;

import config.Properties;

@FunctionScan
@SpringBootApplication
@EnableConfigurationProperties(Properties.class)
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
