import java.util.*;
public class number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); 
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int sum=0;
        int count=0;
        Arrays.sort(arr);
        // for(int y:arr)System.out.println(y);
        for(int i=n-1;i>0;i--){
            int rem=arr[i]%10;
            if(rem==0){
                continue;
            }else if(arr[i]%rem==0){
                count++;
                sum+=arr[i];
            
                if(count==3){
                    break;
                }
            }
        }
        System.out.println(sum);
    }
    
}
