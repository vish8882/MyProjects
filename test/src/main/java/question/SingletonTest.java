package question;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class SingletonTest {
	public static void main(String[] args) throws Exception {
		/*SingletonClass object = SingletonClass.getInstance();
		System.out.println(object.hashCode());
		
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(object);
        out.close();
        
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SingletonClass object2 = (SingletonClass) in.readObject();
        in.close();
        System.out.println(object2.hashCode())*/;
        
        SingletonClass object3=null;
        try{
        Constructor[] cons= SingletonClass.class.getDeclaredConstructors();
       
        	cons[0].setAccessible(true);
        	object3= (SingletonClass) cons[0].newInstance(object3);
        }
        catch(Exception e){
        	e.printStackTrace();
        }
       // System.out.println(object3.hashCode());
	}

}
