package stringWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringWork {
	
	private String o = "NCB=Y+S:8+X+F'";
	private ArrayList<String> list = new ArrayList<String>();
	
	StringWork() throws IOException{
		File file = new File("./files/policies.txt");
		readFile(file);
		createAmendedFile(list);
	}

	public static String split(String s, String d, int i){	//String, Delimiter, Index to return
		List<String> l = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(s, d);
		while(st.hasMoreTokens()){
			l.add(st.nextToken());
		}
		return l.get(i);
	}



	private void readFile(File f)    {   
		BufferedReader br = null;  
		String n = null;
		try{   
			br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));   
			String line = null;   
			while((line = br.readLine()) != null){   
				n = (split(o,"+", 0) + "+" + split(o,"+", 1) + "::" + split(line, ",", 2) + "+" + split(o,"+", 2) + "+" + split(o,"+",3));
				list.add(n);
			}
			br.close();
		}catch(IOException ioe)   {   
			System.err.println("read: " + ioe.getMessage());   
		} 
	}
	
	private void createAmendedFile(ArrayList<String> list) throws IOException{
		File file = new File("./files/amended.txt");
		FileWriter writer = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(writer);
		for(int i = 0; i<list.size(); i++){
			out.write(list.get(i));
			out.write("\r\n");
		}
	    writer.flush();
	    out.close();
	}
	
	
	
	public static void main(String[] args) throws IOException{
		new StringWork();
	}
}
