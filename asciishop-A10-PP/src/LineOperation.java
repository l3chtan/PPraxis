public class LineOperation implements Operation{

	private int x0, y0, x1, y1;
	private char c;

	public LineOperation(int x0, int y0, int x1, int y1, char c){
		this.x0 = x0;	
		this.y0 = y0;	
		this.x1 = x1;	
		this.y1 = y1;	
		this.c = c;
	}


	public AsciiImage execute(AsciiImage img) throws OperationException{

		if(x0<0 || y0<0){
			throw new OperationException("x and/or y is too small");
		}
		if(x1>img.getWidth() || y1>img.getHeight()){
			throw new OperationException("x and/or y is too large");
		}
		if(c == ' '){
			throw new OperationException("No character specified");
		}

		AsciiImage result = new AsciiImage(img);
		//	public void drawLine(int x0, int y0, int x1, int y1, char c){
		double dx = 0.0;
		double dy = 0.0;
		int cache = 0;
		boolean turn = false;

		double steigung = 0.0;
		double y = 0;

		if(Math.abs(y1-y0)>Math.abs(x1-x0)){

			cache = x0;
			x0 = y0;
			y0 = cache;

			cache = x1;
			x1 = y1;
			y1 = cache;
			turn = true;
		}

		if(x1<x0){

			cache = x0;
			x0 = x1;
			x1 = cache;

			cache = y0;
			y0 = y1;
			y1 = cache;
		}

		y = y0;

		dx = x1-x0;
		dy = y1-y0;
		steigung = dy/dx;

		for(int x=x0;x<=x1;x++){
			if(turn == false){
				result.setPixel(x, (int)Math.round(y),c);
			} else {
				result.setPixel((int)Math.round(y), x, c);
			}
			y += steigung;
		}
		return result;
	}
}
