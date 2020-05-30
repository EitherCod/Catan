package catan;
import org.junit.Test;
import static org.junit.Assert.*;
import ucb.junit.textui;


public class UnitTest {
    public static void main(String[] ignored) {
        textui.runClasses(UnitTest.class);
    }

    @Test
    public void boardPrint(){
        Board x = new Board();
        System.out.println(x);
    }
}
