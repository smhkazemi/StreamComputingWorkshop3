package ServiceClasses;

public class ChiSquareTest
{
    public static void doTest(Object[] expected, Object[] observed) throws Exception
    {
        if(!ChiSquare.passesTheTest(expected, observed))
        {
            throw new Exception("Could not pass the chiSquare test");
        }
    }

}