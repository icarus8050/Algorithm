import java.util.Stack;

public class MyQueue<T> {

    private Stack<T> storage;
    private Stack<T> buffer;

    public MyQueue(){
        storage = new Stack<>();
        buffer = new Stack<>();
    }

    public void enQueue(T value){
        storage.push(value);
    }

    public T deQueue(){
        shiftStack();
        return buffer.pop();
    }

    private void shiftStack(){
        if(buffer.isEmpty()){
            while(!storage.isEmpty()){
                buffer.push(storage.pop());
            }
        }
    }
}
