package example.roger;

import org.slf4j.Logger;

import redis.clients.jedis.Jedis;

public class ConsumerThread extends Thread {
	
	private Logger _logger;

	public ConsumerThread(Logger logger) {
		this._logger = logger;
	}

	@Override
	public void run() {
		_logger.debug("Consumer thread started");
		
		final Jedis jedis = new Jedis("localhost", 6379);
		
		while(!interrupted()) {
			String val = jedis.lpop("key");

			try {				
				if (val != null)
					_logger.debug("Consumer got: {}", val);
				else
					Thread.sleep(10);
			} catch (InterruptedException e) { 
				break;
			}
		}
	}
}

