package MorrisCounterDataStructure.MorrisCounter;

public class MorrisCounterLogger
{

    private static int numberOfRows;
    private static int numberOfColumns;

    public static void insertLogForDataStructureSize(MorrisCounterInterface[][] morrisCounterArray)
    {
        numberOfRows = morrisCounterArray.length;
        numberOfColumns = morrisCounterArray[0].length;

    }

    public static int[] getDataStructureSize()
    {
        return new int[]{numberOfRows, numberOfColumns};
    }

}