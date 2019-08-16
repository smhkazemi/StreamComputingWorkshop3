package ServiceClasses.ChiSquare;

public class ChiSquare {
    private static ChiSquareTableInterface chiSquareTableInterface;
    private static double expectedProbabilityForChiSquare;

    static {
        chiSquareTableInterface = new ChiSquareTableFirstImpl();
        expectedProbabilityForChiSquare = 0.1;
    }

    public static boolean passesTheTest(Object[] expectedValues, Object[] actualValues) throws Exception {
        if(expectedValues.length != actualValues.length)
            throw new Exception("not equal length for expectedValues and actualValues");
        long chiSquare  = 0L;
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
