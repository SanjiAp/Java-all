import java.util.*;

class FindSubseq{
	
	public static void main(String[] args) {
		int []arr = {13, 10,5,6,7,4};		
		FindSubseq fs = new FindSubseq();
		fs.getSubseqThree(arr);

	}	
	//arr[i]<arr[j]>arr[k] i<j<k
	public void getSubseqThree(int []arr){
		//Scan array from left and right side storing the indices of the min & max
		int []left = new int[arr.length];
		int min = 0;
		left[0] = -1; //left most element always -1
		for (int i = 1; i < arr.length - 1 ; i++) {
			if (arr[min] < arr[i]) {
				
				left[i] = min;

			}else{
				min = i;
				left[i] = -1;
			}
		}
		int []right = new int[arr.length];
		min = arr.length - 1;
		left[arr.length - 1] = -1; //left most element always -1
		for (int i = arr.length - 2; i >= 0 ; i--) {
			if (arr[min] < arr[i]) {
				
				right[i] = min;

			}else{
				min = i;
				right[i] = -1;
			}
		}
		for (int i = 1; i < arr.length - 1 ; i++) {
			if (left[i]!=-1 && right[i]!= -1) {
				System.out.println(arr[left[i]]+" "+arr[i]+" "+arr[right[i]]);
			}
		}
	}

}

/*
//tc O(n) 
// sc O(1)
void find3Numbers(int a[],int n){
 
	int small=INT_MAX,mid=INT_MAX,greater,storesmall,i;
 
	for(i=0;i<n;i++){
		if(small>=a[i])
		   small=a[i];
 
		else if(mid>=a[i])
		{
		     mid=a[i];
			 storesmall=small;
		}
		else 
		{
			greater=a[i];
			break;
		}
	}
	if(i==n)
	cout<<"No Triplet"<<endl;
	else
	cout<<storesmall<<" "<<mid<<" "<<greater<<endl;
 
	}
 
int main() {
	int n,i;
	cin>>n;
	int a[n+1];
 
	for(i=0;i<n;i++)
     	cin>>a[i];
 
    find3Numbers(a , n);
 
 
	return 0;
}*/