enum Direction  
{  
     EAST, SOUTH, WEST, NORTH
} 
class EnumDemo
{
    public static void main(String[] args)   
    {  
		Direction dir = Direction.NORTH;
        switch(dir)  
        {  
            case EAST:  
                System.out.println("向东");  
                break;  
            case SOUTH:  
                System.out.println("向南");  
                break;  
            case WEST:  
                System.out.println("向西");  
                break;  
            case NORTH:  
                System.out.println("向北");  
                break;  
        }  
    }  
}