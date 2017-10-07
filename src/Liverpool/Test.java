package Liverpool;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Arrays;

import static Liverpool.Account.Valyuta.dollars;
import static Liverpool.Account.Valyuta.euro;
import static Liverpool.Account.Valyuta.rubly;
import static Liverpool.Account.Valyuta.pounds;

public class Test {

    public static void main(String[] args) throws IOException, MyException {
        try {


            FileWriter out = new FileWriter(new File("D:\\Проекты по проге\\3-й семестр\\Прога\\Лаба№5_13\\output.txt"));
            //FileReader in = new FileReader(new File("D:\\Проекты по проге\\3-й семестр\\Прога\\Лаба№5_13\\input.txt"));
            FileInputStream in = new FileInputStream(new File("D:\\Проекты по проге\\3-й семестр\\Прога\\Лаба№5_13\\input.txt"));
            InputStreamReader f1 = new InputStreamReader(in);
            BufferedReader buf = new BufferedReader(f1);
            Client Alina = new Client("Alina","Karpovich");
            Client Diana = new Client("Diana", "Kulich");
            Account user_1 = new Account(Alina,dollars,0.1,100.0);
            Account user_2 = new Account(Diana,euro,0.15,120.0);
           // System.out.println(user_1.toString());
           //System.out.println(user_2.toString());
//            user_1.Take(30);
//            System.out.println(user_1.toString());
//            user_1.Add(370);
//            System.out.println(user_1.toString());
            //user_1.Accrue_Procents(40);
            //System.out.println(user_1.toString());
            String s = buf.readLine();
            Account user_3 = new Account(s);
            //System.out.println(user_3.toString());

            System.out.println(user_1.compareTo(user_3));

            Account [] acc = new Account[3];

            acc[0] = user_3;
            acc[1] = user_1;
            acc[2] = user_2;
            for (int i = 0; i < acc.length; i++) {
                System.out.println(acc[i].toString());
            }
            Arrays.sort(acc);

            for (int i = 0; i < acc.length; i++) {
                System.out.println(acc[i].toString());
            }


            //out.write(user_1.toString() + "\n");
            //out.write(user_2.toString());
            out.flush();


        }
        catch (IOException e){
            e.getMessage();
        }



    }
}
