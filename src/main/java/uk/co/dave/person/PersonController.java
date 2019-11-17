package uk.co.dave.person;

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
public class PersonController {

  private PersonRepository personRepository;
 
  @GetMapping(value = "/non-blocking", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Map<String, String>> nonBlocking() {
    log.info("enter nonBlocking()");
    Mono<Map<String, String>> result = Mono.just(Map.of("quick", "response"));
    log.info("exit nonBlocking()");
    return result;
  }

  

}
