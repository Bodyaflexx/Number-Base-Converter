package converter;

public class OctalConverter implements Converter{
    String number;

    public OctalConverter(String number) {
        this.number = number;
    }

    @Override
    public String convert() {
        StringBuilder result = new StringBuilder();
        int num = Integer.parseInt(number);
        while (num > 0){
            result.append(num % 8);
            num /= 8;
        }
        return result.reverse().toString();
    }

    @Override
    public String convertToDecimal() {
        int result = 0;
        int degree = number.length() - 1;
        for(int i = 0;i < number.length();i++){
            result += Integer.parseInt(String.valueOf(number.charAt(i))) * Math.pow(8,degree--);
        }
        return String.valueOf(result);
    }
}
