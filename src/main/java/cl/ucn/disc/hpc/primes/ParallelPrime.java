package cl.ucn.disc.hpc.primes;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class to find prime number with the use of threads.
 *
 * @author Nicolas
 */
@Slf4j
public final class ParallelPrime {
    /**
     * The main
     * @param args to use.
     */

    /**
     * The counter of primes.
     */
    private static final AtomicInteger counter = new AtomicInteger(0);

    /**
     * The main method.
     * @param args arg used
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //Finding the max numbers of cores available.
        final int  maxCores= Runtime.getRuntime().availableProcessors();

        //Starting number
        final long ini = 2;
        //Ending number
        final long end = 40*1000*1000;

        //Number of repetitions per core
        final long numberOfRepetitions =10 ;

        List<Long> times = new ArrayList<>();

        for(int m = 1 ; m<=maxCores; m++){


            times.clear();
            log.info("Finding primes number from {} to {} with {} cores", ini, end, m);
            for(int i = 0 ; i < numberOfRepetitions; i++){
                counter.set(0);
                long time = findPrimesWithMultipleCores(m, ini, end);
                times.add(time);
            }
            //Obtain the max and min of the list
            long min = Collections.min(times);
            long max = Collections.max(times);

            log.debug("The min is: {} ms", min);
            log.debug("The max is: {} ms", max);

            //Remove the max and min of the list
            times.remove(min);
            times.remove(max);

            //Obtain the average time.
            double average = times.stream().mapToLong((n)->n).average().getAsDouble();
            log.debug("The average time is : {} ms", average);



        }
        //The executor of threads.


    }

    /**
     * Given a starting and ending number, calculate the amount of the primes between and return the time spent
     * used.
     * @param cores number of cores used.
     * @param ini starting number of the sequence
     * @param end ending number of the sequence.
     * @return the time spent to calculate the primes in that sequence.
     * @throws InterruptedException
     */
    private static long findPrimesWithMultipleCores(int cores, long ini, long end) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(cores);



        StopWatch sw = StopWatch.createStarted();


        for( long n = ini ; n<end ; n++) {
            long i = n;
            executorService.submit(() -> {
                if(isPrime(i)){
                    counter.incrementAndGet();
                }
            });
        }

        int maxTime = 1;
        executorService.shutdown();
        long time = sw.getTime(TimeUnit.MILLISECONDS);
        if(executorService.awaitTermination(maxTime, TimeUnit.MINUTES)){
            log.info("Founded {} primes between {} and {}  in {} ms.",counter.get(),ini,end,time);
        } else {
            log.warn("The executor didn't finish in {} minutes", maxTime);
        }
        return time;

    }

    /**
     * Check if a number is primer or not.
     * @param number number to be checked
     * @return True if the number is primer, false otherwise.
     */
    private static boolean isPrime(final long number) {

        if(number<=0) {
            throw new IllegalArgumentException("Error in number: cannot process negative numbers");
        }
        if(number==1) {
            return false;
        }
        if(number==2) {
            return true;
        }
        if(number%2==0){
            return false;
        }

        for(long i=3; (i*i) <= number ; i+=2) {
            if (number%i == 0){
                return false;
            }

        }
        return true;
    }
}
