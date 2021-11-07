package data.structures;

import java.util.Scanner;

/**
 * @author szhang
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[this.maxSize];
        // point to the ahead position of the first element of arr
        this.front = -1;
        // point to the last element of arr
        this.rear = -1;
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("This queue is full.");
        } else {
            ++this.rear;
            this.arr[this.rear] = n;
        }
    }

    public int getQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("This queue is empty.");
        } else {
            ++this.front;
            return this.arr[this.front];
        }
    }

    public void showQueue() {
        if (this.isEmpty()) {
            System.out.println("This queue is empty.");
        } else {
            for(int i = 0; i < this.arr.length; ++i) {
                System.out.printf("arr[%d]=%d\n", i, this.arr[i]);
            }

        }
    }

    public int headQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("This queue is empty.");
        } else {
            return this.arr[this.front + 1];
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("============= Commands: ===========");
            System.out.println("s(show)");
            System.out.println("e(exit)");
            System.out.println("a(add)");
            System.out.println("g(get)");
            System.out.println("h(head)");
            key = scanner.next().charAt(0);
            int res;
            switch(key) {
                case 'a':
                    System.out.println("Input a number:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'g':
                    try {
                        res = queue.getQueue();
                        System.out.printf("Get %d\n", res);
                    } catch (Exception var8) {
                        System.out.println(var8.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        res = queue.headQueue();
                        System.out.printf("Head %d\n", res);
                    } catch (Exception var7) {
                        System.out.println(var7.getMessage());
                    }
                    break;
                case 's':
                    queue.showQueue();
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }

        System.out.println("Exit~~");
    }
}
