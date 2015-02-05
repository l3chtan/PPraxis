import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;

public class AsciiShop{
	/**
	 *Die main-Methode.
	 *Sie liest als einzige Klasse Befehle ein, verarbeitet diese und
	 *gibt sie auf die Standartausgabe aus.
	 */
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		String command = "";
		CreateFactory cre;
		AsciiImage image;
		Stack<AsciiImage> ascii_stack;

		if(!sc.next().equals("create")){		
			System.out.printf("INPUT MISMATCH\n");
			return;
		}

		try{
			try{
				cre = new CreateFactory();
				image = cre.create(sc).execute(null);

				ascii_stack = new Stack<AsciiImage>();
				MetricSet<AsciiImage> out = new MetricSet<AsciiImage>();

				HashMap<String, Factory> factList = new HashMap<String, Factory>();

				factList.put("load", new LoadFactory());
				factList.put("binary", new BinaryFactory());
				factList.put("clear", new ClearFactory());
				factList.put("filter", new FilterFactory());
				factList.put("replace", new ReplaceFactory());
				factList.put("create", new CreateFactory());
				factList.put("save", new SaveFactory(out));
				factList.put("search", new SearchFactory(out));

				while(sc.hasNext()){

					command = sc.next();
					AsciiImage copy = new AsciiImage(image);

					if(factList.containsKey(command)){
						image = factList.get(command).create(sc).execute(image);
					} 
					else if(command.equals("printsaved")){
						if(out.isEmpty()){
							System.out.printf("NO SAVED IMAGES\n");
						}
						for(AsciiImage a:out){
							System.out.printf("%s\n",a.toString());
						}
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

					if(command.equals("clear") || 
							command.equals("replace") || 
							command.equals("binary") ||
							command.equals("load") ||
							command.equals("search") ||
							command.equals("create") ||
							command.equals("filter"))
					{
						ascii_stack.push(copy);
					}
				}
			} catch(FactoryException f){System.out.println("INPUT MISMATCH"); System.err.println(f);}
		} catch(OperationException o){System.out.println("OPERATION FAILED"); System.err.println(o);} 
	}
}
