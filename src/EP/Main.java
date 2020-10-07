package EP;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        for (int i = 1000; i<=99000; i+=1000) {
            File file = new File("D:\\entradas\\tarefas"+i+".txt");
            Scanner sc = new Scanner(file);
            PilhaIngenua guardar = new PilhaIngenua();
            while (sc.hasNext()) {
                guardar.add(sc.nextInt());
            }
            sc.close();

            try {
                File myObj = new File("D:\\saidas\\tarefas"+i+".txt");
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
                FileWriter myWriter = new FileWriter("D:\\saidas\\tarefas"+i+".txt");
                myWriter.write(Arrays.toString(guardar.pilha)+"\nTempo total: "+System.currentTimeMillis());
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }


        }
    }
}
