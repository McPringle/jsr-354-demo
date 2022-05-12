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
import javax.money.format.MonetaryFormats;
import org.javamoney.moneta.Money;

public class FormatDemo {

    public static void main(final String... args) {

        final var amount = Money.of(123.456, "EUR");

        final var formatDE = MonetaryFormats.getAmountFormat(Locale.GERMANY);
        System.out.println(formatDE.format(amount));

        final var formatCH = MonetaryFormats.getAmountFormat(new Locale("de_CH"));
        System.out.println(formatCH.format(amount));

        final var formatUS = MonetaryFormats.getAmountFormat(Locale.US);
        System.out.println(formatUS.format(amount));
    }

}
