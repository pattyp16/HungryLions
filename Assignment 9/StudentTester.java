import java.util.*; 
import java.util.regex.*;
import java.io.*;

/** Lauren Bricker
 *  Assignment 9
 *  A program to test all of the elements of the Student class
 *  StudentTester version 1.0
 *  1/15/2013
 */
public class StudentTester
{
   static boolean DEBUG = false; 
   static final int MAX_COURSES = 8; 
   
   static String[] firstNames; 
   static String[] lastNames; 
   static int[] grades; 
   static int[] numCourses; 
   static String[][] courses; 
   
   /** Main entry point into the test program 
    */ 
	public static void main(String[] args)
	{	
      if (loadFile())
      {  
         Random r = new Random(42);  // test with seed = 42 if you want an exact match with gradeIt and expected output
               
   		System.out.println("testAccessorMutator returned: " + testAccessorMutator(r));
   		System.out.println();
    		System.out.println("testToString returned: " + testToString(r));
    		System.out.println();
   		System.out.println("testEquals returned: " + testEquals(r)); 
   		System.out.println();
    		System.out.println("testAddCourses returned: " + testAddCourse(r));
    		System.out.println();
      }
	}

	
   /** 
    *  Method to test whether all of the accessors and mutators are working correctly
    *  @param r The random object from which to pick the random number
    *  @return boolean Whether the test worked
    */
	public static boolean testAccessorMutator(Random r)
	{	
 
      for (int count = 0; count < 3; count++)  // only do 3 random ones...
      {	
         int ii = r.nextInt(firstNames.length); 
   		Student s = createStudent(firstNames[ii], lastNames[ii], grades[ii]); 
   		boolean first_check = s.getFirstName().equals(firstNames[ii]); 
   		boolean last_check = s.getLastName().equals(lastNames[ii]); 
   		boolean full_check = s.getFullName().equals(firstNames[ii] + " " + lastNames[ii]); 
   		boolean grade_check = s.getGrade() == grades[ii]; 
   		System.out.println("Checking getFirstName().equals " + firstNames[ii] + ": " + first_check);
   		System.out.println("Checking getLastName().equals " + lastNames[ii] + ": " + last_check);
   		System.out.println("Checking getFullName().equals " + firstNames[ii] + " " + lastNames[ii] + ": " + full_check);
   		System.out.println("Checking getGrade() == " + grades[ii] + ": " + grade_check);
   		
   		System.out.println("Adding " + numCourses[ii] + " courses to student " + lastNames[ii] + ": " + Arrays.toString(courses[ii])); 
   		for (int jj = 0; jj < courses[ii].length; jj++)
   		{	
   			s.addCourse(courses[ii][jj], jj); 
   		}
         
         String[] courses2 = s.getCourses(); 
   		System.out.println("Student now has courses: " + Arrays.toString(courses2)); 
   		boolean courses_check = true; 
   		for (int jj = 0; courses_check && jj < courses[ii].length; jj++ )
   		{
   			if ( !courses[ii][jj].equals(courses2[jj]) )
   				courses_check = false; 
   		}
	      System.out.println("Student courses contain courses added:  " + courses_check);

         if ( !(first_check  && last_check  && full_check  && grade_check) )
            return false; 
         System.out.println(); 
      }
      		
		return true; 	
	
	}

	
	/** 
    *  Method that tests whether the Student toString method is working appropriately
    *  @param r The random object from which to pick the random number
    *  @return Whether the toString method worked correctly
    */
	public static boolean testToString(Random r)
	{	
      // only test with one random student
      int which = r.nextInt(firstNames.length);
		Student s = createStudent(firstNames[which], lastNames[which], grades[which]); 
		s.addCourse("a", 0); 
		String expected = "" + grades[which] + ": " + firstNames[which] + " " + lastNames[which] + " [a, Free, Free, Free, Free, Free, Free, Free]";  ;
		String actual = s.toString(); 
		System.out.println("expected: " + expected); 
		System.out.println("actual: " + actual);
		return s.toString().equals(expected); 
	}


	/** 
    *  Method that tests whether the Student equals method is working appropriately
    *  @param r The random object from which to pick the random number
    *  @return Whether the equals method worked correctly
    */
	public static boolean testEquals(Random r)
	{
      // pick three random students
      int number = 2; 
      int[] n = new int[number]; 
      for (int i = 0; i < n.length; i++)
         n[i] = r.nextInt(firstNames.length);
		
      Student[] s = new Student[number + 1]; 
      for (int i = 0; i < s.length - 1; i++)
      {         
   	   s[i] = createStudent(firstNames[n[i]], lastNames[n[i]], grades[n[i]]); 
   		s[i].addCourse("" + (char)('a'+i), 0); 
         for (int ii = 1; ii < MAX_COURSES; ii++)
            s[i].addCourse("Free",ii);
   	}
      s[number] = createStudent(firstNames[n[0]], lastNames[n[0]], grades[n[0]]); 
      s[number].addCourse("a", 0);
      		
		boolean check_equals = s[0].equals(s[2]); 
		boolean check_not_equals = s[0].equals(s[1]); 
		
		System.out.println("Checking if " + s[0] + " equals() " + s[2] + ": " + check_equals);
		System.out.println("Checking if " + s[0] + " equals() " + s[1] + ": " + check_not_equals);
		return check_equals && !check_not_equals; 
	}
	
   /**
    *  Method to test whether adding a course worked correctly
    *  @param r The random object from which to pick the random number
    *  @return boolean Whether adding courses worked correctly 
    */
	public static boolean testAddCourse(Random r)
	{
      // only test with one random student
      int which = r.nextInt(firstNames.length);

		Student s = createStudent(lastNames[which], firstNames[which], grades[which]); 
		System.out.println("Adding courses " + Arrays.toString(courses[which]));
		
		for (int jj = 0; jj < courses[which].length; jj++)
		{
			s.addCourse(courses[which][jj], jj); 
		} 
		
		String[] courses2 = s.getCourses();
		System.out.println("Courses added " + Arrays.toString(courses2)); 
		
		boolean check_add = courses2.length == 8; 
		for (int ii = 0; check_add && ii < courses2.length; ii++ )
		{
			if ( !courses[which][ii].equals(courses2[ii]) )
				check_add = false; 
		}
		
		return check_add; 
	}
		

	/**
    *  Method to test whether creating a student works correctly
    *  @param first The first name of the student
    *  @param last The last name of the student
    *  @param grade The grade, as an integer value, of the student (9-12)
    *  @return boolean Whether adding courses worked correctly 
    */
   public static Student createStudent(String first, String last, int grade)
	{
		System.out.println("Creating Student " + first + " " + last + " in grade " + grade); 
		return new Student(first, last, grade, MAX_COURSES);
	}
   
   /**
    * Method to load the students.txt file into the arrays. 
    * @return whether the load worked. 
    */ 
   public static boolean loadFile()
   {
      Scanner input = null; 
      File f = new File("students.txt");
      try
      {
         input = new Scanner(f); 
	   }
      catch (FileNotFoundException e)
      {
         System.out.println("File is not found"); 
         return false;
      }
      int count = input.nextInt();
      input.nextLine(); 
      printDebug("Count = " + count); 
      firstNames = new String[count]; 
      lastNames = new String[count]; 
      grades = new int[count]; 
      numCourses = new int[count]; 
      courses = new String[count][];
      printDebug("Starting...");
      for (int ii = 0; ii < count && input.hasNextLine(); ii++)
      {
         String line = input.nextLine();
         printDebug(line); 
         processLine(ii, line); 
      }
      return true; 
   }
   
 /**
  *  Method to process a line into the component parts. 
  *  @param which line number you're processing
  *  @param the line your processing.     
  */ 
   public static void processLine(int count, String line)
   {

      Scanner scan = new Scanner(line); 
      Pattern p = Pattern.compile("\t");
      scan = scan.useDelimiter(p);
      if ( scan.hasNext() )  // get the first name from the line
         firstNames[count] = scan.next();
      if ( scan.hasNext() )  // get the last name from the line
         lastNames[count] = scan.next();
      if ( scan.hasNextInt() )  // get the gradefrom the line
         grades[count] = scan.nextInt();
      if ( scan.hasNextInt() )  // get the number and actual course names from the line
      {
         int num = scan.nextInt();
         numCourses[count] = num; 
         courses[count] = new String[num]; 
         for (int ii = 0; ii < num; ii++)
         {
            String toAdd; 
            if ( scan.hasNext() )
               toAdd = scan.next(); 
            else
               toAdd = "Free";
            courses[count][ii] = toAdd; 
         }
      }
      
      printDebug(Arrays.toString(firstNames)); 
      printDebug(Arrays.toString(lastNames)); 
      printDebug(Arrays.toString(grades)); 
      printDebug(Arrays.toString(numCourses)); 
      printDebug(Arrays.deepToString(courses)); 
      
   
   }
   
   /**
    *  A method to wrap a println, so it only prints when the DEBUG string is on.  
    *  @param the string to print out. 
    */
   public static void printDebug(String print)
   {
      if (DEBUG)
      {
         System.out.println(print); 
      }
   }
}
		