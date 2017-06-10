import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class arthmatic_coding {
	static double u=1;
	static double l=0;
	static double range=1;
	static double code;
	static double length=0;
	public static void main(String []args) throws IOException
    {
		while(true)
   	 {
   	 int x;
   	 System.out.println("1-Compressiom");
   	 System.out.println("2-Decompression");
   	 Scanner a=new Scanner(System.in);
   	 x=a.nextInt();
   	 if(x==1)
   	 {
   	  compression();	
   	 }
   	 else if(x==2)
   	 {
   		decompression();
   	 }
   	 else
   	 {
   		 System.out.println("erro!! re-enter your choice!! ");
   	 }
   	 }
	
    }
	public static void compression() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("file.txt"));
		 String everything;
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		       
		        line = br.readLine();
		    }
		    everything = sb.toString();
		} finally {
		    br.close();
		}
		ArrayList<harf>myhrouf=new ArrayList<harf>();
		 for (int i=0;i<everything.length();i++)
	 	 	{
	 	 		boolean b =false;
	           for(int j=0;j<myhrouf.size();j++)
	           {
	         	  if(myhrouf.get(j).getname().equals(""+everything.charAt(i)))
	         	  {
	         		  double probablty=myhrouf.get(j).getpro()+((double)1/everything.length());
	         		  myhrouf.get(j).setpro(probablty);
	         		  b=true;
	         	  }
	           }
	 	 		if(b==false)
	 	 		{
	 	 			
	 	 			harf h=new harf((double)1/everything.length(),""+everything.charAt(i));
	 	 			myhrouf.add(h);
	 	 		}
	 	 	}
		//System.out.println(myhrouf); 
		myhrouf.get(0).setlower(0);
		myhrouf.get(0).setupper(myhrouf.get(0).getpro());
		for(int i=1;i<myhrouf.size();i++){
			myhrouf.get(i).setlower(myhrouf.get(i-1).getupper());
			myhrouf.get(i).setupper(myhrouf.get(i).getpro()+myhrouf.get(i).getlower());
			
		}
		//System.out.println(myhrouf);
	for(int j=0;j<everything.length();j++){
		for(int i=0;i<myhrouf.size();i++)
		   {
			   if(everything.charAt(j) == myhrouf.get(i).getname().charAt(0))
			   {
				   u= l + range * myhrouf.get(i).getupper();
				   l = l + range * myhrouf.get(i).getlower();
				   range = u-l;
				   
			   }
		   }
	}
	code=(u+l)/2;
	System.out.println(code);
	FileWriter fileWriter =new FileWriter("hrouf.txt");
	BufferedWriter bw=new BufferedWriter(fileWriter);
	
	for(int i=0;i<myhrouf.size();i++)
	{ 
	bw.write(myhrouf.get(i).getname());
		bw.flush();
		bw.write(",");
		bw.flush();
		bw.write(myhrouf.get(i).getpro()+"");
		bw.flush();
		bw.write(",");
		bw.flush();
		bw.write(myhrouf.get(i).getlower()+"");
		bw.flush();
		bw.write(",");
		bw.flush();
		bw.write(myhrouf.get(i).getupper()+"");
		bw.flush();
		bw.append(System.lineSeparator());
	
		}
	bw.write("|");
	bw.flush();
	
	FileWriter fileW =new FileWriter("compresscode.txt");
	BufferedWriter w=new BufferedWriter(fileW);
	w.write(code+"");
	w.flush();
	w.close();
	String filename= "compresscode.txt";
    FileWriter W = new FileWriter(filename,true);
	W.write(",");
	W.flush();
	W.write(everything.length()+"");
	W.flush();
	W.close();
	}
	
	public static void decompression() throws IOException {
		ArrayList<harf>myhrouf2=new ArrayList<harf>();
		




FileInputStream f= new FileInputStream("hrouf.txt");
BufferedReader br = new BufferedReader(new InputStreamReader(f));
String strline;
StringBuffer sb = new StringBuffer();
String esm , p , lo , up;
int k=0;
while ((strline = br.readLine()) != null)
{
    String[] arraylist=strline.split(",");
    if(arraylist.length == 4){
    	
    	esm=arraylist[0];
    	p=arraylist[1];
    	lo=arraylist[2];
    	up=arraylist[3];
    	/*System.out.println(esm);
    	System.out.println(p);
    	System.out.println(lo);
    	System.out.println(up);*/
    	double LOW=Double.parseDouble(lo);
    	//System.out.println(LOW);
    	double UP=Double.parseDouble(up);
    	//System.out.println(UP);
    	double P=Double.parseDouble(p);
    	//System.out.println(P);
    	harf h = new harf();
    	h.setlower(LOW);
    	h.setupper(UP);
        h.setname(esm);
    	h.setpro(P);
    	myhrouf2.add(h);
    	
    }

}
f.close();
//System.out.println(myhrouf2);


BufferedReader brr = new BufferedReader(new FileReader("compresscode.txt"));
String e;
try {
   StringBuilder sbb= new StringBuilder();
   String l = brr.readLine();

   while (l != null) {
       sbb.append(l);
      
       l = brr.readLine();
   }
   e = sbb.toString();
} finally {
   brr.close();
}
String codee , lenth;
String[] arraylist=e.split(",");

code=Double.parseDouble(arraylist[0]);
//System.out.println(code);
length=Double.parseDouble(arraylist[1]);
//System.out.println(length);



f.close();


String decomp=new String();
u=1;
l=0;
range=u-l;
for(int i=0;i<length;i++){
	for(int j=0 ; j<myhrouf2.size();j++){
		if(myhrouf2.get(j).getlower()<code&&code<myhrouf2.get(j).getupper()){
			decomp=decomp+myhrouf2.get(j).getname();
			  l=l+(u-l)*myhrouf2.get(j).getlower();
			 u=l+(u-l)*myhrouf2.get(j).getupper();
			 
			/*System.out.println(code);
			 System.out.println(u);
			 System.out.println(l);*/
			 code=(code-myhrouf2.get(j).getlower())/(myhrouf2.get(j).getupper()-myhrouf2.get(j).getlower());
			break;
		}
	}
	
}
System.out.println(decomp);
}
}