package algorithmica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
class Vertex
{
	int id;
	LinkedList<Integer> nodeEdge;
}
class graphDS
{
	public int len=200;
	Hashtable<Integer, Vertex> nodeHash=new Hashtable<Integer, Vertex>();
	public void addVertex(int id)
	{
		Vertex v=new Vertex();
		v.id=id;
		v.nodeEdge=new LinkedList<Integer>();
		nodeHash.put(id, v);
	}
	public void addAdjVertex(int start,int end)
	{
		nodeHash.get(start).nodeEdge.addLast(end);
	}
	public int getAdjVertex(int node,int index)
	{
		return nodeHash.get(node).nodeEdge.get(index);
	}
	public void ContractVertex(int nodeA,int nodeB)
	{
		deleteEdge(nodeA,nodeB);
		findEnd(nodeA,nodeB);
		addList(nodeA,nodeB);
		nodeHash.remove(nodeB);
	}
	private void addList(int nodeA, int nodeB) {
		// TODO Auto-generated method stub
		while(!nodeHash.get(nodeB).nodeEdge.isEmpty())
		{
			nodeHash.get(nodeA).nodeEdge.addLast(nodeHash.get(nodeB).nodeEdge.pop());
		}


	}
	private void findEnd(int nodeA, int nodeB) {
		// TODO Auto-generated method stub
		boolean record[]=new boolean[len];
		for(int index=0;index<nodeHash.get(nodeB).nodeEdge.size();index++)
		{
			int change=nodeHash.get(nodeB).nodeEdge.get(index);
			if(record[change-1]==false)
			{
				changeToEnd(nodeA,nodeB,change);
				record[change-1]=true;
			}
		}

	}
	private void changeToEnd(int nodeA, int nodeB, int change) {
		// TODO Auto-generated method stub
		for(int index=0;index<nodeHash.get(change).nodeEdge.size();index++)
		{
			if(nodeHash.get(change).nodeEdge.get(index) == nodeB)
				nodeHash.get(change).nodeEdge.set(index, nodeA);
		}


	}
	private void deleteEdge(int nodeA, int nodeB) {
		// TODO Auto-generated method stub
		while(nodeHash.get(nodeA).nodeEdge.contains(nodeB))
		{
			int index=nodeHash.get(nodeA).nodeEdge.indexOf(nodeB);
			nodeHash.get(nodeA).nodeEdge.remove(index);
		}
		while(nodeHash.get(nodeB).nodeEdge.contains(nodeA))
		{
			int index=nodeHash.get(nodeB).nodeEdge.indexOf(nodeA);
			nodeHash.get(nodeB).nodeEdge.remove(index);
		}

	}
	public int computerEdge(int nodeA)
	{
		int n=nodeHash.get(nodeA).nodeEdge.size();
		return n;
	}
	public void print(int nodeA)
	{
		if(nodeHash.get(nodeA).nodeEdge.isEmpty())
		{
			System.out.print("["+nodeA+"] :");
			for(int index=0;index<nodeHash.get(nodeA).nodeEdge.size();index++)
			{
				System.out.print(nodeHash.get(nodeA).nodeEdge.get(index)+"-");
			}
			System.out.println();
		}
	}

}
public class ContractionAlgorithm {
	graphDS gds=new graphDS();
	private int vertexLen=gds.len;
	private int nodeA,nodeB;
	private int cutNum;//cut
	private int min=vertexLen-1;//mincut
	private ArrayList<Integer> arraySet=new ArrayList<Integer>();
	public ContractionAlgorithm()
	{
		for(int count=0;count<50;count++)
		{
			input();
			contract();
		}
		System.out.println(min);
	}
	private void contract() {
		// TODO Auto-generated method stub
		while(arraySet.size()>2)
		{
			randEdge();
			gds.ContractVertex(nodeA, nodeB);
			tempNum(nodeA);
		}
		if(arraySet.size()==2)
		{
			if(cutNum<min) 
			{
				min=cutNum;
			}
			System.out.println(nodeA+" "+nodeB+" "+min);
		}
		else
		{
			System.out.println(nodeA+" "+nodeB);
		}
		
		
	}
	private void tempNum(int nodeA2) {
		// TODO Auto-generated method stub
		int num=gds.computerEdge(nodeA2);
		if(num<cutNum)
		{
			cutNum=num;
		}
		
		
	}
	private void input() {
		// TODO Auto-generated method stub
		cutNum=vertexLen-1;
		gds=new graphDS();
		arraySet=new ArrayList<Integer>();
		try
		{
			String file="C:\\Users\\rohith\\algoritmica\\algorithmica\\src\\testcases\\kargerMinCut.txt";
			FileReader in=new FileReader(file);
			BufferedReader br=new BufferedReader(in);
			String s;
			int x;
			while((s=br.readLine())!=null)
			{
				Scanner sca=new Scanner(s);
				x=sca.nextInt();
				gds.addVertex(x);
				while(sca.hasNext())
				{
					int y=sca.nextInt();
					gds.addAdjVertex(x, y);
				}
				
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		initSet();
		
		
		
	}
	private void initSet() {
		// TODO Auto-generated method stub
		for(int i=0;i<vertexLen;i++)
		{
			arraySet.add(i,i+1);
		}
		
	}
	public void randEdge()
	{
		int indexOfnodeA,indexOfnodeB;
		Random rand=new Random();
		indexOfnodeA=rand.nextInt(arraySet.size());
		nodeA=arraySet.get(indexOfnodeA);
		int randomSeed=gds.nodeHash.get(nodeA).nodeEdge.size();
		indexOfnodeB=rand.nextInt(randomSeed);
		nodeB=gds.getAdjVertex(nodeA, indexOfnodeB);
		arraySet.remove(arraySet.indexOf(nodeB));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContractionAlgorithm ca=new ContractionAlgorithm();


	}

}
