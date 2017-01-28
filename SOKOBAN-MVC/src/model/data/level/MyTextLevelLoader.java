package model.data.level;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.data.components.Baggage;
import model.data.components.Floor;
import model.data.components.Player;
import model.data.components.Target;
import model.data.components.Wall;
import model.data.components.Components;

public class MyTextLevelLoader implements LevelLoader{

	BufferedReader reader;
	
	public MyTextLevelLoader() {}
	
	@Override
	public Level loadLevel(InputStream input) throws IOException  
	{	
		if (!(input instanceof FileInputStream))
			throw new IOException("input is not FileInputStream instance");
	
		this.reader = new BufferedReader(new InputStreamReader(input));
		ArrayList<ArrayList<Components>> grid = new ArrayList<ArrayList<Components>>();
		String line;
		int i = 0;
		while ((line = reader.readLine()) != null) 
		{
			grid.add(new ArrayList<Components>());

			for(int j = 0; j < line.length(); j++)
			{
				if (line.charAt(j) == '#')
					grid.get(i).add(new Wall(new Point(i,j)));
				if (line.charAt(j) == '@')
					grid.get(i).add(new Baggage(new Point(i,j)));
				if (line.charAt(j) == 'o')
					grid.get(i).add(new Target(new Point(i,j)));
				if (line.charAt(j) == ' ')
					grid.get(i).add(new Floor(new Point(i,j)));
				if (line.charAt(j) == 'A')
					grid.get(i).add(new Player(new Point(i,j)));
			}
			i++;
		}
		reader.close();		
		Level level = new Level(grid);
		return level;
	}
}
		



