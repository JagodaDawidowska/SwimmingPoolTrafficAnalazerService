package com.example.swimmingpoolservice.utils;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class CollectDataUtil {

    private final static String url = "https://www.mosir.zgora.pl";

    public List<String> displayFileteredInformation() throws IOException {

        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {

            stringBuilder.append(inputLine);
            stringBuilder.append(System.lineSeparator());
        }

        String content = stringBuilder.toString();
        in.close();

        List<String> list = findInformation(content);
        List<String> cleanStringList = chceckIfContainsNumber(list);
        return cleanStringList;
    }

    public static List<String> findInformation(String content) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < content.length(); i++) {
            if (i > 3) {
                break;
            }
            int index = content.indexOf("\"col-md-3\"> <span>");
            String a = content.substring(index);
            String d = a.split("</div>")[i];
            list.add(d);
        }
        return list;
    }


    public static List<String> chceckIfContainsNumber(List<String> list) {
        List<String> stringList = new ArrayList<>();
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }
            stringList.add(String.valueOf(sb));
        }

        for (int i = 0; i < stringList.size(); i++) {
            String newString = stringList.get(i).substring(1);
            newList.add(newString);
        }
        System.out.println(newList);
        return newList;
    }
}
