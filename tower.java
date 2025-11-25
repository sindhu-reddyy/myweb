import java.util.*;
class tower {
    static void t(int n,char A,char B,char C){
        if(n==1){
            System.out.println("Move disk 1 from "+A+" to "+C);
            return;
        }
        t(n-1,A,C,B);
        System.out.println("Move disk "+n+" from "+A+" to "+C);
        t(n-1,B,A,C);




    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        t(n,'A','B','C');


    }
    
}
