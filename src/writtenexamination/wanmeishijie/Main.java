package writtenexamination.wanmeishijie;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replace(" ", "");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                //数字
                if (!stack.isEmpty()){
                    if (stack.peek() == '+'){
                        stack.pop();
                        int temp = (stack.pop() - '0') + (c - '0');
                        stack.push((char) (temp + '0'));
                    }else if (stack.peek() == '-'){
                        stack.pop();
                        int temp = (stack.pop() - '0') - (c - '0');
                        stack.push((char) (temp + '0'));
                    }else {
                        stack.push(c);
                    }
                }else {
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }
        }
//        System.out.println(stack);
        int res = 0;
        Stack<Character> stack1 = new Stack<>();
        while (!stack.isEmpty()){
            char c = stack.pop();
            if (!stack1.isEmpty()){
                if (stack1.peek() == '?'){
                    //取后面9个计算；
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    for (int i = 0; i < 9; i++) {
                        sb.append(stack1.pop());
                    }
                    res = operation(sb.toString());
                    stack1.push((char)(res + '0'));
                }else {
                    stack1.push(c);
                }
            }else {
                //为空直接入栈
                stack1.push(c);
            }

        }
        System.out.println(res);
    }
    public static int operation(String s){
        int a1 = s.charAt(0) - '0';
        int a2 = s.charAt(3) - '0';
        int a3 = s.charAt(5) - '0';
        int b1 = s.charAt(7) - '0';
        int b2 = s.charAt(9) - '0';
        if (a1 >= a2 && a1 <= a3){
            return a1 + b1 + b2;
        }else if (a1 < a2){
            return a2 + b1;
        }else if (a1 > a3){
            return a3 + b2;
        }
        return -1;
    }
}
