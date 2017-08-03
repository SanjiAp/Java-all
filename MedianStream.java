import java.util.*;
import java.lang.*;
import java.io.*;
class MedianStream
 {
	public static void main (String[] args){
	    try{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();
	    int n = Integer.parseInt(str);
	    PriorityQueue<Integer> min = new PriorityQueue<Integer>();
	    PriorityQueue<Integer> max = new PriorityQueue<Integer>(27,new Comparator<Integer>(){
	       public int compare(Integer a , Integer b){
	           return b - a;
	       } 
	        });
	        
	    int eff_med = 0;     
	    for(int i = 0; i < n; i++){
	        int n1 = Integer.parseInt(br.readLine().trim());
	        if(min.size() == 0 && max.size()==0){
	            eff_med = n1;
	            min.add(n1);
	        }else if(max.size()==0){
	            if(eff_med > n1){
	                max.add(n1);
	            }else{
	                max.add(min.poll());
	                min.add(n1);
	            }
	            eff_med = (max.peek()+min.peek())/2;
	        }else{
	            if(min.size() == max.size() && eff_med < n1){
	                min.add(n1);
	                eff_med = min.peek();
	            }else if(min.size() == max.size() && eff_med > n1){
	                max.add(n1);
	                eff_med = max.peek();
	            }else if(min.size() > max.size() ){
	                if(eff_med > n1)
	                    max.add(n1);
	                else{
	                    max.add(min.poll());
	                    min.add(n1);
	                }
	                eff_med = (max.peek() + min.peek())/2;
	            }else if(min.size() < max.size() ){
	                if(eff_med < n1)
	                    min.add(n1);
	                else{
	                    min.add(max.poll());
	                    max.add(n1);
	                }
	                eff_med = (max.peek() + min.peek())/2;
	            }
	            
	            
	        }
	        System.out.println(eff_med);
	    }
	    }catch(IOException ie){
	        
	    }
	 }
}