import javax.swing.SwingUtilities;

/**
 * This main file implements the Runnable package to make
 * sure that the TicTacToeGUI code runs similtaniously.
 *
 * @author Joshus Noronha
 * @version April 2, 2022
 */
public class Main implements Runnable 
{
    /**
     * Constructor for objects of class Main makes sure that 
     * all the code is compressed to run simultaneously.
     */
    public Main()
    {
        SwingUtilities.invokeLater(this);
    }

    /**
     * This method runs the TicTacToeGUI.
     *
     */
    public void run()
    {
        new TicTacToeGUI();
    }
}
