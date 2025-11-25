import java.util.*;
class base{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)>s.charAt(i+1)){
                sb.append("D");
            }else if(s.charAt(i)<s.charAt(i+1)){
                sb.append("I");
            }else{
                sb.append("E");
            }
        }
        System.out.println(sb.toString());
        String ans=sb.toString();
        char[] arr=ans.toCharArray();
        StringBuilder comp=new StringBuilder();
        comp.append(ans.charAt(0));
        for(int i=1;i<ans.length();i++){
            if(ans.charAt(i)!=ans.charAt(i-1)){
                comp.append(ans.charAt(i));
            }
        }
        System.out.println(comp.toString());

    }
}