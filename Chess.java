
package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jaymc
 */
public class Chess {

    public static LinkedList<Pieces> list = new LinkedList<>();
    public static Pieces selectedPiece = null;
    
    public static void main(String[] args) throws IOException{
        
        //creates a list and an array of images to recognize the different chess pieces from an image and place them on the board.
        
        BufferedImage all = ImageIO.read(new File("C:\\Users\\jaymc\\Desktop\\chessapp\\chess.png"));
        Image imgs[] = new Image[12];
        int index=0;
        
        //takes the image and splits it into subsections to distinguish pieces to be able to place them on the grid
        for(int x = 0; x < 400; x += 200){
            for(int y = 0; y < 1200; y += 200){
                imgs[index] = all.getSubimage(y, x, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                index++;
            }
        }
        
        //places the subimages on the grid to act as chess pieces 
        Pieces blackRook = new Pieces(false, 0, 0, "rook", list);
        Pieces blackKnight = new Pieces(false, 1, 0, "knight", list);
        Pieces blackBishop = new Pieces(false, 2, 0, "bishop", list);
        Pieces blackQueen = new Pieces(false, 3, 0, "queen", list);
        Pieces blackKing = new Pieces(false, 4, 0, "king", list);
        Pieces blackBishop2 = new Pieces(false, 5, 0, "bishop", list);
        Pieces blackKnight2 = new Pieces(false, 6, 0, "knight", list);
        Pieces blackRook2 = new Pieces(false, 7, 0, "rook", list);
        Pieces blackPawn = new Pieces(false, 1, 1, "pawn", list);
        Pieces blackPawn2 = new Pieces(false, 2, 1, "pawn", list);
        Pieces blackPawn3 = new Pieces(false, 3, 1, "pawn", list);
        Pieces blackPawn4 = new Pieces(false, 4, 1, "pawn", list);
        Pieces blackPawn5 = new Pieces(false, 5, 1, "pawn", list);
        Pieces blackPawn6 = new Pieces(false, 6, 1, "pawn", list);
        Pieces blackPawn7 = new Pieces(false, 7, 1, "pawn", list);
        Pieces blackPawn8 = new Pieces(false, 0, 1, "pawn", list);

        Pieces whiteRook = new Pieces(true, 0, 7, "rook", list);
        Pieces whiteKnight = new Pieces(true, 1, 7, "knight", list);
        Pieces whiteBishop = new Pieces(true, 2, 7, "bishop", list);
        Pieces whiteQueen = new Pieces(true, 3, 7, "queen", list);
        Pieces whiteKing = new Pieces(true, 4, 7, "king", list);
        Pieces whiteBishop2 = new Pieces(true, 5, 7, "bishop", list);
        Pieces whiteKnight2 = new Pieces(true, 6, 7, "knight", list);
        Pieces whiteRook2 = new Pieces(true, 7, 7, "rook", list);
        Pieces whitePawn = new Pieces(true, 1, 6, "pawn", list);
        Pieces whitePawn2 = new Pieces(true, 2, 6, "pawn", list);
        Pieces whitePawn3 = new Pieces(true, 3, 6, "pawn", list);
        Pieces whitePawn4 = new Pieces(true, 4, 6, "pawn", list);
        Pieces whitePawn5 = new Pieces(true, 5, 6, "pawn", list);
        Pieces whitePawn6 = new Pieces(true, 6, 6, "pawn", list);
        Pieces whitePawn7 = new Pieces(true, 7, 6, "pawn", list);
        Pieces whitePawn8 = new Pieces(true, 0, 6, "pawn", list);
        
        //making the chess board itself and setting the dimensions 
        JFrame frame = new JFrame(); 
        frame.setBounds(10, 10, 512, 512); //setting the size of the grid 
        frame.setUndecorated(true); //removing the boundaries of the tab
        JPanel panel;
        panel = new JPanel(){
            @Override
            //adding colour to the board and making it alternate for every new grid square
            public void paint(Graphics g) {
                boolean white = true;
                for(int x = 0; x < 8; x++){
                    for(int y=0; y < 8; y++){
                        if(white){
                            g.setColor(Color.white);
                        }
                        else{
                            g.setColor(Color.pink);
                        }
                        g.fillRect(x*64, y*64, 64, 64); //filling the colour of each grid sqaure alternating between pink and white 
                        white = !white;
                    }
                    white = !white;
                }
                //reading from the list and setting it so it understands which piece is which image (e.g.  king, queen, bishop, knight, rook)
                for(Pieces p: list){
                    int index = 0;
                    
                    if(p.pieceType.equalsIgnoreCase("king")){
                        index = 0;
                    }
                    
                    if(p.pieceType.equalsIgnoreCase("queen")){
                        index = 1;
                    }
                    
                    if(p.pieceType.equalsIgnoreCase("bishop")){
                        index = 2;
                    }
                    
                    if(p.pieceType.equalsIgnoreCase("knight")){
                        index = 3;
                    }
                    
                    if(p.pieceType.equalsIgnoreCase("rook")){
                        index = 4;
                    }
                    
                    if(p.pieceType.equalsIgnoreCase("pawn")){
                        index = 5;
                    }
                    
                    if(!p.colourSide){
                        index += 6;
                    }
                    //adding it to the grid and choosing the sqaure for its location
                    g.drawImage(imgs[index], p.y, p.x, this);
                }
            }
           
        };
        frame.add(panel);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedPiece != null){  
                   selectedPiece.y = e.getX() - 32;
                   selectedPiece.x = e.getY() - 32;
                   frame.repaint(); 
                }
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
               
            @Override
            public void mousePressed(MouseEvent e) {
                selectedPiece = getPiece(e.getY(), e.getX());
            }
             

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedPiece.pieceMovement(e.getX() / 64, e.getY() / 64);
                frame.repaint();
            }
                

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }
          

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
    
    public static Pieces getPiece(int x, int y){
        
        int xPos = x / 64; 
        int yPos = y / 64;
        
        for(Pieces p:list){
            if(p.xPos == xPos && p.yPos == yPos){
                return p;
            }
        }
        
        return null;
    }
    
}
