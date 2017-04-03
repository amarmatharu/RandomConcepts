import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {
	
	private static String table = "_TAB";
	private static String view = "_VW";
	private PropertyUtil util = new PropertyUtil();
	
	public final String text_to_search_1 = "TEMPLATECLASS";
	public final String text_to_search_2 = "TEMPLATEPACKAGE";
	public final String text_to_search_3 = "TEMPLATESERVICE";
	
	public void readFileFromDirectory(String fromDirectory, String toDirectory, String structure, String detailStructure, String serviceName)
	{
			  
		try{
			List<String> fileNames = new ArrayList<String>();
			fileNames = util.getList(detailStructure);
			
			for(int i =0; i < fileNames.size(); i++)
			{
				ArrayList<String> lines = new ArrayList<String>();
				  String line = null;
				StringBuffer bf = new StringBuffer(toDirectory);
				String fileName_key = fileNames.get(i);
				bf.append(fileName_key).append(structure).append(".java");
				String textToReplace_1 = fileName_key + structure;
				String textToReplace_2 = detailStructure;
				String textToReplace_3 = serviceName;
	    	   File afile =new File(fromDirectory);
	    	   File output =new File(bf.toString());

	    	   FileReader fr = new FileReader(afile);
	           BufferedReader br = new BufferedReader(fr);
	           
	           while ((line = br.readLine())!= null)
	           
	           {
	                if (line.contains(text_to_search_1))
	                {
	                    line = line.replace(text_to_search_1, textToReplace_1);
	                }
	                if (line.contains(text_to_search_2))
	                {
	                    line = line.replace(text_to_search_2, textToReplace_2);
	                }
	                if (line.contains(text_to_search_3))
	                {
	                    line = line.replace(text_to_search_3, textToReplace_3);
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
	    	   
	    	
	    	   System.out.println("File is moved!");
	    
	    	 
			}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
		

	
	public static void main(String args[])
	{		
		CreateFile obj = new CreateFile();
		obj.readFileFromDirectory(
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\FileMakerUtiltiy\\input\\template.java",
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\JmeterTestUtility\\src\\main\\java\\com\\bdna\\automation\\bdnapublish\\dimtable\\",
				table,
				"dimtable",
				"DimTableService");
		obj.readFileFromDirectory(
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\FileMakerUtiltiy\\input\\template.java",
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\JmeterTestUtility\\src\\main\\java\\com\\bdna\\automation\\bdnapublish\\dimview\\",
				view,
				"dimview",
				"DimViewService");
		obj.readFileFromDirectory(
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\FileMakerUtiltiy\\input\\template.java",
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\JmeterTestUtility\\src\\main\\java\\com\\bdna\\automation\\bdnapublish\\facttable\\",
				table,
				"facttable",				
				"FactTableService");
		obj.readFileFromDirectory(
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\FileMakerUtiltiy\\input\\template.java",
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\JmeterTestUtility\\src\\main\\java\\com\\bdna\\automation\\bdnapublish\\factview\\",
				view,
				"factview",				
				"FactViewService");
		obj.readFileFromDirectory(
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\FileMakerUtiltiy\\input\\template.java",
				"C:\\Users\\rjames\\Documents\\GitHub\\master_UtilityProjects\\JmeterTestUtility\\src\\main\\java\\com\\bdna\\automation\\bdnapublish\\aggtable\\",
				table,
				"aggtable",				
				"AggTableService");
	}
	
	
	

}
