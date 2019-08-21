import java.util.Random;

class ReserviorTest {

    private static Reservoir reservoir;
    private static Random random = new Random();

    static
    {
        int samplingArraySize = 10; // for example -- feel free to change this!
        reservoir = new Reservoir(samplingArraySize);
        random.setSeed(1299999890);
    }

    static void doTest() throws Exception {
        int rangeForGeneratedRandomNumber = 10000;
        for(int i = 0; i < rangeForGeneratedRandomNumber; i++)
        {
            reservoir.considerItem(random.nextInt(rangeForGeneratedRandomNumber) % rangeForGeneratedRandomNumber);
        }
        for(Object item : reservoir.report())
        {
            if((Integer) item > rangeForGeneratedRandomNumber)
                throw new Exception("item is larger than the rangeForGeneratedRandomNumber");
            if((Integer) item < -1)
                throw new Exception("item is less than -1" + " "  + "item  is: " + item);
        }
    }
}
