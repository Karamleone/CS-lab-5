import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.cmu.ri.createlab.terk.robot.finch.Finch; 


public class CS1702_lab5 {
public static void main(String[] args) throws Exception
{
	maintask();
	Finch(); 
}
static public void maintask()
{

	ArrayList<Data> array_list = new ArrayList<Data>();
	
	array_list.add(new Data("fred", 21));
	array_list.add(new Data("jo", 43));
	array_list.add(new Data("zoe", 37));
	array_list.add(2, new Data("harry", 78));
	
	
	for(int i=0;i<array_list.size();++i)
	{
		array_list.get(i).Print();
	}
	
	
	System.out.println();
	System.out.println("5.4 - Casting");
	
	int x = 10;
	double y = x;
	System.out.println(y);
	
	double x1 = 10.3;
	int y1 = (int)x1;
	System.out.println(y1);

	Byte by = new Byte((byte)255);
	System.out.println(by);
	
	Long v1 = 10L; //when removed L = (Type mismatch: cannot convert from int to Long)
	Float v2 = 10.3F; //when removed F = (Type mismatch: cannot convert from double to Float) 

	Long v11 = (long) 10; 
	Float v21 = (float) 10.3;

	System.out.println("5.5 - ArrayList implementation considerations ");
	
	ArrayList<Data> ArrayA = new ArrayList<Data>();
	ArrayA.add(new Data("fred", 21));
	ArrayA.add(new Data("jo", 43));
	ArrayA.add(new Data("zoe", 37));
	
	ArrayList<Data> ArrayB = new ArrayList<Data>();
	
	PrintDataArray(ArrayA);
	System.out.println();
	ArrayB = ArrayA;
	PrintDataArray(ArrayB);
	System.out.println();
	ArrayA.remove(1);
	PrintDataArray(ArrayB);

	ArrayList<Data> ArrayC = new ArrayList<Data>();
	ArrayC.add(new Data("fred", 21));
	ArrayC.add(new Data("jo", 43));
	ArrayC.add(new Data("zoe", 37));
	
	ArrayList<Data> ArrayD = new ArrayList<Data>();	
	System.out.println();
	System.out.println("C and D");
	
	PrintDataArray(ArrayC);
	System.out.println();
	ArrayD = (ArrayList<Data>)ArrayC.clone();
	ArrayC.remove(1); //placement of remove A (row 2) changes which jo is removed
	PrintDataArray(ArrayC);
	System.out.println();	
	PrintDataArray(ArrayD);
	System.out.println();

	
}

private static void PrintDataArray(ArrayList<Data> data) {
    for(int i=0;i<data.size();++i){
        data.get(i).Print();
    }
}
static public void Finch() throws Exception
{
	
	int Speed[][] = 
	{	
		{25,25,5000},
		{50,50,5000},
		{75,75,5000},
		{100,100,5000},
		{125,125,5000},
		{150,150,5000},
		{175,175,5000},
		{200,200,5000},
		{225,225,5000},
		{250,250,5000},
		
	};
	
	Finch Swiftness = new Finch();
	
	for(int i=0; i < 10 ; ++i)
	{
		Swiftness.setWheelVelocities(Speed[i][0],Speed[i][1]); //setting the wheel veloicity using the array
		long Pre = System.currentTimeMillis();  //measures the time in ms
		while (System.currentTimeMillis() - Pre < Speed[i][2])
		{
			JOptionPane.showMessageDialog(null,"Click OK to continue to the next speed setting");
		}
	}
	Swiftness.stopWheels();
	Swiftness.quit();

}


}