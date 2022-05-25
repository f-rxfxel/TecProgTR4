package trabalho.periodo3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GenerateTxtFile {
	
	public static void createFile(String subject, String path, ArrayList<String> presentsStudents) /* CORREÇÃO DO JAVA A PARTIR DAQUI: */ throws InterruptedException {
		subject = subject.toLowerCase();
		
		Date currentDate = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd_MM_yyyy");
		
		subject = removeSpecialChars(subject);
		String nameFile = subject + "_" + formatDate.format(currentDate);
		
		System.out.println("Generating .txt file!");
		
		for(int i = 0; i < 5; i++) {
			Thread.sleep(500);
			// TRY CATCH?
			System.out.println("\t·");
		}
		
		FileWriter writer;
		try {
			writer = new FileWriter(path + nameFile + ".txt");
			writer.write("\t> " + subject + "\n");
			for(String name : presentsStudents) {
				writer.write(" - " + name + "\n");
			}
			
			writer.close();
		} catch (IOException e) {
			System.out.println("It is not possible to generate this file!");
			e.printStackTrace();
		}
		
		
		Thread.sleep(700);
		
		System.out.println("File " + nameFile + ".txt generated!");
		
	}
	
	public static String removeSpecialChars(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
}
