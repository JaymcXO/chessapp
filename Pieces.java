package chess;

import java.util.LinkedList;

/**
 *
 * @author jaymc
 */
public class Pieces {
    //defining variable to recognize the positon, colour of the pieces and create the list of pieces
    boolean colourSide; 
    int yPos;
    int xPos;
    
    int x;
    int y;
    LinkedList<Pieces> list;
    String pieceType;
    
    public Pieces(boolean colourSide, int yPos, int xPos, String name, LinkedList<Pieces> list) {
        x =  xPos * 64;
        y = yPos * 64;
        this.colourSide = colourSide;
        this.yPos = yPos;
        this.xPos = xPos;
       
        this.list = list;
        pieceType = name;
        list.add(this);
    }
    
    public void pieceMovement(int yPos, int xPos){
        if(Chess.getPiece(xPos * 64, yPos * 64) != null){
            if(Chess.getPiece(xPos * 64, yPos * 64).colourSide != colourSide){
                Chess.getPiece(xPos * 64, yPos * 64).kill();
            }else{
                x =  this.xPos * 64;
                y = this.yPos * 64;
                return;
            }
        }
        this.xPos = xPos;
        this.yPos = yPos;
        
        x =  xPos * 64;
        y = yPos * 64;
    }
        
    public void kill(){
        list.remove(this);
    }
}
