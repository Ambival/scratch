package example.roger;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RedisTest {

	public static void main(String[] args) throws InterruptedException {
		BasicConfigurator.configure();
		
		new RedisTest().run(args);
	}

	private void run(String[] args) throws InterruptedException {
		Logger logger = LoggerFactory.getLogger(RedisTest.class);
		
		ConsumerThread consumer = new ConsumerThread(logger);
		consumer.start();

		PublisherThread publisher = new PublisherThread(logger);
		publisher.start();
		
		Thread.sleep(20000);
		
		logger.debug("Interrupting publisher");

		publisher.interrupt();
		publisher.join();
		
		logger.debug("Interrupting consumer");
		
		consumer.interrupt();
		consumer.join();

		logger.debug("All threads have shut down");
	}
}