package Sortable;

public class SortableArray<T extends Comparable<? super T>> extends SortableComparableData<T> {
	
	private T[] array;
	
	public SortableArray(T[] a){
		this.array = a;
	}
	
	public int size() {
		return array.length;
	}

	public void swap(int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public T get(int i) {
		return array[i];
	}
}
