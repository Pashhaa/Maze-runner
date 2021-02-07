

package Base;


import Base.Objects.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main extends JPanel {

    final int WIDTH = 576;
    final int HEIGHT = 576;
    public Player player;



    String gameStatus = "Play Game";
    // B - Brick, M- Monster, GG - Gold, P - Player, G - Ground, E - Exit
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

    public ArrayList<AbstractMovingFigur> abstractMovingFigurList = new ArrayList<>();
    {
        RandomBotLoader();
    }

    private AbstractFigur[][] RandomBotLoader(){
        AbstractFigur exit = new Exit();
        Random random = new Random();
        int exitIndexX = random.nextInt(12);
        int exitIndexY = random.nextInt(11);
        data[exitIndexY][exitIndexX] = exit;
        String[] array = {"N","N","N","N","M","GG","E", "N", "N","N","N","N"};
        int goldCount = 8;
        int botCount = 5;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int elemIndex = random.nextInt(array.length);
                if(data[i][j].getClass() == Emptiness.class) {
                    AbstractFigur arrayValue;
                    if (array[elemIndex].equals("M") && botCount > 0){
                        arrayValue = new Bot();
                        ((AbstractMovingFigur)arrayValue).setGameMap(this);
                        abstractMovingFigurList.add((AbstractMovingFigur) arrayValue);
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
        player = new Player();
        abstractMovingFigurList.add(player);
        player.setGameMap(this);
        player.setX(playerX);
        player.setY(playerY);

        data[playerY][playerX] = player;

        return data;



    }




    void runTheGame() throws Exception {
        for ( AbstractFigur current: abstractMovingFigurList ) {
            if(current.getY() < 11){
                AbstractMovingFigur movingFigur = (AbstractMovingFigur) current;
                movingFigur.move(2);
            }
        }
        while (player.getY()>0){
            player.move(1);
        }
        gameStatus = "Game Over";
        drawTable();
    }




    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.runTheGame();
    }


    JTable table;
    String[] column = new String[11];
    JLabel labelScore = new JLabel();
    JLabel labelSteps = new JLabel();
    JLabel labelGameStatus = new JLabel();


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


        for (int i = 0; i < column.length; i++) {
            column[i] = "";
        }

        drawTable();

        add(table);
        add(labelScore);
        add(labelSteps);
        add(labelGameStatus);
        frame.setMinimumSize(new Dimension(WIDTH,HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }

    private void score() {
        labelScore.setText("Score: " + player.getScore());
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
        countSteps();
    }

}
