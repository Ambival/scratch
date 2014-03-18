package example.roger;

import org.slf4j.Logger;

import redis.clients.jedis.Jedis;

public class PublisherThread extends Thread {
	
	private Logger _logger;

	public PublisherThread(Logger logger) {
		this._logger = logger;
	}

	@Override
	public void run() {
		_logger.debug("Publisher thread started");
		
		final Jedis jedis = new Jedis("localhost", 6379);
		
		for (int ct=0; ct<1000; ++ct) {
			jedis.rpush("key", Integer.toString(ct));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
		}
	}
}
