import java.util.ArrayList;

public class GrowRegionOperation{

	private char c;

	public GrowRegionOperation(char c){
		this.c = c;	
	}

	AsciiImage execute(AsciiImage img) throws OperationException{

		if(img.getCharset().indexOf(c) < 0){
			throw new OperationException("Invalid char");
		}

		AsciiImage result = new AsciiImage(img);

		ArrayList<AsciiPoint> tmp = img.getPointList(c);

		int x=0, y=0;

		for(int p=0;p<tmp.size();p++){
			x=tmp.get(p).getX();
			y=tmp.get(p).getY();

			if(y<result.getHeight()-1 && result.getPixel(x,y+1) == '.'){
				result.setPixel(x,y+1,c);
			}
			if(x<result.getWidth()-1 && result.getPixel(x+1,y) == '.'){
				result.setPixel(x+1,y,c);
			}
			if(y>0 && result.getPixel(x,y-1) == '.'){
				result.setPixel(x,y-1,c);
			}
			if(x>0 && result.getPixel(x-1,y) == '.'){
				result.setPixel(x-1,y,c);
			}
		}

	return result;
	}
}
