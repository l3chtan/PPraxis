public class AverageOperation extends FilterOperation {

	//protected BlockGenerator block;

	public AverageOperation(BlockGenerator block){
		super(block);
		//this.block = block;
	}

	public int filter(int[] values){
		
		double avg = 0;

		for(int i: values){
			avg += i;
		}
		return ((int)Math.round(avg/values.length));
	}
}
