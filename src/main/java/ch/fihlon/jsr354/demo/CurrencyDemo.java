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
import javax.money.CurrencyUnit;
import javax.money.Monetary;

public class CurrencyDemo {

    public static void main(final String... args) {
        // Kuwait Dinar
        final var kwd = Monetary.getCurrency("KWD");
        log(kwd);

        // Euro
        final var eur = Monetary.getCurrency(Locale.GERMANY);
        log(eur);
    }

    private static void log(final CurrencyUnit currencyUnit) {
        System.out.println("==============================");
        System.out.println("toString: " + currencyUnit);
        System.out.println("Currency Code: " + currencyUnit.getCurrencyCode());
        System.out.println("Numeric Code: " + currencyUnit.getNumericCode());
        System.out.println("Default Fraction Digits: " + currencyUnit.getDefaultFractionDigits());
        System.out.println("Context: " + currencyUnit.getContext());
    }

}
