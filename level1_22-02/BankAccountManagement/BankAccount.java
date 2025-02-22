public class BankAccount{
private long amount=0;
public void deposit{int a}{
amount+=a;
}
public void withdraw(int a){
if(a>amount){
System.out.println("Not enough balance");
return;
}
amount-=a;
}
public long getBalance(){
return amount;
}
}
