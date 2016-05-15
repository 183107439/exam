package cn.edu.qdu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Answer {
	private List<String> answers;//�ü��ϴ洢��
	
	//��ʼ����
	{
		answers=new ArrayList<String>();
	}
	//����--������ȷ��
	public  List<String> getAnswer() throws IOException{
		BufferedReader in=null;
		try {
			in=new BufferedReader(new FileReader("H:\\JAVA\\answer.txt"));
			String s;
			while ((s=in.readLine())!=null) {		
				answers.add(s);	
			}
			return answers;
		} catch (Exception e) {
			throw e;
		}finally{		
			for (String answer: answers) {
				System.out.println(answer);
			}
			in.close();
		}
	}
	
}
