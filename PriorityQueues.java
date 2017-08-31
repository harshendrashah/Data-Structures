public class PriorityQueues {
	private int[] A;
	private  int HeapSize=-1;
	public PriorityQueues(int [] A){
		this.A=A;
	    HeapSize=A.length-1;
	    buildMaxHeap(A);
	    }
    public int getMax(int[] A){
    	return A[0];	
    }
	public  int extractMax(int[] A){
		//System.out.println(HeapSize);
		if(HeapSize<1) return -1;
		int temp= A[0];
		A[0]=A[HeapSize];
		A[HeapSize]=temp;
		HeapSize--;
		heapMaxify(A,0);
		return temp;
		}
	public void incrKey(int[] A,int i, int key){
		if(key<A[i]){
			System.out.println("key is less than current key");
			return;
		}
		A[i]=key;
		while(i>1){
			if(A[i]>A[parent(i)]){
				int temp=A[i];
				A[i]=A[parent(i)];
				A[parent(i)]=temp;
				i=parent(i);
			}
		}
	}
	
	public void insert(int[] A, int key){
		
		HeapSize++;
		A[HeapSize]=-99999999;
		incrKey(A,HeapSize,key);
		}protected void buildMaxHeap(int[] A ) {
			for(int i=A.length/2;i>=0;i--){
				heapMaxify(A,i);	
				
				}
			}
			protected  void heapMaxify(int [] A, int i){
				int largest;
				if(Left(i)<=HeapSize&&A[Left(i)]>A[i]) largest=Left(i);
				else largest=i;
				if(Right(i)<=HeapSize&&A[Right(i)]>A[largest]) largest=Right(i);
				if(largest!=i) {
					int temp=A[i];
					A[i]=A[largest];
					A[largest]=temp;
					heapMaxify(A,largest);
				}
				
				}
			public int Right(int i){
				return 2*i+2;
			}
			public  int Left(int i){
				return 2*i+1;
			}
			public int parent(int i) {
				return (i+1)/2;}
}
