package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimulationEngine {
    final private List<Simulation> simulations;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        ExecutorService executorService = Executors.newFixedThreadPool(simulations.size());
        List<Future<?>> futures = new ArrayList<>();

        for (Simulation simulation : simulations) {
            futures.add(executorService.submit(simulation));
        }
        awaitSimulationsEnd(futures);
        executorService.shutdown();
    }

    public void runAsyncWithThreadPool(int threadPoolSize) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        List<Future<?>> futures = new ArrayList<>();

        for (Simulation simulation : simulations) {
            futures.add(executorService.submit(simulation));
        }
        awaitSimulationsEnd(futures);
        executorService.shutdown();
    }

    private void awaitSimulationsEnd(List<Future<?>> futures) {
        try {
            for (Future<?> future : futures) {
                future.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
