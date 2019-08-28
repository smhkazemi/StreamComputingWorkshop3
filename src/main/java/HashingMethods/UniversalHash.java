package HashingMethods;

import edu.princeton.cs.introcs.StdRandom;

public class UniversalHash extends AbstractHash {

    private int aLargePrimeNumber;
    private int firstCoefficient, secondCoefficient;

    public UniversalHash(int primNumber){
        aLargePrimeNumber = primNumber;
        firstCoefficient = StdRandom.uniform(aLargePrimeNumber - 1) + 1;
        secondCoefficient = StdRandom.uniform(aLargePrimeNumber);
    }

    @Override
    public Integer getHashFor(Object key, Object rangeForHashingResult){
        int result = ((firstCoefficient * Integer.parseInt(key.toString()) + secondCoefficient) % aLargePrimeNumber)
                % Integer.parseInt(rangeForHashingResult.toString());
        return (result >= 0) ? result : result + Integer.parseInt(rangeForHashingResult.toString());
    }
}
