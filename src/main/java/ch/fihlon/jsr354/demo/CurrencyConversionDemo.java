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

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

public class CurrencyConversionDemo {

    public static void main(final String... args) {

        // get the default CurrencyConversion
        final CurrencyConversion dollarConversion = MonetaryConversions.getConversion("USD");

        // create a monetary amount of 100 euro
        final MonetaryAmount inEuro = Money.of(100, "EUR");

        // convert the euro amount to us dollar
        final MonetaryAmount inDollar = inEuro.with(dollarConversion);

        // output
        System.out.println(String.format("%s ≙ %s", inEuro, inDollar));
    }

}
