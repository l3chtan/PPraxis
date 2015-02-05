public class TransposeOperation{

	public TransposeOperation(){

	}

	//Ausführliches Testen notwendig! Hoch experimentel!
	AsciiImage execute(AsciiImage img){

		AsciiImage result = new AsciiImage(img.getHeight(),img.getWidth(),img.getCharset());

		//char[][] temp = new char[result.getHeight()][getWidth()];

		for(int n=0;n<result.getHeight();n++){
			for(int m=0;m<result.getWidth();m++){
				result.setPixel(m,n,img.getPixel(n,m));
			}
		}

		//result.picture = temp;

		//int cache = result.getHeight();
		//result.getHeight() = result.getWidth();
		//result.getWidth() = cache;
	return result; 
	}
}
