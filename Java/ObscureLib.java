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

}