import HashingMethods.UniversalHash;
import ServiceClasses.ChiSquareTest;

import java.util.HashMap;
import java.util.Random;

class UniversalHashTest {

    private static HashMap<Integer, Integer> indexFrequencies = new HashMap<Integer, Integer>();
    private static Integer[] hashingResults = new Integer[100];
    private static UniversalHash universalHash = new UniversalHash();
    private static Random random = new Random();

    static void doTest() throws Exception {
        random.setSeed(1239999999);
        for (int indexOnActualResults = 0; indexOnActualResults < 100;  indexOnActualResults++)
        {
            hashingResults[indexOnActualResults] =
                    universalHash.getHashFor(random.nextInt(), 10);
            if(!indexFrequencies.containsKey(hashingResults[indexOnActualResults]))
            {
                indexFrequencies.put(hashingResults[indexOnActualResults], 1);
            }
            else {
                swapNewAndOldValuesFor(hashingResults[indexOnActualResults]);
            }
        }
        ChiSquareTest.doTest(new Integer[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                indexFrequencies.values().toArray());
    }

    private static void swapNewAndOldValuesFor(Integer item)
    {
        int newValue  = indexFrequencies.get(item) + 1;
        indexFrequencies.remove(item);
        indexFrequencies.put(item, newValue);
    }
}
