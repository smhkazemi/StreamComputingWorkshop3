import edu.princeton.cs.introcs.StdRandom;

public class MorrisCounter
{
    private int counter;
    private int power2;
    /* this is still an int, so doesn't technically pack into
    log log n bits, but illustrates the idea */

    MorrisCounter()
    {
        counter = 0;
        power2 = 1;
    }

    void increment()
    {
        if(StdRandom.uniform() < 1D / Math.pow(2, counter))
        {
            counter++;
            power2 *= 2;
        }
    }

    public int myCount()
    {
        return power2 - 1;
    }
}
