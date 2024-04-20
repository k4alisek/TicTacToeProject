import javax.swing.*;
import java.awt.*;
public class TicTacToeGraphic extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 700;
    private JLabel display;
    private JButton[] tiles;
    private final TicTacToe ticTacToe;
    private boolean end = false;
    public TicTacToeGraphic() {
        super("TicTacToe");
        ticTacToe = new TicTacToe();
        addComponents();
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void addComponents() {
        Container pane = getContentPane();
        display = new JLabel("player x");
        display.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        display.setHorizontalAlignment(JTextField.CENTER);
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 3));
        tiles = new JButton[9];
        for (int index = 0; index < tiles.length; index++) {
            tiles[index] = new JButton(" ");
            final int finalIndex = index;
            tiles[index].addActionListener(e -> tilePressed(finalIndex));
            tiles[index].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
            tiles[index].setForeground(Color.white);
            tiles[index].setBackground(Color.darkGray);
            buttons.add(tiles[index]);
        }
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, display, buttons);
        split.setResizeWeight(0.3);
        split.setDividerSize(0);
        pane.add(split);
    }
    private void tilePressed(int digit) {
        if (!end) {
            int currentPlayer;
            if (tiles[digit].getText().equals(" ")) {
                if (display.getText().equals("player x")) {
                    currentPlayer = 1;
                    ticTacToe.updateBoard(digit, currentPlayer);
                    tiles[digit].setText("x");
                    display.setText("player o");
                }
                else {
                    currentPlayer = 2;
                    ticTacToe.updateBoard(digit, currentPlayer);
                    tiles[digit].setText("o");
                    display.setText("player x");
                }
                ticTacToe.updateRound();
                if (ticTacToe.win()) {
                    if (currentPlayer == 1) {
                        display.setText("player x wins!");
                    }
                    else {
                        display.setText("player o wins!");
                    }
                    end = true;
                }
                if (ticTacToe.getRound() == 9) {
                    display.setText("draw");
                    end = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        new TicTacToeGraphic();
    }
}