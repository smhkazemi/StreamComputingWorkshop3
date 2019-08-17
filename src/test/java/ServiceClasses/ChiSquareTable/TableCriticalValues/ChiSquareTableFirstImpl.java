package ServiceClasses.ChiSquareTable.TableCriticalValues;

import ServiceClasses.ChiSquareTable.ChiSquareTableInterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class ChiSquareTableFirstImpl implements ChiSquareTableInterface {
    private HashMap[] table;

    public ChiSquareTableFirstImpl()
    {
        table = new HashMap[10];
        Arrays.fill(table, new HashMap<Long, Long>());
        readTableData();
    }

    private void readTableData()
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(
                            "/Users/mokazemi-93/Downloads/IE_del/StreamComputingWorkshop3/src/test/java/ServiceClasses/ChiSquareTable/TableCriticalValues/ChiSquareData.txt"
                    )
            );
            String[] probabilities = bufferedReader.readLine().split(" ");
            int indexOnProbabilitiesArray = 0;
            for(HashMap line : table)
            {
               for(String itemInTableLine : bufferedReader.readLine().split(" "))
               {
                   line.put(Long.parseLong(itemInTableLine), Long.parseLong(probabilities[indexOnProbabilitiesArray]));
               }
               indexOnProbabilitiesArray++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Long probabilityOf(long chiTwo, int degreeOfFreedom){
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
            return -1L;
        }
        for(Object chiValue : table[degreeOfFreedom - 1].keySet())
        {
            if(Math.abs((Long) chiValue - chiTwo) < 1 )
            {
                return (Long) table[degreeOfFreedom - 1].get(chiValue);
            }
        }
        return -1L;
    }
}
