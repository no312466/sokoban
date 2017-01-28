package model.receivers.save;

import java.io.IOException;

import model.data.level.Level;

public interface SaveLevel {

	public void save(Level level, String path) throws IOException;
	
}
