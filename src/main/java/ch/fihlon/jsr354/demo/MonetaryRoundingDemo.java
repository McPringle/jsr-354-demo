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

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryRounding;

public class MonetaryRoundingDemo {

    public static void main(final String... args) {
        final MonetaryAmount eurAmount1 = Money.of(22.435, "EUR");
        final MonetaryAmount eurAmountRounded1 = round(eurAmount1);
        log(eurAmount1, eurAmountRounded1);

        final MonetaryAmount eurAmount2 = Money.of(22.434999, "EUR");
        final MonetaryAmount eurAmountRounded2 = round(eurAmount2);
        log(eurAmount2, eurAmountRounded2);
    }

    private static MonetaryAmount round(final MonetaryAmount amount) {
        final CurrencyUnit currency = amount.getCurrency();
        final MonetaryRounding rounding = Monetary.getRounding(currency);
        return rounding.apply(amount);
    }

    private static void log(final MonetaryAmount amount,
                            final MonetaryAmount roundedAmount) {
        System.out.println("==============================");
        System.out.println("Amount:         " + amount);
        System.out.println("Double Value Exact: " + amount.getNumber().doubleValueExact());
        System.out.println("Rounded Amount: " + roundedAmount);
        System.out.println("Double Value Exact: " + roundedAmount.getNumber().doubleValueExact());
    }

}
