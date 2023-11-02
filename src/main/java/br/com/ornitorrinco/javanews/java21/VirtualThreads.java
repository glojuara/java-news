package br.com.ornitorrinco.javanews.java21;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.*;

// JEP 444: Virtual Threads
public class VirtualThreads {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int numberOfProcess = 20000;

//        ExecutorService executor = Executors.newFixedThreadPool(numberOfProcess);
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        LocalDateTime start = LocalDateTime.now();


        /*
        List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfProcess; i++) {
            futures.add(executor.submit(() -> new Process().run()));
        }

         */

        Future<Long> contadorDePendencias = executor.submit(() -> new Process().run());
        Future<Long> contadorDeConversas = executor.submit(() -> new Process().run());
        Future<Long> contadorDeNotificacoes = executor.submit(() -> new Process().run());

        shutdownAndAwaitTermination(executor);

        long total = contadorDePendencias.get() + contadorDeConversas.get() + contadorDeNotificacoes.get();


        /*
        Long total = futures.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).reduce(0L, Long::sum);

         */


        LocalDateTime end = LocalDateTime.now();
        System.out.println("Tempo de execução: " + ChronoUnit.SECONDS.between(start, end) + " segundos");
        System.out.println("Resultado final: " + total);


    }

    private static void shutdownAndAwaitTermination(ExecutorService pool) {
        // Disable new tasks from being submitted
        pool.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                // Cancel currently executing tasks forcefully
                pool.shutdownNow();
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    private static class Process {


        public Long run() {
            Long random = (long) (Math.random() * 10);
            System.out.println(random);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                return random;
            }
            return random;
        }


    }

}



