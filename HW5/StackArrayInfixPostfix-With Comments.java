import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class StackArrayInfixPostfix {

    public static int pr(char elem)
    {                
        switch(elem)
        {
            //case '#': return 0;
            case '(': return 1;
            case '+':
            case '-': return 2;
            case '*':
            case '/': return 3;
            case '^': return 4;
        }

        return -1;
    }

    public static String InfixToPostfix(String infx)
    {                        
        char ch, elem;
        int i = 0;
/* 
        String is immutable in java but StringBuilder object is not
        we are creating an empty string using StringBuilder class
        and then we would keep appending characters in it to get the postfix expression
*/
        StringBuilder pofx = new StringBuilder();

        // create a stack of size 100 (here the Stack will be used for Character type objects)
        Stack<Character> stack = new Stack();
        // run a loop to traverse over each character of the string infix
        for(i = 0; i < infx.length(); i++)
        {
            ch = infx.charAt(i); //get character in string at index i
/* 
            Character c = new Character(ch);
            There can be 4 cases '('', alphanumeric (a-z, A-Z, 0-9), ')'', or operator based on content of ch
            run an if else here for each case
*/
            if(Character.isLetterOrDigit(ch)) { //if ch is an alphanumeric character
                pofx.append(ch); //append it to the postfix expression
            } else if ( ch == '(') {  //if ch is a left parenthesis
                stack.push(ch); //push it to the stack
            } else if ( ch == ')') { //if ch is a right parenthesis
                while(!stack.isEmpty() && stack.peek() != '(') { //while the stack is not empty and the top element is not a left parenthesis 
                    pofx.append(stack.pop()); //append the top element to the postfix expression
                }
                stack.pop(); //if ch is a right parenthesis, pop it from the stack
            } else {
              //while the stack is not empty and the top element has a higher precendence than ch

                while(!stack.isEmpty() && pr(ch) <= pr(stack.peek())) {

                    pofx.append(stack.pop()); //append the top element to the postfix expression
                }
                stack.push(ch); //puch ch to the stack
            }
            // Note, push, pop, getTop functions takes/returns objects
            // pr function takes char (not Character object) as input

          
        }
        
        while (!stack.isEmpty()) {
            // pop all the values and append
            if(stack.peek() == '(') {
                return "Invalid infix expression";
            }
            pofx.append(stack.pop());
        }
      
        return pofx.toString();   /* the toString functin of StringBuilder object returns the string */
    }

    public static int evaluatepostfix (String pofx)
    {
        
        int operand1, operand2, result = 0, i;
        char ch;
        // create a stack of size 100 (here the Stack will be used for Integer type objects)
        Stack<Integer> stack = new Stack<>();
        // run a loop to traverse over each character of the string pofx
        for(i = 0; i < pofx.length(); i++) {
            // read the character from pofx in variable named ch
            ch = pofx.charAt(i);
            // if the character is space or tab, skip
            if (ch == ' ' || ch == '\t')
            {
                i++ ;
                continue;
            }

            // check if ch is a digit (0-9)
            if(Character.isDigit(ch)) {
                Integer obj = new Integer(ch);
                stack.push(obj);
            } else {
               operand1 = stack.pop();
               operand2 = stack.pop();
               switch(ch) {
                 case '+':
                   result = operand1 + operand2;
                   break;
                 case '-':
                   result = operand1 - operand2;
                   break;
                 case '*':
                   result = operand1 * operand2;
                   break;
                 case '/':
                   result = operand1 / operand2;
                   break;
                 case '^':
                   result = (int)Math.pow(operand1, operand2);
                   break;
                 default:
                   break;
               }
               stack.push(Character.getNumericValue(ch));
            }
        }
            // if digit, create a new Integer object with value (ch -'0') and push it in stack
            
            // else ch is an operator
            // Call pop function to get two operands (note: pop will return Integer objects. You need to read the int value from it)
            // then use a switch/if-else to do the operation (+,-,*,/,^) and push the result by converting that result into an Integer object
         
        return ((Integer)stack.pop()).intValue(); // return the last value in your stack which is the evaluation result
}

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new FileReader("in.txt"));
        String infix, pofx;
        System.out.println("ASSUMPTION: The infix expression contains single letter variables and single digit constants only");
        infix = in.nextLine();
        
        System.out.println("Infix: " + infix);
        pofx = InfixToPostfix(infix);                   /* call to convert */
        System.out.println("Pstfix: " + pofx);
        //block this line if you are not doing the bonus part
        System.out.println("Postfix evaluation: " + evaluatepostfix(pofx));
        in.close();
           
    }
    
}
