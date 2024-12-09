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
    private List<Thread> threads;
    private ExecutorService executorService;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
        this.threads = new ArrayList<>();
        for (Simulation simulation : simulations) {
            threads.add(new Thread(simulation));
        }
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void runAsyncInThreadPool(int threadPoolSize) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        for (Simulation simulation : simulations) {
            executorService.submit(simulation);
        }
    }

    public void awaitSimulationsEnd() {
        try{
            for(Thread thread : threads) {
                thread.join();
            }

            executorService.shutdown();
            if(!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
