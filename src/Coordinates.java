/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Coordinates {
    
    public static int[] x_coordinates = 
        {50,100,150,200,250,300,350,400,450,500,550,600,650};
    public static int[] y_coordinates = 
        {50,100,150,200,250,300,350,400,450,500,550,600,650};
    public static boolean[][] hasBlackPiece = new boolean[15][15];
    public static boolean[][] hasWhitePiece = new boolean[15][15];
    public static boolean blackWin = false;
    public static boolean whiteWin = false;
    public static int consecutiveCount;
    
    public static void setAllEmpty(){
        for (int row=0;row<hasBlackPiece.length;row++)
            for (int col=0;col<hasBlackPiece[0].length;col++)
                hasBlackPiece[row][col] = false;
        for (int row=0;row<hasWhitePiece.length;row++)
            for (int col=0;col<hasWhitePiece[0].length;col++)
                hasWhitePiece[row][col] = false;
    }
    
    public static void setAllOccupied(){
        for (int row=0;row<hasBlackPiece.length;row++)
            for (int col=0;col<hasBlackPiece[0].length;col++)
                hasBlackPiece[row][col] = true;
        for (int row=0;row<hasWhitePiece.length;row++)
            for (int col=0;col<hasWhitePiece[0].length;col++)
                hasWhitePiece[row][col] = true;
    }
    
    public static int closestX(int x){
        int distance = Math.abs(x_coordinates[0] - x);
        int idx = 0;
        for(int c = 1; c < x_coordinates.length; c++){
            int cdistance = Math.abs(x_coordinates[c] - x);
            if(cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        return x_coordinates[idx];
    }
    
    public static int closestY(int y){
        int distance = Math.abs(y_coordinates[0] - y);
        int idx = 0;
        for(int c = 1; c < y_coordinates.length; c++){
            int cdistance = Math.abs(y_coordinates[c] - y);
            if(cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        return y_coordinates[idx];
    }
    
    public static boolean detectOverlay(int y, int x){
        if (Coordinates.hasBlackPiece[y][x]==true||
                Coordinates.hasWhitePiece[y][x]==true)
            return true;
        else
            return false;
    }
    
    public static boolean detectBlackWin(int y, int x){
        consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasBlackPiece[y+count][x]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;

        for(int count=1; Coordinates.hasBlackPiece[y-count][x]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;

        for(int count=1; Coordinates.hasBlackPiece[y][x+count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasBlackPiece[y][x-count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasBlackPiece[y+count][x+count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasBlackPiece[y-count][x-count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasBlackPiece[y+count][x-count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasBlackPiece[y-count][x+count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        if(consecutiveCount == 5)
            return true;
        else
            return false;
    }
    
    public static boolean detectWhiteWin(int y, int x){
        consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasWhitePiece[y+count][x]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;

        for(int count=1; Coordinates.hasWhitePiece[y-count][x]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;

        for(int count=1; Coordinates.hasWhitePiece[y][x+count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasWhitePiece[y][x-count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasWhitePiece[y+count][x+count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasWhitePiece[y-count][x-count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasWhitePiece[y+count][x-count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        for(int count=1; Coordinates.hasWhitePiece[y-count][x+count]==true; count++)
            consecutiveCount++;
        if (consecutiveCount!=5)
            consecutiveCount = 1;
        
        if(consecutiveCount == 5)
            return true;
        else
            return false;  
    }
}