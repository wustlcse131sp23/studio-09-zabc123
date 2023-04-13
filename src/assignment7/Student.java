package assignment7;
public class Student {
	private String FN;
	private String LN;
	private int ID;
	private int attCre;
	private int passCre;
	private double TGQP;
	private double balance;
	
//	public Student(String FN1,String LN1,String ID1,int attCre1,int passCre1,int TGQP1,int balance1) {
	public Student(String FN1,String LN1,int ID1) {
		FN=FN1;
		LN=LN1;
		ID=ID1;
//		attCre=attCre1;
//		passCre=passCre1;
//		TGQP=TGQP1;
//		balance=balance1;
	}
	public Student() {
		FN="";
		LN="";
		ID=0;
		attCre=0;
		passCre=0;
		TGQP=0;
		balance=0.0;
	}
	/**
	* following methods are both getters
	*/
	public String getFullName() {
		return FN+" "+LN;
	}
	public int getId() {
		return ID;
	}
	
	/**
	* mutation method, change values of some instance variables
	*/
	public void submitGrade(double grade,int credits) {
		TGQP=TGQP+grade*credits;
		attCre=getTotalAttemptedCredits(credits);
		passCre=getTotalPassingCredits(grade,credits);
	}
	/**
	* functional method, return gpa
	*/
	public double calculateGradePointAverage() {
		
		double GPA_result=TGQP/attCre;
		return GPA_result;
	}
	
	/**
	* functional method, return atc
	*/
	public int getTotalAttemptedCredits(int credits) {
		return attCre+credits;
	}
	/**
	* functional method, return atpc
	*/
	public int getTotalPassingCredits(double grade,int credits) {
		if (grade>=1.7){
			return passCre+credits;
		}else {
			return passCre;
		}
	}
	/**
	* functional method, return stage
	*/
	public String getClassStanding() {
		if (passCre<30) {
			return "First Year";
		}
		else if (passCre>=30 && passCre<60) {
			return "Sophomore";
		}
		else if (passCre>=60 && passCre<90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	/**
	* functional method, return boolean
	*/
	public boolean isEligibleForPhiBetaKappa() {
		double GPA=calculateGradePointAverage();
		if (passCre>=98 && GPA>=3.6) {
			return true;
		}else if (passCre>=75 && GPA>=3.8) {
			return true;
		}
		else {
			return false;
		}
	}
	public void depositBearBucks(double amount) {
		balance=balance+amount;
	}
	public void deductBearBucks(double amount) {
		balance=balance-amount;
	}
	public double getBearBucksBalance() {
		return balance;
	}
	/**
	* functional method, return the remaining cash
	*/
	public double cashOutBearBucks() {
		double dummy;
		if (balance>10) {
			dummy=balance-10;
			balance=0;
			return dummy;
		}
		else {
			balance=0;
			return 0;
		}
	}
	/**
	* functional method, return new class object
	*/
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		String lastname;
		if (isHyphenated) {
			lastname=LN+"-"+otherParent.LN;
		}
		else {
			lastname=LN;
		}
		
		Student newstudent = new Student(firstName, lastname, id);
		newstudent.balance=cashOutBearBucks()+otherParent.cashOutBearBucks();
		return newstudent;
	}
	/**
	* functional method, return the full name
	*/
	public String toString() {
		return FN+" "+LN+ID;
	}

}
