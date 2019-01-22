import java.util.Scanner;

public class Main {

    public final static String VOWEL = "aeiou";

    public static void main(String[] args) {
        System.out.println("请输入一个字符串： ");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();

        vowel_statistics(read);


    }

    public static void vowel_statistics(String input){
        int j = -1;
        int[] sum = {0, 0, 0, 0, 0};
        char[] tag = {'a', 'e', 'i', 'o', 'u'};

        for(int i = 0; i<input.length(); i++){
            if((j = VOWEL.indexOf(input.charAt(i))) != -1){
                sum[j] += 1;
            }
        }

        for(int i =0; i < sum.length; i++)
        {
            System.out.print(tag[i] + ": " + sum[i] + " ");
        }
    }
}
