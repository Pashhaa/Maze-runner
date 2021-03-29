
package Base.UserInterface;

import Base.Collection.ArrayCollection;
import Base.Collection.GameCollection;
import Base.MapLoaders.HardLoader;
import Base.MapLoaders.MediumLoader;
import Base.Objects.Enums.Direction;
import Base.Objects.Enums.ObjectType;
import Base.Observer.CollectionSubscriber;
import Base.Objects.Realization.*;
import Base.Strategy.RandomStrategy;
import Base.Threads.GameThread;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import static java.awt.event.KeyEvent.*;

public class GameMap extends JPanel implements CollectionSubscriber, KeyListener {

    final int WIDTH = 576;
    final int HEIGHT = 576;
    public Player player = new Player();

    private String gameStatus = "Play game";
    public GameCollection collection;

    void runTheGame() throws Exception {
        GameThread thread = new GameThread(collection);
        thread.start();
    }



    public static void main(String[] args) throws Exception {
        GameMap main = new GameMap();
        main.runTheGame();
    }

    JTable table;
    String[] column = new String[11];
    JLabel labelScore = new JLabel();
    JLabel labelSteps = new JLabel();
    JLabel labelTime = new JLabel();
    JLabel labelGameStatus = new JLabel();

    public GameMap() {
        collection = new ArrayCollection(new MediumLoader());

        collection.addListener(this);
        JFrame frame = new JFrame("Maze runner");

        table=new JTable();

        table.setTableHeader(null);
        table.setEnabled(false);
        table.setSize(new Dimension(300, 300));
        table.setRowHeight(26);
        table.setRowSelectionAllowed(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setUpdateSelectionOnSort(false);
        table.setVerifyInputWhenFocusTarget(false);


        Arrays.fill(column, "");

        drawTable();

        add(table);
        add(labelScore);
        add(labelSteps);
        add(labelTime);
        add(labelGameStatus);
        frame.setMinimumSize(new Dimension(WIDTH,HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        frame.addKeyListener(this);
    }

    private void score(int score) {
        labelScore.setText("Score: " + score);
    }


    private void countSteps(int countSteps) {
        labelSteps.setText("Counter: " + countSteps);
    }

    private void gameStatus() {
        labelGameStatus.setText(gameStatus);
    }




    public void drawTable() {


        table.setModel(new DefaultTableModel(collection.getData(), column));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
            TableColumn a = table.getColumnModel().getColumn(i);
            a.setPreferredWidth(26);
        }
        gameStatus();
    }

    @Override
    public void notifyFromListener() {

        Player player = collection.getPlayer();
        score(player.getScore());
        countSteps(player.getCountSteps());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        drawTable();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case VK_UP:
                collection.moveMovableFigur(ObjectType.PLAYER,Direction.UP);
                break;
            case VK_LEFT:
                collection.moveMovableFigur(ObjectType.PLAYER,Direction.LEFT);
                break;
            case VK_DOWN:
                collection.moveMovableFigur(ObjectType.PLAYER,Direction.DOWN);
                break;
            case VK_RIGHT:
                collection.moveMovableFigur(ObjectType.PLAYER,Direction.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
