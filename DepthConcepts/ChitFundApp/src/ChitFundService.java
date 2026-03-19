public class ChitFundService {
    public Result<Double> getDiscountAmount(double chitAmount,double bidAmount){
        if(bidAmount>chitAmount){
            return new Result<Double>(false,null,"Bid Amount is Higher than Chit Amount");
        }
        return new Result<Double>(true,(chitAmount-bidAmount));
    }

    public int getPersonIdx(String person){
        int i=1;
        int n = person.length();
        int idx = 0;
        while(i<n){
            char c = person.charAt(i);
            if(!Character.isDigit(c)){
                return -1;
            }
            idx = idx*10+(c-'0');
            i++;
        }
        return idx;
    }
    public Result<Double> getAmountOfPerson(double[] personDepositArr,String person){
        int idx = getPersonIdx(person);
        if(idx<0)
            return new Result<Double>(false,null,"Given person is not correct");
        double personAmount = personDepositArr[idx-1];
        return new Result<>(true,personAmount);
    }

    public void accumulateAmount(double amount,double[] personDepositArr){
        for(int i=0;i<personDepositArr.length;i++){
            personDepositArr[i]+=amount;
        }
    }

    public boolean adddAmountToPerson(double[] personBuyArr,String person,double amount){
        int idx = getPersonIdx(person);
        if(personBuyArr[idx]!=Double.MIN_VALUE)
            return false;
        personBuyArr[idx] = amount;
        return true;
    }

}
