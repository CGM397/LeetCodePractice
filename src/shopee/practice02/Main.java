package shopee.practice02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/7/4 16:09
 * @description: 字符串
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> store = new ArrayList<>();
            if (line.indexOf('_') != -1) {
                store = Arrays.asList(line.split("_"));
            }
            else if (line.indexOf('-') != -1) {
                store = Arrays.asList(line.split("-"));
            }
            else {
                int cur = 1;
                String tmp = Character.toLowerCase(line.charAt(0)) + "";
                while (cur < line.length()) {
                    while (cur < line.length() && !Character.isUpperCase(line.charAt(cur))) {
                        tmp += line.charAt(cur);
                        cur++;
                    }
                    store.add(tmp);
                    if (cur < line.length()) {
                        tmp = Character.toLowerCase(line.charAt(cur)) + "";
                        cur++;
                    }
                }
            }

            StringBuilder res = new StringBuilder();
            boolean first = true;

            for (String one : store) {
                res.append(Character.toUpperCase(one.charAt(0))).append(one.substring(1));
            }

            res.append(" ");
            for (String one : store) {
                if (first) {
                    first = false;
                    res.append(one);
                }
                else
                    res.append(Character.toUpperCase(one.charAt(0))).append(one.substring(1));
            }

            res.append(" ");
            first = true;
            for (String one : store) {
                if (first) {
                    first = false;
                    res.append(one);
                }
                else
                    res.append("_").append(one);
            }

            res.append(" ");
            first = true;
            for (String one : store) {
                if (first) {
                    first = false;
                    res.append(one);
                }
                else
                    res.append("-").append(one);
            }

            System.out.println(res);
        }
    }
}
