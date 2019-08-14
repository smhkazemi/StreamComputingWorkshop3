
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
			arrayOfHashFunctions[index] = new UniversalHash();
		}
	}
	
	void insert(Key key)
	{
		int h = AbstractHash.basicHashingFor(key);
		for(AbstractHash AbstractHashFunction : arrayOfHashFunctions)
		{
			int hu = AbstractHashFunction.getHashFor(h, lengthOfMembershipArray);
			membershipArray[hu % lengthOfMembershipArray] = true;
		}
	}
	
	boolean query(Key key)
	{
		for(AbstractHash AbstractHashFunction : arrayOfHashFunctions)
		{
			int inRangeHashForKey = AbstractHashFunction.getHashFor(AbstractHash.basicHashingFor(key), lengthOfMembershipArray)
									% lengthOfMembershipArray;
			if(!membershipArray[inRangeHashForKey])
			{
				return true;
			}
		}
		return false;
	}
}
