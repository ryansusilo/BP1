//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Files: (a list of all source files used by that program)
// Course: (course number, term, and year)
//
// Author: Ryan Susilo
// Email: susilo2@wisc.edu
// Lecturer's Name: Marc Renault
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates
// strangers, etc do. If you received no outside help from either type of
// source, then please explicitly indicate NONE.
//
// Persons: Jason Sutanto (Programming Partner)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

public class Sokoban {

    /**
     * Prompts the user for a value by displaying prompt. Note: This method should not add a new
     * line to the output of prompt.
     *
     * After prompting the user, the method will consume an entire line of input while reading an
     * int. If the value read is between min and max (inclusive), that value is returned. Otherwise,
     * "Invalid value." terminated by a new line is output to the console and the user is prompted
     * again.
     *
     * @param sc The Scanner instance to read from System.in.
     * @param prompt The name of the value for which the user is prompted.
     * @param min The minimum acceptable int value (inclusive).
     * @param max The maximum acceptable int value (inclusive).
     * @return Returns the value read from the user.
     */
    public static int promptInt(Scanner sc, String prompt, int min, int max) {


        while (true) {
            String input = "";
            int num;
            System.out.print(prompt);


            if (sc.hasNextInt()) {
                input = sc.nextLine();
                num = Integer.parseInt(input);
                if (num >= min && num <= max) {
                    return num;
                }

            }

            else {

                System.out.println("Invalid value.");
                input = sc.nextLine();

            }

        }
    }

    /**
     * Prompts the user for a char value by displaying prompt. Note: This method should not be a new
     * line to the output of prompt.
     *
     * After prompting the user, the method will read an entire line of input and return the first
     * non-whitespace character converted to lower case.
     *
     * @param sc The Scanner instance to read from System.in
     * @param prompt The user prompt.
     * @return Returns the first non-whitespace character (in lower case) read from the user. If
     *         there are no non-whitespace characters read, the null character is returned.
     */
    public static char promptChar(Scanner sc, String prompt) {
        char input = ' ';

        while (true) {
            System.out.print(prompt);
            if (sc.hasNextLine()) {
                input = sc.nextLine().charAt(0);
                input = Character.toLowerCase(input);
                return input;
            } else {
                System.out.print("Invalid value");
                input = sc.nextLine().charAt(0);
            }
        }

    }


    /**
     * Prompts the user for a string value by displaying prompt. Note: This method should not be a
     * new line to the output of prompt.
     *
     * After prompting the user, the method will read an entire line of input, remove any leading
     * and trailing whitespace, and return the input converted to lower case.
     *
     * @param sc The Scanner instance to read from System.in
     * @param prompt The user prompt.
     * @return Returns the string entered by the user, converted to lower case with leading and
     *         trailing whitespace removed.
     */
    public static String promptString(Scanner sc, String prompt) {
        String input = "";

        while (true) {

            System.out.print(prompt);

            if (sc.hasNextLine()) {

                input = sc.nextLine();

                input = input.trim().toLowerCase();



                return input;

            }

            else
                System.out.print("Invalid input");
            input = sc.nextLine();

        }



    }

    /**
     * Initializes the game board to a given level. You can assume that the level at lvl has been
     * successfully verified by the checkLevel method and that pos is an array of length 2.
     *
     * 1 - The game board should be created row-by-row. a - For each row, copy the values from the
     * corresponding row in the 2-d array contained at index lvl in levels. b - When the worker is
     * located, it's position should be recorded in the pos parameter. 2 - For each goal described
     * in the array at index lvl of goals, convert the character at the goal coordinate to: -
     * Config.WORK_GOAL_CHAR if it contains the worker - Config.BOX_GOAL_CHAR if it contains a box -
     * Config.GOAL_CHAR otherwise
     * 
     * @param lvl The index of the level to load.
     * @param levels The array containing the levels.
     * @param goals The parallel array to levels, containing the goals for the levels.
     * @param pos The starting pos of the worker. A length 2 array, where index 0 is the row and
     *        index 1 is the column.
     * @return A two dimension array representing the initial configuration for the given level.
     */
    public static char[][] initBoard(int lvl, char[][][] levels, int[][] goals, int[] pos) {
        // FIX ME
        char[][] configArray = levels[lvl];
        for (int i = 0; i < levels[lvl].length; ++i) {

            for (int j = 0; j < levels[lvl][i].length; ++j) {

                // configArray[i][j] = levels[lvl][i][j];

                if (levels[lvl][i][j] == Config.WORKER_CHAR) {
                    pos[0] = i;
                    pos[1] = j;
                }


            }
        }


        for (int i = 0; i < goals[lvl].length; i += 2) {
            int goalRow = goals[lvl][i];
            int goalCol = goals[lvl][i + 1];

            if (levels[lvl][goalRow][goalCol] == Config.BOX_CHAR) {
                levels[lvl][goalRow][goalCol] = Config.BOX_GOAL_CHAR;
            }

            else if (levels[lvl][goalRow][goalCol] == Config.WORKER_CHAR) {
                levels[lvl][goalRow][goalCol] = Config.WORK_GOAL_CHAR;
            }

            else {
                levels[lvl][goalRow][goalCol] = Config.GOAL_CHAR;
            }
        }
        return configArray;
    }

    /**
     * Prints out the game board.
     * 
     * 1 - Since the game board does not contain the outer walls, print out a sequence of
     * Config.WALL_CHAR with a length equal to that of the first row of board, plus the outer wall
     * to the left and the right. 2 - For each row in board, print out a Config.WALL_CHAR, followed
     * by the contents of the row, followed by a Config.WALL_CHAR. 3 - Finally, print out a sequence
     * of Config.WALL_CHAR with a length equal to that of the last row of board, plus the outer wall
     * to the left and the right.
     *
     * Note: each row printed out should be terminated by a new line.
     *
     * @param board The board to print.
     */
    public static void printBoard(char[][] board) {
        // FIX ME
        for (int x = 0; x < board.length + 2; ++x) {
            System.out.print("#");
        }

        System.out.print("\n");
        for (int i = 0; i < (board.length); ++i) {
            System.out.print("#");
            for (int j = 0; j < (board[i].length); ++j) {
                System.out.print(board[i][j]);
            }
            System.out.print("#");
            System.out.print("\n");
        }
        for (int x = 0; x < board.length + 2; ++x) {
            System.out.print("#");
        }
    }

    /**
     * Runs a given level through some basic sanity checks.
     *
     * This method performs the following tests (in order): 1- lvl >= 0 2- lvl is a valid index in
     * levels, that the 2-d array at index lvl exists and that it contains at least 1 row. 3- lvl is
     * a valid index in goals, the 1-d array at index lvl exists and that it contains an even number
     * of cells. 4- the number of boxes is more than 0. 5- the number of boxes equals the number of
     * goals. 6- the coordinate of each goal is valid for the given lvl and does not correspond to a
     * wall cell. 7- the number of workers is exactly 1. 8- check for duplicate goals.
     *
     * @param lvl The index of the level to load.
     * @param levels The array containing the levels.
     * @param goals The parallel array to levels, containg the goals for the levels.
     * @return 1 if all tests pass. Otherwise if test: - Test 1 fails: 0 - Test 2 fails: -1 - Test 3
     *         fails: -2 - Test 4 fails: -3 - Test 5 fails: -4 - Test 6 fails: -5 - Test 7 fails: -6
     *         - Test 8 fails: -7
     * 
     */
    public static int checkLevel(int lvl, char[][][] levels, int[][] goals) {
        // FIX ME


        // test 1
        if (lvl < 0) {
            return 0;
        }

        // test 2
        if (lvl >= levels.length) {
            return -1;
        }
        if (levels[lvl] == null) {
            return -1;
        }

        if (levels[lvl].length <= 0) {
            return -1;
        }

        // test 3
        if (lvl >= goals.length) {
            return -2;
        }


        if (goals[lvl] == null) {
            return -2;
        }



        if (goals[lvl].length % 2 != 0) {
            return -2;
        }

        // test 4
        int sumBox = 0;


        for (int j = 0; j < levels[lvl].length; ++j) {

            for (int k = 0; k < levels[lvl][j].length; ++k) {

                if (levels[lvl][j][k] == Config.BOX_CHAR) {
                    sumBox += 1;

                }

            }

        }

        if (sumBox <= 0) {
            return -3;
        }


        // test 5

        int sumGoals = goals[lvl].length / 2;

        if (sumGoals != sumBox) {
            return -4;
        }



        // test 6
        for (int i = 0; i < goals[lvl].length - 1; i += 2) {
            int goalRow = goals[lvl][i];
            int goalCol = goals[lvl][i + 1];
            // check if row is valid
            if (goalRow < 0 || goalRow >= levels[lvl].length) {
                return -5;
            }

            // check if col is valid
            if (goalCol < 0 || goalCol >= levels[lvl][goalRow].length) {
                return -5;
            }
            // check if if there is a wall
            if (levels[lvl][goalRow][goalCol] == Config.WALL_CHAR) {
                return -5;
            }

        }



        // test 7
        int sumWorkers = 0;
        for (int j = 0; j < levels[lvl].length; ++j) {

            for (int k = 0; k < levels[lvl][j].length; ++k) {

                if (levels[lvl][j][k] == Config.WORKER_CHAR) {
                    sumWorkers += 1;

                }

            }

        }
        if (sumWorkers > 1) {
            return -6;
        }


        // Test 8 checks if there are duplicate goals
        for (int i = 0; i < goals[lvl].length - 1; i += 2) {
            for (int j = i + 2; j < goals[lvl].length - 1; j += 2) {
                if (goals[lvl][i] == goals[lvl][j] && goals[lvl][i + 1] == goals[lvl][j + 1]) {
                    return -7;
                }
            }
        }



        return 1;

    }



    /**
     * This method builds an int array with 2 cells, representing a movement vector, based on the
     * String parameter.
     *
     * The rules to create the length 2 int array are as follows: - The 1st character of the String
     * represents the direction. - The remaining characters (if there are any) are interpreted as
     * integer and represent the magnitude or the number of steps to take.
     *
     * The cell at index 0 represents movement in the rows. Hence, a negative value represents
     * moving up the rows and a positive value represents moving down the rows.
     *
     * The cell at index 1 represents movement in the columns. Hence, a negative value represents
     * moving left in the columns and a positive value represents moving right in the columns.
     *
     * If the first character of moveStr does not match on of Config.UP_CHAR, Config.DOWN_CHAR,
     * Config.LEFT_CHAR, or Config.RIGHT_CHAR, then return an array with 0 in both cells.
     *
     * If there are no characters after the first character of moveStr or the characters cannot be
     * interpreted as an int, set the magnitude of the movement to 1.
     *
     * Hint: Use Scanner to parse the magnitude.
     *
     * Some examples: - If the parameter moveStr is "81": An array {-1, 0} would represent moving up
     * by one character. - If the parameter moveStr is "65": An array {0, 5} would represent moving
     * right by 5 characters.
     *
     * @param moveStr The string to parse.
     * @return The calculated movement vector as a 2 cell int array.
     */
    public static int[] calcDelta(String moveStr) {
        // FIX ME
        Scanner sc = new Scanner(moveStr);
        String number = "";
        int[] movementVector = new int[2];
        if (sc.hasNextInt()) {
            if (moveStr.charAt(0) != Config.UP_CHAR && moveStr.charAt(0) != Config.DOWN_CHAR
                && moveStr.charAt(0) != Config.LEFT_CHAR
                && moveStr.charAt(0) != Config.RIGHT_CHAR) {

                for (int i = 0; i < movementVector.length; ++i) {
                    movementVector[i] = 0;
                }

                return movementVector;

            }

            else if (Character.isDigit(moveStr.charAt(1))
                && Character.isWhitespace(moveStr.charAt(1))) {
                for (int i = 0; i < movementVector.length; ++i) {
                    if (i == 0) {
                        movementVector[i] = Character.getNumericValue(moveStr.charAt(0));
                    } else {
                        movementVector[i] = 1;
                    }
                }

                return movementVector;

            }

            else {
                for (int i = 0; i < movementVector.length; ++i) {
                    if (moveStr.charAt(0) == Config.UP_CHAR) {
                        if (i == 0) {
                            for (int x = 1; x < moveStr.length(); ++x) {
                                number += Character.toString(moveStr.charAt(x));

                            }
                            movementVector[i] = Integer.parseInt(number) * (-1);
                        } else {
                            movementVector[i] = 0;
                        }
                    } else if (moveStr.charAt(0) == Config.DOWN_CHAR) {
                        if (i == 0) {
                            for (int x = 1; x < moveStr.length(); ++x) {
                                number += Character.toString(moveStr.charAt(x));
                            }
                            movementVector[i] = Integer.parseInt(number);
                        } else {
                            movementVector[i] = 0;
                        }
                    } else if (moveStr.charAt(0) == Config.LEFT_CHAR) {
                        if (i == 1) {
                            for (int x = 1; x < moveStr.length(); ++x) {
                                number += Character.toString(moveStr.charAt(x));
                            }
                            movementVector[i] = Integer.parseInt(number) * (-1);
                        } else {
                            movementVector[i] = 0;
                        }

                    } else if (moveStr.charAt(0) == Config.RIGHT_CHAR) {
                        if (i == 1) {
                            for (int x = 1; x < moveStr.length(); ++x) {
                                number += Character.toString(moveStr.charAt(x));
                            }
                            movementVector[i] = Integer.parseInt(number);
                        } else {
                            movementVector[i] = 0;
                        }

                    }

                }
                return movementVector;

            }
        }
        return movementVector;
    }

    /**
     * This method checks that moving from one position to another position is a valid move.
     *
     * To validate the move, the method should (in order) check: 1 - that pos is valid. 2 - that the
     * character at pos in board is in the valid array. 3 - that the delta is valid. 4 - that the
     * new position is valid and not a wall character. 5 - that the new position is not a box
     * character For what makes each test invalid, see the return details below.
     *
     * @param board The current board.
     * @param pos The position to move from. A length 2 array, where index 0 is the row and index 1
     *        is the column.
     * @param delta The move distance. A length 2 array, where index 0 is the change in row and
     *        index 1 is the change in column.
     * @param valid A character array containing the valid characters for the cell at pos.
     * @return 1 if the move is valid. Otherwise: -1 : if pos is null, not length 2, or not on the
     *         board. -2 : if the character at pos is not valid (not in the valid array). -3 : if
     *         delta is null or not length 2. -4 : if the new position is off the board or a wall
     *         character -5 : if the new position is a box character
     */
    public static int checkDelta(char[][] board, int[] pos, int[] delta, char[] valid) {
        // FIX ME

        // test 1
        if (pos == null) {
            return -1;
        }

        int x = pos[0];
        int y = pos[1];

        if (x > board.length || x < 0 || y > board[x].length || y < 0) {
            return -1;
        }


        // test 2


        int match = 0;

        for (int i = 0; i < valid.length; ++i) {
            if (board[pos[0]][pos[1]] == valid[i]) {
                match += 1;
            }


        }

        if (match >= 1) {
            return -2;
        }

        // test 3
        if (delta == null || delta.length > 2 || delta.length < 0) {
            return -3;
        }

        // test 4
        if (board[pos[0] + delta[0]][pos[1] + delta[1]] == Config.WALL_CHAR
            || pos[0] + delta[0] > board.length || pos[1] + delta[1] > board[0].length) {

            return -4;
        }

        // test 5
        if (board[pos[0] + delta[0]][pos[1] + delta[1]] == Config.BOX_CHAR) {
            return -5;
        }
        return 1;
    }

    /**
     * Changes a character on the board to one of two characters (opt1 or opt2), depending on the
     * value of the cell.
     *
     * Check the cell at position pos. If the character is val, change it to opt1. Otherwise, change
     * it to opt2.
     *
     * @param board The current board.
     * @param pos The position to change. A length 2 array, where index 0 is the row and index 1 is
     *        the column.
     * @param val The value to check for in the board.
     * @param opt1 The character to change to if the value is val.
     * @param opt2 The character to change to if the value is not val.
     */
    public static void togglePos(char[][] board, int[] pos, char val, char opt1, char opt2) {
        // FIX ME
    }

    /**
     * Moves a box on the board.
     *
     * Step 1: Use your checkDelta method to check that the move is valid. Recall that there are 2
     * characters that can represent a box. Step 2: Use your togglePos method to correctly change
     * the character at the new position to the appropriate box character. Step 3: Again use your
     * togglePos method to correctly change the character at pos to the the appropriate character
     * without a box.
     *
     * @param board The current board.
     * @param pos The position to change. A length 2 array, where index 0 is the row and index 1 is
     *        the column.
     * @param delta The move distance. A length 2 array, where index 0 is the change in row and
     *        index 1 is the change in column.
     * @return The return value of checkDelta if less than 1. Otherwise 1.
     */
    public static int shiftBox(char[][] board, int[] pos, int[] delta) {
        // FIX ME
        return -99;
    }

    /**
     * Processes a move of the worker step-by-step.
     *
     * Go through the delta step-by-step, calling doMove for each step. That is, if the delta is {0,
     * -3}, your method should call doMove three times with an argument of {0, -1} for the delta
     * parameter of doMove. Or, if the delta is {6, 0}, it would call the doMove six times with an
     * argument of {1, 0} for the delta parameter of the doMove method.
     *
     * During the processing of the move, if ever a call to doMove returns a value less than 1, your
     * method should stop processing and return that value.
     *
     * Note: You can assume that one of the cells of delta will be 0.
     *
     * @param board The current board.
     * @param pos The position to change. A length 2 array, where index 0 is the row and index 1 is
     *        the column.
     * @param delta The move distance. A length 2 array, where index 0 is the change in row and
     *        index 1 is the change in column.
     * @return If both of the cells of delta are 0, return 0. If the call to doMove returns a value
     *         less than 1, return that value. Otherwise, return 1.
     */
    public static int processMove(char[][] board, int[] pos, int[] delta) {
        // FIX ME
        return -99;
    }

    /**
     * Moves the worker on the board.
     *
     * Step 1: Use your checkDelta method to check that the move is valid. Recall that there are 2
     * characters that can represent the worker. Step 2: If checkDelta returns -5, use your shiftBox
     * method to move the box by delta before moving the worker. Step 3: Use your togglePos method
     * to correctly change the character at the new position to the appropriate worker character.
     * Step 4: Again use your togglePos method to correctly change the character at pos to the the
     * appropriate character without a worker. Step 5: Update the position of the worker in pos.
     *
     * @param board The current board.
     * @param pos The position to change. A length 2 array, where index 0 is the row and index 1 is
     *        the column.
     * @param delta The move distance. A length 2 array, where index 0 is the change in row and
     *        index 1 is the change in column.
     * @return If checkDelta returns a value less than 1 that is not -5, return that value. If
     *         checkDelta returns -5 and shiftBox returns a value less than 0, return 0. Otherwise,
     *         return 1.
     */
    public static int doMove(char[][] board, int[] pos, int[] delta) {
        // FIX ME
        return -99;
    }

    /**
     * Checks all the cells in board and ensures that there are no goals that are not covered by
     * boxes.
     *
     * @param board The current board.
     * @return true if all the goals are covered by boxes. Otherwise, false.
     */
    public static boolean checkWin(char[][] board) {
        // FIX ME
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == Config.GOAL_CHAR) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This is the main method for the Sokoban game. It consists of the main game and play again
     * loops with calls to the various supporting methods. The details of the main method for each
     * milestone can be found in the BP1 - Sokoban write-up on the CS 200 webpage:
     * https://cs200-www.cs.wisc.edu/wp/programs/
     *
     * For all milestones, you will need to create a Scanner object to read from System.in that you
     * will pass to the helper methods.
     *
     * For milestone 3, you will need to create a Random object using Config.SEED as the seed. This
     * object should be create at the beginning of the method, outside of any loops.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pos = new int[2];
        char[][] board = {};
        int min = 0;
        int max = Config.LEVELS.length - 1;
        String prompt = "Choose a level between 0 and " + (Config.LEVELS.length - 1) + ": ";
        String prompt2 = "Play again? (y/n) ";
        char userChar = ' ';
        int checkLevel = 0;

        System.out.println("Welcome to Sokoban!");


        do {
            int userInt = promptInt(sc, prompt, min, max);
            checkLevel = checkLevel(userInt, Config.LEVELS, Config.GOALS);
            if (checkLevel == 1) {
                System.out.println("Sokoban Level " + userInt);
                board = initBoard(userInt, Config.LEVELS, Config.GOALS, pos);
                printBoard(board);
                promptString(sc, prompt);

                if (promptString(sc, prompt).equals(Config.QUIT_CHAR)) {
                    userChar = 'n';
                }

                userChar = promptChar(sc, prompt2);


            }
        } while (userChar == 'y');


        System.out.println("Thanks for playing!");
    }

}

