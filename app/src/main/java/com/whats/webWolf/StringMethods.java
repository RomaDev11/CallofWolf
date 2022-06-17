package com.whats.webWolf;

public class StringMethods {
    public static String subSubstringWolf(String[] stringsWolf){
        StringBuilder resulWolf = new StringBuilder("");
        String[] mapWolf = new String[10];
        for (int i = 0; i < stringsWolf.length; i++) {
            mapWolf[i] = "&uwd" + (i + 1) + "=";
            resulWolf.append(codWolf(mapWolf[i], 2)).append(stringsWolf[i]);
        }
        return String.valueOf(resulWolf);
    }
    public static String codWolf(String aasdWolf, int Wolf) {
        int x = Integer.parseInt("-" + Wolf);
        String string = "";
        for (int i = 0; i < aasdWolf.length(); i++) {
            char c = aasdWolf.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += x % 26;
                if (c < 'a')
                    c += 26;
                if (c > 'z')
                    c -= 26;
            } else if (c >= 'A' && c <= 'Z') {
                c += x % 26;
                if (c < 'A')
                    c += 26;
                if (c > 'Z')
                    c -= 26;
            }
            string += c;
        }
        return string;
    }
}
