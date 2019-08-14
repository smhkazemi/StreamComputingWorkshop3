// Hash.java
// Hash class
// awirth for COMP90056
// Aug 2017,8,9

import edu.princeton.cs.introcs.StdRandom;

public class AbstractHash {
	private int p = 24593; //smaller than 2^15
	private int a,b;		// only use for hash tables < 24593 in size
	
	public AbstractHash(){
		a = StdRandom.uniform(p-1)+1;	// choose random parameters
		b = StdRandom.uniform(p);
	}
	public int getHashFor(int x, int r){

		int y = (a*x+b) % p;
		return y % r;
	}
	
	public static int basicHashingFor(Object key){	    // if you only want the
	    return (key.hashCode() & 0x0000ffff);   // lower 16 bits
	}
	
	public static void main(String args[]){
		AbstractHash h = new AbstractHash();
		
		int h2 = h.getHashFor(100,20);
	}
}
