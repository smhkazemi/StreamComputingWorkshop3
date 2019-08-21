class MorrisCounterTest
{
    static void doTest(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        MorrisCounter[] morrisCounters = new MorrisCounter[k];
        for(int indexOnMorrisCounters = 0; indexOnMorrisCounters < k; indexOnMorrisCounters++)
        {
            morrisCounters[indexOnMorrisCounters] = new MorrisCounter();
        }
        for(int counter = 0; counter < n; counter++)
        {
            for(MorrisCounter itemInArray : morrisCounters)
            {
                itemInArray.increment();
                // ToDo: add exceptions
                // System.out.println("actual "+i+" Morris["+j+"]"+ morrisCounters[j].myCount());
            }
        }
    }
}
