import HashingMethods.AbstractHash;
import HashingMethods.UniversalHash;

class BloomFilter<Key>{

	private int lengthOfMembershipArray;
	private AbstractHash[] arrayOfHashFunctions;
	private boolean[] membershipArray;
	
	BloomFilter(int lengthOfMembershipArray, int numberOfHashFunctionsToUse){
		this.lengthOfMembershipArray = lengthOfMembershipArray;
		membershipArray = new boolean[lengthOfMembershipArray];
		arrayOfHashFunctions = new AbstractHash[numberOfHashFunctionsToUse];
		for(int index = 0; index < numberOfHashFunctionsToUse; index++)
		{
			arrayOfHashFunctions[index] = new UniversalHash(24593);
		}
	}
	
	void insert(Key key)
	{
		int h = AbstractHash.basicHashingFor(key);
		for(AbstractHash hashFunction : arrayOfHashFunctions)
		{
			int hu = hashFunction.getHashFor(h, lengthOfMembershipArray);
			membershipArray[hu % lengthOfMembershipArray] = true;
		}
	}
	
	boolean query(Key key)
	{
		for(AbstractHash hashFunction : arrayOfHashFunctions)
		{
			int inRangeHashForKey = hashFunction.getHashFor(AbstractHash.basicHashingFor(key), lengthOfMembershipArray)
									% lengthOfMembershipArray;
			if(!membershipArray[inRangeHashForKey])
			{
				return false;
			}
		}
		return true;
	}
}
