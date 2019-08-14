import edu.princeton.cs.introcs.StdRandom;

public class UniversalHash extends AbstractHash {

    private int aLargePrimeNumber = 24593;  // smaller than 2^15
    private int firstCoefficient, secondCoefficient;    // only use for hash tables < 24593 in size

    public UniversalHash(){
        firstCoefficient = StdRandom.uniform(aLargePrimeNumber - 1) + 1;	// choose random parameters
        secondCoefficient = StdRandom.uniform(aLargePrimeNumber);
    }

    @Override
    public int getHashFor(int sampledNumber, int samplingArraySize){
        return (firstCoefficient * sampledNumber + secondCoefficient) % aLargePrimeNumber % samplingArraySize;
    }
}
