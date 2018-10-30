//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (descriptive title of the program making use of this file)
// Files:           (a list of all source files used by that program)
// Course:          (course number, term, and year)
//
// Author:          Ryan Susilo 
// Email:           susilo2@wisc.edu 
// Lecturer's Name: Marc Renault
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         Jason Sutanto (Programming Partner)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This file contains testing methods for the Sokoban project. These methods are intended to provide
 * an example of a way to incrementally test your code, and to provide example method calls for the
 * Sokoban methods
 *
 * Toward these objectives, the expectation is that part of the grade for the Sokoban project is to
 * write some tests and write header comments summarizing the tests that have been written. Specific
 * places are noted with FIXME but add any other comments you feel would be useful.
 */

import java.util.Arrays;

/**
 * This class contains a few methods for testing methods in the Sokoban class as they are developed.
 * These methods are all private as they are only intended for use within this class.
 * 
 * @author Marc Renault
 * @author FIXME add your name here when you add test
 *
 */
public class TestSokoban {

    /**
     * This is the main method that runs the various tests. Uncomment the tests when you are ready
     * for them to run.
     * 
     * @param args (unused)
     */
    public static void main(String[] args) {
        // Milestone 1
        testCheckLevel();
        // Milestone 2
        testInitBoard();
        // testCheckWin();
        // testCalcDelta();
        // testCheckDelta();
        // Milestone 3
        // testTogglePos();
        // testShiftBox();
        // testDoMove();
        // testProcessMove();
    }

    private static void testCheckLevel() {
        int numTests = 4;
        int passed = numTests;
        int res;
        // Test 1
        if ((res = Sokoban.checkLevel(-1, Config.LEVELS, Config.GOALS)) != 0) {
            System.out.println(
                "FAILED: Sokoban.checkLevel Test 1. Expected 0, but value returned " + res);
            passed--;
        }

        // Test 2
        char[][][] lvl = new char[2][][];
        if ((res = Sokoban.checkLevel(1, lvl, Config.GOALS)) != -1) {
            System.out.println(
                "FAILED: Sokoban.checkLevel Test 2. Expected -1, but value returned " + res);
            passed--;
        }

        // Test 3
        char[][][] goal = new char[2][][];
        if ((res = Sokoban.checkLevel(1, goal, Config.GOALS)) != -2) {
            System.out.println(
                "FAILED: Sokoban.checkLevel Test 3. Expected -2, but value returned " + res);
            passed--;
        }

        // test 4

        if ((res = Sokoban.checkLevel(0, Config.LEVELS, Config.GOALS)) != -3) {
            System.out.println(
                "FAILED: Sokoban.checkLevel Test 4. Expected -3, but value returned " + res);
            passed--;
        }



        // FIXME Add more tests

        System.out.println("testCheckLevel: Passed " + passed + " of " + numTests + " tests.");
    }

    /**
     * Returns true if the arrays are the same size and have the same contents.
     */
    private static boolean compBoards(char[][] a, char[][] b) {
        if (a == null || b == null)
            return false;
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }

    private static void testInitBoard() {
        int numTests = 1;
        int passed = numTests;

        // Test 1
        int[] pTest1 = new int[2];
        char[][] bTest1 = Sokoban.initBoard(0, Config.LEVELS, Config.GOALS, pTest1);
        if (!Arrays.equals(pTest1, new int[] {4, 4})) {
            System.out.println(
                "FAILED: Sokoban.initBoard Test 1. Expected initial position: {4, 4} , but value after call "
                    + Arrays.toString(pTest1));
            passed--;
        }
        char[][] bCompTest1 = new char[][] {
            {Config.EMPTY_CHAR, Config.EMPTY_CHAR, Config.EMPTY_CHAR, Config.EMPTY_CHAR,
                Config.EMPTY_CHAR},
            {Config.EMPTY_CHAR, Config.EMPTY_CHAR, Config.EMPTY_CHAR, Config.EMPTY_CHAR,
                Config.EMPTY_CHAR},
            {Config.EMPTY_CHAR, Config.EMPTY_CHAR, Config.GOAL_CHAR, Config.BOX_CHAR,
                Config.EMPTY_CHAR},
            {Config.EMPTY_CHAR, Config.EMPTY_CHAR, Config.EMPTY_CHAR, Config.EMPTY_CHAR,
                Config.EMPTY_CHAR},
            {Config.EMPTY_CHAR, Config.EMPTY_CHAR, Config.EMPTY_CHAR, Config.EMPTY_CHAR,
                Config.WORKER_CHAR}};
        if (!compBoards(bTest1, bCompTest1)) {
            System.out.println("FAILED: Sokoban.initBoard Test 1. Board not as expected!");
            System.out.println("Generated:");
            Sokoban.printBoard(bTest1);
            System.out.println("Expected:");
            Sokoban.printBoard(bCompTest1);
            passed--;
        }
        // End of Test 1

        // FIXME Add more tests

        System.out.println("testInitBoard: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testCheckWin() {
        // FIXME
    }

    private static void testCalcDelta() {
        // FIXME
    }

    private static void testCheckDelta() {
        // FIXME
    }

    private static void testTogglePos() {
        // FIXME
    }

    private static void testShiftBox() {
        // FIXME
    }

    private static void testDoMove() {
        // FIXME
    }

    private static void testProcessMove() {
        // FIXME
    }

}
