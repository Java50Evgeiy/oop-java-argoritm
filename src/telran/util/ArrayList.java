package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import org.junit.Test;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	@Override
	public boolean add(T obj) {
		if(size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);
		
	}
	@Override
	public void add(int index, T obj) {
		if (size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
	}

	@Override
	public T remove(int index) {
		T res = array[index];
		
		System.arraycopy(array, index + 1, array, index,
				size - index - 1);
		size--;
		return res;
	}

	@Override
	public T get(int index) {
		T res = array[index];
		return res;
	}
	@Override
	public int size() {
		
		return size;
	}
	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		int index = indexOf(pattern);
		if (index > -1) {
			res = true;
			remove(index);
		}
		return res;
	}
	@Override
	public T[] toArray(T[] array) {
		if(array.length < size) {
			array = Arrays.copyOf(this.array,size);
		}
		System.arraycopy(this.array,0, array, 0, size);
		if(array.length >size) {
			array[size]=null;
		}
		
		return array;
	}
	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int index = 0;
		while(index < size && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index++;
		}
		return res;
	}
	private boolean isEqual(T object, T pattern) {
		
		return pattern == null ? object == pattern :
			pattern.equals(object);
	}
	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		int index = size - 1;
		while (index >= 0 && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index--;
		}
		return res;
	}

	@Override
	public void sort() {
Arrays.sort(array,0 , size);
		
	}
	
	
	@Override
public void sort (Comparator<T> comp) {
	int n=size;
	boolean FlUnSort = false;
	do{
		FlUnSort = false;
		n--;
	for(int i= 0;i<n;i++) {
			if(comp.compare(array[i], array[i+1])>0) {
				swap(i);
			}
			FlUnSort = true;
		}



}		while(FlUnSort);
	}
	private void swap(int i) {
	T tmp = array[i];
	array[i] = array[i + 1];
	array[i + 1] = tmp;
	
}
	@Override
	public int indexOf(Predicate<T> predicate) {
		int res = -1;
		int index = 0;
		while(index < size && res == -1) {
			if (predicate.test(array[index])) {
				res = index;
			}
			index++;
		}
		return res;
	
	}
	
	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		{
			int res = -1;
			int index = size - 1;
			while (index >= 0 && res == -1) {
				if (predicate.test(array[index])) {
					res = index;
				}
				index--;
			}
			return res;
		}
		
	}
	@Override
	public boolean removeIf(Predicate<T> predicate) {
		int currentSize = size;
		int index =0;
		for(int i =0; i <currentSize;i++) {
			if(!predicate.test(array[i])) {
				array[index++]=array[i];
			}
		}
		size = index;
		return currentSize !=size;
	}

}