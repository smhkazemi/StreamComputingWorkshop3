package Distinct;

import HashingMethods.AbstractHash;

import java.util.Arrays;

public class AMSm implements DistinctInterface{
    private int zs[]; // array of z values
    private AbstractHash hashFunctions[]; // array of hash functions
    private int range = 536870912-3;//2^29-3
    //private int c=1835; //from the formula!
    private int c=18; //NOT from the formula!

    public AMSm(int n,int del1)
    {
        // set the values of n and k (latter from del1)
        // set up zs and hs
    }

    public static double getMedian(int[] data)
    {
        int[] copy = Arrays.copyOf(data, data.length);
        Arrays.sort(copy);
        if(hasOddLength(copy))
        {
            return copy[copy.length >> 1];
        }
        return (copy[copy.length >> 1] + copy[(copy.length >> 1) - 1]) >> 1;
    }

    private static boolean hasOddLength(int[] array)
    {
        return array.length % 2 != 0;
    }

    @Override
    public void addNewElementToTheCollection(Object newElement)
    {
        for(int i = 0; i < hashFunctions.length; i++)
        {
            int val = AbstractHash.basicHashingFor(newElement);
            // use the h2u from hs[i]

            // for each hash function, store the maximum number of
            // zeros seen
        }
    }

    @Override
    public double numberOfDistinctElements()
    {
        // use the fact that 2^(z+0.5) is monotonic to return median estimate
        return 0; //placeholder
    }
}
