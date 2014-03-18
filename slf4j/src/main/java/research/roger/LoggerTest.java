package research.roger;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		new LoggerTest().run(args);
	}

	private void run(String[] args) {
		Logger LOG = LoggerFactory.getLogger(LoggerTest.class);
		
		LOG.debug("debug {} message", 123);
		LOG.info("info {} message", 1.34f);
		LOG.error("error {} message", "abcdef");
	}

}
