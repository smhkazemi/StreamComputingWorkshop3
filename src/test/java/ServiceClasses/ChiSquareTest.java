package ServiceClasses;

import java.util.Arrays;

public class ChiSquareTest
{
    public static void doTest(Object[] expected, Object[] observed) throws Exception
    {
        if(!ChiSquare.passesTheTest(expected, observed))
        {
            throw new Exception("Could not pass the chiSquare test" + "\n expected: "
                    + Arrays.toString(expected) + "\n observed: " + Arrays.toString(observed));
        }
    }

}