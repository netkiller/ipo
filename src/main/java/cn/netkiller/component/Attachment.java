package cn.netkiller.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(60)
public class Attachment implements ApplicationRunner {

	public Attachment() {
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// this.contract();
		// System.exit(0);

	}

}
