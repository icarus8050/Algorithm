public class MainClass {

    public static void main(String[] args){
        SortStack stack = new SortStack();

        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(15);
        stack.push(12);
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
