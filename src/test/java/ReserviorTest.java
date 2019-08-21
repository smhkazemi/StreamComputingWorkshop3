import java.util.HashMap;
import java.util.Random;

class ReserviorTest {

    private static Reservoir reservoir;
    private static Random random;

    static
    {
        int samplingArraySize = 10; // for example -- feel free to change this!
        reservoir = new Reservoir(samplingArraySize);
        random = new Random();
        random.setSeed(1299999890);
    }

    static void doTest() throws Exception {
        int rangeForGeneratedRandomNumber = 10000;
        HashMap<Integer, Boolean> restOfTheStream = new HashMap<>();
        int tempRandomlyGeneratedNumber;
        for(int counter = 0; counter < rangeForGeneratedRandomNumber; counter++)
        {
            tempRandomlyGeneratedNumber = random.nextInt(rangeForGeneratedRandomNumber) % rangeForGeneratedRandomNumber;
            restOfTheStream.put(tempRandomlyGeneratedNumber, true);
            reservoir.considerItem(tempRandomlyGeneratedNumber);
        }
        for(Object item : reservoir.report())
        {
            if((Integer) item > rangeForGeneratedRandomNumber)
                throw new Exception("item is larger than the rangeForGeneratedRandomNumber");
            if((Integer) item < -1)
                throw new Exception("item is less than -1" + " "  + "item  is: " + item);
            if(!restOfTheStream.containsKey(item))
                throw new  Exception("item: " + item + " has never been produced");
        }
    }
}
