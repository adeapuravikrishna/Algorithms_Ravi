import java.util.HashSet;
import java.util.Scanner;

public class LinkedList<T> implements list<T> {


	/**
	 * @param args
	 */
	private final listnode<T> header;
	public listnode<T> lastnode;
	private int size;
	
	//inner class
	@SuppressWarnings("hiding")
	private class listnode<T>
	{
		public T element;
		public listnode<T> next;
		public listnode() {
			// TODO Auto-generated constructor stub
			this.element=null;
			this.next=null;
		}

	}
	
	
	public LinkedList()
	{
		size=0;
		header=new listnode<T>();
		lastnode=header;
	}
	
	
	public boolean add(T element)
	{
		listnode<T> temp=new listnode<T>();
		temp.element=element;
		lastnode.next=temp;
		lastnode=temp;
		size++;

		return true;

	}
	
	public void display()
	{
		listnode<T> current=header.next;
		while(current!=null)
		{
			System.out.println(current.element+" ");
			current=current.next;
		}
		//System.out.print("\n");
	}
	
	public listnode<T> findmiddle()
	{
		listnode<T> slow=header,fast=header;

		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public boolean contains(T element)
	{
		listnode<T> current=header.next;
		while(current!=null)
		{
			if(element.equals(current.element))
				return true;
			current=current.next;
		}
		return false;
	}
	
	public void reverse()
	{
		listnode<T> current=header.next,prev=null,temp;
		temp=current;
		while(current!=null)
		{
			temp=current.next;
			current.next=prev;
			prev=current;
			current=temp;
		}
		header.next=prev;
	}
	public void createloop()
	{
		listnode<T> temp=header;
		for(int i=0;i<3;i++)
			temp=temp.next;
		lastnode.next=temp;
		
	}

	public T getelement(listnode<T> l)
	{
		return l.element;
	}
	public boolean checkloop()
	{
		listnode<T> slow=header;
		listnode<T> fast=header;
		do
		{
			if(fast==null||fast.next==null)
				return false;
			slow=slow.next;
			fast=fast.next.next;;
			
		}while(slow!=fast);
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l=new LinkedList<Integer>();
		LinkedList<Character> c=new LinkedList<Character>();
		//Scanner in=new Scanner(System.in);
		//int n=in.nextInt();
		//for(int i=0;i<n;i++)
		//	l.add(in.nextInt());
		//l.display();
		//System.out.println(l.getelement(l.findmiddle()));
		
		//System.out.println("Enter Element to search");
		//int input=in.nextInt();
		//System.out.println(l.contains(input));
		//l.reverse();
		//l.display();

		l.add(45);
		l.add(56);
		l.add(77);
		l.add(67);
		l.add(88);
		l.add(55);
		l.add(54);
		l.createloop();
		System.out.println(l.checkloop());
		c.add('c');
		c.add('k');
		c.add('l');
		//System.out.println(c.checkloop());
		//l.display();
		//l.removeloopfindingcycle();
		//System.out.println(l.checkloop());
		//l.display();
		l.removeloop();
		System.out.println(l.checkloop());
		l.display();
		
		//l.display();
		
	}

	

	private void removeloopfindingcycle() {
		// TODO Auto-generated method stub
		listnode<T> slow,fast,temp;;
		int count=0;
		slow=header;
		fast=header;
		temp=header;
		do
		{
			slow=slow.next;
			fast=fast.next.next;
		}while(slow!=fast);
		do
		{
			fast=fast.next;
			count++;
			
		}while(fast!=slow);
		
		System.out.println(count);
		//while(temp!=slow)
		
	}


	public void removeloop() {
		// TODO Auto-generated method stub
		listnode<T> slow,fast,prev;
		slow=header;
		fast=header;
		do
		{
			slow=slow.next;
			fast=fast.next.next;
		}while(slow!=fast);
		fast=header;
		prev=slow;
		while(slow!=fast)
		{
			prev=slow;
			slow=slow.next;
			fast=fast.next;
		}
		prev.next=null;
		
	}
	
	


}
