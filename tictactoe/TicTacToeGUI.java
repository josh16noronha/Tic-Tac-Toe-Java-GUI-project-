import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The class TicTacToeGUI creates a userfriendly tic tac toe game.
 * There is a menu bar to either start a new game or quit.
 *
 * @author Joshus Noronha
 * @version April 2, 2022
 */
public class TicTacToeGUI extends JFrame //implements ActionListener 
{
    public static final String PLAYER_X = "X"; // player using "X"
    public static final String PLAYER_O = "O"; // player using "O"
    public static final String EMPTY = " ";  // empty cell
    public static final String TIE = "Tied"; // game ended in a tie
    private int numFreeSquares;
    private Container pane;
    private String currentPlayer;
    private JButton [][] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;


    /**
     * Constructor for objects of class TicTacToeGUI creates
     * the pane where the 3 by 3 buttons are allocated.
     */
    public TicTacToeGUI()
    {
       super();
       pane = getContentPane();
       numFreeSquares = 9;
       pane.setLayout(new GridLayout(3,3));
       setTitle("Tic Tac Toe");
       currentPlayer = PLAYER_X;
       board = new JButton[3][3];
       setSize(600,600);
       setResizable(false);
       setVisible(true);
       createBoard();
       createMenuBar();
    }

    /**
     * This method uses ActionListener to implement the menu bar
     * when the user clicks new game, or quit.
     *
     */
    private void createMenuBar()
    {
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        
        newGame = new JMenuItem ("New Game");
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clearBoard(); 
            }
        });
        quit = new JMenuItem ("Quit");
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0); 
            }
        });
        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    
    /**
     * This method clears the board to start a new game.
     *
     */
    private void clearBoard()
    {
        currentPlayer = PLAYER_X;
        hasWinner = false;
        numFreeSquares = 9;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
              board[i][j].setText("");
            }
        }
    }
    
    /**
     * This method creates a new board at the start of the game.
     *
     */
    private void createBoard()
    {
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
              JButton button = new JButton();
              board[i][j] = button;
              button.setFont(new Font("Dialog",Font.BOLD,70));
              
              button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if(((JButton)e.getSource()).getText().equals("") && hasWinner == false){
                            button.setText(currentPlayer);
                            numFreeSquares--;
                            hasWinner();
                            switchPlayer();
        
                        }
                    }
              });
              pane.add(button);
           }
        }
    }
    
    
    /**
     * This method changes the current player to the next.
     *
     */
    private void switchPlayer()
    {
        if(currentPlayer.equals(PLAYER_X)){
            currentPlayer = PLAYER_O;
        }
        else{
            currentPlayer = PLAYER_X;
        }
    }
    
    /**
     * This method computes who is the winner by looking
     * for a straight line of 3 Xs or 3 Os. Otherwise Tie.
     *
     */
    private void hasWinner()
    {
      
       if ( board[0][0].getText().equals(currentPlayer)&&(board[1][0]).getText().equals(currentPlayer) && (board[2][0]).getText().equals(currentPlayer)){
            
           JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
           hasWinner = true;
        }
        
       else if (numFreeSquares == 0){
            JOptionPane.showMessageDialog(null, "Both Players have"+ TIE);
            hasWinner = false;
        
       }
            
       else if ( board[0][1].getText().equals(currentPlayer)&&(board[1][1]).getText().equals(currentPlayer) && (board[2][1]).getText().equals(currentPlayer)){
            
           JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
           hasWinner = true;
        }
        
       else if ( board[0][2].getText().equals(currentPlayer)&&(board[1][2]).getText().equals(currentPlayer) && (board[2][2]).getText().equals(currentPlayer)){
            
           JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
           hasWinner = true;
        }
        
       else if ( board[0][0].getText().equals(currentPlayer)&&(board[0][1]).getText().equals(currentPlayer) && (board[0][2]).getText().equals(currentPlayer)){
            
           JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
           hasWinner = true;
        }
            
       else if ( board[1][0].getText().equals(currentPlayer)&&(board[1][1]).getText().equals(currentPlayer) && (board[1][2]).getText().equals(currentPlayer)){
            
           JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
           hasWinner = true;
        }
        
       else if ( board[2][0].getText().equals(currentPlayer)&&(board[2][1]).getText().equals(currentPlayer) && (board[2][2]).getText().equals(currentPlayer)){
            
           JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
           hasWinner = true;
        }  
        
       else if ( board[0][0].getText().equals(currentPlayer)&&(board[1][1]).getText().equals(currentPlayer) && (board[2][2]).getText().equals(currentPlayer)){
            
           JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
           hasWinner = true;
        } 
       else if ( board[2][0].getText().equals(currentPlayer)&&(board[1][1]).getText().equals(currentPlayer) && (board[0][2]).getText().equals(currentPlayer)){
            
           JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
           hasWinner = true;
        }  
        
       
    }
}








