package com.mirre.test.view.question.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.mirre.test.TestMain;
import com.mirre.test.utils.Question;

public enum Questions {
	//0,1,2,3
	GEOGRAFI {
		@Override
		public List<Question> getQuestions() {
			return getQuestions("Geografi");
		}
	}, HISTORIA {
		@Override
		public List<Question> getQuestions() {
			return getQuestions("Historia");
		}
	}, NÖJE {
		@Override
		public List<Question> getQuestions() {
			return getQuestions("Nöje");
		}
	}, BLANDAT {
		@Override
		public List<Question> getQuestions() {
			List<Question> questions = new ArrayList<Question>();
			questions.addAll(getQuestions("Geografi"));
			questions.addAll(getQuestions("Historia"));
			questions.addAll(getQuestions("Nöje"));
			return questions;
		}
	};
	
	Questions(){}
	
	public abstract List<Question> getQuestions();
	
	private static List<Question> getQuestions(String loc){
		List<Question> questions = new ArrayList<Question>();
		try {
			final File folder = new File(TestMain.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "com/mirre/test/view/question/resources/");
			File f = folder.listFiles(new FilenameFilter(){
				@Override
				public boolean accept(File file, String s) {
					if(s.contains(loc))
						return true;
					return false;
				}
			})[0];
			try(BufferedReader br = new BufferedReader(new FileReader(f))) {
				StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    for(String l : sb.toString().split("\n")){
			    	questions.add(Question.fromString(l));
			    }
			    
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return questions;
	}
}
