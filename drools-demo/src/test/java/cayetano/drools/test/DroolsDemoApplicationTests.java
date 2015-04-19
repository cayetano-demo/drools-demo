package cayetano.drools.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cayetano.demo.kie_demo.GameOutcome;
import cayetano.demo.kie_demo.Transaction;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DroolsDemoApplication.class)
public class DroolsDemoApplicationTests {

	@Autowired private KieContainer kieContainer;
	
	@Test
	public void contextLoads() {
		Transaction transaction = new Transaction(2, 12.94);
		GameOutcome go = new GameOutcome(true, 2, "123-trans-id", transaction);
		
		StatelessKieSession kieSession = kieContainer.newStatelessKieSession("CayetanoKieSession");
		kieSession.execute(go);
	}
}
