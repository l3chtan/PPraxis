import java.util.Scanner;

/**
 * Diese Klasse enthält eine Methode zum erstellen einer MedianOperation.
 * Sie implementiert Factory.*/
public class FilterFactory implements Factory{

	/**
	 * Konstruktor.
	 * Erzeugt ein neues FilterFactory Objekt.*/
	public FilterFactory(){
	}

	/**
	 * Erstellt eine neue MedianOperation.
	 *
	 * @param scanner Liest den Filterbefehl ein.
	 * @return Eine neue Instanz von MedianOperation, oder AverageOperation.
	 * @throws FactoryExcpetion Wird geworfen, wenn der eingelesene Befehl weder "average" noch "median" ist.*/
	public Operation create(Scanner scanner) throws FactoryException {

		String tmp = scanner.nextLine();
		Scanner line_sc = new Scanner(tmp);
		String cmd = line_sc.next(); 
		int blockS = 3;
		String genName = "x";

		for(int i=0;i<2;i++){
			if(line_sc.hasNextInt()){
				blockS = line_sc.nextInt();
				if(blockS%2 == 0){
					throw new FactoryException("Invalid Blocksize");
				}
			} else if(line_sc.hasNext()){
				genName = line_sc.next();	
			} else {
				break;
			}
		}

		if(cmd.equals("median")){
			return new MedianOperation(bGen(genName, blockS));
		} else if(cmd.equals("average")){
			return new AverageOperation(bGen(genName, blockS));
		} else {
			throw new FactoryException("UNKNOWN COMMAND");
		}
	}

	public BlockGenerator bGen(String name, int bs){

		if(name.equals("x")){
			return new XBlockGenerator(bs);
		} else 	if(name.equals("circular")){
			return new CircularBlockGenerator(bs);
		} else if(name.equals("replicate")){
				return new ReplicateBlockGenerator(bs);	
		} else if(name.equals("symmetric")){
				return new SymmetricBlockGenerator(bs);
		}

		return new XBlockGenerator(bs); 
	}
}
