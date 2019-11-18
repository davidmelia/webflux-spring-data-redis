package uk.co.dave.holding;

import java.math.BigDecimal;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

@SpringBootTest
public class HoldingRepositoryTest {
	@Autowired
	@Qualifier("dave")
	private ReactiveRedisTemplate<String, Holdings> dave;

	@Test
	public void test() {
		Holding holding = new Holding();
		holding.setQuantity(BigDecimal.valueOf(123));
		holding.setAvailableSettledQuantity(BigDecimal.valueOf(321));
		Instrument instrument = new Instrument();
		instrument.setInstrumentName("My Instrument Name");
		holding.setInstrument(instrument);
		Holdings holdings = new Holdings();
		holdings.withHolding(holding);
		dave.opsForValue().set("dave", holdings, Duration.ofSeconds(10)).block();
	}
}
