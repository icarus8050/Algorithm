import java.util.ArrayList;

public class SetOfStacks {
    private int capacity;
    private ArrayList<Stack> stacks;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
        stacks = new ArrayList<Stack>();
    }

    public Stack getLastStack(){
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int value){
        Stack last_Stack = getLastStack();
        if (last_Stack != null && !last_Stack.isFull()){
            last_Stack.push(value);
        } else {
            Stack newStack = new Stack(capacity);
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public int pop(){
        Stack last_Stack = getLastStack();
        int value = last_Stack.pop();
        if (last_Stack.getSize() == 0) stacks.remove(stacks.size() - 1);
        return value;
    }
}
