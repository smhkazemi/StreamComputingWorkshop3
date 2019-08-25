package MorrisCounterDataStructure;

public class MorrisCounterLogger
{

    private static int numberOfRows;
    private static int numberOfColumns;

    static void insertLogForDataStructureSize(AbstractMorrisCounter[][] morrisCounterArray)
    {
        numberOfRows = morrisCounterArray.length;
        numberOfColumns = morrisCounterArray[0].length;

    }

    public static int[] getDataStructureSize()
    {
        return new int[]{numberOfRows, numberOfColumns};
    }

}