package text;

import java.util.Arrays;

public class MyArray {
	private int [] m_Ary;
	public MyArray(int arr[]){
		this.m_Ary=arr;
		for(int i=0;i>m_Ary.length;i++){
			m_Ary[i]=arr[i];
		}
	}
	public  void getArrayMaxValue(int[] arr) {
		int max=arr[0];
		for(int ai:arr) 
			if(ai>max) max=ai;			
		//return max;
		System.out.print("\n���ֵΪ��"+max);

	}
	public  void getArrayMinValue(int[] arr) {
		int min=arr[0];
		for(int ai:arr) 
			if(ai<min) min=ai;			
		System.out.print("\n��СֵΪ��"+min+"");
	}

	void print(){
		for(int i=0;i<m_Ary.length;i++)
			System.out.print(m_Ary[i]+"  ");
	    	
	    	//System.out.print("\n���ֵ��"+this.getArrayMaxValue(this.m_Ary));
    }
	public static void main(String[] args) {
			int[]array=new int[]{3,4,5,6};
			MyArray ma=new MyArray(array);
			array[0]=7;
			ma.print();
			ma.getArrayMaxValue(array);
			ma.getArrayMinValue(array);
			Arrays.sort(array);
			ma.print();
				

		}

	
}
