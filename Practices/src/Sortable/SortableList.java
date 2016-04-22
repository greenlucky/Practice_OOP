package Sortable;

import java.util.List;

public class SortableList<T extends Comparable<? super T>> extends SortableComparableData<T> {
	
	private List<T> list;
	
	public SortableList(List<T> list) {
		this.list = list;
	}
	
	public int size() {
		return list.size();
	}

	public void swap(int i, int j) {
		T temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public T get(int i) {
		return list.get(i);
	}

}
