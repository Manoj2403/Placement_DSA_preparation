import java.util.HashMap;

public class RomToInt_13 {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] ch = s.toCharArray();
        int prevVal = 0;
        int sum = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            if (map.get(ch[i]) >= prevVal) {
                prevVal = map.get(ch[i]);
                sum += map.get(ch[i]);
            } else
            {
                prevVal = map.get(ch[i]);
                sum -= map.get(ch[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        RomToInt_13 r = new RomToInt_13();
        int result = r.romanToInt(s);
        System.out.println(result);
    }
}
