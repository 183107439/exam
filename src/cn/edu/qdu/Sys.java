package cn.edu.qdu;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Sys {
	public static void main(String[] args) {
		FileWriter out=null;
		try {
			//����ѧ���ɼ��ļ�
			out=new FileWriter("H:\\JAVA\\grade.txt");
			
			//������ȷ��
			Answer answer=new Answer();
			List<String> answers=new ArrayList<String>();
			answers=answer.getAnswer();
			
			//����ѧ����
			StuAnswer stuAnswer=new StuAnswer();
			List<String> stuNames=new ArrayList<String>();//ѧ������
			List<String> stuAnswers=new ArrayList<String>();//ѧ����
			stuAnswers=stuAnswer.getStuAnswer();
			stuNames=stuAnswer.getStuNames();
			
			//����
			for (int i = 0; i < answers.size(); i++) {
				String tempAnswer=answers.get(i);
				String tempStuAnswer=stuAnswers.get(i);
				double score=0;//����
				int right=0;//��ȷ����
				//���մ�
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
				//ͳ�Ƴɼ�
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
