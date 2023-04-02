package telran.util.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.ArrayList;

class ArrayListTest {
	ArrayList<Integer> numbers = new ArrayList<>();

	@Test
	void testAdd() {
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<String> String = new ArrayList<>();
		numbers.add(5);
		numbers.add(10);
		String.add("ABC");
		assertEquals(2,numbers.size());
		assertEquals(1,String.size());
		}
	@Test
void	testAddIndex(){
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i=0; i<10;i++) {
			numbers.add(i);
			}
		assertEquals(10,numbers.size());
		numbers.add(0,20);
		assertEquals(11,numbers.size());
		numbers.add(3,40);
		assertEquals(12,numbers.size());
		numbers.add(5,70);
		numbers.add(6,90);
		assertEquals(14,numbers.size());
		assertEquals(20,numbers.get(0));
		assertEquals(40,numbers.get(3));
	}
	@Test
	void testremove() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i=0;i<10;i++) {
			numbers.add(i);
	}
		int removed1 = numbers.remove(8);
		int removed2 = numbers.remove(5);
		int removed3 = numbers.remove(2);
		int removed4 = numbers.remove(0);
		assertEquals(6, numbers.size());
		assertEquals(8, removed1);
		assertEquals(5, removed2);
	    assertEquals(2, removed3);
		assertEquals(0, removed4);
		
	}

}
