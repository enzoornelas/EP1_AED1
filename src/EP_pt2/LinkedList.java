package EP_pt2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LinkedList {
    protected Node head, tail;
    protected long size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }


    public boolean isEmpty() {
        return (size == 0);
    }

    public void addFirst(Node n) {
        n.setNext(head);
        head = n;
        if (isEmpty()) {
            tail = n;
        }
        size++;
    }

    public void addLast(Node n) {
        n.setNext(null);
        tail.setNext(n);
        tail = n;
        if (isEmpty()) {
            head = n;
        }
        size++;
    }

    public String toString() {
        String s = "[";
        for (Node n = head; n != null; n = n.getNext()) {
            s += n.getElement();
            if (n != tail) {
                s += ", ";
            }
        }
        return s + "]";
    }



    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i=1000; i<=99000; i+=1000) {
            File file = new File("/Users/enzo/Downloads/entradas/tarefas"+i+".txt");
            Scanner sc = new Scanner(file);
            LinkedList list = new LinkedList();
            list.addFirst(new Node(sc.nextInt(),null));
            while (sc.hasNext()) {
                list.addLast(new Node(sc.nextInt(),null));

            }
            sc.close();


            try {
                File myObj = new File("/Users/enzo/IdeaProjects/EP1_AED1/src/EP_pt2/saidas_2/tarefas"+i+".txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            try {
                FileWriter myWriter = new FileWriter("/Users/enzo/IdeaProjects/EP1_AED1/src/EP_pt2/saidas_2/tarefas"+i+".txt");
                long endtime = System.currentTimeMillis();
                long duration = (endtime-startTime);
                myWriter.write(list.toString()+"\nTempo total: "+duration);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }
    }
}