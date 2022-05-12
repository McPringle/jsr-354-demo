/*
 * jsr-354-demo – Demo code for a talk about the Java Money and Currency API (JSR-354)
 * Copyright (C) 2017 Marcus Fihlon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package ch.fihlon.jsr354.demo;

import java.util.Locale;
import javax.money.MonetaryException;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

public class ParseDemo {

    public static void main(final String... args) {
        System.out.println("\n============================== Locale.GERMANY ==============================");
        final var formatDE = MonetaryFormats.getAmountFormat(Locale.GERMANY);
        test(formatDE, "123,46 EUR");
        test(formatDE, "EUR 123.46");
        test(formatDE, "EUR123.46");

        System.out.println("\n=================================== de_CH ==================================");
        final var formatCH = MonetaryFormats.getAmountFormat(new Locale("de_CH"));
        test(formatCH, "123,46 EUR");
        test(formatCH, "EUR 123.46");
        test(formatCH, "EUR123.46");

        System.out.println("\n==================================== US ====================================");
        final var formatUS = MonetaryFormats.getAmountFormat(Locale.US);
        test(formatUS, "123,46 EUR");
        test(formatUS, "EUR 123.46");
        test(formatUS, "EUR123.46");
    }

    private static void test(final MonetaryAmountFormat format,
                             final String text) {
        try {
            final var amount = format.parse(text);
            System.out.println("Success: " + amount);
        } catch (final MonetaryException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
