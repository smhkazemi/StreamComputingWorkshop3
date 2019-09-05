import HashingMethods.UniversalHash;
import ServiceClasses.ChiSquare.ChiSquare;
import Distinct.SpaceHungryDistinctAndFrequency;

import java.util.Random;

class UniversalHashTest {

    private static SpaceHungryDistinctAndFrequency frequencyOfItems = new SpaceHungryDistinctAndFrequency();
    private static UniversalHash universalHash = new UniversalHash(24593);
    private static Random random = new Random();

    static void doTest() throws Exception {
        random.setSeed(1239999999);
        int hashResult;
        for (int counter = 0; counter < 100;  counter++)
        {
            hashResult = universalHash.getHashFor(random.nextInt(), 10);
            frequencyOfItems.addNewElementToTheCollection(hashResult);
        }
        ChiSquare.doTest(new Integer[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                frequencyOfItems.reportAllFrequenciesInOrder().toArray());
    }
}
