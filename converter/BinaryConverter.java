package converter;

public class BinaryConverter implements Converter {
    String number;

    public BinaryConverter(String number) {
        this.number = number;
    }

    @Override
    public String convert() {
        int num = Integer.parseInt(number);
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            result.append(num % 2);
            num /= 2;
        }
        return result.reverse().toString();
    }

    @Override
    public String convertToDecimal() {
        int result = 0;
        int degree = number.length() - 1;
        for(int i = 0;i < number.length();i++){
            result += Integer.parseInt(String.valueOf(number.charAt(i))) * Math.pow(2,degree--);
        }
        return String.valueOf(result);
    }
}
