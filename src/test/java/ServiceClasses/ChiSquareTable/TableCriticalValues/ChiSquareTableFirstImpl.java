package ServiceClasses.ChiSquareTable.TableCriticalValues;

import ServiceClasses.ChiSquareTable.ChiSquareTableInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ChiSquareTableFirstImpl implements ChiSquareTableInterface {
    private ArrayList table;

    public ChiSquareTableFirstImpl()
    {
        table = new ArrayList<HashMap>();
        for(int num  = 0; num < 10; num++)
        {
            table.add(new HashMap<Float, Float>());
        }
        readTableData();
    }

    private void readTableData()
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(
                            "/Users/mokazemi-93/Downloads/IE_del/StreamComputingWorkshop3/src/test/java/" +
                                    "ServiceClasses/ChiSquareTable/TableCriticalValues/ChiSquareData.txt"
                            // ToDo: Fix addressing for the input file
                    )
            );
            String[] probabilities = bufferedReader.readLine().split(" ");
            int indexOnProbabilitiesArray = 0;
            for (Object rowInTable : table)
            {
                for (String itemInTableRow : bufferedReader.readLine().split(" "))
                {
                    ((HashMap)rowInTable).put(Float.parseFloat(itemInTableRow), Float.parseFloat(probabilities[indexOnProbabilitiesArray]));
                    indexOnProbabilitiesArray++;
                }
                indexOnProbabilitiesArray = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Float probabilityOf(Float chiTwo, int degreeOfFreedom){
        try {
            if(degreeOfFreedom > 10 || degreeOfFreedom < 1)
            {
                throw new Exception("Not supported degreeOfFreedom");
            }
            if (chiTwo < 0)
            {
                throw new Exception("Invalid ChiTwo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1F;
        }
        ArrayList keySet = new ArrayList(Arrays.asList((((HashMap) table.get(degreeOfFreedom - 1)).keySet().toArray())));
        keySet.sort(Comparator.naturalOrder());
        for(Object chiValue : keySet)
        {
            if(Math.abs(Float.parseFloat(chiValue.toString()) - chiTwo) < 1 || chiTwo < Float.parseFloat(chiValue.toString()))
            {
                return (Float) ((HashMap)table.get(degreeOfFreedom - 1)).get(chiValue);
            }
        }
        return -1F;
    }
}
