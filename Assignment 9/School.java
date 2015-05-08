//Patty Popp
//School
//
//Version 1.0
//February 10th, 2015

/** The purpose of this School program is to create two student objects based on user input (for first name, last name, grade, and
 * number of courses), and through using and manipulating the Student class, inform the user whether the two students share any
 * classes and if so, during what periods.
 */
import java.util.*;
public class School
{

/** freshman - the minimum grade at this school
 */
   public static final int freshman = 9;

/** senior - the maximum grade at this school
 */
   public static final int senior = 12;

/** minCourse - the minimum number of classes a student can take at this school
 */
   public static final int minCourse = 1;

/** maxCourse - the maximum number of classes a stuent can take at this school
 */
   public static final int maxCourse = 8;

/** beginStrIndex - the first term's index in the String "common"
 */
   public static final int beginStrIndex = 0;

/** removeStrIndex - the number of terms that are removed at the end of the String in order to avoid a fencepost issue
 */
   public static final int removeStrIndex = 2;

/** This is the main method; where it all begins. First off, we establish the Scanner object for user input and then create Strings
 * containing prompts and error messages for the program, based off of the parameters. Then, the program creates two Student objects
 * by calling getStudentInfo, and then compares the two Students.
 * @param args the arguments of the program (when the program is really passionate about a topic and decides to express its opinion)
 */
   public static void main (String[]args)
   {
      Scanner input = new Scanner(System.in);
      String getName = "What is the student's name (firstname lastname)? ";
      String getGrade = "What is the student's grade (" +freshman+", "+(freshman+1)+", "+(freshman+2)+", "+senior+")? ";
      String getCourses = "How many courses is this student taking (" + minCourse + "-" + maxCourse + ")? ";
      String errorMessage = "Input is not valid, you need to enter a number";
      Student s1 = getStudentInfo(input, getName, getGrade, getCourses, errorMessage);
      System.out.println();
      Student s2 = getStudentInfo(input, getName, getGrade, getCourses, errorMessage);
      compareList(s1, s2);
   }

/** The method "getStudentInfo" takes five parameters. The method prints the prompt to get the first and last name of the Student, and
 * then prints the prompt for the student's grade and courses. The grade and number of courses are both passed into getGradeAndCourses
 * for the purpose of testing whether the user input is valid (i.e. an integer and within range). The method then creates a Student
 * object based on all of the fabulous information it gathered and creates a list of courses by calling the method getListOfCourses
 * and at the end, it returns the Student object.
 * @param input the Scanner object for the user input
 * @param getName the String prompt to get the name of the Student
 * @param getGrade the String prompt to get the grade of the Student
 * @param getCourses the String prompt to get the number of courses
 * @param errorMessage the error message for if the user input is not valid
 * @return s the newly constructed Student object based on all of the information that was collected
 */
   public static Student getStudentInfo (Scanner input, String getName, String getGrade, String getCourses, String errorMessage)
   {
      System.out.print(getName);
      String firstName = input.next().trim();
      String lastName = "";
      lastName = input.nextLine().trim();
      System.out.print(getGrade);
      int grade = getGradeAndCourses(input, errorMessage, getGrade, freshman, senior);
      System.out.print(getCourses);
      int numCourses = getGradeAndCourses(input, errorMessage, getCourses, minCourse, maxCourse);
      Student s = new Student(firstName, lastName, grade, maxCourse);
      getListOfCourses (input, numCourses, s);
      return s;
   }
 
/** The method "getGradeAndCourses" takes in five parameters. The method tests to see if the user input is valid, by checking for if
 * the input is an int and if it is within range. If it is not, the user is given an error message and reprompted, until the user 
 * finally inputs a valid grade/number of courses. This valid int is then returned by the method.
 * @param input the Scanner object for the user input
 * @param errorMessage the error message for if the user input is invalid
 * @param getGrade the String prompt that is passed in to get the grade/number of courses of the Student
 * @param min the minimum number for the range that is tested
 * @param max the maximum number for the range that is tested
 * @return the valid grade/number of courses
 */
   public static int getGradeAndCourses(Scanner input, String errorMessage, String getGrade, int min, int max)
   {
      int x = 0;
      boolean goodInput = false;
      while (!goodInput)
      {
         while (!input.hasNextInt())
         {
            System.out.println(errorMessage);
            System.out.print(getGrade);
            input.nextLine();
         }
         x = input.nextInt();
         input.nextLine();
         if (x < min || x > max)
         {
            System.out.println(errorMessage + " between " + min + " and " + max);
            System.out.print(getGrade);
         }
         else //(input is in range)
         {
            goodInput = true;
         }
      }
      return x;
   }

/** The method "getListOfCourses" takes three parameters and asks the user (number of courses) times for a course name, and adds the
 * courses to the array using the addCourse method from the Student class, at the specific period.
 * @param input the Scanner object for the user input
 * @param numCourses the number of classes that the Student is taking
 * @param s the Student object
 */
   public static void getListOfCourses(Scanner input, int numCourses, Student s)
   {
      for (int ii = 0; ii<numCourses; ii++)
      {
         System.out.printf("Course %d name? ", ii+1);
         String course = input.nextLine();
         s.addCourse(course, ii);
      }
   }

/** The method "compareList" takes in two parameters and informs the user which courses each student is taking, and if they have any
 * courses in common.
 * @param s1 the first Student object up for comparison
 * @param s2 the second Student object up for comparison
 */
   public static void compareList(Student s1, Student s2)
   {
      System.out.println();
      System.out.println("Student " + s1.getFullName() + " is taking courses " + Arrays.toString(s1.getCourses()));
      System.out.println("Student " + s2.getFullName() + " is taking courses " + Arrays.toString(s2.getCourses()));
      String [] courseArray1 = s1.getCourses();
      String [] courseArray2 = s2.getCourses();
      String common = "";
      for (int ii=0; ii<maxCourse; ii++)
      {
         if (courseArray1[ii].equals(courseArray2[ii]))
         {
            common+= ((ii+1) + ", ");
         } 
      }
      if (common.equals(""))
      {
         System.out.println ("The students have no shared classes.");
      }
      else // if (!common.equals(""))
      {
         System.out.println ("The students have the same classes in periods " + common.substring(beginStrIndex,
            (common.length())-removeStrIndex));
      }
   }
}