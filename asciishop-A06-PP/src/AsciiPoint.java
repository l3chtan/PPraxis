public class AsciiPoint{

private int x, y;
	/**
	*Konstruktor.
	*@param x Gibt die Spalte des Bildes an.
	*@param y Gibt die Zeile des Bildes an.
	*/
	public AsciiPoint(int x, int y){

		this.x = x;
		this.y = y;
	}
	/**
	*Gibt die x-Kooridnate des Punktes zurück.
	*@return x-Kooridnate
	*/
	public int getX(){

		return x;
	}
	/**
	*Gibt die y-Koordinate des Punktes zurück.
	*@return y-Koordinate
	*/
	public int getY(){

		return y;
	}
	/**
	*Gibt die x- und y-Koordinate formatiert zurück.
	*@return Formatierte Koordinaten
	*/
	public String toString(){
		//gibt eine lesbare Darstellung des Punktes in der Form (x,y) zurück.
		return String.format("(%d,%d)", getX(), getY());
	}
}
