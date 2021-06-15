package homework.score;

import java.util.Scanner;

import uility.ScanUtil;

// 

public class ScorePass {
	public static final String name = "엘사";
	public static final String SINGLE_ROW = "-------------------------";
	public static final String DOUBLE_ROW = "=========================";
	
	
	
	
	public static void main(String[] args) {
		int score = random();
		int score2 = random();
		int score3 = random();
		
		String subject = "국어";
		int subscore = score;
		String subject2 = "영어";
		int subscore2 = score2;
		String subject3 = "수학";
		int subscore3 = score3;
		
		
		 int totalScore = 0;
		 double averageScore = 0.0;


		 totalScore = getSomeScore(subscore, subscore2, subscore3);
		 averageScore = getAvgScore(subscore, subscore2, subscore3);
		 
		
	
		 
		 
		 System.out.println("==== 성적 등급 판정표 ====");
		 System.out.printf("\t 이름:'%s'씨\n", name);
		 System.out.printf("\t %s:%d 점\n",subject,subscore);
		 System.out.printf("\t %s:%d 점\n",subject2,subscore2);
		 System.out.printf("\t %s:%d 점\n",subject3,subscore3);
		 System.out.println(SINGLE_ROW);
		 System.out.printf("\t 총점: %d 점 \n", totalScore);
		 System.out.printf("\t 평균: %.2f 점\n", averageScore);
		 System.out.println(SINGLE_ROW);
		 
		 String getMsg = "";
		 getMsg = RatingaverageScore(averageScore);
		 System.out.println("\t등급판정:" + getMsg);
		 
		 
		 getMsg =  failSubScore(subscore,subscore2,subscore3);
		 System.out.println("\t과락체크:" + getMsg);
	}
			 
		
	
	

	private static String failSubScore(int subscore, int subscore2, int subscore3) {
		String getMsg = "";
		if(subscore < 41 && subscore2 < 41) {
			 getMsg = "국어 영어 과락으로 불합격";
		}else if(subscore < 41 && subscore3 < 41) {
			getMsg = "국어 수학 과락으로 불합격";
		}else if(subscore2 < 41 && subscore3 < 41) {
			getMsg = "영어 수학 과락으로 불합격";
		}else if(subscore < 41) {
			getMsg = "국어  과락으로 불합격";
		}else if(subscore2 < 41) {
			getMsg = "영어 과락으로 불합격";
		}else if(subscore3 < 41) {
			getMsg = "수학 과락으로 불합격";
		}else getMsg = "과락없음으로 합격";
			
		return getMsg;
		
	}





	public static int random() {
		return (int) ((Math.random() * 100) + 1);
	}

	private static String RatingaverageScore(double averageScore) {
		String getMsg = "";
		 if(averageScore <= 100 && averageScore > 90) {
			 	getMsg = "<<< A >>>";
		 }else if (averageScore > 70) {
		 		getMsg ="<<< B >>>";
		 }else if (averageScore > 60) {
		 		getMsg ="<<< C >>>";
		 }else if (averageScore > 40) {
		 		getMsg ="<<< D >>>";
		 }	else getMsg ="<<< F(낙제) >>>";
		
	
		return getMsg;
		
		
	}



	private static double getAvgScore(int subscore, int subscore2, int subscore3) {
		double getAvgScore = 0.0;
		getAvgScore = (double)(subscore + subscore2 + subscore3) / 3;
		return getAvgScore;
	}

	private static int getSomeScore(int subscore, int subscore2, int subscore3) {
		int  getSomeScore= 0;
		
		getSomeScore = subscore + subscore2 + subscore3;
		
		return getSomeScore;
	}
		
	

}
