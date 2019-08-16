package ServiceClasses.ChiSquare;

import java.util.HashMap;

public class ChiSquareTableFirstImpl implements ChiSquareTableInterface {
    private HashMap[] table;

    ChiSquareTableFirstImpl() {
        table = new HashMap[10];
        for(int i = 0; i < table.length; i++)
        {
            table[i] = new HashMap<Long, Long>();
        }
    }

    public long probabilityOf(long ChiTwo, int degreeOfFreedom) {
        return 0;
    }
}
