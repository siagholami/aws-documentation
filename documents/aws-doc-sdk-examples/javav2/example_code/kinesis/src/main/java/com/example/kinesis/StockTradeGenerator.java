//snippet-sourcedescription:[StockTrade.java is a helper class.]
//snippet-keyword:[Java]
//snippet-sourcesyntax:[java]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon Kinesis]
//snippet-service:[kinesis]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[3-26-2020]
//snippet-sourceauthor:scmacdon - AWS]
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.example.kinesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Generates random stock trades by picking randomly from a collection of stocks, assigning a
 * random price based on the mean, and picking a random quantity for the shares
 *
 */

public class StockTradeGenerator {

    private static final List<StockPrice> STOCK_PRICES = new ArrayList<StockPrice>();
    static {
        STOCK_PRICES.add(new StockPrice("AAPL", 119.72));
        STOCK_PRICES.add(new StockPrice("XOM", 91.56));
        STOCK_PRICES.add(new StockPrice("GOOG", 527.83));
        STOCK_PRICES.add(new StockPrice("BRK.A", 223999.88));
        STOCK_PRICES.add(new StockPrice("MSFT", 42.36));
        STOCK_PRICES.add(new StockPrice("WFC", 54.21));
        STOCK_PRICES.add(new StockPrice("JNJ", 99.78));
        STOCK_PRICES.add(new StockPrice("WMT", 85.91));
        STOCK_PRICES.add(new StockPrice("CHL", 66.96));
        STOCK_PRICES.add(new StockPrice("GE", 24.64));
        STOCK_PRICES.add(new StockPrice("NVS", 102.46));
        STOCK_PRICES.add(new StockPrice("PG", 85.05));
        STOCK_PRICES.add(new StockPrice("JPM", 57.82));
        STOCK_PRICES.add(new StockPrice("RDS.A", 66.72));
        STOCK_PRICES.add(new StockPrice("CVX", 110.43));
        STOCK_PRICES.add(new StockPrice("PFE", 33.07));
        STOCK_PRICES.add(new StockPrice("FB", 74.44));
        STOCK_PRICES.add(new StockPrice("VZ", 49.09));
        STOCK_PRICES.add(new StockPrice("PTR", 111.08));
        STOCK_PRICES.add(new StockPrice("BUD", 120.39));
        STOCK_PRICES.add(new StockPrice("ORCL", 43.40));
        STOCK_PRICES.add(new StockPrice("KO", 41.23));
        STOCK_PRICES.add(new StockPrice("T", 34.64));
        STOCK_PRICES.add(new StockPrice("DIS", 101.73));
        STOCK_PRICES.add(new StockPrice("AMZN", 370.56));
    }

    /** The ratio of the deviation from the mean price **/
    private static final double MAX_DEVIATION = 0.2; // ie 20%

    /** The number of shares is picked randomly between 1 and the MAX_QUANTITY **/
    private static final int MAX_QUANTITY = 10000;

    /** Probability of the trade being a sell **/
    private static final double PROBABILITY_SELL = 0.4; // ie 40%

    private final Random random = new Random();
    private AtomicLong id = new AtomicLong(1);

    /**
     * Return a random stock trade with a unique ID every time
     *
     */
    public StockTrade getRandomTrade() {
        // Pick a random stock
        StockPrice stockPrice = STOCK_PRICES.get(random.nextInt(STOCK_PRICES.size()));
        // Pick a random deviation between -MAX_DEVIATION and +MAX_DEVIATION
        double deviation = (random.nextDouble() - 0.5) * 2.0 * MAX_DEVIATION;
        // Set the price using the deviation and mean price
        double price = stockPrice.price * (1 + deviation);
        // Round price to 2 decimal places
        price = Math.round(price * 100.0) / 100.0;

        // Set the trade type to buy or sell depending on the probability of sell
        StockTrade.TradeType tradeType = StockTrade.TradeType.BUY;
        if (random.nextDouble() < PROBABILITY_SELL) {
            tradeType = StockTrade.TradeType.SELL;
        }

        // Randomly pick a quantity of shares.
        long quantity = random.nextInt(MAX_QUANTITY) + 1; // Add 1 because nextInt() will return between 0 (inclusive)
        // and MAX_QUANTITY (exclusive). We want at least 1 share.

        return new StockTrade(stockPrice.tickerSymbol, tradeType, price, quantity, id.getAndIncrement());
    }

    private static class StockPrice {
        String tickerSymbol;
        double price;

        StockPrice(String tickerSymbol, double price) {
            this.tickerSymbol = tickerSymbol;
            this.price = price;
        }
    }
}
