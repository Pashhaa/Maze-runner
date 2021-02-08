package Base.Objects;

import Base.Main;

public abstract class AbstractMovingFigur extends AbstractFigur {

    protected Main gameMap;


    public void setGameMap(Main gameMap) {
        this.gameMap = gameMap;
    }

    protected void moveUp() throws Exception{
        int y = getY();
        int x = getX();
        gameMap.data[y][x] = new Emptiness();
        y--;
        gameMap.data[y][x] = this;
        setY(y);
        gameMap.drawTable();
        Thread.sleep(600);
    }
    protected void moveDown()throws Exception{
        int y = getY();
        int x = getX();
        gameMap.data[y][x] = new Emptiness();
        y++;
        gameMap.data[y][x] = this;
        setY(y);
        gameMap.drawTable();
        Thread.sleep(600);
    }
    protected void moveLeft()throws Exception{
        int y = getY();
        int x = getX();
        gameMap.data[y][x] = new Emptiness();
        x--;
        gameMap.data[y][x] = this;
        setX(x);
        gameMap.drawTable();
        Thread.sleep(600);
    }
    protected void moveRight()throws Exception{
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
            if(gameMap.data[getY() - 1][getX()].getClass() == Emptiness.class || gameMap.data[getY() - 1][getX()].getClass() == Gold.class  ){
                moveUp();
            }
            else {
                return;
            }
        }
        if(direction == 2){
            if(gameMap.data[getY() + 1][getX()].getClass() == Emptiness.class || gameMap.data[getY() + 1][getX()].getClass() == Gold.class ){
                moveDown();
            }
            else {
                return;
            }
        }
        if(direction == 3){
            if(gameMap.data[getY()][getX() - 1].getClass() == Emptiness.class || gameMap.data[getY()][getX() - 1].getClass() == Gold.class ){
                moveLeft();
            }
            else {
                return;
            }
        }
        if(direction == 4){
            if(gameMap.data[getY()][getX() + 1].getClass() == Emptiness.class || gameMap.data[getY()][getX() + 1].getClass() == Gold.class ){
                moveRight();
            }
            else {
                return;
            }
        }

    }
}
