package receiver_load;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import level.Level;
import level.MyObjectLevelLoader;

public class LoadObjectLevel implements LoadLevel {

	@Override
	public Level load(String path) throws IOException, IOException {
		
		MyObjectLevelLoader loader = new MyObjectLevelLoader();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		
		Level level = loader.loadLevel(in);
		
		in.close();
		
		return level;
		
	}
}