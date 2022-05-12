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
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactoryQueryBuilder;
import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

public class MonetaryAmountDemo {

    public static void main(final String... args) {
        final var brl = Monetary.getCurrency("BRL");
        final var brlAmount = Money.of(120, brl);
        log(brlAmount);

        final var usd = Monetary.getCurrency(Locale.US);
        final var usdAmount = FastMoney.of(120, usd);
        log(usdAmount);

        final var query10 = MonetaryAmountFactoryQueryBuilder.of()
                .setPrecision(10)
                .build();
        final var amountFactory10 = Monetary.getAmountFactory(query10);
        final var eurAmount = amountFactory10
                .setCurrency("EUR")
                .setNumber(120)
                .create();
        log(eurAmount);

        final var query20 = MonetaryAmountFactoryQueryBuilder.of()
                .setPrecision(20)
                .build();
        final var amountFactory20 = Monetary.getAmountFactory(query20);
        final var chfAmount = amountFactory20
                .setCurrency("CHF")
                .setNumber(120)
                .create();
        log(chfAmount);
    }

    private static void log(MonetaryAmount monetaryAmount) {
        System.out.println("==============================");
        System.out.println("toString: " + monetaryAmount);
        System.out.println("CurrencyCode: " +monetaryAmount.getCurrency().getCurrencyCode());
        System.out.println("Double Value Exact: " + monetaryAmount.getNumber().doubleValueExact());
        System.out.println("Class: "+ monetaryAmount.getClass().getName());
        System.out.println("Context: " + monetaryAmount.getContext());
    }

}
