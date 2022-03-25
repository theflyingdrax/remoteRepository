package commonFunctionality;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public Properties prop;
	FileInputStream fis = null;
	
public Properties readProperty() {
     prop=new Properties();
	
	try {
		fis = new FileInputStream("src\\main\\java\\commonFunctionality\\data.properties");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		prop.load(fis);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return prop;
	
}
}
