
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {

	private static Properties props = new Properties();
	private static boolean isPropInitialized = false;
	// private static final Logger logger =
	// Logger.getLogger(PropertyUtil.class);
	private static final String filename = "FileName.properties";

	private void initPropFile() {

		if (!isPropInitialized) {

			// if (logger.isDebugEnabled()) logger.debug("Reading " + filename +
			// " file");

			InputStream propertyStream = getClass().getClassLoader().getResourceAsStream(filename);

			try {
				// logger.debug("prop: " + propertyStream + " props: " + props);

				props.load(propertyStream);

				isPropInitialized = true;

			} catch (Exception e) {

				// logger.error("An error occurred while attempting to read the
				// property file: " + filename + e.getMessage(),e);
				throw new RuntimeException("An error occurred while attempting to read the property file: " + filename,
						e);

			} finally {
				try {
					if (propertyStream != null)
						propertyStream.close();
				} catch (IOException e) {
					// logger.error("An error occurred while attempting to close
					// the property file: " + filename + e.getMessage(),e);
					throw new RuntimeException(
							"An error occurred while attempting to close the property file: " + filename, e);
				}
			}
		}
	}

	public String getValue(String key) {

		initPropFile();
		String value = props.getProperty(key);
		// if (logger.isDebugEnabled()) logger.debug("Retrieved value: " + value
		// + " from config file");

		if ((value == null || value.trim().equals("")))
			throw new IllegalStateException(
					"Property: " + key + " was not found in the configuration file: " + filename);

		return value;

	}

	public List<String> getList() {
		initPropFile();
		List<String> fileNames = new ArrayList<String>();
		for (Map.Entry<Object, Object> e : props.entrySet()) {
			String key = (String) e.getKey();
			fileNames.add(key);

		}

		return fileNames;

	}

}