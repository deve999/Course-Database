package Project4;
 
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	private int size;
	public LinkedList<CourseDBElement>[] hashTable;
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String test, int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
 
	public void add(CourseDBElement element) {
		int hashElement = element.hashCode();
		boolean inTable = false;
	
		for(int i = 0; i < size; i++) {
			
			if(hashTable[i] != null) {
				if(hashTable[i].peek() != null) {
					if( (hashTable[i].getFirst().hashCode() % size) == (hashElement % size)) {
						hashTable[i].add(element);
						inTable = true;
					}
				}
				else if((hashTable[i].hashCode() % size) == (hashElement % size)) {
					hashTable[i].add(element);
					inTable = true;
				}
			}
		}
		
		if(!inTable){
			int index = hashElement % size;  
			LinkedList<CourseDBElement> implementElement = new LinkedList<CourseDBElement>();
			implementElement.add(element);
			hashTable[index] = implementElement;
		}
	}
	
	public CourseDBElement get(int crn) throws IOException {
		int number;
		CourseDBElement element;
		for(int i = 0; i < size; i++) {
			if(hashTable[i] != null) {
				ListIterator<CourseDBElement> listIterate = hashTable[i].listIterator();
				while(listIterate.hasNext()) {
					 element = listIterate.next();
					 number = element.getCRN();
					 if(number == crn) {
						return element;
						}
					}
				}
			}
		return null;
	}
	
	public void clear() {
		hashTable = null;
	}
	public int getTableSize() {
		return hashTable.length;
	}
	
}
