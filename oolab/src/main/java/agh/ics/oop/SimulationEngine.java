package agh.ics.oop;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SimulationEngine {
    final private List<Simulation> simulations;
    private List<Future<?>> futures;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
        this.futures = new ArrayList<>();
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Simulation simulation : simulations) {
            futures.add(executorService.submit(simulation));
        }
        executorService.shutdown();
    }

    public void runAsyncInThreadPool(int threadPoolSize) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        for (Simulation simulation : simulations) {
            futures.add(executorService.submit(simulation));
        }
        executorService.shutdown();
    }

    public void awaitSimulationsEnd() {
        try {
            Instant deadline = Instant.now().plus(10, ChronoUnit.SECONDS);
            for (Future<?> future : futures) {
                if (Instant.now().isAfter(deadline)) {
                    throw new TimeoutException();
                }
                future.get(Duration.between(Instant.now(), deadline).toNanos(), TimeUnit.NANOSECONDS);
            }
        } catch (TimeoutException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            for (Future<?> future : futures) {
                future.cancel(true);
            }
        }
    }
}
