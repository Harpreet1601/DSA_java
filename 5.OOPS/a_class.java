public class a_class{
    public static void main(String[] args) {
        //Created a pen object called p1
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getColor());

        p1.setTip(5);
        System.out.println(p1.tip);

        // BankAccount myAcc = new BankAccount();
        // myAcc.username = "Harpreet";
        // myAcc.setPassword("abchdhfh");
    }
}

//Access Specifiers
// class BankAccount{
//     public String username;
//     private String password;

//     //Acsess priavte password inside the class
//     public void setPassword(String pwd) {
//         password = pwd;
//     }
// }

class Pen{
    //Property
    private String color;
    int tip;

    //GET
    String getColor(){
        return this.color;
    }

    //Declare function and setters
    void setColor(String newColor){
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }
}