package cn.edu.qdu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StuAnswer {
	private List<String> stuNames;//ʹ�ü��ϴ洢ѧ������
	private List<File> answersFiles;//ʹ�ü��ϱ�������ѧ�����ļ���ַ
	private List<String> stuAnswers;//ʹ�ü���ѧ����
	
	//��ʼ����
	{
		stuNames=new ArrayList<String>();
		answersFiles=new ArrayList<File>();
		stuAnswers=new ArrayList<String>();
	}
	//����--��ȡ���С�ѧ���𰸡��ļ��м��ļ����µ������ļ�
		public List<File> getAnswersFile() throws IOException{
			File file=null;
			try {
				file=new File("H:\\JAVA\\stuAnswer");//�ҵ�ѧ���ɼ��ļ���
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
		
	//����--��ȡѧ����
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