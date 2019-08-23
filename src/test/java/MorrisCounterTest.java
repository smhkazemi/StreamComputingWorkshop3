import ServiceClasses.ChiSquare.ChiSquare;

import java.util.Arrays;

class MorrisCounterTest
{
    static void doTest(String[] args)
    {
        int exactNumberOfAnItemInTheStream = Integer.parseInt(args[0]);
        int numberOfMorrisCounters = Integer.parseInt(args[1]);
        MorrisCounter[] morrisCounters = new MorrisCounter[numberOfMorrisCounters];
        Integer[] expectedResults = new Integer[numberOfMorrisCounters];
        Integer[] results = new Integer[numberOfMorrisCounters];
        for(int indexOnMorrisCounters = 0; indexOnMorrisCounters < numberOfMorrisCounters; indexOnMorrisCounters++)
        {
            morrisCounters[indexOnMorrisCounters] = new MorrisCounter();
        }
        for(int counter = 0; counter < exactNumberOfAnItemInTheStream; counter++)
        {
            for(MorrisCounter itemInArray : morrisCounters)
            {
                itemInArray.increment();
            }
        }
        for(int indexOnMorrisCounterArray = 0; indexOnMorrisCounterArray < numberOfMorrisCounters;
            indexOnMorrisCounterArray++)
        {
            expectedResults[indexOnMorrisCounterArray] = exactNumberOfAnItemInTheStream;
            results[indexOnMorrisCounterArray] =
                    morrisCounters[indexOnMorrisCounterArray].estimatedCount();
        }
        try {
            ChiSquare.doTest(expectedResults, results);
        }catch (Exception e) {
            System.out.println("numberOfMorrisCounters: " + numberOfMorrisCounters
                    + " exactNumberOfAnItemInTheStream: " + exactNumberOfAnItemInTheStream);
            System.out.println("expected: " + Arrays.toString(expectedResults)
                    + " \nfound: " + Arrays.toString(results));
        }
    }
}
