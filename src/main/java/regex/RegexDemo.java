package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void matchPattern(Matcher matcher){
        System.out.println("matcher matches: " + matcher.matches()); // matches方法尝试将整个输入序列与模式匹配（必须整个输入序列完整匹配成功，才返回true）
        matcher.reset();
        System.out.println("matcher lookingAt: " + matcher.lookingAt()); // lootingAt方法尝试将输入序列（从头开始）与模式匹配（必须存在从头开始的可匹配的子序列，才返回true）
        matcher.reset();
        System.out.println("matcher find: " + matcher.find()); // find方法扫描输入序列，寻找与模式匹配的下一个子序列（只要存在这样的子序列，就返回true）
    }


    public static void main(String[] args){
        Pattern pattern1 = Pattern.compile("[Aa].*string");
        Matcher matcher1 = pattern1.matcher("A string");
        boolean didMatch = matcher1.matches();
        System.out.println("didMatch: " + didMatch);
        int patternStartIndex = matcher1.start();
        System.out.println("pattern start index: " + patternStartIndex);
        int patternEndIndex = matcher1.end();
        System.out.println("pattern end index: " + patternEndIndex);

        Matcher matcher2 = pattern1.matcher("a string with more than just the pattern.");
        matchPattern(matcher2);

        Matcher matcher3 = pattern1.matcher("this is a string with more than just the pattern.");
        matchPattern(matcher3);

        System.out.println(("123hello").replaceAll("\\d", ""));

        test();
    }

    public static void test(){
        Pattern pattern2 = Pattern.compile("a\\.");
        Matcher matcher4 = pattern2.matcher("a.");
        System.out.println("did [a.] Match: " + matcher4.matches());

        Pattern pattern3 = Pattern.compile("\\d+");
        Matcher matcher5 = pattern3.matcher("12");
        System.out.println("did [12] Match: " + matcher5.matches());
    }
}
