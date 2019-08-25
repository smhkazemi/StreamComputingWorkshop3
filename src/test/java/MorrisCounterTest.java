import MorrisCounterDataStructure.MorrisCounterDataStructure;
import MorrisCounterDataStructure.MorrisCounterLogger;

class MorrisCounterTest
{
    static void doTest(String[] args) throws Exception {
        int exactNumberOfAnItemInTheStream = 1000 * Integer.parseInt(args[0]);
        MorrisCounterDataStructure morrisCounterDataStructure =
                new MorrisCounterDataStructure(0.01D, 1D / 20D);
        int[] sizeOfDataStructure = MorrisCounterLogger.getDataStructureSize();
        if(sizeOfDataStructure[0] != (int) (12D * Math.log(100D)) + 1)
            throw new Exception("Invalid number of rows in MorrisCounterDataStructure." +
                    " Expected: " + (int) (12D * Math.log(100D)) + 1 + ", found: " + sizeOfDataStructure[0]);
        if(sizeOfDataStructure[1] != (int) (2D / (0.05D * 0.05D)) + 1)
            throw new Exception("Invalid number of columns in MorrisCounterDataStructure." +
                    " Expected: " + (int) (2D / (0.05D * 0.05D)) + 1 + ", found: " + sizeOfDataStructure[1]);
        for(int counter =  0; counter < exactNumberOfAnItemInTheStream; counter++)
        {
            morrisCounterDataStructure.increment();
        }
        System.out.println("Estimated: " + morrisCounterDataStructure.getEstimate()
                + "\nActual: " + exactNumberOfAnItemInTheStream);
    }
}
