import java.util.Random;

class ReserviorTest {

    private static Reservoir reservoir;
    private static int samplingArraySize = 10; // for example -- feel free to change this!
    private static Random random = new Random();

    static
    {
        reservoir = new Reservoir(samplingArraySize);
    }

    static void doTest() throws Exception {
        random.setSeed(1299999890);
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
