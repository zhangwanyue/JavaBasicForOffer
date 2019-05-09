package thoughtWorks.bookingCourt;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    /*
    str[1]: user ID
    str[4]: start year
    str[6]: start month
    str[8]: start day
    str[10]: start clock
    str[14]: end clock
    str[18]: Accept
    str[20]: cancel
    */
    static String[] str = new String[21];
    static int minStartClock = 9;
    static int maxEndClock = 22;
    static List<Customer> bookList = new LinkedList<>();
    static List<Customer> cancelList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
//        String line = "";
//        while (line.length() != 1 && line != " ") {
//            line = sc.nextLine();
//            if (line.length() != 1 && line != " ")
//                mainProcess(line);
//        }
//        printResult();
         String [] line = new String[6];
         line[0] = "U002 2017-08-01 19:00~22:00 A";
         line[1] = "U003 2017-08-01 18:00~20:00 A";
         line[2] = "U002 2017-08-01 19:00~22:00 A C";
         line[3] = "U002 2017-08-01 19:00~22:00 A C";
         line[4] = "U003 2017-08-01 18:00~20:00 A";
         line[5] = "U003 2017-08-02 13:00~17:00 B";
         for (String l:line) {
             mainProcess(l);
         }
         printResult();
    }

    public static void mainProcess(String line) {
        String userID;
        int year;
        int month;
        int day;
        int startClock;
        int endClock;
        String place;
        String bookPattern = "(U)(\\d{3})(\\s)(\\d{4})(-)(\\d{2})(-)(\\d{2})(\\s)(\\d{2})(:)(00)(~)(\\d{2})(:)(00)(\\s)([A-D])";
        String cancelPattern = "(U)(\\d{3})(\\s)(\\d{4})(-)(\\d{2})(-)(\\d{2})(\\s)(\\d{2})(:)(00)(~)(\\d{2})(:)(00)(\\s)([A-D])(\\s)([C])";
        boolean isBook = Pattern.matches(bookPattern, line);
        boolean iscancel = Pattern.matches(cancelPattern, line);
        // System.out.println(line);
        if (isBook) {
            // System.out.println(Pattern.matches(bookPattern, line));
            Pattern p = Pattern.compile(bookPattern);
            Matcher m = p.matcher(line);
            // System.out.println(m.groupCount());
            m.find();
            for (int j = 0; j < m.groupCount() + 1; j++) {
                str[j] = m.group(j);
            // System.out.println(str[j]);
            }
            // System.out.println(str[20]);
            userID = str[2];
            year = Integer.valueOf(str[4]);
            month = Integer.valueOf(str[6]);
            day = Integer.valueOf(str[8]);
            startClock = Integer.valueOf(str[10]);
            endClock = Integer.valueOf(str[14]);
            place = str[18];
            // bookMessage = year + month + day +
            // 如果与预定表达式一样的话，那么看预定的时间是否相等，预定的开始时间是否小于最小开始时间，结束时间是否大于最大结束时间，如果是的话，打印预定不正确错误。
            if (Integer.valueOf(startClock) == Integer.valueOf(endClock)
                    || Integer.valueOf(startClock) < minStartClock
                    || Integer.valueOf(endClock) > maxEndClock)
                printInvalidBookError();
            else {
                Customer cus = new Customer(userID, year, month, day, startClock, endClock, place);
                book(cus);
            }
        } else if (iscancel) {
            Pattern p = Pattern.compile(cancelPattern);
            Matcher m = p.matcher(line);
            // System.out.println(m.groupCount());
            m.find();
            for (int j = 0; j < m.groupCount() + 1; j++) {
                str[j] = m.group(j);
            // System.out.println(str[j]);
            }
            // System.out.println(str[20]);
            userID = str[2];
            year = Integer.valueOf(str[4]);
            month = Integer.valueOf(str[6]);
            day = Integer.valueOf(str[8]);
            startClock = Integer.valueOf(str[10]);
            endClock = Integer.valueOf(str[14]);
            place = str[18];
            Customer cus = new Customer(userID, year, month, day, startClock, endClock, place);
            cancelBook(cus);
        } else {
            printInvalidBookError();
        }
    }

    public static void book(Customer cus) {
        for (Customer c : bookList) {
            if (c.isTimeConflict(cus)) {
                printConflictError();
                return;
            }
        }
        bookList.add(cus);
        printBookSuccess();
    }

    public static void cancelBook(Customer cus) {
        boolean rem = false;
        for (Customer c : bookList) {
            if (cus.isEqual(c)) {
                bookList.remove(c);
                cancelList.add(cus);
                printBookSuccess();
                rem = true;
            }
        }
        if (!rem)
            printcancelError();
    }

    public static void printResult() {
        String[] placeIncome = new String[4];
        int[] placePrice = new int[4];
        int bookIncome;
        int cancelIncome;
        for (int j = 'A', k = 0; j <= 'D'; j++, k++) {
            placeIncome[k] = "场地" + String.valueOf((char) (j)) + ":\n";
        }
        System.out.println("\n" + "收入汇总\n" + "---");
        for (Customer c : bookList) {
            bookIncome = callPrice(c);
            for (int j = 'A', k = 0; j <= 'D'; j++, k++) {
                if ((String.valueOf((char) (j))).equals(c.place)) {
                    placePrice[k] += bookIncome;
                    placeIncome[k] += (c.year + "-" + (c.month < 10 ? ("0" + c.month) : c.month) + "-" + (c.day < 10 ? ("0" + c.day) : c.day) + " "
                            + (c.startClock < 10 ? ("0" + c.startClock) : c.startClock) + ":" + "00" + "~"
                            + (c.endClock < 10 ? ("0" + c.endClock) : c.endClock) + ":" + "00"
                            + " " + bookIncome + "元" + "\n");
                }
            }
            // System.out.println(bookIncome);
        }
        for (Customer c : cancelList) {
            cancelIncome = calcancel(c);
            for (int j = 'A', k = 0; j <= 'D'; j++, k++) {
                if ((String.valueOf((char) (j))).equals(c.place)) {
                    placePrice[k] += cancelIncome;
                    placeIncome[k] += (c.year + "-" + (c.month < 10 ? ("0" + c.month) : c.month) + "-" + (c.day < 10 ? ("0" + c.day) : c.day) + " "
                            + (c.startClock < 10 ? ("0" + c.startClock) : c.startClock) + ":" + "00" + "~"
                            + (c.endClock < 10 ? ("0" + c.endClock) : c.endClock) + ":" + "00"
                            + " 违约金" + " " + cancelIncome + "元\n");
                }
            }
        }
        int i = 0;
        int sumPrice = 0;
        for (String p : placeIncome) {
            sumPrice += placePrice[i];
            System.out.print(p);
            System.out.println("小计：" + placePrice[i++] + "元");
            System.out.println();
        }
        System.out.println("---\n" + "总计：" + sumPrice + "元");
    }

    public static int calcancel(Customer c) {
        return (int) (callPrice(c) * (getWeek(c) <= 5 ? 0.5 : 0.25));
    }

    public static int getWeek(Customer c) {
        String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        String strDate = c.year + "-" + c.month + "-" + c.day;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = f.parse(strDate);// 将字符串转换为日期
        } catch (ParseException e) {
            System.out.println("输入的日期格式不合理！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String week = sdf.format(date);
        for (int i = 0; i < weeks.length; i++) {
            if (week.equals(weeks[i]))
                return ++i;
        }
        return 0;
    }

    public static int callPrice(Customer c) {
        int[] workDayPrice = {30, 50, 80, 60};
        int[] weekDayPrice = {40, 50, 60};
        int week = getWeek(c);
        int price = 0;
        if (week <= 5) { // 周一到周五的价格计算
            if (c.startClock >= 9 && c.startClock <= 12) {
                if (c.endClock >= 9 && c.endClock <= 12) {
                    price = (c.endClock - c.startClock) * workDayPrice[0];
                } else if (c.endClock > 12 && c.endClock <= 18) {
                    price = (12 - c.startClock) * workDayPrice[0] + (c.endClock - 12) * workDayPrice[1];
                } else if (c.endClock > 18 && c.endClock <= 20) {
                    price = (12 - c.startClock) * workDayPrice[0] + (18 - 12) * workDayPrice[1]
                            + (c.endClock - 18) * workDayPrice[2];
                } else if (c.endClock > 20 && c.endClock <= 22) {
                    price = (12 - c.startClock) * workDayPrice[0] + (18 - 12) * workDayPrice[1]
                            + (20 - 18) * workDayPrice[2] + (c.endClock - 20) * workDayPrice[3];
                }
            } else if (c.startClock > 12 && c.startClock <= 18) {
                if (c.endClock >= 12 && c.endClock <= 18)
                    price = (c.endClock - c.startClock) * workDayPrice[1];
                else if (c.endClock > 18 && c.endClock <= 20)
                    price = (18 - c.startClock) * workDayPrice[1]
                            + (c.endClock - 18) * workDayPrice[2];
                else if (c.endClock > 20 && c.endClock <= 22)
                    price = (18 - c.startClock) * workDayPrice[1] + (20 - 18) * workDayPrice[2]
                            + (c.endClock - 20) * workDayPrice[3];
            } else if (c.startClock > 18 && c.startClock <= 20) {
                if (c.endClock >= 18 && c.endClock <= 20)
                    price = (c.endClock - c.startClock) * workDayPrice[2];
                else if (c.endClock > 20 && c.endClock <= 22) {
                    price = (20 - c.startClock) * workDayPrice[2] + (c.endClock - 20) * workDayPrice[3];
                }
            } else if (c.startClock > 20 && c.startClock <= 22) {
                price = (c.endClock - c.startClock) * workDayPrice[3];
            }
        } else {
            if (c.startClock >= 9 && c.endClock <= 12) {
                if (c.endClock > 9 && c.endClock <= 12) {
                    price = (c.endClock - c.startClock) * weekDayPrice[0];
                } else if (c.endClock > 12 && c.endClock <= 18) {
                    price = (12 - c.startClock) * weekDayPrice[0] + (c.endClock - 12) * weekDayPrice[1];
                } else if (c.endClock > 18 && c.endClock <= 22) {
                    price = (12 - c.startClock) * weekDayPrice[0] + (18 - 12) * weekDayPrice[1]
                            + (c.endClock - 18) * weekDayPrice[2];
                }
            } else if (c.startClock > 12 && c.startClock <= 18) {
                if (c.endClock > 12 && c.endClock <= 18)
                    price = (c.endClock - c.startClock) * weekDayPrice[1];
                else if (c.endClock > 18 && c.endClock <= 22)
                    price = (18 - c.startClock) * weekDayPrice[1] + (c.endClock - 18) * weekDayPrice[2];
            } else if (c.startClock > 18 && c.startClock <= 22) {
                price = (c.endClock - c.startClock) * weekDayPrice[2];
            }
        }
        return price;
    }

    public static void printInvalidBookError() {
        System.out.println("Error: the booking is invalid!");
    }

    public static void printConflictError() {
        System.out.println("Error: the booking conflicts with existing bookings!");
    }

    public static void printcancelError() {
        System.out.println("Error: the booking being cancelled does not exist!");
    }

    public static void printBookSuccess() {
        System.out.println("Success: the booking is accepted!");
    }

}
