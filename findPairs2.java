import java.util.*;
class findPairs2{
	public static void main(String[] args) {
		int[] arr = new int[]{3, 4, 7, 1, 2, 9, 8};
		HashMap<Integer,Obj> hm = new HashMap<Integer, Obj>();
		for (int i = 0; i < arr.length ; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (hm.containsKey(sum)) {
					System.out.println("(" + hm.get(sum).i + "," + hm.get(sum).j +")" + "--" + "(" + i + "," + j +")");	
				}else{
					hm.put(sum,new Obj(i,j));
				}	
			}
		}
	}


}
class Obj{
	int i , j;
	Obj(int i,int j){
		this.i = i;
		this.j = j;
	}
}