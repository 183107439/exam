package cn.edu.qdu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Answer {
	private List<String> answers;//用集合存储答案
	
	//初始化块
	{
		answers=new ArrayList<String>();
	}
	//方法--读入正确答案
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
