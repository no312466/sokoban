package controller.commands;

import java.io.IOException;

import model.Model;
import model.receivers.move.Direction;

public class MoveCommand implements Command {

	private Model model = null;
	private Direction direction = null;
	
	public MoveCommand(Model model ) { 
		this.model = model; 
	}
	public void setDefinitions(String[] definitions) {
				
		switch(definitions[1]) {
		
		case "up":	  this.direction = Direction.UP; 
					  break;
			 
		case "down":  this.direction = Direction.DOWN;;
					  break;
			
		case "right": this.direction = Direction.RIGHT;;
					  break;
			
		case "left":  this.direction = Direction.LEFT;;
				      break;
			
		default:	  System.out.println("direction dosen't exist");
					  break;
		}
		
	}
	
	
	@Override
	public void execute() throws IOException {
		model.move(direction);
	}

}


