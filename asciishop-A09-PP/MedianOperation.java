import java.util.Arrays;

public class MedianOperation extends FilterOperation{

	//protected BlockGenerator block;

	/**
	 * Konstruktor.
	 * Initialisiert diese Klasse.*/
	public MedianOperation(BlockGenerator block){
		super(block);
		//this.block = block;
	}

	public int filter(int[] values){

		Arrays.sort(values);
		return values[values.length/2];
	}
}
