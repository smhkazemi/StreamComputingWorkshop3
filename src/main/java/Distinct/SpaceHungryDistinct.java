package Distinct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class SpaceHungryDistinct implements DistinctInterface {
    private HashMap<Object, Integer> distinctItems;

    public SpaceHungryDistinct()
    {
        distinctItems = new HashMap<>();
    }

    @Override
    public void add(Object newItem)
    {
        if(distinctItems.containsKey(newItem))
        {
            increaseFrequencyOf(newItem);
            return;
        }
        distinctItems.put(newItem, 1);
    }

    @Override
    public double distinct()
    {
        return distinctItems.keySet().size();
    }

    public ArrayList<Integer> reportAllFrequenciesInOrder()
    {
        ArrayList<Integer> result = new ArrayList<>(distinctItems.values());
        result.sort(Comparator.naturalOrder());
        return result;
    }

    private void increaseFrequencyOf(Object item)
    {
        int newValue  = distinctItems.get(item) + 1;
        distinctItems.remove(item);
        distinctItems.put(item, newValue);
    }
}
