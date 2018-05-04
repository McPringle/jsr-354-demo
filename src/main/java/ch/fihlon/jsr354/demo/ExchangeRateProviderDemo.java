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

import org.javamoney.moneta.convert.ExchangeRateBuilder;
import org.javamoney.moneta.spi.AbstractRateProvider;
import org.javamoney.moneta.spi.DefaultNumberValue;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.ConversionContextBuilder;
import javax.money.convert.ConversionQuery;
import javax.money.convert.ExchangeRate;
import javax.money.convert.ProviderContext;
import javax.money.convert.ProviderContextBuilder;
import javax.money.convert.RateType;

public class ExchangeRateProviderDemo extends AbstractRateProvider {

    private CurrencyUnit BRL = Monetary.getCurrency("BRL");
    private CurrencyUnit EUR = Monetary.getCurrency("EUR");

    private static final ProviderContext CONTEXT = ProviderContextBuilder.of("DEMO", RateType.ANY)
            .set("providerDescription", "My really cool own exchange rate provider implementation.")
            .build();

    public ExchangeRateProviderDemo() {
        super(CONTEXT);
    }

    public ExchangeRateProviderDemo(final ProviderContext providerContext) {
        super(providerContext);
    }

    @Override
    public ExchangeRate getExchangeRate(final ConversionQuery conversionQuery) {
        final CurrencyUnit baseCurrency = conversionQuery.getBaseCurrency();
        final CurrencyUnit currency = conversionQuery.getCurrency();

        if (baseCurrency.equals(BRL) && currency.equals(BRL))
            return createExchangeRate(baseCurrency, currency, 1);
        if (baseCurrency.equals(EUR) && currency.equals(EUR))
            return createExchangeRate(baseCurrency, currency, 1);
        if (baseCurrency.equals(BRL) && currency.equals(EUR))
            return createExchangeRate(baseCurrency, currency, 0.2663);
        if (baseCurrency.equals(EUR) && currency.equals(BRL))
            return createExchangeRate(baseCurrency, currency, 3.7545);

        return null;
    }

    private ExchangeRate createExchangeRate(final CurrencyUnit baseCurrency, final CurrencyUnit currency, final Number factor) {
        return new ExchangeRateBuilder(ConversionContextBuilder.create(getContext(), RateType.ANY).build())
                .setBase(baseCurrency)
                .setTerm(currency)
                .setFactor(DefaultNumberValue.of(factor))
                .build();
    }

}
