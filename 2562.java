import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[9];
        for(int i=0;i<9;i++){
            arr[i]=in.nextInt();
        }
        int max=arr[0];
        int idx=1;
        for(int i=1;i<9;i++){
            if(max<arr[i]){
                max=arr[i];
                idx=i+1;
            }
        }
        System.out.println(max);
        System.out.println(idx);
    }
}