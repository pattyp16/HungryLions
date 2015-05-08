//Patty Popp
//Student
//
//Version 1.0
//February 10th, 2015


/** This class encapsulates the state and behavior of a Student object. By creating instance variables, a constructor, accessor and
 * mutator methods, a toString method, an equals method, and an addCourses method, School.java is able to utilize and manipulate
 * Student objects in order to delve into the idea of a Student Scheduler.
 */
import java.util.*;
public class Student
{

/** first - Student's first name
 */
   private String first;

/** last - Student's last name
 */
   private String last;

/** grade - Student's grade level
 */
   private int grade;
   
/** maxClasses - maximum number of classes a Student can take
 */
   private int maxClasses;

/** arrayOfCourses - string array containing list of courses
 */
   private String[] arrayOfCourses;

/** numberOfCourses - the number of courses that any given Student is taking
 */
   private int numberOfCourses;

/** This method constructs an object of type Student based on four parameters that are passed in. Number of courses is originally set
 * to zero, and is later incremented once courses are added. "arrayOfCourses" is initialized and assigned to an array of length
 * maxClasses, and is filled in entirely with Free's.
 * @param first Student's first name
 * @param last Student's last name
 * @param grade Student's grade level
 * @param maxClasses maximum number of classes Student can take
 */
   public Student(String first, String last, int grade, int maxClasses)
   {
      this.first = first;
      this.last = last;
      this.grade = grade;
      this.maxClasses = maxClasses;
      this.numberOfCourses = 0;
      this.arrayOfCourses = new String[maxClasses];
      for (int ii = 0; ii<maxClasses; ii++)
      {
         arrayOfCourses[ii] = "Free";
      }
   }

/** The method "getFirstName" returns the student's first name.
 * @return Student's first name
 */
   public String getFirstName()
   {
      return first;
   }

/** The method "getLastName" returns the student's last name.
 * @return Student's last name
 */
   public String getLastName()
   {
      return last;
   }

/** The method "getFullName" returns the student's full name by concatenating his/her first and last name.
 * @return Student's full name
 */
   public String getFullName()
   {
      return (first + " " + last);
   }

/** The method "getGrade" returns the student's current grade.
 * @return Student's grade level
 */
   public int getGrade()
   {
      return grade;
   }

/** The method "getCourses" returns the array containing the student's course list.
 * @return String array containing courses
 */
   public String[] getCourses()
   {
      return arrayOfCourses;
   }

/** The method "setInfo" takes in three paramaters and sets the student's information with a new first name, last name, and grade.
 * @param newFirst new first name for Student
 * @param newLast new last name for Student
 * @param newGrade new grade level for Student
 */
   public void setInfo(String newFirst, String newLast, int newGrade)
   {
      first = newFirst;
      last = newLast;
      grade = newGrade;
   }

/** The method "toString" returns a String representation of the called Student object (using Arrays.toString for course array).
 * @return the String representation of the Student object
 */
   public String toString()
   {
      return (grade + ": " + first + " " + last + " " + Arrays.toString(arrayOfCourses));
   }

/** The method "equals" returns true if the Student object that was called represents the same Student as that in the parameter (i.e.
 * same name, grade, and course list). Returns false if otherwise.
 * @param s a student object that the user wants to pass in to test for equivalency
 * @return true or false depending if name, grade, and course arrays are equivalent
 */
   public boolean equals (Student s)
   {
      return (first.equals(s.first) && last.equals(s.last) && grade==s.grade && Arrays.equals(arrayOfCourses, s.arrayOfCourses));
   }

/** The method "addCourse" adds a course to a Student's schedule based on the parameters course and period, if the Student has a free
 * period during that time and their number of current courses does not exceed the maximum number of classes. The number of courses is
 * then incremented.
 * @param course String representation of a course said Student wants to take
 * @param period int representation of period number
 * @return the number of courses the Student is taking after changes were made to schedule
 */
   public int addCourse(String course, int period)
   {
      if ((arrayOfCourses[period].equals("Free")) && numberOfCourses<maxClasses)
      {
         arrayOfCourses[period] = course;
         numberOfCourses++;
      }
      return numberOfCourses;
   }
}