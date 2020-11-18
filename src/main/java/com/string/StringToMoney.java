package com.string;

/**
 * TODO
 *
 * @author ahao 2020-11-09
 */
public class StringToMoney {
    public static void main(String[] args) {
        String str = "13260";
        String[] unit = {"万","千","百","十","元"};
        String[] numsByWord={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                result.append(numsByWord[Integer.parseInt(String.valueOf(str.charAt(i)))]+unit[i]);
            }else {
                result.append(numsByWord[0]);
                while (str.charAt(i)=='0'){
                    i++;
                    if (i == str.length()-1) {
                        i--;
                        break;
                    }
                }
            }
        }
        System.out.println(result.toString());
    }
}
