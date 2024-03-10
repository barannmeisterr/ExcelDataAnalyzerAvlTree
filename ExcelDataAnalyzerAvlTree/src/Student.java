//-----------------------------------------------------
// Title: Student Node class
// Author: Arda Baran
// Description: This class defines Student structure in excel file.
//-----------------------------------------------------
public class Student {
//prelabs start after lab5.there is no prelab before lab6.there are three prelab named as prelab6,prelab7,prelab8
	//lab1,lab2,lab3,lab4,lab5,prelab6,lab6,prelab7,lab7,prelab8,lab8,allLabsAverage,project,midtermExam,finalExam,totalCourseGrade	
	double l1,l2,l3,l4,l5,l6,l7,l8,pl6,pl7,pl8,labsOverall,project,midterm,finAl,total;//assingment grades of a student
	String nameSurname,email;//fullname and email adress of a student 
	Student left,right;//left and right pointers of node
	int height;//height of node
	public Student(String nameSurname,String email,double l1,double l2,double l3,double l4,double l5,double pl6,double l6,double pl7,double l7,double pl8,double l8,double labsOverall,double project,double midterm,double finAl,double total) {
		//--------------------------------------------------------
		// Summary: Student constructor consists of all occupied columns of excel file
		// two separate name and surname columns in the original excel file are merged. 
		//--------------------------------------------------------
		this.nameSurname=nameSurname;		
		this.email=email;
		this.l1=l1;
		this.l2=l2;
	   this.l3=l3;
	   this.l4=l4;
	   this.l5=l5;
	   this.pl6=pl6;
		this.l6=l6;
	  this.pl7=pl7;
	  this.l7=l7;
	  this.pl8=pl8;
	this.l8=l8;
	this.labsOverall=labsOverall;
	this.project=project;
	this.midterm=midterm;
	this.finAl=finAl;
	this.total=total;
	this.left=null;
	this.right=null;
	this.height=1;
	}
	//--------------------------------------------------------
	
	// Summary: Getter and Setters
	
	//--------------------------------------------------------
	
	public double getL1() {
		return l1;
	}
	public void setL1(double l1) {
		this.l1 = l1;
	}
	public double getL2() {
		return l2;
	}
	public void setL2(double l2) {
		this.l2 = l2;
	}
	public double getL3() {
		return l3;
	}
	public void setL3(double l3) {
		this.l3 = l3;
	}
	public double getL4() {
		return l4;
	}
	public void setL4(double l4) {
		this.l4 = l4;
	}
	public double getL5() {
		return l5;
	}
	public void setL5(double l5) {
		this.l5 = l5;
	}
	public double getL6() {
		return l6;
	}
	public void setL6(double l6) {
		this.l6 = l6;
	}
	public double getL7() {
		return l7;
	}
	public void setL7(double l7) {
		this.l7 = l7;
	}
	public double getL8() {
		return l8;
	}
	public void setL8(double l8) {
		this.l8 = l8;
	}
	public double getPl6() {
		return pl6;
	}
	public void setPl6(double pl6) {
		this.pl6 = pl6;
	}
	public double getPl7() {
		return pl7;
	}
	public void setPl7(double pl7) {
		this.pl7 = pl7;
	}
	public double getPl8() {
		return pl8;
	}
	public void setPl8(double pl8) {
		this.pl8 = pl8;
	}
	public double getLabsOverall() {
		return labsOverall;
	}
	public void setLabsOverall(double labsOverall) {
		this.labsOverall = labsOverall;
	}
	public double getProject() {
		return project;
	}
	public void setProject(double project) {
		this.project = project;
	}
	public double getMidterm() {
		return midterm;
	}
	public void setMidterm(double midterm) {
		this.midterm = midterm;
	}
	public double getFinAl() {
		return finAl;
	}
	public void setFinAl(double finAl) {
		this.finAl = finAl;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getNameSurname() {
		return nameSurname;
	}
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student getLeft() {
		return left;
	}
	public void setLeft(Student left) {
		this.left = left;
	}
	public Student getRight() {
		return right;
	}
	public void setRight(Student right) {
		this.right = right;
	}
	public void printStudent() {
		//--------------------------------------------------------
		// Summary: prints student
		//--------------------------------------------------------
		System.out.println();
	    System.out.println("              Student Report           ");
	   System.out.println();
	    System.out.println("Name Surname: " + getNameSurname());
	    System.out.println("Email Address: " + getEmail());
	    System.out.println();
	   System.out.println("lab work grades");
	    System.out.printf("%-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-8s\n",
	            "L1", "L2", "L3", "L4", "L5", "PL6", "L6", "PL7", "L7", "PL8", "L8", "Labs Overall");
	    System.out.printf("%-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-8.2f\n",
	            getL1(), getL2(), getL3(), getL4(), getL5(), getPl6(), getL6(), getPl7(), getL7(), getPl8(), getL8(), getLabsOverall());
	    System.out.println();
	    System.out.println("Project Grade: " + getProject());
	    System.out.println("Midterm Exam Grade: " + getMidterm());
	    System.out.println("Final Exam Grade: " + getFinAl());
	    System.out.println();
	    System.out.printf("Total Grade: %.2f\n", getTotal());
	    System.out.println();
	}
	}
