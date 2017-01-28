package view;

import java.io.IOException;
import java.util.Scanner;

import command.*;
import level.Level;
import moveable.Moveable;
import receiver_move.Direction;
import receiver_move.Move;

public class CLI {

	private Scanner scanner = new Scanner(System.in);
	private String choose = null;
	private boolean exit = false;
	private Level level = null;
	private MoveCommand moveUp = null;
	private MoveCommand moveDown = null;
	private MoveCommand moveRight = null;
	private MoveCommand moveLeft = null;
	private Moveable moveable = null;
	private DisplayCommand display = null;
	
	public void run() throws IOException {
				
		System.out.println("This is the Sokoban game!");
		System.out.println("Please choose command:"+"\n"
							+"Load filename"+"\n"
							+"Display"+"\n"
							+"Move {up, down, left, right}"+"\n"
							+"Save 'filepath'"+" ending"+"\n"
							+"Exit"+"\n"+"\n");
		
		while (!exit) {
			choose = scanner.nextLine();
			choose = choose.toLowerCase();
			String[] command = choose.split(" ");
			
			switch(command[0]) { 
			
			case "load":
				if (command.length < 2) {
				System.out.println("no path");
				break;
			}
			load(command[1]);
			break;
			
			case "display":	
				display();
				break;
				
			case "move":		
				if (command.length < 2) {
					System.out.println("invalid direction");
					break;
					}
				move(command[1]);
				break;
				
			case "save":		
				if (command.length < 2) {
					System.out.println("no path");
					break;
					}
				save(command[1]);
				break;
			
			case "exit": 		
				exit();
				break;
			
			default:			
				System.out.println("invalid command");
				break;
			
			}

		}
		scanner.close();
		
	}
	
	private void load(String path) throws IOException {
		
		LoadCommand loadCommand = new LoadCommand(path);
		loadCommand.execute();
		if (loadCommand.getLevel() == null)
			return;
		level = loadCommand.getLevel();
		
		moveUp = new MoveCommand(new Move(level,level.getPlayer(),Direction.UP));
		moveDown = new MoveCommand(new Move(level,level.getPlayer(),Direction.DOWN));
		moveLeft = new MoveCommand(new Move(level,level.getPlayer(),Direction.LEFT));
		moveRight = new MoveCommand(new Move(level,level.getPlayer(),Direction.RIGHT));
		
		display = new DisplayCommand(level);
		moveable = new Moveable(level);
				
	}
	
	private void save(String path) throws IOException {
		
		if (level == null){
			System.out.println("level is not loaded");
			return;
		}
		SaveCommand saveCommand = new SaveCommand(level,path);
		saveCommand.execute();
		
	}
	
	private void move(String direction) {
		
		if (level == null){
			System.out.println("level is not loaded");
			return;
		}
		
		switch(direction) {
		
		case "up":	  
			moveable.execute(moveUp);
			display();
			break;
			 
		case "down":  
			moveable.execute(moveDown);
			display();
			break;
			
		case "right": 
			moveable.execute(moveRight);
			display();
			break;
			
		case "left":  
			moveable.execute(moveLeft);				      
			display();
			break;
			
		default:	 
			System.out.println("invalid direction");
			break;
		}
			
	}
	
	private void display() {
		
		if(display == null)
		{
			System.out.println("level is not loaded");
			return;
		}
		display.execute();
	}
	
	private void exit() {
		
		ExitCommand exitCommand = new ExitCommand();
		exit = exitCommand.getExit();
	}
	
	public boolean isExit(){
		return exit;
	}
	
	
}