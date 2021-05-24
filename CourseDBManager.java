package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	
	private CourseDBStructure database = new CourseDBStructure(3);
	private ArrayList<String> data = new ArrayList<String>();
	
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
		data.add( "\n" + "Course:" + id + " " + "CRN:" + String.valueOf(crn) + " " + "Credits:"
		+ String.valueOf(credits) + " " +  "Instructor:" +  instructor + " " + "Room:" + roomNum);
		System.out.println(newElement);
		database.add(newElement);
	}
	
	public void add(CourseDBElement newElement) {
		database.add(newElement);
	}
	
	public CourseDBElement get(int crn) {
		try {
			return database.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void readFile(File input) throws FileNotFoundException {
		Scanner read = new Scanner(input);
	    int crn, credits;
	    String roomNum, instructor, id;
	    
		while(read.hasNext()) {
			id = read.next().trim();
			crn = Integer.parseInt(String.valueOf(read.nextInt()).trim());
			credits = Integer.parseInt(String.valueOf(read.nextInt()).trim());
			roomNum = read.next().trim();
			instructor = read.nextLine().trim();
			
			CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
			
			data.add(newElement.toString());
			
			add(newElement);
		}
		read.close();
	}
	
	
	public ArrayList<String> showAll(){
		return data;
	}
}
