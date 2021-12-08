import java.util.*;
class VehicleStateException extends Exception
{
    public VehicleStateException(String sr)
    {
        System.out.println(sr);
    }
}

public class IndianVehicleNumber
{
    public static void main(String args[])
    {
        String vhno;
        String st;
        int flag=0;
        int s=0;
        int dg=0;
        char c;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Vehicle Number:");
        vhno=sc.next();
        int l=vhno.length();
        System.out.println("Enter the state:");
        st=sc.next();
        String str=st.substring(0,2);
        try
        {
            for(int i=0;i<2;i++)
            {
                c=vhno.charAt(i);
                if(!vhno.substring(0,2).equals(str))
                {
                    //System.out.println("abd");
                    throw new VehicleStateException("Invalid Vehicle Number");
                }
            }
            for(int i=2;i<4;i++)
            {
                c=vhno.charAt(i);
                if(Character.isDigit(c))
                {
                    //System.out.println("flag: "+ flag);
                    flag++;
                    System.out.println("flag: "+ flag);

                }
            }
            if(flag!=2)
            {
                //System.out.println("flag != 2");
                throw new VehicleStateException("Invalid Vehicle Number");
            }
            for(int i=4;i<6;i++)
            {
                c=vhno.charAt(i);
                if(Character.isLetter(c))
                {
                    s++;
                    System.out.println("s: "+ s);

                }
            }
            if(s!=1 && s!=2)
            {
//                System.out.println("s != 1 || s != 2");
                throw new VehicleStateException("Invalid Vehicle Number");
            }
            for(int i=6;i<l;i++)
            {
                c=vhno.charAt(i);
                if(Character.isDigit(c))
                {
                    dg++;
                }
            }
            if(dg!=4)
            {
                throw new VehicleStateException("Invalid Vehicle Number");
            }
        }
        catch(VehicleStateException a)
        {
            System.out.println(a);
        }

    }
}