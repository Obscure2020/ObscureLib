import java.util.ArrayList;

public final class ObscureLib {

    private static void obscureAssert(boolean check, String message){
        if(!check){
            throw new AssertionError(message);
        }
    }

    public static String leftPad(String body, char pad, int length){
        if(body.length() >= length) return body;
        StringBuilder sb = new StringBuilder(body);
        while(sb.length() < length) sb.insert(0, pad);
        return sb.toString();
    }

    public static String rightPad(String body, char pad, int length){
        if(body.length() >= length) return body;
        StringBuilder sb = new StringBuilder(body);
        while(sb.length() < length) sb.append(pad);
        return sb.toString();
    }

    public static String sliceAfter(String full, String match){
        int spot = full.indexOf(match);
        obscureAssert(spot>=0, "Slice match target not found in full string.");
        return full.substring(spot + match.length());
    }

    public static String sliceAfterKeep(String full, String match){
        int spot = full.indexOf(match);
        obscureAssert(spot>=0, "Slice match target not found in full string.");
        return full.substring(spot);
    }

    public static String sliceBefore(String full, String match){
        int spot = full.indexOf(match);
        obscureAssert(spot>=0, "Slice match target not found in full string.");
        return full.substring(0, spot);
    }

    public static String sliceBeforeKeep(String full, String match){
        int spot = full.indexOf(match);
        obscureAssert(spot>=0, "Slice match target not found in full string.");
        return full.substring(0, spot + match.length());
    }

    public static String longToEnglish(long number){
        if(number < 0){
            if(number == Long.MIN_VALUE){
                return "negative nine quintillion, two hundred and twenty-three quadrillion, three hundred and seventy-two trillion, thirty-six billion, eight hundred and fifty-four million, seven hundred and seventy-five thousand, eight hundred and eight";
            }
            return "negative " + longToEnglish(-number);
        }
        if(number < 20){
            switch((int) number){
                case 0: return "zero";
                case 1: return "one";
                case 2: return "two";
                case 3: return "three";
                case 4: return "four";
                case 5: return "five";
                case 6: return "six";
                case 7: return "seven";
                case 8: return "eight";
                case 9: return "nine";
                case 10: return "ten";
                case 11: return "eleven";
                case 12: return "twelve";
                case 13: return "thirteen";
                case 14: return "fourteen";
                case 15: return "fifteen";
                case 16: return "sixteen";
                case 17: return "seventeen";
                case 18: return "eighteen";
                case 19: return "nineteen";
                default: throw new AssertionError("This should not be possible.\nFailiure in the \"under 20\" switch statement.");
            }
        }
        if(number < 100){
            int tens = (int) ((number / 10) % 10);
            int ones = (int) (number % 10);
            String prefix = switch(tens){
                case 2: yield "twenty";
                case 3: yield "thirty";
                case 4: yield "forty";
                case 5: yield "fifty";
                case 6: yield "sixty";
                case 7: yield "seventy";
                case 8: yield "eighty";
                case 9: yield "ninety";
                default: throw new AssertionError("This should not be possible.\nFailiure in the \"under 100\" switch statement.");
            };
            if(ones == 0){
                return prefix;
            }
            return prefix + "-" + longToEnglish(ones);
        }
        if(number < 1000){
            int hundreds = (int) ((number / 100) % 10);
            int less = (int) (number % 100);
            String base = longToEnglish(hundreds) + " hundred";
            if(less == 0){
                return base;
            }
            return base + " and " + longToEnglish(less);
        }
        //We now know the number is at least 1000.
        ArrayList<String> chunks = new ArrayList<>();
        String[] suffixes = {"", " thousand", " million", " billion", " trillion", " quadrillion", " quintillion"};
        int stage = 0;
        long residual = number;
        while(residual > 0){
            long chunk = residual % 1000;
            if(chunk > 0){
                chunks.add(longToEnglish(chunk) + suffixes[stage]);
            }
            stage++;
            residual /= 1000;
        }
        StringBuilder sb = new StringBuilder();
        while(chunks.size() > 1){
            sb.append(chunks.removeLast());
            sb.append(", ");
        }
        sb.append(chunks.removeLast());
        return sb.toString();
    }

}