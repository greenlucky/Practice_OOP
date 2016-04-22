package Sortable;

public abstract class SortableComparableData<T extends Comparable<? super T>> implements SortableData<T>{
	
	public final int compare(int i, int j){
		return get(i).compareTo(get(j));
	}
}
