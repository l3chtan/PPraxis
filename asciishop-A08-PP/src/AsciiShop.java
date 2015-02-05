import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;

/**
 *Die main-Methode.
 *Sie liest als einzige Klasse Befehle ein, verarbeitet diese und
 *gibt sie auf die Standartausgabe aus.
 */

public class AsciiShop{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int width = 0, height = 0;
		boolean input_error = false;
		String charSet = "", command = "";
		/*
		 *Die nächsten vier if-Abfragen überprüfen, ob das erste Wort "create" ist, ob danach zwei Zahlenwerte folgen und ob ein String der erlaubten Zeichen vorhanden ist, sonst wird ein Fehler ausgegeben.
		 */
		if(!sc.next().equals("create")){		
			input_error = true;
		}
		if(sc.hasNextInt()){
			width = sc.nextInt();
		} else {input_error = true;}
		if(sc.hasNextInt()){
			height = sc.nextInt();
		} else {input_error = true;}
		if(sc.hasNext()){
			charSet = sc.next();
		} else {input_error = true;}

		/*
		 * Falls bisher kein Fehler aufgetreten ist, wird ein Objekt der Klasse AsciiImage mit den, aus der Eingabedatei eingelesenen, Werten erzeugt.
		 */
		AsciiImage image = new AsciiImage(0,0,"");
		if(input_error == false){
			AsciiImage defa = new AsciiImage(width, height, charSet);
			image = defa;
		}

		image = new ClearOperation().execute(image);
		Stack<AsciiImage> ascii_stack = new Stack<AsciiImage>();

		/*
		 *Die Schleife wird solange durchlaufen, solange kein Fehler auftritt und eine Eingabe vorhanden ist.
		 *Das Bild wird bis "eof" eingelesen und die Bildpunkte entsprechen ihren Koordinaten gespeichert. 
		 *Folgt nach der angegebenen Höhe nicht "eof" wird ein Fehler ausgegeben. 
		 *Es wird auch ein Fehler ausgegeben, wenn die Breite einer Zeile sich von der angegebenen unterscheidet.
		 */
		while(sc.hasNext() && input_error == false){
			command = sc.next();
			AsciiImage copy = new AsciiImage(image);
			HashMap<String, Factory> factList = new HashMap<String, Factory>();

			factList.put("load", new LoadFactory());
			factList.put("binary", new BinaryFactory());
			factList.put("clear", new ClearFactory());
			factList.put("filter", new FilterFactory());
			factList.put("replace", new ReplaceFactory());

			try{
				try{

					if(factList.containsKey(command)){
						image = factList.get(command).create(sc).execute(image);
					} 
					else if(command.equals("undo")){				

						if(ascii_stack.empty()){
							System.out.println("STACK EMPTY");
						} else {
							image = ascii_stack.pop();
						}
						/*AsciiImage Pimage = ascii_stack.pop();		

						  if(Pimage == null){				
						  System.out.println("STACK EMPTY");
						  } else {
						  image=Pimage;
						  }*/
					}
					else if(command.equals("print")){				
						System.out.println(image.toString());
					} else {
						System.out.println("UNKNOWN COMMAND");
						break;
					}

					/*
					 *Wenn einer der Befehle eingegeben wurde, wird eine Kopie des Bildes auf dem Stack abgelegt.
					 */	
					if(command.equals("clear") || 
							command.equals("replace") || 
							command.equals("binary") ||
							command.equals("load") ||
							command.equals("filter"))
					{
						ascii_stack.push(copy);
					}
				} catch(FactoryException f){System.out.println("INPUT MISMATCH"); System.err.println(f); break;}
			} catch(OperationException o){System.out.println("OPERATION FAILED"); System.err.println(o); break;} 
		}

		if(input_error == true){
			System.out.println("INPUT MISMATCH");
		} 
	}
}
