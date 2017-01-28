package receiver_load;

import java.io.FileInputStream;
import java.io.IOException;

import level.Level;
import level.MyXMLLevelLoader;

public class LoadXMLLevel implements LoadLevel{

	@Override
	public Level load(String path) throws IOException, IOException {
		
		MyXMLLevelLoader loader = new MyXMLLevelLoader();
		
		FileInputStream in = new FileInputStream(path);
		
		Level level = loader.loadLevel(in);
		
		in.close();
		
		return level;
	
	}
}