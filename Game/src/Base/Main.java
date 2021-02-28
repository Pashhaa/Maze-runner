
package Base;

import Base.MapLoaders.EasyLoader;
import Base.Objects.AbstractFigur;
import Base.Objects.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Main extends JPanel {

    final int WIDTH = 576;
    final int HEIGHT = 576;
    public Player player = new Player();

    private String gameStatus = "Play game";

    public AbstractFigur[][] data = {
            {new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness()},
            {new Wall(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall()},
            {new Wall(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness()},
            {new Wall(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness()},
            {new Emptiness(), new Wall(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness()},
            {new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness()},
            {new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness()},
            {new Wall(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(),new Wall(), new Emptiness(), new Emptiness()},
            {new Emptiness(),new Emptiness(), new Emptiness(), new Emptiness(),new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness()},
            {new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Wall()},
            {new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness()},
            {new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness()}
    };

    {
        loading(EasyLoader.getArray(), EasyLoader.getBotCount(), EasyLoader.getGoldCount());
    }

    public void loading(String[] array, int botCount, int goldCount){
        AbstractFigur exit = Exit.getExit();
        Random random = new Random();
        int exitIndexX = random.nextInt(11);
        int exitIndexY = random.nextInt(10);
        data[exitIndexY][exitIndexX] = exit;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int elemIndex = random.nextInt(array.length);
                if(data[i][j].getClass() == Emptiness.class) {
                    AbstractFigur arrayValue;
                    if (array[elemIndex].equals("M") && botCount > 0){
                        arrayValue = new Bot();
                        ((AbstractMovingFigur)arrayValue).setGameMap(this);
                        botCount--;
                    }
                    else if(array[elemIndex].equals("GG") && goldCount > 0){
                        arrayValue = new Gold();
                        goldCount--;
                    }
                    else {
                        arrayValue = data[i][j];
                    }
                    arrayValue.setX(j);
                    arrayValue.setY(i);
                    data[i][j]=arrayValue;
                }

            }

        }
        int playerX = 5;
        int playerY = 6;
        player.setGameMap(this);
        player.setX(playerX);
        player.setY(playerY);

        data[playerY][playerX] = player;




    }



    private long firstTime, lastTime;
    private double time;

    void runTheGame() throws Exception {
        firstTime = System.currentTimeMillis();
        player.move(1);
        player.move(1);
        player.move(1);
        gameStatus = "Game Over";
        lastTime = System.currentTimeMillis();
        time = timeout(firstTime, lastTime);
        drawTable();
    }
    public double timeout(long firstTime, long lastTime){
        double localTime = lastTime - firstTime;
        return localTime/1000;
    }



    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.runTheGame();
    }


    JTable table;
    String[] column = new String[11];
    JLabel labelScore = new JLabel();
    JLabel labelSteps = new JLabel();
    JLabel labelTime = new JLabel();
    JLabel labelGameStatus = new JLabel();
    JLabel labelBestScore = new JLabel();


    public Main() {
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

    private void score() {
        labelScore.setText("Score: " + player.getScore());
    }
    private void time(){
        labelTime.setText("Time: " + time + " seconds") ;
    }

    private void countSteps() {
        labelSteps.setText("Counter: " + player.getCountSteps());
    }

    private void gameStatus() {
        labelGameStatus.setText(gameStatus);
    }



    public void drawTable() {


        table.setModel(new DefaultTableModel(data, column));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
            TableColumn a = table.getColumnModel().getColumn(i);
            a.setPreferredWidth(26);
        }
        gameStatus();
        score();
        time();
        countSteps();
    }

}
