package cn.edu.qdu;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Sys {
	public static void main(String[] args) {
		FileWriter out=null;
		try {
			//保存学生成绩文件
			out=new FileWriter("H:\\JAVA\\grade.txt");
			
			//导入正确答案
			Answer answer=new Answer();
			List<String> answers=new ArrayList<String>();
			answers=answer.getAnswer();
			
			//导入学生答案
			StuAnswer stuAnswer=new StuAnswer();
			List<String> stuNames=new ArrayList<String>();//学生名字
			List<String> stuAnswers=new ArrayList<String>();//学生答案
			stuAnswers=stuAnswer.getStuAnswer();
			stuNames=stuAnswer.getStuNames();
			
			//批卷
			for (int i = 0; i < answers.size(); i++) {
				String tempAnswer=answers.get(i);
				String tempStuAnswer=stuAnswers.get(i);
				double score=0;//分数
				int right=0;//正确题数
				//对照答案
				for (int j = 0; j < tempAnswer.length(); j++) {
					char c1=tempAnswer.charAt(j);
					char c2=tempStuAnswer.charAt(j);
					boolean c1_flag=(('a'<c1 && c1<'d')||(('A'<c1 && c1<'D')));
					boolean c2_flag=(('a'<c2 && c2<'d')||(('A'<c2 && c2<'D')));
					if (c1_flag && c2_flag && (c1==c2 || c1==(c2-22))) {
						//System.out.println("AAAA");
						right++;
					}
				}
				//统计成绩
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
