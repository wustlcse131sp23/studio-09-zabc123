package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> dic;
	public UniversityDatabase() {
		dic = new HashMap<>();
	}
	public void addStudent(String accountName, Student student) {
		dic.put(accountName, student);
	}

	public int getStudentCount() {
		
		return dic.size();
	}

	public String lookupFullName(String accountName) {
		if (dic.get(accountName)==null) {
			return null;
		}
		return dic.get(accountName).getFullName();
	}

	public double getTotalBearBucks() {
		double sum=0;
		for (String name:dic.keySet()) {
			sum=sum+dic.get(name).getBearBucksBalance();
		}
		return sum;
	}
}
