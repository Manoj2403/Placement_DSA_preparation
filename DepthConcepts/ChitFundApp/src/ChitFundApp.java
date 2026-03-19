import java.util.*;
public class ChitFundApp {
    public static void main(String[] args) {
        ChitFundService chitFundService = new ChitFundService();
        double[] personDepositArr = new double[10];
        double[] personBuyArr = new double[10];
        Arrays.fill(personBuyArr,Double.MIN_VALUE);
//        personDepositArr[2] = 90000;
        System.out.println(chitFundService.getDiscountAmount(100000,20000).getObj());
        System.out.println(chitFundService.getAmountOfPerson(personDepositArr,"P3").getObj());
    }
}