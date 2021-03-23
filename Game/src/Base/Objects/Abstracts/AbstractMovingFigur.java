package Base.Objects.Abstracts;

import Base.Objects.Enums.Directions;
import Base.Objects.Realization.Emptiness;

public abstract class AbstractMovingFigur extends AbstractFigur {


    public boolean canMove(AbstractFigur nextObject) {
        return nextObject.getClass() != null && nextObject.getClass() == Emptiness.class;
    }

    public int[] move(Directions direction) {

        int y = getY();
        int x = getX();

        switch (direction) {
            case UP: {
                y--;
                break;
            }
            case DOWN:{
                y++;
                break;
            }
            case LEFT:{
                x--;
                break;
            }
            case RIGHT:{
                x++;
                break;
            }


        }

        return new int[] {y, x};

    }

/*    protected void moveUp() throws Exception{
        int y = getY();
        int x = getX();
        data.getData()[y][x] = new Emptiness();
        y--;
        data.getData()[y][x] = this;
        setY(y);
        gameMap.drawTable();
        Thread.sleep(600);
    }
    protected void moveDown()throws Exception{
        int y = getY();
        int x = getX();
        data.getData()[y][x] = new Emptiness();
        y++;
        data.getData()[y][x] = this;
        setY(y);
        gameMap.drawTable();
        Thread.sleep(600);
    }
    protected void moveLeft()throws Exception{
        int y = getY();
        int x = getX();
        data.getData()[y][x] = new Emptiness();
        x--;
        data.getData()[y][x] = this;
        setX(x);
        gameMap.drawTable();
        Thread.sleep(600);
    }
    protected void moveRight()throws Exception{
        int y = getY();
        int x = getX();
        data.getData()[y][x] = new Emptiness();
        x++;
        data.getData()[y][x] = this;
        gameMap.drawTable();
        setX(x);
        Thread.sleep(600);
    }





    // direction VALUE (1 - UP, 2 - DOWN, 3 - LEFT, 4 - RIGHT
    public int[] move(int direction) throws Exception{

        if(direction == 1){
            if(data.getData()[getY() - 1][getX()].getClass() == Emptiness.class || data.getData()[getY() - 1][getX()].getClass() == Gold.class  ){
                moveUp();
            }
            else {
                return new int[0];
            }
        }
        if(direction == 2){
            if(data.getData()[getY() + 1][getX()].getClass() == Emptiness.class || data.getData()[getY() + 1][getX()].getClass() == Gold.class ){
                moveDown();
            }
            else {
                return new int[0];
            }
        }
        if(direction == 3){
            if(data.getData()[getY()][getX() - 1].getClass() == Emptiness.class || data.getData()[getY()][getX() - 1].getClass() == Gold.class ){
                moveLeft();
            }
            else {
                return new int[0];
            }
        }
        if(direction == 4){
            if(data.getData()[getY()][getX() + 1].getClass() == Emptiness.class || data.getData()[getY()][getX() + 1].getClass() == Gold.class ){
                moveRight();
            }
            else {
                return new int[0];
            }
        }

        return new int[] {getX(),getY()};
    }*/
}
