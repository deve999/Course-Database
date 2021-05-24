package Project4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface database = new CourseDBManager();
	private CourseDBManagerInterface database2 = new CourseDBManager();
	@BeforeEach
	void setUp() throws Exception {
		database = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		database = null;
		database2 = null;
	}
	

	@Test
	public void testGet() {
		try {
			File inputFile = new File("Test2.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.print("CMSC203 30503 4 SC450 Jill B. Who-Dunit");
			inFile.close();
			database.readFile(inputFile);
			assertEquals("CMSC203 30504 4 SC450 Joey Bag-O-Donuts", database.get(30504).toString());
			assertEquals("CMSC203 30503 4 SC450 Jill B. Who-Dunit", database.get(30503).toString());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}


	@Test
	public void testCollisionGet() {
		try {
			File inputFile = new File("Test3.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.println("CMSC203 30503 4 SC450 Jill B. Who-Dunit");
			inFile.println("CMSC100 22974 2 Distance-Learning Janet E. Joy");
			inFile.println("CMSC110 20484 3 HT300 Madhvi A. Shah");
			inFile.print("CMSC110 21564 3 SC451 Behzad Maghami");
			inFile.close();
			database2.readFile(inputFile);
			assertEquals("CMSC203 30504 4 SC450 Joey Bag-O-Donuts", database2.get(30504).toString());
			assertEquals("CMSC203 30503 4 SC450 Jill B. Who-Dunit", database2.get(30503).toString());
			assertEquals("CMSC100 22974 2 Distance-Learning Janet E. Joy", database2.get(22974).toString());
			assertEquals("CMSC110 20484 3 HT300 Madhvi A. Shah", database2.get(20484).toString());
			assertEquals("CMSC110 21564 3 SC451 Behzad Maghami", database2.get(21564).toString());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}

