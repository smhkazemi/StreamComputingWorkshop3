import MorrisCounter.MorrisCounterDataStructure;

class MorrisCounterTest
{
    static void doTest(String[] args)
    {
        int exactNumberOfAnItemInTheStream = Integer.parseInt(args[0]);
        MorrisCounterDataStructure morrisCounterDataStructure =
                new MorrisCounterDataStructure(0.01, 1D / 20D);
        for(int counter =  0; counter < exactNumberOfAnItemInTheStream; counter++)
        {
            morrisCounterDataStructure.increment();
        }
        System.out.println("Estimated: " + morrisCounterDataStructure.getEstimate()
                + "\nActual: " + exactNumberOfAnItemInTheStream);
    }
}