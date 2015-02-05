import java.util.ArrayList;

public class AsciiImage{

	private int height, width; 
	private char[][] picture;
	private String charset;

	/**
	 *Konstruktor. 
	 *Erzeugt ein neues Bild mit angegebener Breite und Höhe.
	 *@param width Breite des Bildes
	 *@param height Höhe des Bildes
	 */
	public AsciiImage(int width, int height, String charset){	

		this.height = height;
		this.width = width;
		this.charset = charset;

		picture = new char[width][height];
	}
	/**
	 *Kopier-Konstruktor. 
	 *Erzeugt eine Kopie des AsciiImage Objektes.
	 *@param img Eine AsciiImage Kopie
	 */
	public AsciiImage(AsciiImage img){
		this.height = img.getHeight();
		this.width = img.getWidth();
		this.charset = new String(img.getCharset());
		picture = new char[img.width][img.height];

		for(int g=0;g<width;g++){
			for(int h=0;h<height;h++){
				picture[g][h] = img.getPixel(g,h);
			}
		}
	}
	public String getCharset(){

		return charset;
	}
	/**
	 * Bildbreite.
	 * Gibt die Bildbreite aus.
	 *@return Gibt die Breite des Bildes zurück
	 */
	public int getWidth(){

		return width;
	}
	/**
	 * Bildhöhe.
	 * Gibt die Bildhöhe aus.
	 *@return Gibt die Höhe des Bildes zurück.
	 */
	public int getHeight(){

		return height;
	}
	/**
	 * Bildpunkt.
	 * Gibt einen, den übergebenen Parametern gemäßen, Bildpunkt aus
	 *@param x x-Koordinate
	 *@param y y-Koordinate
	 *@return Zeichen an den angegebenen Koordinaten
	 */
	public char getPixel(int x, int y){

		return picture[x][y];
	}
	/**
	 * Bildpunkt.
	 *@param p Ein Objekt der AsciiPoint Klasse.
	 *@return Zeichen an den angebenen Koordinaten
	 *@see AsciiPoint.java
	 */
	public char getPixel(AsciiPoint p){

		return picture[p.getX()][p.getY()];
	}

	/**
	 * Setzt ein Zeichen.
	 *Die Methode setzt an den angegebenen Koordinaten ein übergebenes Zeichen.
	 *@param x x-Koordinate
	 *@param y y-Koordinate
	 *@param c zu setzendes Zeichen
	 */
	public void setPixel(int x, int y, char c){

		picture[x][y] = c;
	}
	/**
	 * Setzt ein Zeichen.
	 *Die Methode setzt an den angegebenen Koordinaten ein übergebenes Zeichen.
	 *@param p Ein Objekt der AsciiPoint Klasse.
	 *@param c zu setzendes Zeichen
	 *@see AsciiPoint.java
	 */
	public void setPixel(AsciiPoint p, char c){

		picture[p.getX()][p.getY()] = c;
	}
	/**
	 * Liste eines Zeichens.
	 *Speichert alle Koordinaten des Zeichens "c" aus dem Bild in einer ArrayList.
	 *@param c Zeichen von welchem alle Vorkommen in der ArrayList gespeichert werden
	 *@return Eine ArrayList vom Typ AsciiPoint mit allen Koordinaten an denen das Zeichen c vorkommt.
	 *@see AsciiPoint.java
	 */
	public ArrayList<AsciiPoint> getPointList(char c){

		ArrayList<AsciiPoint> pixel = new ArrayList<AsciiPoint>();

		for(int a=0;a<width;a++){
			for(int b=0;b<height;b++){

				if(getPixel(a,b) == c){
					AsciiPoint d = new AsciiPoint(a,b);
					pixel.add(d);
				}
			}
		}
		return pixel;
	}

	/**
	 * Anzahl unterschiedlicher Characters.
	 * @return Anzahl unterschiedliche Character-Elemente im Bild vorkommen.*/
	public int getUniqueChars(){

		String chars = "";
		chars += picture[0][0];

		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){

				String ha = "";
				ha += picture[i][j];
				if(!chars.contains(ha)){
					chars += picture[i][j];
				}
			}
		}

		return chars.length();
	}
	/**
	 * Formatierte Ausgabe.
	 *Formatiert das Bild und gibt eine Lesbare Darstellung aus.
	 *@return Gibt den formatierten String aus.
	 */
	public String toString(){

		String img_out = "";

		for(int m=0;m<height;m++){
			for(int n=0;n<width;n++){
				img_out += getPixel(new AsciiPoint(n,m));
			}
			img_out += String.format("%n");
		}
		return img_out;
	}

	/**
	 * Vergleichsmethode.
	 * Vergleicht zwei AsciiImage Objekte miteinander.
	 * Sie sind gleich wenn sie die selbe Höhe und Breite haben.
	 * Außerdem muss gelten, dass alle Pixel in beiden Bildern zu den Koordinaten (x,y) das selbe Zeichen enthalten.
	 * @param o das Objekt mit dem dieses verglichen werden soll.
	 * @return Wahr falls die Bilder äquivalent sind, sonst falsch.*/
	public boolean equals(Object o){
		boolean eq = true;

		if(((AsciiImage)o).getWidth() != width || ((AsciiImage)o).getHeight() != height){
			eq = false;
		}	

		if(eq == true){
			for(int m=0;m<width;m++){
				for(int n=0;n<height;n++){
					if(picture[m][n] != ((AsciiImage)o).getPixel(m,n)){
						eq = false;
						break;
					}
				}
			}
		}
		return (o instanceof AsciiImage && eq);
	}

	/**
	 * Hashcode des AsciiImage.
	 * Der Hashcode ist die Summer der Numerischen Werte der einzelnen Pixel des Bildes.
	 * @return Hashcode*/
	public int hashCode(){
		int code = 0;

		for(int m=0;m<width;m++){
			for(int n=0;n<height;n++){
				code += Character.getNumericValue(picture[m][n]);
			}
		}
		return code;
	}
}
