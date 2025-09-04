package org.escinteligente.escritorio_inteligente.Utils;

public final class ValidateEntrys {

    private ValidateEntrys (){}

    public static int validateNumber (String number){
        return validateNumber(number, 0, 0);
    }

    public static int validateNumber (String number, int begin, int end){
        try {
            int numberTransformed = Integer.parseInt(number);
            if (end == 0 | (numberTransformed >= begin && numberTransformed <=end)){
                return numberTransformed;
            }
            throw new RuntimeException("Valor fora das opções!");
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Por favor, digite um número!");
        }
    }
}
