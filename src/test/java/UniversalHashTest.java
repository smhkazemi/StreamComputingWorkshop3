import HashingMethods.UniversalHash;
import ServiceClasses.ChiSquare;

import java.util.HashMap;
import java.util.Random;

class UniversalHashTest {

    private static HashMap<Integer, Integer> indexFrequencies = new HashMap();
    private static UniversalHash universalHash = new UniversalHash();
    private static Random random = new Random();

    static void doTest() throws Exception {
        random.setSeed(1239999999);
        int hashResult;
        for (int counter = 0; counter < 100;  counter++)
        {
            hashResult = universalHash.getHashFor(random.nextInt(), 10);
            if(!indexFrequencies.containsKey(hashResult))
            {
                indexFrequencies.put(hashResult, 1);
            }
            else {
                incrementValueFor(hashResult);
            }
        }
        ChiSquare.doTest(new Integer[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                indexFrequencies.values().toArray());
    }

    private static void incrementValueFor(Integer item)
    {
        int newValue  = indexFrequencies.get(item) + 1;
        indexFrequencies.remove(item);
        indexFrequencies.put(item, newValue);
    }
}
