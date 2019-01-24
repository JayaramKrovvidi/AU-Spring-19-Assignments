package filemanager;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import com.opencsv.CSVReader;

public class Read 
{
	
	public Map<Integer,Student> readFromFile1() throws NumberFormatException, IOException
	{
		CSVReader reader = new CSVReader(new FileReader("StudentPersonal.csv"), ',');
		Map<Integer,Student> studentMap = new HashMap<Integer,Student>();
		
		String[] record = null;

		while ((record = reader.readNext()) != null) 
		{
			Student s = new Student();
			s.setStudentId(Integer.parseInt(record[0]));
			s.setStudentName(record[1]);
			s.setStudentDOB(LocalDate.parse(record[2]));
			studentMap.put(s.getStudentId(), s);
		}
		reader.close();
		return studentMap;
	}
	
	public TreeSet<Student> readFromFile2 (HashMap<Integer,Student>smap) throws NumberFormatException, IOException
	{
		CSVReader reader = new CSVReader(new FileReader("StudentMarks.csv"), ',');
		
		TreeSet<Student> studentSet =new TreeSet<Student>();
		
		String[] record = null;

		while ((record = reader.readNext()) != null) 
		{
			Student s = smap.get(Integer.parseInt(record[0]));
			s.setMathsMarks(Integer.parseInt(record[1]));
			s.setPhysicsMarks(Integer.parseInt(record[2]));
			s.setChemistryMarks(Integer.parseInt(record[3]));
			s.setStudentTotal(s.getChemistryMarks()+s.getMathsMarks()+s.getPhysicsMarks());
			studentSet.add(s);
		}
		reader.close();
		return studentSet;
	}
	
	
}