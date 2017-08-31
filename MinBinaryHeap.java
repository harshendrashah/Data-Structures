
public class MinBinaryHeap {
	int A[];
	public int heapSize;
	public MinBinaryHeap(int A[]){
		this.A=A;
		heapSize=A.length-1;
		buildMinHeap();
		}
	public int right(int i){
		return 2*i+2;
	}
	public  int left(int i){
		return 2*i+1;
	}
	public int parent(int i) {
		return (i+1)/2;}

	public void buildMinHeap(){
		for(int i=A.length/2;i>=0;i--){
			heapMin(i);	
			}
		}
	public void heapMin(int i){
		int min;
		if(left(i)<=heapSize&&A[left(i)]<A[i])
			min=left(i);
		else 
			min=i;
		if(right(i)<=heapSize&&A[right(i)]<A[min])
			min = right(i);
		if(min!=i){
			int temp=A[min];
			A[min]=A[i];
			A[i]=temp;
			heapMin(min);
			}
		}
	public int extractMin(){
		int min=A[0];
		A[0]=A[heapSize];
		A[heapSize]=999999999;
		heapSize--;
		heapMin(0);
		return min;
		}
	public void Add(int num){
		heapSize++;
		int temp=A[0];
		A[0]=num;
		A[heapSize]=temp;
		heapMin(0);
	}
	public void decrese(int i, int num){
		if(i<=heapSize){
			A[i]=num;
			int temp=A[0];
			A[0]=A[i];
			A[i]=temp;
			heapMin(0);
		}
	}
	

}
