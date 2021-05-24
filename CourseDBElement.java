package Project4;

public class CourseDBElement implements Comparable<CourseDBElement> {
	
	private String id;
	private int crn;
	private int credits;
	private String roomNum;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getCRN() {
		return crn;
	}


	public void setCRN(int crn) {
		this.crn = crn;
	}


	public int getCredits() {
		return credits;
	}


	public void setCredits(int credits) {
		this.credits = credits;
	}


	public String getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	private String instructor;
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	
	public CourseDBElement() {
		this.id = null;
		this.crn = 0;
		this.credits = 0;
		this.roomNum = null;
		this.instructor = null;
	}

	
	@Override
	public int compareTo(CourseDBElement element) {
		if(id.compareTo(element.id) == 0) 
			if(crn == element.crn) 
				if(credits == element.credits) 
					if(roomNum.compareTo(element.roomNum) == 0) 
						if(instructor.compareTo(element.instructor) == 0)
							return 0;
		return -1;
	}
	
	public String toString() {
		return "\n" + "Course:" + id + " " + "CRN:" + String.valueOf(crn) + " " + "Credits:"
				+ String.valueOf(credits) + " " +  "Instructor:" +  instructor + " " + "Room:" + roomNum;
	}
	
	
}
