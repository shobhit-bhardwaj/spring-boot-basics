package com.shobhit.reactive.dao;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.shobhit.reactive.model.Employ;

import reactor.core.publisher.Flux;

@Repository
public class EmployDao {

	public List<Employ> getEmploysStream() {
		return IntStream.rangeClosed(1, 20)
			.peek(id -> {
				System.out.println("Processing Stream Id - " + id);
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			})
			.mapToObj(i -> new Employ(i, "name-" + i, "designation-" + i, i*1000))
			.toList();
	}

	public Flux<Employ> getEmploysFlux() {
		return Flux.range(1, 20)
			.doOnNext(id -> System.out.println("Processing Flux Id - " + id))
			.delayElements(Duration.of(500, ChronoUnit.MILLIS))
			.map(i -> new Employ(i, "name-" + i, "designation-" + i, i*1000));
	}
}
