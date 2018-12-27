import java.util.HashMap;

public class studentSystem {
	
	private HashMap<Integer, String> courseList = new HashMap<Integer, String>();
	private HashMap<String, HashMap<String, Integer>> studentList = new HashMap<String, HashMap<String, Integer>>();
	
	public void addCourse(int courseID, String courseName) {
		courseList.put(courseID, courseName);
	}
	
	public void addScore(String name, String courseName, int score) {
		if ( !studentList.keySet().contains(name) ) {
			studentList.put(name, new HashMap<String, Integer>(){{put(courseName, score);}});
		}
		
		studentList.get(name).put(courseName, score);
	}
	
	public void listScoreByStudent(String name) {
		for (String courseName : studentList.get(name).keySet()) {
			System.out.println(name +  " : " + courseName + " : " +studentList.get(name).get(courseName));
		}
	}
	
	public void listScoreByCourse(String courseName) {
		for (String name : studentList.keySet()) {
			System.out.println(courseName + " : " + name + " : " + studentList.get(name).get(courseName));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		studentSystem stuDB = new studentSystem();
		stuDB.addCourse(1, "Math");
		stuDB.addCourse(2, "English");
		stuDB.addCourse(3, "Chinese");
		stuDB.addScore("Gao", "Math", 100);
		stuDB.addScore("Gao", "English", 200);
		stuDB.addScore("Gao", "Chinese", 300);
		stuDB.addScore("Yuan", "Math", 100);
		stuDB.addScore("Yuan", "English", 67);
		stuDB.addScore("Yuan", "Chinese", 50);
		stuDB.listScoreByStudent("Gao");
		stuDB.listScoreByStudent("Yuan");
		stuDB.listScoreByCourse("Math");
		stuDB.listScoreByCourse("English");
	}

}
