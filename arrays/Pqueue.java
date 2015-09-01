import java.util.ArrayList;
import java.util.Comparator;


public class Pqueue<T extends Comparable<T>> {

	/**
	 * @param args
	 */
	private ArrayList<T> list;
	public Pqueue(int size)
	{
		list=new ArrayList<T>(size);
	}
	public void add(T element)
	{
		list.add(element);
		int current=list.size()-1;
		while(current>0)
		{
			int ret=list.get(current).compareTo(list.get((current-1)/2));
			if(ret>0)
			{
				swap(list, current,(current-1)/2);
				current=(current-1)/2;
			}
			else
				break;

		}


	}
	
	private void deleteMax()
	{
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		int current=0;
		int size=list.size()-1;
		if(size==1)
		{
			int ret=list.get(0).compareTo(list.get(1));
			if(ret<0)
				swap(list,0,1);
		}
		while(current<size/2)
		{
			int ret1=list.get(current).compareTo(list.get((2*current)+1));
			int ret2=list.get(current).compareTo(list.get((2*current)+2));
			int ret3=list.get((2*current)+1).compareTo(list.get((2*current)+2));
			int index;
			if(ret3>0)
				index=(2*current)+1;
			else
				index=(2*current)+2;
			if(ret1>0&&ret2>0)
			{
				break;
			}
			else
			{
				swap(list,current,index);
				current=index;
			}
				
			
		}
	}

	private void swap(ArrayList<T> arr,int i,int j)
	{
		T temp=arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j,temp);

	}
	private void display()
	{
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+" ");
	}
	private T findMax()
	{
		if(list.isEmpty()) return null;
		else
			return list.get(0);
			
	}
	public void sort()
	{
		int size=list.size();
		for(int i=0;i<size;i++)
		{
			System.out.print(this.findMax()+" ");
			this.deleteMax();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pqueue<Integer> p=new Pqueue(8);
		p.add(13);
		p.add(4);
		p.add(1);
		p.add(12);
		p.add(6);
		p.add(9);
		p.add(10);
		p.add(14);
		p.display();
		System.out.println();
		p.sort();
		


	}




}
