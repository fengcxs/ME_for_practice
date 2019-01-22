import java.util.Scanner;

public class Main {
    final static String vowel ="aeiou";

    public static void main(String[] args) {
        System.out.println("请输入一个单词：");
        Scanner scan = new Scanner(System.in);
        String read = scan.next();
        System.out.println("输入的单词为：" + read);

        System.out.println("格式化为：" + pig_latin(read));

        System.exit(0);

    }


    public static String pig_latin(String input){
        String res = "";

        char firstLetter = input.charAt(0);
        if(vowel.indexOf(firstLetter) == -1){
            String startConsonant="" + firstLetter;
            int i = 1;
            while(vowel.indexOf(input.charAt(i)) == -1){
                startConsonant += input.charAt(i);
                if(i < input.length()-1){
                    i++;
                }
            }
            res = input.substring(i, input.length()) + '-' + startConsonant + "ay";
        }
        else{
            res = input + "-ay";
        }

        return res;
    }
}
