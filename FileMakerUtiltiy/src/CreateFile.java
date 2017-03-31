import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {
	
	private PropertyUtil util = new PropertyUtil();
	
	public final String text_to_search = "public class TEMPLATE";
	
	public void readFileFromDirectory(String fileName)
	{
			  
		try{
			List<String> fileNames = new ArrayList<String>();
			fileNames = util.getList();
			
			//fileNames.addAll(util.getList());
	
			
			for(int i =0; i < fileNames.size(); i++)
			{
				ArrayList<String> lines = new ArrayList<String>();
				  String line = null;
				StringBuffer bf = new StringBuffer("C:\\GIT\\JmeterTestUtility\\src\\main\\java\\com\\bdna\\automation\\dim\\");
				String fileName_key = fileNames.get(i);
				bf.append(fileName_key).append(".java");
				System.out.println("Class name: " + fileName_key);
				
				String textToReplace = "public class " + fileName_key;
				System.out.println("Writing file: " + bf.toString() + " " + fileName_key);
	    	   File afile =new File("C:\\GIT\\FileMakerUtiltiy\\input\\template.java");
	    	   File output =new File(bf.toString());

	    	   FileReader fr = new FileReader(afile);
	           BufferedReader br = new BufferedReader(fr);
	           
	           while ((line = br.readLine())!= null)
	           
	           {
	                if (line.contains(text_to_search))
	                {
	                	System.out.println("replacing text: " + textToReplace);
	                    line = line.replace(text_to_search, textToReplace);
	                    System.out.println("line: " + line);
	                }
	                lines.add(line);
	            }
	           
	          
	           
	           FileWriter fw = new FileWriter(output);
	            BufferedWriter out = new BufferedWriter(fw);
	            for(String s : lines)
	            {
	                 out.write(s);
	                 System.out.println("Line written: " + s);
	            }
	            
	                 
	            fr.close();
		        br.close();
	            out.flush();
	            out.close();
	    	   
	    	  // Files.copy(afile.toPath(), output.toPath());
	    	   System.out.println("File is moved!");
	    
	    	   /*
	    	   if(afile..renameTo(new File("C:\\GIT\\FileMakerUtiltiy\\output\\" + afile.getName()))){
	    		System.out.println("File is moved successful!");
	    	   }else{
	    		System.out.println("File is failed to move!");
	    	   }
*/
			}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
		

	
	public static void main(String args[])
	{
		
		
		CreateFile obj = new CreateFile();
		obj.readFileFromDirectory("input/DIM_N_CPU.java");
	}
	
	
	

}
