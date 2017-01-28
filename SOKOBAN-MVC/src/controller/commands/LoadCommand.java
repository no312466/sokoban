package controller.commands;

import java.io.IOException;
import java.util.HashMap;

import model.Model;
import model.data.level.Level;
import model.receivers.load.LoadLevel;
import model.receivers.load.LoadObjectLevel;
import model.receivers.load.LoadTextLevel;
import model.receivers.load.LoadXMLLevel;

public class LoadCommand implements Command {

	private HashMap<String,LoadLevel> levelLoaderFactory = new HashMap<String,LoadLevel>();
	private Level level = null;
    private String type = null;
	private String path = null;
	private Model model = null;
	
	
	@Override
	public void setDefinitions(String[] definition) {	
		this.path = definition[1];
		this.type = path.substring(path.lastIndexOf('.')+1);
	}
	
	public LoadCommand(Model model) {
		this.model = model;
		levelLoaderFactory.put("txt",new LoadTextLevel());
		levelLoaderFactory.put("obj",new LoadObjectLevel());
		levelLoaderFactory.put("xml",new LoadXMLLevel());
	}
	
	@Override
	public void execute() throws IOException {
		if (!(type.equals("txt") || type.equals("obj") || type.equals("xml")))
		{
			throw new IOException("incorrect file name");
		}
		
		level = levelLoaderFactory.get(type).load(path);
    	model.setLevel(level);
		System.out.println("Completed");
	}


}
