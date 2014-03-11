import java.io.*;

class FileDiGuiListFiles 
{
	public static void main(String[] args) 
	{
		File dir = new File("d:\\myDiary");
		showDir(dir);

		//toBin(6);
		//int n = getSum(8000);
		//System.out.println("n="+n);

		//System.out.println(dir.delete());
	}
	public static String getLevel(int level)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("|--");
		for(int x=0; x<level; x++)
		{
			//sb.append("|--");
			sb.insert(0,"|  ");

		}
		return sb.toString();
	}
	public static void showDir(File dir)
	{
		
		//System.out.println(getLevel(level)+dir.getName());
		System.out.println(dir);

		//level++;
		File[] files = dir.listFiles();
		for(int x=0; x<files.length; x++)
		{
			if(files[x].isDirectory())
				showDir(files[x]);
			else
				//System.out.println(getLevel(level)+files[x]);
				System.out.println(files[x]);
		}
	}
}
