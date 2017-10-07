package Liverpool;


import java.util.Iterator;
import java.util.Scanner;

public class Account implements Comparable<Account>{
    private Client fio;
    private String nomer;
    private Valyuta currency;
    private double proc;
    private double sum;

    enum Valyuta{rubly, dollars, euro, pounds}

    private static int counter = 1;
    public Client getFio() {
        return fio;
    }
    public String getNomer() {
        return nomer;
    }
    public String getCurrency() {
        switch(this.currency){
            case rubly: return "rubly";
            case dollars: return "dollars";
            case euro: return "euro";
            case pounds: return "pounds";
            default:
                return "none";
        }
    }
    public double getProc() {
        return proc;
    }
    public double getSum() {
        return sum;
    }

    private Valyuta Otvorot(String s){
        switch (s){
            case "rubly": return Valyuta.rubly;
            case "dollars": return Valyuta.dollars;
            case "euro": return Valyuta.euro;
            case "pounds": return Valyuta.pounds;
            default: return Valyuta.rubly;
        }
    }


    public void setProc(float proc) {
        this.proc = proc;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }

    public Account(Client fio) {
        this.fio = new Client(fio.getName(),fio.getSurname());
        String s = String.valueOf(fio.getName().charAt(0)) + String.valueOf(fio.getSurname().charAt(0));
        this.nomer = s + String.valueOf(counter);
        counter++;
        this.proc = 0;
        this.sum = 0;
        this.currency = null;
    }

    public Account(Client fio, Valyuta currency, double proc, double sum) {
        this.fio = new Client(fio.getName(),fio.getSurname());

        String s = String.valueOf(fio.getName().charAt(0)) + String.valueOf(fio.getSurname().charAt(0));
        this.nomer = s + String.valueOf(counter);
        counter++;
        this.currency = currency;
        this.proc = proc;
        this.sum = sum;
    }

    public Account(String s){
        String [] d = s.split(";");
        int j = d[0].indexOf(' ');
        String s1 = d[0].substring(0,j);
        String s2 = d[0].substring(j+1,d[0].length());
        this.fio = new Client(s1,s2);
        String s3 = String.valueOf(fio.getName().charAt(0)) + String.valueOf(fio.getSurname().charAt(0));
        this.nomer = s3 + String.valueOf(counter);
        counter++;
        this.sum = Double.parseDouble(d[3]);
        this.proc = Double.parseDouble(d[2]);
        this.currency = Otvorot(d[1]);
    }

    public void Take(int sum) throws MyException{
        if(sum>this.sum)
            throw new MyException("This sum is too big. Insufficient funds on the account");
        this.sum -=sum;
    }
    public void Add(int sum) throws MyException{
        if(sum < 0)
            throw new MyException("Wrong parametr");
        this.sum +=sum;
    }
    public void Accrue_Procents(int days)throws MyException{
        if(days < 0)
            throw new MyException("Wrong parametr");
        double f = this.sum * this.proc;
        f =f / 360 * days;
        this.sum +=f;
    }

    @Override
    public int compareTo(Account o) {
        System.out.println("Please, choose the field: ");
        System.out.println("1 - Surname");
        System.out.println("2 - Nomer");
        System.out.println("3 - Proc");
        System.out.println("4 - Sum");
        Scanner in = new Scanner(System.in);
        switch(in.nextInt()){
            case 1: return this.fio.getSurname().equals(o.fio.getSurname()) ? 1 : -1;
            case 2: String s1 = this.nomer.substring(2,this.nomer.length());
                    String s2 = o.nomer.substring(2, o.nomer.length());
                    return s1.equals(s2) ? 1 : -1;
            case 3: return this.proc > o.proc ? 1 : -1;
            case 4: return this.sum > o.sum ? 1 : -1;
            default: return 4;
        }

    }



    @Override
    public String toString() {
        return "Account: " +
                 fio.getName() + " " + fio.getSurname()+ " " +
                "," + nomer  +
                ", " + currency +
                ", " + proc +
                ", sum: " + sum;
    }

}
