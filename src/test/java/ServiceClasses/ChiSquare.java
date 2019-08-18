package ServiceClasses;

import ServiceClasses.ChiSquareTable.TableCriticalValues.ChiSquareTableFirstImpl;
import ServiceClasses.ChiSquareTable.ChiSquareTableInterface;

class ChiSquare {
    private static ChiSquareTableInterface chiSquareTableInterface;
    private static double expectedProbabilityForChiSquare;

    static {
        chiSquareTableInterface = new ChiSquareTableFirstImpl();
        expectedProbabilityForChiSquare = 0.1;
    }

    static boolean passesTheTest(Object[] expectedValues, Object[] actualValues) throws Exception {
        if(expectedValues.length != actualValues.length)
            throw new Exception("not equal length for expectedValues and actualValues");
        Float chiSquare  = 0F;
        for(int index = 0; index < expectedValues.length; index++)
        {
            chiSquare += calculateChiSquare(expectedValues[index].toString(), actualValues[index].toString());
        }
        return chiSquareTableInterface.probabilityOf(chiSquare, expectedValues.length) > expectedProbabilityForChiSquare;
    }

    private static Float calculateChiSquare(String expectedValue, String actualValue){
        Float difference = Float.parseFloat(expectedValue) - Float.parseFloat(actualValue);
        return difference * difference / Float.parseFloat(expectedValue);
    }

}
