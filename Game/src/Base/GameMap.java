
package Base;

import Base.Collection.ArrayCollection;
import Base.Collection.GameCollection;
import Base.MapLoaders.EasyLoader;
import Base.Objects.Enums.Direction;
import Base.Observer.CollectionSubscriber;
import Base.Objects.Realization.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Arrays;

public class GameMap extends JPanel implements CollectionSubscriber {

    final int WIDTH = 576;
    final int HEIGHT = 576;
    public Player player = new Player();

    private String gameStatus = "Play game";
    public GameCollection collection;

    void runTheGame() throws Exception {
        firstTime = System.currentTimeMillis();
        for (int i = 0; i < 6; i++) {
            collection.moveAllMovables(Direction.LEFT);
            drawTable();
        }
        gameStatus = "Game Over";
        lastTime = System.currentTimeMillis();
        time = timer(firstTime, lastTime);
        drawTable();
    }

    private long firstTime, lastTime;
    private double time;
    private double timer(long firstTime, long lastTime){
        double localTime = lastTime - firstTime;
        return localTime/1000;
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
        collection = new ArrayCollection(new EasyLoader(),this);

        collection.addListener(this);
        JFrame frame = new JFrame("Maze run");

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
    }

    private void score(int score) {
        labelScore.setText("Score: " + score);
    }

    private void time(){
        labelTime.setText("Time: " + time + " seconds") ;
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
        time();
    }

    @Override
    public void notifyFromListener() {

        Player player = collection.getPlayer();
        score(player.getScore());
        countSteps(player.getCountSteps());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        drawTable();
    }
}
