// Bloom.java
// Bloom filter class
// awirth for COMP90056
// Aug 2017,8,9

public class Bloom<Key>{
	private int lengthOfMembershipArray;
	private int numberOfHashFunctionsToUse;
	private Hash[] arrayOfHashFunctions;
	private boolean[] membershipArray;
	
	public Bloom(int lengthOfMembershipArray, int numberOfHashFunctionsToUse){
		this.lengthOfMembershipArray = lengthOfMembershipArray; // initialize lengthOfMembershipArray & numberOfHashFunctionsToUse
		this.numberOfHashFunctionsToUse = numberOfHashFunctionsToUse;
		membershipArray = new boolean[lengthOfMembershipArray];//initializes to false
		arrayOfHashFunctions = new Hash[numberOfHashFunctionsToUse]; // build an array of numberOfHashFunctionsToUse arrayOfHashFunctions functions
		for(int i = 0; i< numberOfHashFunctionsToUse; i++){
			arrayOfHashFunctions[i] = new Hash();
		}
	}
	
	public void insert(Key key){
		int h = Hash.basicHashingFor(key);
		for(Hash hashFunction : arrayOfHashFunctions){
			int hu = hashFunction.getHashFor(h, lengthOfMembershipArray);
			membershipArray[hu % lengthOfMembershipArray] = true;
		}
	}
	
	public boolean query(Key key){
		for(Hash hashFunction : arrayOfHashFunctions){
			int hu = hashFunction.getHashFor(Hash.basicHashingFor(key), lengthOfMembershipArray);
			if(!membershipArray[hu % lengthOfMembershipArray]){
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
		Bloom<String> sb = new Bloom(n,k);
		Bloom<Integer> si = new Bloom(n,k);
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
