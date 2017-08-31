//It is FIFO
public class queue {
	private int [] object;//Stores Array
	private int f,o,l=-1,hold;//f for first element,o for last one, l controls when array increase,hold is no. of element in arrays
	
	public queue(){
		hold=1-l;
		object=new int[hold];
		f=0;o=0;
		}
	public void push(int num){
		if(l>0) resize();
		object[f++]=num;l++;
	}
	
	public void resize(){
		hold+=2;
		int[] temp=object;
		object = new int [hold];
		for(int i=0;i<hold-2;i++) object[i]=temp[i];
		l=-1;
	}
	public Integer pop(){
		  if(o>=f) return null;
		  return object[o++];
	}
}
