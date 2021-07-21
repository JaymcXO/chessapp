/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/* import java.util.LinkedList; */

/**
 *
 * @author jaymc
 */
/* public class King extends Pieces 
{
    private boolean castling = false;
    
    public King(boolean colourType,  int yPos, int xPos, String name, LinkedList<Pieces> list)
    {
        Pieces whiteKing = new Pieces(true, 4, 7, "king", list);
    }
    
    public boolean isCastlingDone()
    {
        return this.castling;
    }
    
    public void setCastlingDone(boolean castling){
        this.castling = castling;
    }
    
    public boolean canMove(int xPos, int yPos)
    {
        if(Chess.getPiece(xPos * 64, yPos * 64) != null){
            if(Chess.getPiece(xPos * 64, yPos * 64).colourSide != colourSide){
                Chess.getPiece(xPos * 64, yPos * 64).kill();
            }else{
                x =  this.xPos * 64;
                y = this.yPos * 64;
                return false;
            }
        }
    }
} /*
