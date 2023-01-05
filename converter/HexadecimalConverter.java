package converter;

public class HexadecimalConverter implements Converter{
    String number;

    public HexadecimalConverter(String number) {
        this.number = number;
    }

    @Override
    public String convert() {
        return Integer.toHexString(Integer.parseInt(number));
    }

    @Override
    public String convertToDecimal() {
        return String.valueOf(Integer.parseInt(number,16));
    }
}
