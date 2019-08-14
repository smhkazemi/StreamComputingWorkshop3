import java.util.Random;

class ReserviorTest {

    static void doTest() throws Exception {
        Reservoir reservoir;
        int samplingArraySize = 10; // for example -- feel free to change this!
        reservoir = new Reservoir(samplingArraySize);
        Random random = new Random();
        random.setSeed(1299999890);
        int range = 10000;
        for(int i = 0; i < range; i++)
        {
            reservoir.considerItem(random.nextInt(range) % range);
        }
        for(Object item : reservoir.report())
        {
            if((Integer) item > range)
                throw new Exception("item is larger than the range");
            if((Integer) item < -1)
                throw new Exception("item is less than -1" + " "  + "item  is: " + item);
        }
    }
}
