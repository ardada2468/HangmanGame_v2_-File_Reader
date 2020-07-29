import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Words {
    ArrayList<String> wordSTR = new ArrayList<>();
    ArrayList<Character> GameWordShower = new ArrayList<>();
    private String Word = "";
    ArrayList<Character> WordCharList = new ArrayList<>();

    public void addword(String Word){
        wordSTR.add(Word);
    }

    public Words() {
        // clearScreen();
    }

    public void GetRandomWord(){
        System.out.println(wordSTR.toString());
        Random rand = new Random();
        int rand_int1 = rand.nextInt(370099);
        Word = wordSTR.get(rand_int1);
        System.out.println(Word);
        for(int i = 0; i < Word.length(); i++){
            GameWordShower.add('_');
        }
        char [] wordlist = Word.toCharArray();
        for(char char1 : wordlist){
            WordCharList.add(char1);
        }
        for(Character character : GameWordShower){
            System.out.print(character);
        }
        //System.out.print(GameWordShower.toString());
    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public void printGameWord(){
        //clearScreen();
        String s = "";
        for(Character character : GameWordShower){
            s = s + character.toString();
        }
        System.out.println( "\n" + s+"\n");
    }

//    public void addWords(){
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileReader("words_alpha.txt"));
//            scanner.useDelimiter("\n");
//            while (scanner.hasNextLine()){
//                String s = scanner.nextLine();
//                wordSTR.add(s);
//                System.out.println(s);
//            }
//            System.out.println(wordSTR.toString());
//        }catch (IOException e){
//
//            e.printStackTrace();
//
//        }finally {
//            if(scanner != null){
//                scanner.close();
//            }
//        }
//    }


    public void Game(){
        GetRandomWord();
        int WordLength = Word.length();
        int Guesses = WordLength + 5;
        for(int i = 0; i < Guesses; i++){
            System.out.println("\t You have "+ (Guesses-i) + " Guesses left");
            printGameWord();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter a Letter");
            String s = scanner.nextLine();
            s = s.toLowerCase();
            if(s.length() == 1 && !s.equals("")){
                if(WordContains(s)){
                    ChangeGamewordShower(toCharacter(s));
                }
                if (GameWordShower.equals(WordCharList)) {
                    System.out.print("Congratulations you Won!! \n");
                    break;
                }
                } else {
                    System.out.println("Please Enter a Character (a - z)");
                }if(s.equals("") || s.length() > 1){
                i--;
            }
            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        }
        System.out.println("Word was - " + Word);
        }



    public Character toCharacter(String s){
        char returnable = 'a';
        char[] chars = s.toCharArray();
        if(chars.length == 1) {
            for (char Char : chars) {
                returnable = Char;
                return returnable;
            }
        }
        return null;
    }

    public void ChangeGamewordShower(Character letter){
        char[] wordchararray =  Word.toCharArray();
        int index = 0;
        for(Character Char : wordchararray){
            if(letter.equals(Char)){
                GameWordShower.remove(index);
                GameWordShower.add(index,letter);
                //printGameWord();
            }
            index++;
        }

//        printGameWord();
    }


    public boolean WordContains(String letter){
        char[] letters = Word.toCharArray();
        String[] lettersSTR = null;
        int i = 0;
        for(char Char2 : letters){
            if(Word.contains(letter)){
                return true;
            }
            i++;
        }
        return false;
    }

    public void setWordSTR(ArrayList<String> wordSTR) {
        this.wordSTR = wordSTR;
    }
}



