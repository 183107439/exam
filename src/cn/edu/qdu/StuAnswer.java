package cn.edu.qdu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StuAnswer {
	private List<String> stuNames;//使用集合存储学生姓名
	private List<File> answersFiles;//使用集合保存所有学生的文件地址
	private List<String> stuAnswers;//使用集合学生答案
	
	//初始化块
	{
		stuNames=new ArrayList<String>();
		answersFiles=new ArrayList<File>();
		stuAnswers=new ArrayList<String>();
	}
	//方法--获取所有‘学生答案’文件夹及文件夹下的所有文件
		public List<File> getAnswersFile() throws IOException{
			File file=null;
			try {
				file=new File("H:\\JAVA\\stuAnswer");//找到学生成绩文件夹
				File[] stuAnswerList=file.listFiles();
				for (File file2 : stuAnswerList) {
					answersFiles.add(file2);
					stuNames.add(file2.getName());
				}
				return answersFiles;
			} catch (Exception e) { 
				throw e;
			}
		}
		
	//方法--获取学生答案
	public List<String> getStuAnswer() throws Exception{
		BufferedReader in=null;
		try {
			getAnswersFile();
			for (File file : answersFiles) {
				in=new BufferedReader(new FileReader(file));
				String s;
				while ((s=in.readLine())!=null) {
					stuAnswers.add(s);					
				}				
			}	
			return stuAnswers;	
		} catch (Exception e) {
			throw e;
		}finally{
			in.close();
		}
	}

	public List<String> getStuNames() {
		return stuNames;
	}

	public void setStuNames(List<String> stuNames) {
		this.stuNames = stuNames;
	}
	
}