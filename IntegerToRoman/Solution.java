class Solution {
    public String intToRoman(int num) {

        StringBuilder out = new StringBuilder();

        while(num > 0){
            if(num / 1000 > 0){
                if(num % 1000 == 0){
                    while (num - 1000 >= 0){
                        num = num - 1000;
                        out.append("M");
                    }
                }
                else{
                    num = num-1000;
                    out.append("M");
                }
            }
            else if(num / 500 > 0){
                if(num < 900){
                    out.append("D");
                    num = num%500;
                }
                else{
                    out.append("CM");
                    num = num%900;
                }
            }
            else if(num / 100 > 0){
                if(num >= 400){
                    out.append("CD");
                    num = num - 400;
                }
                else{
                    if(num % 100 == 0){
                        while (num - 100 >= 0){
                            num = num - 100;
                            out.append("C");
                        }
                    }else{
                        out.append("C");
                        num = num-100;
                    }
                }


            }
            else if(num / 50 > 0){
                if(num < 90){
                    out.append("L");
                    num = num%50;
                }
                else{
                    out.append("XC");
                    num = num%90;
                }
            }
            else if(num / 10 > 0){
                if(num < 40){
                    if(num % 10 == 0){
                        while (num - 10 >= 0){
                            num = num - 10;
                            out.append("X");
                        }
                    }else{
                        num = num-10;
                        out.append("X");
                    }
                }
                else{
                    out.append("XL");
                    num = num%40;
                }


            }
            else{
                out.append(digitRoman(num));
                num = num/10;
            }
        }

        return out.toString();
    }

    public String digitRoman(int digit){
        switch(digit){
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            default : return "";
        }
    }
}
