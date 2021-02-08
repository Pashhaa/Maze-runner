package Base.Objects;

import Base.Main;

public abstract class AbstractMovingFigur extends AbstractFigur {

    private Main gameMap;


    public void setGameMap(Main gameMap) {
        this.gameMap = gameMap;
    }

    private void moveUp() throws Exception{
        int y = getY();
        int x = getX();
        gameMap.data[y][x] = new Emptiness();
        y--;
        gameMap.data[y][x] = this;
        setY(y);
        gameMap.drawTable();
        Thread.sleep(600);
    }
    private void moveDown()throws Exception{
        int y = getY();
        int x = getX();
        gameMap.data[y][x] = new Emptiness();
        y++;
        gameMap.data[y][x] = this;
        setY(y);
        gameMap.drawTable();
        Thread.sleep(600);
    }
    private void moveLeft()throws Exception{
        int y = getY();
        int x = getX();
        gameMap.data[y][x] = new Emptiness();
        x--;
        gameMap.data[y][x] = this;
        setX(x);
        gameMap.drawTable();
        Thread.sleep(600);
    }
    private void moveRight()throws Exception{
        int y = getY();
        int x = getX();
        gameMap.data[y][x] = new Emptiness();
        x++;
        gameMap.data[y][x] = this;
        gameMap.drawTable();
        setX(x);
        Thread.sleep(600);
    }





    // direction VALUE (1 - UP, 2 - DOWN, 3 - LEFT, 4 - RIGHT
    public void move(int direction) throws Exception{

        if(direction == 1){
            if(gameMap.data[y - 1][x].getClass() == Emptiness.class || gameMap.data[y - 1][x].getClass() == Gold.class  ){
                moveUp();
            }
            else {
                return;
            }
        }
        if(direction == 2){
            if(gameMap.data[y + 1][x].getClass() == Emptiness.class || gameMap.data[y + 1][x].getClass() == Gold.class ){
                moveDown();
            }
            else {
                return;
            }
        }
        if(direction == 3){
            if(gameMap.data[y][x - 1].getClass() == Emptiness.class || gameMap.data[y][x - 1].getClass() == Gold.class ){
                moveLeft();
            }
            else {
                return;
            }
        }
        if(direction == 4){
            if(gameMap.data[y][x + 1].getClass() == Emptiness.class || gameMap.data[y][x + 1].getClass() == Gold.class ){
                moveRight();
            }
            else {
                return;
            }
        }

    }
}
