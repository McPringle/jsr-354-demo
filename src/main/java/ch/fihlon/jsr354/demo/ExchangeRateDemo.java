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

import javax.money.Monetary;
import javax.money.convert.MonetaryConversions;

public class ExchangeRateDemo {

    public static void main(final String... args) {

        final var brl = Monetary.getCurrency("BRL");
        final var eur = Monetary.getCurrency("EUR");

        final var rateProvider = MonetaryConversions.getExchangeRateProvider("DEMO");
        final var exchangeRate = rateProvider.getExchangeRate(brl, eur);

        System.out.println("==============================");
        System.out.println("Exchange Rate: " + exchangeRate);
        System.out.println("Base Currency: " + exchangeRate.getBaseCurrency());
        System.out.println("Currency: " + exchangeRate.getCurrency());
        System.out.println("Factor: " + exchangeRate.getFactor().doubleValueExact());
        System.out.println("Context: " + exchangeRate.getContext());
    }

}
