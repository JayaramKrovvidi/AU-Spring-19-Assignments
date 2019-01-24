package filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * Hello world!
 *
 */
public class App 
{

    
    public String readAndWrite(String fileName1, String fileName2, String fileName3)
	{
    	CSVReader reader1;
    	CSVReader reader2;
    	CSVWriter writer;
    	try
    	{
			reader1 = new CSVReader(new FileReader(fileName1), ',');
			reader2 = new CSVReader(new FileReader(fileName2), ',');
			writer = new CSVWriter(new FileWriter(new File(fileName3)));
		
			Map<Integer,Student> studentMap = new HashMap<Integer,Student>();
			
			String[] record = null;

			while ((record = reader1.readNext()) != null) 
			{
				Student s = new Student();
				s.setStudentId(Integer.parseInt(record[0]));
				s.setStudentName(record[1]);
				s.setStudentDOB(LocalDate.parse(record[2]));
				studentMap.put(s.getStudentId(), s);
			}
			
			TreeSet<Student> studentSet =new TreeSet<Student>();	
	
			while ((record = reader2.readNext()) != null) 
			{
				Student s = studentMap.get(Integer.parseInt(record[0]));
				s.setMathsMarks(Integer.parseInt(record[1]));
				s.setPhysicsMarks(Integer.parseInt(record[2]));
				s.setChemistryMarks(Integer.parseInt(record[3]));
				s.setStudentTotal(s.getChemistryMarks()+s.getMathsMarks()+s.getPhysicsMarks());
				studentSet.add(s);
			}
			
			List<String[]> studentList = toStringArray(studentSet);
	
			writer.writeAll(studentList);
			
			reader1.close();
			reader2.close();
			writer.close();
			
			return "success";
    	}
    	catch(IOException e)
		{
			return "fileNotFoundException";
		}
    	catch(NumberFormatException e)
    	{
    		return "numberFormatException";
    	}
    	
	}

	public List<String[]> toStringArray(TreeSet<Student> studentSet) 
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
