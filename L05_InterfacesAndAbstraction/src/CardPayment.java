public class CardPayment implements Payable{

    @Override
    public void pay() {
        System.out.println("Card payment!");
    }

    @Override
    public void getTotal() {

    }
}
