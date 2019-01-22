import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("请输入一个字符串： ");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();

        int sum = sum_words(read);
        System.out.println("有" + sum +"个单词");
    }


    public static int sum_words(String input){
        int sum = 0;
        int i =0;
        int len = input.length();

        while(i < len - 1){
            if(input.charAt(i) != ' '){
                sum++;
                while(input.charAt(i) != ' ' && i < len -1){
                    i++;
                }
            }
            if(input.charAt(i) == ' '){
                while(input.charAt(i) == ' ' && i < len -1){
                    i++;
                }
            }
        }

        return sum;
    }
}
