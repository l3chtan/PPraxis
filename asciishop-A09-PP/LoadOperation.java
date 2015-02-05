import java.util.Scanner;

public class LoadOperation implements Operation{

	private String data;
	
	/**
	 * Konstruktor.
	 * Speichert den übergebenen String in eine Klassenvariable.
	 * @param data Das eingelesene Bild als String.*/
	public LoadOperation(String data){
		this.data = data;
	}
	
	/**
	 * Lädt das Bild.
	 * Von dem erzeugten AsciiImage wird eine Kopie erstellt.
	 * Die Kopie wird mit dem eingelesenen Bild Zeichen für Zeichen überschrieben.
	 * @param img Das übergebene AsciiImage.
	 * @return Ein AsciiImage Objekt, das den Bildinhalt der Eingabe enthält.*/
	public AsciiImage execute(AsciiImage img) throws OperationException {

		Scanner lines = new Scanner(data);
		AsciiImage result = new AsciiImage(img);
		int width = 0;
		int height = result.getHeight();
		int cnt = 0;
		String line = "";


		while(line.length() == width && lines.hasNext()){		

			width = result.getWidth();
			line = lines.next();

			if(line.length() < width){
				throw new OperationException("Bild zu schmal in Zeile: " + (cnt+1));
			} else if(line.length() > width){
				throw new OperationException("Bild zu breit in Zeile: " + (cnt+1));
			}

			for(int i=0;i<width;i++){
				if(result.getCharset().indexOf(line.charAt(i))<0){
					throw new OperationException("Zeichen an der Position (" + i + ", " + cnt + ") ist nicht erlaubt.");
				}
				if(cnt < height){
					result.setPixel(i,cnt,line.charAt(i));
				} else {
					throw new OperationException("Bild zu groß");
				} 
			}
			cnt++;
		}

		if(cnt < height-1){
			throw new OperationException("Bild zu klein. Angegebenene Höhe: " + height + ", tatsächliche Höhe: " + cnt);
		}
		return result;
	}
}
