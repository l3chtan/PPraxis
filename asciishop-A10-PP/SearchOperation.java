import java.util.Iterator;

public class SearchOperation implements Operation {

	private MetricSet<AsciiImage> saved;
	private Metric<AsciiImage> m;

	/**
	 * Konstruktor.
	 * @param saved Liste der gespeicherten Bilder.
	 * @param m die Metrik mit der zwei Bilder verglichen werden.*/
	public SearchOperation(MetricSet<AsciiImage> saved, Metric<AsciiImage> m){
		this.saved = saved;
		this.m = m;
	}	

	/**
	 * Führt die Operation aus.
	 * Sucht nach dem/den, zu img, ähnlichsten Bild(ern).
	 * @param img Das Referenzbild, nach dem gesucht werden soll.
	 * @return das ähnlichste Bild, bzw. eines der ähnlichsten Bilder, sollten mehrere gleiche Ähnlichtkeit aufweisen.*/
	public AsciiImage execute(AsciiImage img) throws OperationException{
	
		if(saved == null){
			throw new OperationException("No images saved to search from");
		}
		MetricSet<AsciiImage> tmp = saved.search(img, m);
		Iterator<AsciiImage> iter = tmp.iterator();
		
		return iter.next();
	}
}
