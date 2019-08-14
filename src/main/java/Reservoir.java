

public class Reservoir{
	private int[] sampleArray;
	private int streamLength = 0;
	private int numberOfSamplesToStoreFromTheStream;
	
	public Reservoir(int numberOfSamplesToStoreFromTheStream){
	    // constructor
	}
	
	public void considerItem(int x){
		// to make things a bit simpler, focus on the case of sampling numberOfSamplesToStoreFromTheStream integers from a stream
	}
	
	public int report(int S[]){
		// tell us what's inside, by copying into S
		// use the returned int to say how many integers are in the sample! (what if n<numberOfSamplesToStoreFromTheStream?!)
		
		// actually, this is a very ugly C-style way of doing this.
		return 0;
	}
	
	public static void main(String args[]){
		int i;
		Reservoir r;
		int f;
		int k = 10; // for example -- feel free to change this!
		int S[] = new int[k];
		
		r = new Reservoir(k);

		// How do you test your code?
	}
}
