package ma.youcode.demosaasplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestDemoSaasPlatformApplication {

	public static void main(String[] args) {
		SpringApplication
				.from(DemoSaasPlatformApplication::main)
				.with(TestDemoSaasPlatformApplication.class)
				.run(args);
	}



	@Bean
	@ServiceConnection
	@RestartScope
	public PostgreSQLContainer<?> mysqlContainer() {
		return new PostgreSQLContainer<>("postgres:15");
	}

}
