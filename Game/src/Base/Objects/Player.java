package Base.Objects;

import javax.swing.*;

public class Player extends AbstractFigur{
    int score = 0;
    int countSteps = 50;
    public Player(){
        setImage(new ImageIcon(getClass().getResource("/images/goldman_up.png")));
    }

    public int getScore() {
        return score;
    }

    public int getCountSteps() {
        return countSteps;
    }

    private void moveUp() throws Exception{
/*      data[y][x] = "G";
       y--;
        data[y][x] = "P";
        drawTable();
        Thread.sleep(600);*/
    }
    private void moveDown()throws Exception{
/*         data[y][x] = "G";
        y++;
        data[y][x] = "P";
        drawTable();
        Thread.sleep(600);*/
    }
    private void moveLeft()throws Exception{
        //data[y][x] = "G";
        //x--;
        //data[y][x] = "P";
        //drawTable();
        //Thread.sleep(600);
    }
    private void moveRight()throws Exception{
        //data[y][x] = "G";
        //x++;
        //data[y][x] = "P";
        //drawTable();
        //Thread.sleep(600);
    }





    // direction VALUE (1 - UP, 2 - DOWN, 3 - LEFT, 4 - RIGHT
/*    public void move(int direction) throws Exception{

        if(direction == 1){
            if(data[y - 1][x] == "G" || data[y - 1][x] == "GG" ){
                moveUp();
            }
            else {
                return;
            }
        }
        if(direction == 2){
            if(data[y + 1][x] == "G" || data[y + 1][x] == "GG" ){
                moveDown();
            }
            else {
                return;
            }
        }
        if(direction == 3){
            if(data[y][x - 1] == "G" || data[y][x - 1] == "GG" ){
                moveLeft();
            }
            else {
                return;
            }
        }
        if(direction == 4){
            if(data[y][x + 1] == "G" || data[y][x + 1] == "GG" ){
                moveRight();
            }
            else {
                return;
            }
        }

    }*/

}
