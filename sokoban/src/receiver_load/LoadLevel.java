package receiver_load;

import java.io.IOException;

import level.Level;

public interface LoadLevel {

	public Level load(String path) throws IOException;
	
}