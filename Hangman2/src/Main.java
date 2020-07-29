import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   private static ArrayList<String> wordsArrayList = new ArrayList<>();
    public static void main(String[] args) {
        Words words = new Words();
        words.setWordSTR(wordsArrayList);
//        words.GetRandomWord();
//        words.ChangeGamewordShower('a');
        words.Game();
    }



    static {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("words_alpha.txt"));
            scanner.useDelimiter("\n");
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                wordsArrayList.add(s);
                //System.out.println(s);
            }
//            System.out.println(wordsArrayList.toString());
        }catch (IOException e){

            e.printStackTrace();

        }finally {
            if(scanner != null){
                scanner.close();
            }
        }
    }
}


