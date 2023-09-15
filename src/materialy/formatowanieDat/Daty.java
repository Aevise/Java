package materialy.formatowanieDat;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Daty {

    private static LocalTime localTime;

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        Locale locale = new Locale("pl");
//
//        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
//        System.out.println(localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
//        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(3));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Poland"));

        System.out.println(offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        System.out.println(offsetDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

        System.out.println("\nDateTimeFormatter.ofLocalizedDate():");
        DateTimeFormatter dateTimeFormatterDateFULL = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter dateTimeFormatterDateLONG = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter dateTimeFormatterDateMEDIUM = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatterDateSHORT = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        System.out.println("FULL: " + localDate.format(dateTimeFormatterDateFULL));
        System.out.println("LONG: " + localDate.format(dateTimeFormatterDateLONG));
        System.out.println("MEDIUM: " + localDate.format(dateTimeFormatterDateMEDIUM));
        System.out.println("SHORT: " + localDate.format(dateTimeFormatterDateSHORT));

        System.out.println("\nDateTimeFormatter.ofLocalizedTime():");
        DateTimeFormatter dateTimeFormatterTimeFULL = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        DateTimeFormatter dateTimeFormatterTimeLONG = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
        DateTimeFormatter dateTimeFormatterTimeMEDIUM = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatterTimeSHORT = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);

//        System.out.println("FULL: " + localTime.format(dateTimeFormatterTimeFULL));
//        System.out.println("LONG: " + localTime.format(dateTimeFormatterTimeLONG));
        System.out.println("MEDIUM: " + localTime.format(dateTimeFormatterTimeMEDIUM));
        System.out.println("SHORT: " + localTime.format(dateTimeFormatterTimeSHORT));

        System.out.println("\nDateTimeFormatter.ofLocalizedDateTime():");
        DateTimeFormatter dateTimeFormatterDateTimeFULL = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        DateTimeFormatter dateTimeFormatterDateTimeLONG = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter dateTimeFormatterDateTimeMEDIUM = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatterDateTimeSHORT = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

//        System.out.println("FULL: " + localDateTime.format(dateTimeFormatterDateTimeFULL));
//        System.out.println("LONG: " + localDateTime.format(dateTimeFormatterDateTimeLONG));
        System.out.println("MEDIUM: " + localDateTime.format(dateTimeFormatterDateTimeMEDIUM));
        System.out.println("SHORT: " + localDateTime.format(dateTimeFormatterDateTimeSHORT));

        System.out.println("\noffsetDateTime.format:");
        //        System.out.println("FULL: " + offsetDateTime.format(dateTimeFormatterDateTimeFULL));
//        System.out.println("LONG: " + offsetDateTime.format(dateTimeFormatterDateTimeLONG));
        System.out.println("MEDIUM: " + offsetDateTime.format(dateTimeFormatterDateTimeMEDIUM));
        System.out.println("SHORT: " + offsetDateTime.format(dateTimeFormatterDateTimeSHORT));

        System.out.println("\nzonedDateTime.format:");
        System.out.println("FULL: " + zonedDateTime.format(dateTimeFormatterDateTimeFULL));
        System.out.println("LONG: " + zonedDateTime.format(dateTimeFormatterDateTimeLONG));
        System.out.println("MEDIUM: " + zonedDateTime.format(dateTimeFormatterDateTimeMEDIUM));
        System.out.println("SHORT: " + zonedDateTime.format(dateTimeFormatterDateTimeSHORT));

        DateTimeFormatter formatterFULL_US = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
        DateTimeFormatter formatterLONG_US = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.US);
        DateTimeFormatter formatterMEDIUM_US = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US);
        DateTimeFormatter formatterSHORT_US = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.US);

        DateTimeFormatter formatterFULL_GER = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.GERMANY);
        DateTimeFormatter formatterLONG_GER = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.GERMANY);
        DateTimeFormatter formatterMEDIUM_GER = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMANY);
        DateTimeFormatter formatterSHORT_GER = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.GERMANY);

        System.out.println("\nFormatter_US");
        System.out.println("FULL: " + zonedDateTime.format(formatterFULL_US));
        System.out.println("LONG: " + zonedDateTime.format(formatterLONG_US));
        System.out.println("MEDIUM: " + zonedDateTime.format(formatterMEDIUM_US));
        System.out.println("SHORT: " + zonedDateTime.format(formatterSHORT_US));

        System.out.println("\nFormatter_GER");
        System.out.println("FULL: " + zonedDateTime.format(formatterFULL_GER));
        System.out.println("LONG: " + zonedDateTime.format(formatterLONG_GER));
        System.out.println("MEDIUM: " + zonedDateTime.format(formatterMEDIUM_GER));
        System.out.println("SHORT: " + zonedDateTime.format(formatterSHORT_GER));
    }
}
