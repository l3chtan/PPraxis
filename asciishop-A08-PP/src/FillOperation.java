public class FillOperation{

	private int x, y;
	private char c;

	public FillOperation(int x, int y, char c){
		this.x = x;
		this.y = y;
		this.c = c;
	}

	AsciiImage execute(AsciiImage img) throws OperationException{
	
		if(x < 0){
			throw new OperationException("x too small");
		}

		if(y < 0){
			throw new OperationException("y too small");
		}

		if(c == ' '){
			throw new OperationException("No character specified");
		}

		AsciiImage result = new AsciiImage(img);

		String temp = "";
		char rep = result.getPixel(x, y);

		result.setPixel(x,y,c);

		if(y<result.getHeight()-1 && result.getPixel(x, y+1) == rep){
			new FillOperation(x, y+1, c);
		}
		if(x<result.getWidth()-1 && result.getPixel(x+1, y) == rep){
			new FillOperation(x+1, y, c);
		}
		if(y>0 && result.getPixel(x, y-1) == rep){
			new FillOperation(x, y-1, c);
		}
		if(x>0 && result.getPixel(x-1, y) == rep){
			new FillOperation(x-1, y, c);
		}

		return result;
	}
}
