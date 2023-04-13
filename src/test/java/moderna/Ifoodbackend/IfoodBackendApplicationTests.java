package moderna.Ifoodbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"moderna.ifoodbackend.*"})
public class IfoodBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
