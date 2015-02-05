public class PlateStack {

	private Plate first, other, tmp;
	private String out;

	public PlateStack(){
		this.first = null;
		this.other = null;
		this.tmp = null;
		this.out = "";
	}

	public void push(Plate plate){
		if(this.first == null){
			this.first = plate;
		} else {
			if(this.other == null){
				first.putOn(plate);
				this.other = plate;
			} else {
				this.other.putOn(plate);
				this.other = plate;
				/*if(this.other.next() == null){
					System.out.printf("null\n");
				} else {
					System.out.printf("%s\n",other.next().toString());
				}*/
			}
		}
		this.tmp = plate;
		//System.out.println(plate.toString());
	}

	public String toString(){
		//String out = "";

		if(this.tmp != null){
			//System.out.printf("Huhu!\n");
		out += this.tmp.toString(); 
		/*if(other.next() == null){
			System.out.printf("null\n");
		}*/
		this.tmp = this.tmp.next();		
		toString();
		}
		return out;
	}
}
