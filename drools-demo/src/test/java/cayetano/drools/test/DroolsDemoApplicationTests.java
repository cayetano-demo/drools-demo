package cayetano.drools.test;

import java.util.Arrays;

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
		int outcomeState = 1;
		String ticketId = "123-ticket-id";

		int stakeTransactionType = 0;
		int winTransactionType = 1;
		int pendingTransactionStatus = 2;
		int completedTransactionStatus = 0;
		Transaction stakeTransaction = new Transaction(pendingTransactionStatus, 12.94, stakeTransactionType);
		Transaction winTransaction = new Transaction(completedTransactionStatus, 9.56, winTransactionType);
		
		GameOutcome go = new GameOutcome(true, outcomeState, ticketId, Arrays.asList(stakeTransaction, winTransaction));
		
		StatelessKieSession kieSession = kieContainer.newStatelessKieSession("CayetanoKieSession");
		kieSession.execute(go);
	}
}
