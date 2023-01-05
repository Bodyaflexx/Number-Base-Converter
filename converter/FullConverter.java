package converter;

import java.math.BigInteger;

public class FullConverter implements Converter{
    final String number;
    int targetBase;
    int sourceBase;

    public FullConverter(String number, int targetBase, int sourceBase) {
        this.number = number;
        this.targetBase = targetBase;
        this.sourceBase = sourceBase;
    }

    @Override
    public String convert() {
        return new BigInteger(String.valueOf(convertToDecimal())).toString(targetBase);
    }

    @Override
    public String convertToDecimal() {
        return new BigInteger(String.valueOf(number),sourceBase).toString();
    }
    public String fractionalConverter(){
        String list = "0123456789abcdefghijklmnopqrstuvwxyz";
        String[] numberByParts = number.split("\\.");
        String whole = numberByParts[0];
        String fraction = numberByParts[1];
        String targetWhole = new BigInteger(whole, sourceBase).toString(targetBase);
        var decimalFraction = 0.0;
        var divider = (double) sourceBase;

        for (var digit : fraction.toCharArray()) {
            decimalFraction += list.indexOf(digit) / divider;
            divider *= sourceBase;
        }
        final var targetFraction = new StringBuilder();
        for (int i = 5; i > 0; --i) {
            decimalFraction *= targetBase;
            var index = (int) decimalFraction;
            targetFraction.append(list.charAt(index));
            decimalFraction -= index;
        }

        return targetWhole + "." + targetFraction;
    }
}
