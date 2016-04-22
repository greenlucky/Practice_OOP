package Sortable;

public interface SortableData<T> {
	
	public int size();
	
	public void swap(int i, int j);
	
	public T get(int i);
	
	public int compare(int i,int j);
}
