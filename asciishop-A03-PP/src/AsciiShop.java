import java.util.Scanner;

public class AsciiShop{
	
	private static int height = 0;					//Array Größe und Anzahl der Zeilen des Bildes
	private static int width = 0;					//Länge jedes Elementes des Array und Breite jeder Zeile des Bildes
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		boolean input_error = false;					
		boolean op_error = false;
		String[] image;
		
		//String command = "";
		
		
		if(sc.hasNext() && sc.next().equals("read")){			//Überprüft ob eine Eingabe vorhanden ist, und ob der erste eingelesene Block "read" ist.
			
			height = sc.nextInt();					//Speichert die angegebene Höhe des Bildes.
		} else {
			input_error = true;
		}
		
		image = new String[height];					//Initialisiert ein String Array der größe "height".
		
		/*Die Schleife wird "height" mal durchlaufen, und genau so viele Zeilen werden
		aus der Eingabedatei eingelesen, unabhängig davon wie lang das Bild tatsächlich ist.
		Jede Zeile wird in einem Platz des Array gespeichert.*/
		for(int i=0;i<=height-1;i++){
			
			if(sc.hasNext()){
				
				image[i] = sc.next();				
				
				if(i>0 && width != image[i].length()){		//Es wird, nach der ersten Zeile, überprüft ob die eingelesene Zeile gleich 
					//lang ist wie die erste Zeile, deren Länge in width gespeichert wird.
					input_error = true;
					break;
				} else {
					width = image[i].length();
				}
			} else {
				input_error = true;
				break;
			}
		}		
		//Die if-Abfrage überprüft ob nach den eingelesenen Zeilen der Befehl "fill" kommt oder etwas anderes
		
		while(sc.hasNext() && input_error == false){	//Die Schleife wird so oft durchlaufen, so oft der Befehl "fill" vorkommt. 
			
			if(!sc.next().equals("fill")){
				input_error = true;
				break;
			} else {
				
				int x = 0;
				int y = 0;
				String inp = "";
				/*Es wird überprüft ob nach dem "fill" Befehl zwei Zahlen und danach noch ein Zeichen kommen.*/
				if(sc.hasNextInt()){
					
					x = sc.nextInt();	//Breite
				} else {
					input_error = true;
					break;
				}
				if(sc.hasNextInt()){
					
					y= sc.nextInt();	//Höhe
				} else {
					input_error = true;
					break;
				}
				if(sc.hasNext()){
					
					inp = sc.next();
				} else {
					input_error = true;
					break;
				}
				
				if(x<=width && y<=height){				//Die eingelesenen Koordinaten werden mit der Höhe und Breite des Bildes verglichen. Sind sie größer wird ein Fehler ausgegeben.
					
					fill(image, x, y, inp.charAt(0));
				} else {
					op_error = true;
					break;
				}
			}
		}
		
		
		
		if(input_error == false && op_error == false){			//Gab es keine Probleme während dem Einlesen und der Verarbeitung des Bildes, wird es, gefolgt von Breite und Höhe, ausgegeben.
			//Andernfalls wird der entsprechende Fehler ausgegeben.
			for(int m=0;m<height;m++){
				System.out.println(image[m]);
			}
			System.out.println(width + " " + height);
			
		} else if(input_error == true)	{
			
			System.out.println("INPUT MISMATCH");
			
		} else if(op_error == true){
			
			System.out.println("OPERATION FAILED");
		}
	}
	
	public static void fill(String[] image, int x, int y, char c){
		
		String temp = "";
		char repl = image[y].charAt(x);				//Das zu ersetzende Zeichen wird in ein char gespeichert.
		
		/*Die Zeile mit dem erstzten Zeichen wird in einen zusätzlichen String gespeichert,
		und danach wird die entsprechende Zeile im Array überschrieben.*/
		temp = image[y].substring(0, x);
		temp += c;
		temp += image[y].substring(x+1);
		
		image[y] = temp;
		/*Die If-Abfragen überprüfen, ob die Zeichen ober-und unterhalb sowie
		links und rechts von dem zu ersetzenden Zeichen gleich diesem Zeichen sind.
		Trifft dies zu ruft sich der Algorithmus selber wieder auf.*/
		if(x>0 && image[y].charAt(x-1) == repl){
			
			fill(image, x-1, y, c);
		}
		if(y<image.length-1 && image[y+1].charAt(x) == repl){
			
			fill(image, x, y+1, c);
		}
		if(x<image[y].length()-1 && image[y].charAt(x+1) == repl){
			
			fill(image, x+1, y, c);
		}
		if(y>0 && image[y-1].charAt(x) == repl){
			
			fill(image, x, y-1, c);
		}
	}
}
