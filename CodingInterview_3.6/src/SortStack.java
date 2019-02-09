import java.util.Stack;

public class SortStack {
    private Stack<Integer> storage;

    public SortStack(){
        storage = new Stack();
    }

    public void push(int value){
        Stack<Integer> buffer = new Stack();
        if(storage.isEmpty()) storage.push(value);
        else {
            while (!storage.isEmpty()) {
                if (storage.peek() > value) buffer.push(storage.pop());
                else {
                    storage.push(value);
                    break;
                }
            }
            while (!buffer.isEmpty()) storage.push(buffer.pop());
        }
    }

    public int pop(){
        return storage.pop();
    }

    public boolean isEmpty(){
        return storage.isEmpty();
    }

    public int peek(){
        return storage.peek();
    }
}
