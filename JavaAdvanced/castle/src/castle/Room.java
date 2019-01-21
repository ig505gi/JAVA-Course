package castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<String, Room>();

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExit(String direction, Room exit) 
    {
    	exits.put(direction, exit);
    }
    
    public String getExitsDesc() 
    {
    	StringBuffer sb = new StringBuffer();
    	for( String direction : exits.keySet() ) 
    	{
    		sb.append(direction);
    		sb.append(" ");
    	}
    	return sb.toString();
    }
    
    public Room getNextRoom(String direction) 
    {
    	Room re = null;
    	re = exits.get(direction);
    	return re;
    }
    
    @Override
    public String toString()
    {
        return description;
    }
}
