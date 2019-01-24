package filemanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.opencsv.CSVWriter;

public class Write {
	
	public void writeToFile(TreeSet<Student> studentSet) throws IOException
	{
		CSVWriter writer = new CSVWriter(new FileWriter(new File("out.csv")));

		List<String[]> studentList = toStringArray(studentSet);

		writer.writeAll(studentList);

		writer.close();
		
	}

	private static List<String[]> toStringArray(TreeSet<Student> studentSet) 
	{
		
		List<String[]> records = new ArrayList<String[]>();

		records.add(new String[] { "studentCode", "studentName", "studentDOB", "studentTotalMarks" });

		for(Student student : studentSet)
			records.add(new String[] { 
					Integer.toString(student.getStudentId()), 
					student.getStudentName(), 
					student.getStudentDOB().toString(), 
					Integer.toString(student.getStudentTotal()) 
					});
		return records;
	}

}