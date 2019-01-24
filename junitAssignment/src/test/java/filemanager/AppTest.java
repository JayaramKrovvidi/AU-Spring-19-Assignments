package filemanager;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;
import org.mockito.Mockito;

public class AppTest
{
    
	@Test(expected = IOException.class)
	public void testSuccessCode()
	{
		App a = new App();
		String expected = a.readAndWrite("StudentPersonal.csv", "StudentMarks.csv","out3.csv");
		assertEquals("success",expected);
	}
	
	@Test
	public void testFileNotFound()
	{
		App a = new App();
		String expected = a.readAndWrite("StudentPPPP.csv", "StudentMarks.csv","out3.csv");
		assertEquals("fileNotFoundException",expected);
	}
	
	@Test
	public void testNumberFormat()
	{
		App a = new App();
		String expected = a.readAndWrite("StudentError.csv", "StudentMarks.csv","out3.csv");
		assertEquals("numberFormatException",expected);
	}
	
	@Test
	public void testConverterWithMockito()
	{
		Student student1 = new Student(1,"jayaram", LocalDate.parse("1997-09-16"), 20,20,20,60);
		
		TreeSet<Student> studentSet = new TreeSet<>();
		studentSet.add(student1);
		
		App a1 = new App();
		App a2 = Mockito.spy(a1);
		
		Mockito.when(a2.toStringArray(studentSet)).thenReturn(a1.toStringArray(studentSet));
		List<String[]> stringList = a2.toStringArray(studentSet);
		
		assertEquals(4, stringList.get(1).length);
		assertEquals("studentCode", stringList.get(0)[0]);
	}

}
