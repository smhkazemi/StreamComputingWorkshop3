package ServiceClasses.ChiSquare;

import ServiceClasses.ChiSquare.TableCriticalValues.ChiSquareTableFirstImpl;

import java.util.Arrays;

public class ChiSquare {

    private static ChiSquareTableInterface chiSquareTable;
    private static double expectedProbabilityForChiSquare;

    static
    {
        chiSquareTable = new ChiSquareTableFirstImpl();
        expectedProbabilityForChiSquare = 0.1;
    }

    public static void doTest(Object[] expected, Object[] observed) throws Exception
    {
        if(!ChiSquare.passesTheTest(expected, observed))
        {
            throw new Exception("Could not pass the chiSquare test" + "\n expected: "
                    + Arrays.toString(expected) + "\n observed: " + Arrays.toString(observed));
        }
    }

    private static boolean passesTheTest(Object[] expectedValues, Object[] actualValues) throws Exception
    {
        if(expectedValues.length != actualValues.length)
        {
            throw new Exception("not equal length for expectedValues and actualValues");
        }
        Float chiSquare  = 0F;
        for(int index = 0; index < expectedValues.length; index++)
        {
            chiSquare += calculateChiSquare(expectedValues[index].toString(), actualValues[index].toString());
        }
        return chiSquareTable.probabilityOf(chiSquare, expectedValues.length) > expectedProbabilityForChiSquare;
    }

    private static Float calculateChiSquare(String expectedValue, String actualValue)
    {
        Float difference = Float.parseFloat(expectedValue) - Float.parseFloat(actualValue);
        return difference * difference / Float.parseFloat(expectedValue);
    }

}
