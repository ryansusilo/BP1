import java.util.Scanner;

public class something {
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
    
    public static void main(String[] args) {
        
        int [] movementVector = new int [2];
        
        movementVector = calcDelta("4200");
        
        for (int i = 0; i < movementVector.length; ++i) {
            System.out.print(movementVector[i] + " ");
        }
        
      
      

   
   }
}
  
  


