package ServiceClasses;

import ServiceClasses.ChiSquare.ChiSquare;

public class ChiSquareTest
{
    public static void doTest(Object[] expected, Object[] observed, double thresholdForDifferenceWithExpectedValue) throws Exception
    {
        if(thresholdForDifferenceWithExpectedValue > 1)
        {
            throw new Exception("threshold should be less than or equal to 1");
        }
        if(thresholdForDifferenceWithExpectedValue < 0)
        {
            throw new Exception("threshold should be more than or equal to 0");
        }
        if(!ChiSquare.passesTheTest(expected, observed))
        {
            throw new Exception("Could not pass the chiSquare test");
        }
    }

}