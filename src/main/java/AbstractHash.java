
public class AbstractHash {

	public int getHashFor(int intKey, int range){
		return range;
	}
	
	static int basicHashingFor(Object key){	    // if you only want the
	    return (key.hashCode() & 0x0000ffff);   // lower 16 bits
	}
	
//	public static void main(String args[]){
//		AbstractHash h = new AbstractHash();
//
//		int h2 = h.getHashFor(100,20);
//	}
}
