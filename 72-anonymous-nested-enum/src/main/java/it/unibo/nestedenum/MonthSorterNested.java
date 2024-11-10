package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    private enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int nDays;

        Month(final int nDays) {
            this.nDays = nDays;
        }
    }

    private List<Month> getMonthString(final String input) {
        final int inputLen = input.length();
        final List<Month> monthMatchList = new ArrayList<>();
        for (final Month month : Month.values()) {
            if (month.name().length() >= inputLen
                    && month.name().substring(0, inputLen).equals(input.toUpperCase(Locale.ENGLISH))) {
                monthMatchList.add(month);
            }
        }
        return monthMatchList;
    }

    private Month fromString(final String monthName) {
        final List<Month> matchList = getMonthString(monthName);

        if (matchList.size() == 1) {
            return matchList.get(0);
        } else {
            throw new IllegalArgumentException("Invalid month name: " + monthName);
        }

    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<>() {
            @Override
            public int compare(final String m1, final String m2) {
                return Integer.compare(fromString(m1).nDays, fromString(m2).nDays);
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<>() {
            @Override
            public int compare(final String m1, final String m2) {
                return Integer.compare(fromString(m1).ordinal(), fromString(m2).ordinal());
            }
        };
    }
}
