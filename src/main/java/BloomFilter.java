
public class BloomFilter<Key>{

	private int lengthOfMembershipArray;
	private AbstractHash[] arrayOfHashFunctions;
	private boolean[] membershipArray;
	
	public BloomFilter(int lengthOfMembershipArray, int numberOfHashFunctionsToUse){
		this.lengthOfMembershipArray = lengthOfMembershipArray;
		membershipArray = new boolean[lengthOfMembershipArray];
		arrayOfHashFunctions = new AbstractHash[numberOfHashFunctionsToUse];
		for(int index = 0; index < numberOfHashFunctionsToUse; index++)
		{
			arrayOfHashFunctions[index] = new UniversalHash();
		}
	}
	
	public void insert(Key key)
	{
		int h = AbstractHash.basicHashingFor(key);
		for(AbstractHash AbstractHashFunction : arrayOfHashFunctions)
		{
			int hu = AbstractHashFunction.getHashFor(h, lengthOfMembershipArray);
			membershipArray[hu % lengthOfMembershipArray] = true;
		}
	}
	
	public boolean query(Key key)
	{
		for(AbstractHash AbstractHashFunction : arrayOfHashFunctions)
		{
			int inRangeHashForKey = AbstractHashFunction.getHashFor(AbstractHash.basicHashingFor(key), lengthOfMembershipArray)
									% lengthOfMembershipArray;
			if(!membershipArray[inRangeHashForKey])
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){ //for testing
		if(args.length != 2){
			System.err.println("should be two arguments: lengthOfMembershipArray numberOfHashFunctionsToUse");
			System.exit(0);
		}
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);


		String ss[] = {"Tony","Matthias","Yadeesha","Shuo"};
		int m=100;
		BloomFilter<String> sb = new BloomFilter(n,k);
		BloomFilter<Integer> si = new BloomFilter(n,k);
		for(String s:ss){
			sb.insert(s);
		}
		for(String s:ss){
			if(sb.query(s)){
				System.out.println("Yes: "+s);
			}
		}
		for(int i = 0;i<m;i+=3){
			si.insert(i);
		}
		for(int i = 0;i<m;i++){
			if(si.query(i) && i %3 != 0){
				System.out.println("Yes: "+i);
			}
		}
	}
}
