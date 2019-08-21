package ServiceClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class FrequencyOfOccurrence {
    private HashMap<Object, Integer> frequencyHolder;

    public FrequencyOfOccurrence()
    {
        frequencyHolder = new HashMap<>();
    }

    public void insertItem(Object newItem)
    {
        if(frequencyHolder.containsKey(newItem))
        {
            increaseFrequencyOf(newItem);
            return;
        }
        frequencyHolder.put(newItem, 1);
    }

    public ArrayList<Integer> reportAllFrequenciesInOrder()
    {
        ArrayList<Integer> result = new ArrayList<>(frequencyHolder.values());
        result.sort(Comparator.naturalOrder());
        return result;
    }

    private void increaseFrequencyOf(Object item)
    {
        int newValue  = frequencyHolder.get(item) + 1;
        frequencyHolder.remove(item);
        frequencyHolder.put(item, newValue);
    }
}
