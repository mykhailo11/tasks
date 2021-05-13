package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import main.Task1;
import main.Task2;
import main.Task3;

public class TasksTest {

    /**
     * Testing method that computes the number
     * of valid brace expressions for the given
     * number of braces
     */
    @Test
    public void testNumberOfValidBraceExpressions(){
        //Arrange
        Task1 pair1 = new Task1(1);
        Task1 pair2 = new Task1(2);
        Task1 pair3 = new Task1(5);
        //Assert
        assertEquals(1, pair1.computeValid());
        assertEquals(2, pair2.computeValid());
        assertEquals(42, pair3.computeValid());
    }
    /**
     * Testing method for finding
     * minimal transition costs through the graph for
     * the given route
     */
    @Test
    public void testMinPath(){
        //Arrange
        Task2 set1 = new Task2(4);
        String g = "gdansk";
        String b = "bydgoszcz";
        String t = "torun";
        String w = "warszawa";
        //Act
        set1.addCity(g);
        set1.addCity(b);
        set1.addCity(t);
        set1.addCity(w);
        set1.setWeight(g, b, 1);
        set1.setWeight(g, t, 3);
        set1.setWeight(b, g, 1);
        set1.setWeight(b, w, 4);
        set1.setWeight(b, t, 1);
        set1.setWeight(t, g, 3);
        set1.setWeight(t, g, 3);
        set1.setWeight(t, w, 1);
        set1.setWeight(w, t, 1);
        set1.setWeight(w, b, 4);
        //Assert
        assertEquals(3, set1.findMin(g, w));
        assertEquals(2, set1.findMin(b, w));
    }
    /**
     * Simple test for factorial result's digits sum
     */
    @Test
    public void testSumOfFactorialResultDigits(){
        //Arramge
        int num1 = 5;
        int num2 = 100;
        Task3 task1 = new Task3(num1, false);
        Task3 task2 = new Task3(num2, false);
        //Assert
        assertEquals("Error" , 3, task1.sumDigits());
        assertEquals("Error", 648, task2.sumDigits());
    }

}
