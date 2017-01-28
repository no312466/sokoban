package receiver_load;

import java.io.FileInputStream;
import java.io.IOException;

import level.Level;
import level.MyTextLevelLoader;

public class LoadTextLevel implements LoadLevel {

	@Override
	public Level load(String path) throws IOException, IOException {
		
		MyTextLevelLoader loader = new MyTextLevelLoader();
		
		Level level = loader.loadLevel(new FileInputStream(path));
		
		return level;
	
	}		
}