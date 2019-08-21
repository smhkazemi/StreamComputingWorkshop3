import ServiceClasses.FrequencyOfOccurrence;

import java.util.HashMap;
import java.util.Random;

class ReserviorTest {

    private static Reservoir reservoir;
    private static Random random;
    private static FrequencyOfOccurrence frequencyOfItems;
    private static int samplingArraySize;
    private static int rangeOfNumbersInStream;

    static
    {
        samplingArraySize = 10; // for example -- feel free to change this!
        reservoir = new Reservoir(samplingArraySize);
        random = new Random();
        random.setSeed(1299999890);
        frequencyOfItems  = new FrequencyOfOccurrence();
        rangeOfNumbersInStream = 10000;
    }

    static void doTest() throws Exception {
        HashMap<Integer, Boolean> randomlyGeneratedStream =
                generateARandomStream(rangeOfNumbersInStream);;
        checkRangeAndValidityOfSamples(randomlyGeneratedStream);
        checkForSimilarSamples();
    }

    private static void checkForSimilarSamples() throws Exception {
        for(Integer frequency : frequencyOfItems.reportAllFrequenciesInOrder())
        {
            if(frequency > (samplingArraySize >> 1))
            {
                throw new Exception("An item has been sampled more than half of samplingArraySize that is: "
                + samplingArraySize);
            }
        }
    }

    private static void checkRangeAndValidityOfSamples(HashMap<Integer, Boolean> randomlyGeneratedStream) throws Exception {
        for(Object item : reservoir.report())
        {
            if((Integer) item > rangeOfNumbersInStream)
                throw new Exception("item is larger than the rangeForGeneratedRandomNumber");
            if((Integer) item < -1)
                throw new Exception("item is less than -1" + " "  + "item  is: " + item);
            if(!randomlyGeneratedStream.containsKey(item))
                throw new  Exception("item: " + item + " has never been produced");
            frequencyOfItems.insertNewItem(item); // Has been placed here to avoid writing another 'for' loop
        }
    }

    private static HashMap<Integer, Boolean> generateARandomStream(int rangeForGeneratedRandomNumber) {
        HashMap<Integer, Boolean> result  = new HashMap<>();
        int tempRandomlyGeneratedNumber;
        for(int counter = 0; counter < 10000; counter++)
        {
            tempRandomlyGeneratedNumber = random.nextInt(rangeForGeneratedRandomNumber) % rangeForGeneratedRandomNumber;
            result.put(tempRandomlyGeneratedNumber, true);
            reservoir.considerItem(tempRandomlyGeneratedNumber);
        }
        return result;
    }
}
