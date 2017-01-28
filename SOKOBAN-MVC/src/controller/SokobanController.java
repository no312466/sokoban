package controller;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import controller.commands.Command;
import controller.commands.DisplayCommand;
import controller.commands.ExitCommand;
import controller.commands.LoadCommand;
import controller.commands.MoveCommand;
import controller.commands.SaveCommand;
import controller.server.MyServer;
import model.Model;
import view.View;

public class SokobanController implements Observer {

	private Model myModel;
	private View myView;
	private Controller myController;
	private MyServer myServer;
	private HashMap<String,Command> commands = new HashMap<String,Command>();

	
	public SokobanController(Model model, View view) {
		this.myModel = model;
		this.myView = view;
		this.myController = new Controller();
		commands.put("load", new LoadCommand(myModel));
		commands.put("save", new SaveCommand(myModel));
		commands.put("move", new MoveCommand(myModel));
		commands.put("exit", new ExitCommand(myController));
		//commands.put("display", new DisplayCommand(myModel, myServer));
	}
	
	public Command commandProcessor(String input){
		
		String process = input;
		process = process.toLowerCase();
		String[] definitions = process.split(" ");
		commands.put("display", new DisplayCommand(myModel, myServer));
		Command c = commands.get(definitions[0]);
		c.setDefinitions(definitions);
		return c;
	}
	
	
	@Override
	public void update(Observable obserable, Object arg) {
		
		if(arg != null)
			myController.insertCommand(commandProcessor((String)arg));	
	}
	


	public MyServer getServer() {
		return myServer;
	}

	public void setServer(MyServer server) {
		this.myServer = server;

	}

	public Controller getController() { return this.myController; }
	


	
	

}

