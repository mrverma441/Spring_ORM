package spring_orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Student;
import spring_ormdao.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//    	Student student =new Student(2324,"Monu Verma","Kotdwara");
//    	int r = studentDao.insert(student);
//    	System.out.println("Done" +r);
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	boolean go=true;
    	while(go)
    	{
    		System.out.println("PRESS 1 for add new Student");
        	System.out.println("PRESS 2 for display all students");
        	System.out.println("PRESS 3 for get details of single object");
        	System.out.println("PRESS 4 for delete Students");
        	System.out.println("PRESS 5 for update Students");
        	System.out.println("PRESS 6 for exit");
        	
        	try {
        		int input = Integer.parseInt(br.readLine());
        		switch (input) {
				case 1:
					//add a new Student
					//taking input from the user
					System.out.println("Enter user id");
					int uId=Integer.parseInt(br.readLine());
					System.out.println("Enter username");
					String uName=br.readLine();
					System.out.println("Enter the city");
					String ucity=br.readLine();
					//creating the object of the student
					Student s=new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(ucity);
					//inserting the data into database
					int r = studentDao.insert(s);
					System.out.println(r+" student added successfully");
					System.out.println("****************************");
					
					break;

				case 2:
			//Display all student
					System.out.println("*******************************");
					List<Student> allStudents = studentDao.getAllStudents();
					for(Student st:allStudents)
					{

						System.out.println("Id : "+st.getStudentId());
						System.err.println("city : "+st.getStudentCity());
						System.out.println("Name : "+st.getStudentName());
						System.out.println("----------------------------");
					}
					System.out.println("*******************************");

					break;
				case 3:
					//get single student data
					System.out.println("Enter user id");
					int userId=Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userId);
					System.out.println("Id : "+student.getStudentId());
					System.err.println("city : "+student.getStudentCity());
					System.out.println("Name : "+student.getStudentName());
					System.out.println("----------------------------");
					break;
				case 4:
					//for delete the students
					System.out.println("Enter user id");
					int userIdd=Integer.parseInt(br.readLine());
					studentDao.deleteStudent(userIdd);
					System.out.println("Student deleted successfully");
			
					break;
				case 5:
					//for update the student
					break;
				case 6:
					//exit function
					go=false;
					break;
				default:
					break;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid input try with another one !!");
				System.out.println(e.getMessage());
			}
    	}
    	
    	System.out.println("Thanks for using my application");
    }
    
}
