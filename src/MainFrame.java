import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton[][] buttons;
    private Game game;

    public MainFrame() {
        game = new Game();
        buttons = new JButton[3][3];
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        // Initialize buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }

        setSize(300, 300);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            if (game.makeMove(row, col)) {
                buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
                if (game.isWin()) {
                    JOptionPane.showMessageDialog(null, "Player " + game.getCurrentPlayer() + " wins!");
                    resetGame();
                } else if (game.isDraw()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    resetGame();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid move!");
            }
        }
    }

    private void resetGame() {
        game = new Game();
        // Reset buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}