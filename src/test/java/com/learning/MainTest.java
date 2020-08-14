package com.learning;

import com.google.common.base.Strings;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.learning
 * @date 2020/5/25-10:27
 */
public class MainTest {

    public static final long DAY_TIMESTAMP = 24 * 60 * 60 * 1000L;
    public static void main(String[] args) {
        String str = "dd";
        if (Strings.isNullOrEmpty(str)) {
            System.out.println("ues");
        }

        /*Date startTime = DateUtil.parse("2020-06-03 00:00:00");
        Date endTime = DateUtil.parse("2020-06-05 23:59:59");
        // 判断是否是账期日
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate =  format.format(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(endTime);
        cal.add(Calendar.DATE, 1);
        String accountDate = format.format(cal.getTime());
        // 不是账期日，不生成账单
        if (!currentDate.equals(accountDate)) {
            return;
        }*/

        /* String currentDate = DateUtil.format(new Date(), new SimpleDateFormat("yyyy-MM-dd"));
        System.out.println(currentDate);
        Date date = DateUtil.parse("2020-05-24 10:35:11");
        System.out.println(date.toString().substring(0, 10).replace("-", "."));
        String endDate = getDatePlusDay(date, 1).substring(0, 10);
        System.out.println(endDate);
        if (currentDate.compareTo(endDate) == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        List<String> checkDateList = new ArrayList<>();
        checkDateList.add("2018.05.01");
        checkDateList.add("2018.06.01");
        checkDateList.add("2018.07.01");
        checkDateList.add("2018.08.01");
        System.out.println(checkDateList.stream().map(startDate -> startDate.substring(0, 7)).collect(Collectors.toList()));

        System.out.println(SettleStatusEnum.getMessageByCode("1"));
*/
      /* Date startDate = DateUtil.parse("2020-05-18 00:00:00");
       Date endDate = DateUtil.parse("2020-05-24 23:59:59");
       getNextMonth(startDate,endDate,"period");*/
        double profitPrice = 5.6;
        double totalPurchasePrice = 123;
        System.out.println((BigDecimal.valueOf(profitPrice)
                .divide(new BigDecimal(totalPurchasePrice), 4, BigDecimal.ROUND_HALF_DOWN))
                .multiply(new BigDecimal(100)).toPlainString().substring(0, 4));
        System.out.println(new BigDecimal(BigDecimal.valueOf(0)
                .divide(new BigDecimal(totalPurchasePrice), 4, BigDecimal.ROUND_HALF_DOWN)
                .multiply(new BigDecimal(100)).toPlainString().substring(0, 4)));
    }

    public static String getDatePlusDay(Date strDate, int days) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strDate);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return format.format(calendar.getTime());
    }

    public static void getNextMonth(Date startDate, Date endDate, String billType) {
        // 上一个账期的开始时间
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        // 上一个账期的结束时间
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        // 当前时间
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        Date accountStart = null;
        Date accountEnd = null;
        if ("month".equals(billType)) {
            // 当前日期
            int todayDate = cal.get(Calendar.DATE);
            // 月结的日期
            int nextAccountDate = end.get(Calendar.DATE);
            // 下一个月结日为当前月的月结日
            cal.set(Calendar.DATE, nextAccountDate);
            // 如果当前月的月结日已过，则取下一个月的同一天
            if (nextAccountDate < todayDate) {
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
            }
            accountEnd = cal.getTime();
            // 月份-1，日期+1，即为账期的开始时间
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
            accountStart = cal.getTime();
            System.out.println("accountStart=" + accountStart + "-accountEnd=" + accountEnd);
        } else if ("period".equals(billType)) {
            String periodNum = "7";
            int num = Integer.valueOf(periodNum);
            // 如果结算日在当前时间之后
            if (!end.before(now)) {
                accountStart = startDate;
                accountEnd = endDate;
            } else {
                // 如果结算日在当前时间之前
                int days = getIntervalDays(startDate, now);
                int remain = days % Integer.valueOf(periodNum);
                if (remain == 0) {
                    accountEnd = cal.getTime();
                    cal.set(Calendar.DATE, cal.get(Calendar.DATE) - (num - 1));
                    accountStart = cal.getTime();
                } else {
                    // 账期开始时间是 当前日期 - (remain - 1)
                    cal.set(Calendar.DATE, cal.get(Calendar.DATE) - remain + 1);
                    accountStart = cal.getTime();
                    cal.set(Calendar.DATE, cal.get(Calendar.DATE) + (num - 1));
                    accountEnd = cal.getTime();
                }
            }
            System.out.println("accountStart=" + accountStart + "-accountEnd=" + accountEnd);
        }
    }
        public static Date getStartTime(Date time) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 0);
            return calendar.getTime();
        }
    /**
     * 获取两个时间的间隔天数，不足1天以1天计算
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getIntervalDays(Date startTime, Date endTime) {
        long days = (getStartTime(endTime).getTime() - getStartTime(startTime).getTime()) / DAY_TIMESTAMP;
        return (int)days + 1;
    }
}
