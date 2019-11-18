package uk.co.dave.holding;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class HoldingRepository {

//	private final ReactiveRedisTemplate<String, Holding> reactiveRedisTemplate;

//	public Mono<String> getHoldingsFromCache(final CustomerId customerId, final AccountId accountId) {
//		log.info("In getHoldingsFromCache for accountId = {}", accountId);
//		// TODO build the key using customerId, accountId and version
//
//		final String cacheKey = portfolioCacheKeyHelper.getCacheKeyOn(customerId, accountId);
//		return reactiveRedisTemplate.opsForValue().get(cacheKey)
//				.switchIfEmpty(dummyPortfolioRepository.getHoldings(accountId))
//				.flatMap(holdings -> reactiveValueOperations.set(cacheKey, holdings))
//				.then(reactiveValueOperations.opsForValue().get(cacheKey))
//				.doOnSuccess(holdings -> log.info("Out getHoldingsFromCache = {}", holdings));
//	}
}
