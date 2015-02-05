import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Collection;

public class MetricSet<E> extends LinkedHashSet<E> {

	/**
	 * Konstruktor.
	 * Der Default-Kontruktor*/
	public MetricSet(){
	}

	/**
	 * Kontruktor.
	 * Diesem Konstruktor wird beim Aufruf eine bereits gespeicherte Liste an Elementen übergeben.
	 * @param c Collection welche die gespeicherten Elemente enthält.*/
	public MetricSet(Collection<? extends E> c){
			this.addAll(c);
	}

	/**
	 * Search-Methode.
	 * Mithilfe dieser Methode kann einem gespeicherten Bild gesucht werden.
	 * Dazu wird eine bestimmte Metrik verwendet, die aus der Eingabe eingelesen wird.
	 * @param e Element nach dem in den gespeicherten Elementen gesucht werden.
	 * @param m Die Metrik mithilfe derer das Element e in dieser Liste von Elementen gesucht werden.
	 * @return Alle Elemente die die kleinste Distanz zu e haben/die e am ähnlichsten sind.*/
	public MetricSet<E> search(E e, Metric< ? super E> m){

		int dist = 0;
		MetricSet<E> min_dist = new MetricSet<E>();
		Iterator<E> iter = this.iterator();

		E img_tmp = iter.next();
		dist = m.distance(e,img_tmp);
		min_dist.add(img_tmp);

		while(iter.hasNext()){
			 E temp = iter.next();
			if(m.distance(e,temp)<dist){
				min_dist.clear();	
				min_dist.add(temp);
			} else if(m.distance(e,temp) == dist){
				min_dist.add(temp);
			}
		}
		return min_dist; 
	}
}
