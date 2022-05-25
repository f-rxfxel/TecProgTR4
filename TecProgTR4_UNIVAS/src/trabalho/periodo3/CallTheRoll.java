package trabalho.periodo3;

import java.util.ArrayList;
import java.util.Scanner;

public class CallTheRoll {
	
	public static ArrayList<String> takeAttendance(Scanner input, ArrayList<String> presentsStudents) {
		
		System.out.println("Enter the names of the students presents in the class: \n(Type \"0\" to finish)");
		
		String name;
		
		do {
			name = input.next();
			
			if(name.equals("0")) {
				System.out.println("Attendance took!");
				return presentsStudents;
			}
			
			if(presentsStudents.contains(name)) {
				System.out.println("Student already present at the attendance!");
				continue;
			} else {
				presentsStudents.add(name);
			}
		} while(true);
		
	}

}
