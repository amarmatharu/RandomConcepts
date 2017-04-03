
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {

	private static Properties props;
	private static InputStream propertyStream;
	private static final String dimTableFilename = "DimTableNames.properties";
	private static final String dimViewFilename = "DimViewNames.properties";
	private static final String factTableFilename = "FactTableNames.properties";
	private static final String factViewFilename = "FactViewNames.properties";
	private static final String aggTableFilename = "AggTableNames.properties";
    private static Map<String, String> file_map = new HashMap<>();
    
    static{
    	file_map.put("dimtable", dimTableFilename);
    	file_map.put("dimview", dimViewFilename);
    	file_map.put("facttable", factTableFilename);
    	file_map.put("factview", factViewFilename);
    	file_map.put("aggtable", aggTableFilename);
    }
	private void initPropFile(String filename) {
            props = new Properties();
			propertyStream = getClass().getClassLoader().getResourceAsStream(filename);

			try {
				props.load(propertyStream);
			} catch (Exception e) {
				throw new RuntimeException("An error occurred while attempting to load the property file: " + filename,
						e);

			} finally {
				try {
					if (propertyStream != null)
						propertyStream.close();
				} catch (IOException e) {
					throw new RuntimeException(
							"An error occurred while attempting to close the property file: " + filename, e);
				}
			}
			
		}
	
	

	public List<String> getList(String detailStructure) {
		initPropFile(file_map.get(detailStructure));
		List<String> fileNames = new ArrayList<String>();
		for (Map.Entry<Object, Object> e : props.entrySet()) {
			String key = (String) e.getKey();
			fileNames.add(key);
		}
		return fileNames;
	}

}