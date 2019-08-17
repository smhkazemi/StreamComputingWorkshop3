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

    private static Long calculateChiSquare(String expectedValue, String actualValue){
        Long difference = Long.parseLong(expectedValue) - Long.parseLong(actualValue);
        return difference * difference / Long.parseLong(expectedValue);
    }

}
