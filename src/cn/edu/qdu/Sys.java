package cn.edu.qdu;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Sys {
	public static void main(String[] args) {
		FileWriter out=null;
		try {
//			out=new FileWriter("H:\\JAVA\\grade.txt",Appendable);
			out=new FileWriter("H:\\JAVA\\grade.txt");
			
			Answer answer=new Answer();
			List<String> answers=new ArrayList<String>();
			answers=answer.getAnswer();
			
			StuAnswer stuAnswer=new StuAnswer();
			List<String> stuNames=new ArrayList<String>();
			List<String> stuAnswers=new ArrayList<String>();
			stuAnswers=stuAnswer.getStuAnswer();
			stuNames=stuAnswer.getStuNames();
			
			for (int i = 0; i < answers.size(); i++) {
				String tempAnswer=answers.get(i);
				String tempStuAnswer=stuAnswers.get(i);
				double score=0;
				int right=0;
				for (int j = 0; j < tempAnswer.length(); j++) {
					char c1=tempAnswer.charAt(j);
					char c2=tempStuAnswer.charAt(j);					
					if (c1==c2 || c1==(c2+22)) {
						right++;
					}
				}
				score=4*right;
				out.append(stuNames.get(i));
				out.append("  "+score+"\n");		
			}
			out.close();
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
		}finally {
			//out.close();
			System.out.println("OVER!");
		}
		
	}
}
