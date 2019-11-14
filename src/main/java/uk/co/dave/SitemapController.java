package uk.co.dave;

import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SitemapController {

  @Qualifier("schedulerForBlocking")
  private final Scheduler scheduler;
 
  @GetMapping(value = "/non-blocking", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Map<String, String>> nonBlocking() {
    log.info("enter nonBlocking()");
    Mono<Map<String, String>> result = Mono.just(Map.of("quick", "response"));
    log.info("exit nonBlocking()");
    return result;
  }

  
  @GetMapping(value = "/block", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Map<String, String>> block() {
    log.info("enter block()");
    Mono<Map<String, String>> result = Mono.just(syncCallBlocking());
    log.info("exit block()");
    return result;
  }

  @GetMapping(value = "/block-in-seperate-threadpool", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Map<String, String>> blockInSeperateThreadpool() {
    log.info("enter blockInSeperateThreadpool()");
    Mono<Map<String, String>> result = Mono.fromSupplier(() -> syncCallBlocking()).subscribeOn(scheduler);
    log.info("exit blockInSeperateThreadpool()");
    return result;
  }


  private Map<String, String> syncCallBlocking() {
    log.info("syncCallBlocking");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      log.error("", e);
      throw new RuntimeException(e);
    }
    return Map.of("blocking", "blocked");
  }

}
