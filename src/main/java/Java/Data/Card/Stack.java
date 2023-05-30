package Data;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    List<Card> mystack;

    public Stack (Card card){
        List<Card> stack = new ArrayList<>();
        stack.add(card);
        this.mystack = stack;
    }

    public boolean control(){
        boolean result = false;
        if (mystack.size()==5){
            result = true;
        }
        return result;
    }
    public int point (){
        int result = 0;
        for (int k = 0; k<5;k++){
            result += mystack.get(k).getBullhead();
        }
        return result;
    }
}
