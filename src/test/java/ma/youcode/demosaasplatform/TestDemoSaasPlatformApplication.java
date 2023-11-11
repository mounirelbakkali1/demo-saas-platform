package ma.youcode.demosaasplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestDemoSaasPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoSaasPlatformApplication::main).with(TestDemoSaasPlatformApplication.class).run(args);
	}

}
