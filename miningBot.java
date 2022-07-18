import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;
import java.awt.event.KeyEvent;
public class miningBot  {
                        
    public static void mineIron(int x,int y){
        try
        {
        Robot mineIron = new Robot();
        mineIron.mouseMove(x,y); 
        }
        catch (AWTException e)
        {
        e.printStackTrace();
        }
    }
    public static void randomInterval(int x, int y) throws InterruptedException{
        int randomInterval = new Random().nextInt(x) + y;
        Thread.sleep(randomInterval);
    }
    public static int randomDrop(int x, int y) throws InterruptedException{
        int randomDrop = new Random().nextInt(x) + y;
        return randomDrop;
    }
    public static void randomPixel(int x,int y, int xx, int yy){
       int horizontal = new Random().nextInt(x) + xx;
       int vertical = new Random().nextInt(y) + yy;
       System.out.println("x " + horizontal);
       System.out.println("y " + vertical);
       mineIron(horizontal,vertical);

    }

    public static void dropIron(int x, int y) throws InterruptedException{
        try
        {
        Robot dropIron = new Robot();
        dropIron.keyPress(KeyEvent.VK_SHIFT);
        randomInterval(200,100);
        int[][] coord = new int[4][6];
        for (int i=0; i<coord.length; i++){
            randomInterval(200,100);
            x += randomDrop(6,37);;
            y = randomDrop(6,757);
            dropIron.mouseMove(x, y);
            dropIron.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            dropIron.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            for (int j=0; j<coord[0].length; j++){
                randomInterval(200,100);
                y += randomDrop(6,34);
                dropIron.mouseMove(x, y);
                dropIron.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                dropIron.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }
         }
         dropIron.keyRelease(KeyEvent.VK_SHIFT); 
        }
        catch (AWTException e)
        {
            e.printStackTrace(); 
        }
    }
    public static void main(String[] args)
    throws InterruptedException, AWTException  {
        for (int x=0; x<10; x++){
            randomInterval(500,1000);
        /*for (int i=0; i<14;i++){
            randomPixel(63,39,1387,823);
            randomInterval(200,300);
            Robot click = new Robot();
            click.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            click.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            randomInterval(4200,3600);
            randomPixel(48,47,1486,729);
            randomInterval(150,300);
            click.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            click.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            randomInterval(4200,3600);
            
        } */
        dropIron(1691,760);
        randomInterval(120,30);
     }
    }
}
