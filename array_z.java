import java.util.*;
import java.lang.Math;
public class array_z {
    public static int linear_search(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void largest (int arr[]){
       int L = Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++){
        if(arr[i]>L){
            L=arr[i];
        }
        
       } 
       System.out.println(L);
    }
    public static int binary_search(int arr[],int key){
     int start = 0; 
     int end = arr.length-1;
     int mid=0;
     while(start<=end){
        mid =(start+end)/2;

        if(key==arr[mid]){
            return mid;
        }
        if(key<arr[mid]){
         end = mid-1;   
        }
        if(key>arr[mid]){
           start=mid+1; 
        }
     }
     return -1;
}
    public static void reverse(int arr[]){
        int first=0;
        int last=arr.length-1;
        while(first<last) {
            int temp = arr[first];
            arr[first]= arr[last];
            arr[last]=temp;
            first++;
            last--;
        }
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
         }
    }
    public static void pairs(int arr[]){
        int n = arr.length;
        int count =0;
        for(int i = 0;i<n; i++) {
            for(int j =i+1;j<n;j++){
                System.out.print ("("+arr[i]+" "+arr[j]+")"+"  ");
                count++;
            }
            System.out.println();  
        }
        System.out.print(count);
    }
    public static void sub_array(int arr[]){
        int ts=0; int max_sum =Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            int sum=0;
            int start = i;
            for(int j=i;j<arr.length;j++){
                int end = j;
                for(int k=start;k<= end;k++){
                    System.out.print(arr[k] +" ");
                   sum += arr[k];
                }

                System.out.print(sum+" ");
                if(max_sum <sum){
                    max_sum =sum;
                } 
                sum =0;
                ts++;
                System.out.println();
            } 
            System.out.println();         
        }System.out.println(max_sum);
        System.out.println(ts);
   }
    public static void prefix_array(int arr[]){
        int prefix []=new int[arr.length];
        int maxsum=Integer.MIN_VALUE;
        int start =0; 
        int end=0;
        int currsum =0;
        prefix[0]=arr[0];
        for(int i =1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i = 0; i<arr.length ;i++){
            start =i;
            for(int j = i; j<arr.length ;j++){
                end =j;
                currsum = start==0?prefix[end]: prefix[end]-prefix[start-1];
                if(currsum>maxsum){
                    maxsum = currsum;
                }
            }
        }System.out.println(maxsum);
    }
    public static void kadanes_algo(int arr[]){
        int currsum=0;
        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
          currsum+=arr[i];
          if(currsum<0){
            currsum=0;
          } 
          maxsum=Math.max(maxsum,currsum);
        }
        System.out.println(maxsum);
    }
    public static void rain_water(int arr[]){
       int n = arr.length;
        // left _max
        int left_max[]=new int [n];
        left_max[0] = arr[0];
        for(int i=1;i<n;i++){
            left_max[i]=Math.max(arr[i],left_max[i-1]);
        }
        // rigth_max
        int right_max[]=new int[n];
        right_max[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            right_max[i]=Math.max(arr[i],right_max[i+1]);
        }
        // trepped_water;
        int trapped_water=0;
        for(int i =0;i<n;i++){
            int water_level = Math.min(left_max[i],right_max[i]);
            trapped_water += water_level-arr[i];
        }
        System.out.println(trapped_water);  
    }

    public static void main(String[] args){
        int arr[]={4,2,0,6,3,2,5};
     //   int key = 25;
   /*    int result=linear_search(arr,key);
        if(result==-1){
            System.out.println("key not found");
        }
        else{
            System.out.println("key found at index "+result );
        }
*/
   //     largest(arr);
  // int b = binary_search(arr,key);
  // System.out.println(key + " key is at index "+ b);
   //  reverse(arr);
  // pairs(arr);
   //     sub_array(arr);
   //     prefix_array(arr);
 //  kadanes_algo(arr);
//  rain_water(arr);
    }
}
