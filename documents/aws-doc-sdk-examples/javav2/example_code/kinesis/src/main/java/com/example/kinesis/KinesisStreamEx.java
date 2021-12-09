//snippet-sourcedescription:[KinesisStreamEx.java demonstrates the various ways to consume and process an Amazon Kinesis stream asynchronously.]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[Amazon Kinesis]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[3-26-2020]
//snippet-sourceauthor:[scmacdon-aws]
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.kinesis;

// snippet-start:[kinesis.java2.stream_example.import]

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import software.amazon.awssdk.core.async.SdkPublisher;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;
import software.amazon.awssdk.services.kinesis.model.ShardIteratorType;
import software.amazon.awssdk.services.kinesis.model.SubscribeToShardEvent;
import software.amazon.awssdk.services.kinesis.model.SubscribeToShardEventStream;
import software.amazon.awssdk.services.kinesis.model.SubscribeToShardRequest;
import software.amazon.awssdk.services.kinesis.model.SubscribeToShardResponse;
import software.amazon.awssdk.services.kinesis.model.SubscribeToShardResponseHandler;
// snippet-end:[kinesis.java2.stream_example.import]

public class KinesisStreamEx {

    /**
     * Creates a SubscribeToShardResponseHandler using the builder, which lets you set each lifecycle callback separately
     * instead of implementing the interface
     */

    // Update to include a value CONSUMER_ARN
    private static final String CONSUMER_ARN = "arn:aws:kinesis:us-east-1:814548047983:stream/StockTradeStream/consumer/StockApp:1585146130";

    public static void main(String[] args) {

        // snippet-start:[kinesis.java2.stream_example.setup]
        Region region = Region.US_EAST_1;
        KinesisAsyncClient client = KinesisAsyncClient.builder()
        .region(region)
        .build();

        SubscribeToShardRequest request = SubscribeToShardRequest.builder()
                .consumerARN(CONSUMER_ARN)
                .shardId("arn:aws:kinesis:us-east-1:814548047983:stream/StockTradeStream")
                .startingPosition(s -> s.type(ShardIteratorType.LATEST)).build();

        // snippet-end:[kinesis.java2.stream_example.setup]
        SubscribeToShardResponseHandler responseHandler = SubscribeToShardResponseHandler
                .builder()
                .onError(t -> System.err.println("Error during stream - " + t.getMessage()))
                .subscriber(MySubscriber::new)
                .build();

        client.subscribeToShard(request, responseHandler);
        client.close();
    }

    // snippet-start:[kinesis.java2.stream_example.lifecycle_callback]
    private static CompletableFuture<Void> responseHandlerBuilder(KinesisAsyncClient client, SubscribeToShardRequest request) {
        SubscribeToShardResponseHandler responseHandler = SubscribeToShardResponseHandler
                .builder()
                .onError(t -> System.err.println("Error during stream - " + t.getMessage()))
                .onComplete(() -> System.out.println("All records stream successfully"))
                // Must supply some type of subscriber
                .subscriber(e -> System.out.println("Received event - " + e))
                .build();
        return client.subscribeToShard(request, responseHandler);
    }
    // snippet-end:[kinesis.java2.stream_example.lifecycle_callback]

    /**
     * Uses the SubscribeToShardResponseHandler.Builder and a simple consumer of events to subscribe
     */
    private static CompletableFuture<Void> responseHandlerBuilderConsumer(KinesisAsyncClient client, SubscribeToShardRequest request) {
        SubscribeToShardResponseHandler responseHandler = SubscribeToShardResponseHandler
                .builder()
                .onError(t -> System.err.println("Error during stream - " + t.getMessage()))
                .subscriber(e -> System.out.println("Received event - " + e))
                .build();
        return client.subscribeToShard(request, responseHandler);
    }

    /**
     * Uses the publisherTransformer method to customize the publisher before ultimately subscribing to it
     */
    // snippet-start:[kinesis.java2.stream_example.publish_transformer]
    private static CompletableFuture<Void> responseHandlerBuilderPublisherTransformer(KinesisAsyncClient client, SubscribeToShardRequest request) {
        SubscribeToShardResponseHandler responseHandler = SubscribeToShardResponseHandler
                .builder()
                .onError(t -> System.err.println("Error during stream - " + t.getMessage()))
                .publisherTransformer(p -> p.filter(e -> e instanceof SubscribeToShardEvent).limit(100))
                .subscriber(e -> System.out.println("Received event - " + e))
                .build();
        return client.subscribeToShard(request, responseHandler);
    }
    // snippet-end:[kinesis.java2.stream_example.publish_transformer]

    /**
     * Creates a SubscribeToShardResponseHandler.Visitor using the builder, which lets you register an event handler for
     * all events you're interested in instead of implementing the interface
     */
    // snippet-start:[kinesis.java2.stream_example.visitor]
    private static CompletableFuture<Void> responseHandlerBuilderVisitorBuilder(KinesisAsyncClient client, SubscribeToShardRequest request) {
        SubscribeToShardResponseHandler.Visitor visitor = SubscribeToShardResponseHandler.Visitor
                .builder()
                .onSubscribeToShardEvent(e -> System.out.println("Received subscribe to shard event " + e))
                .build();
        SubscribeToShardResponseHandler responseHandler = SubscribeToShardResponseHandler
                .builder()
                .onError(t -> System.err.println("Error during stream - " + t.getMessage()))
                .subscriber(visitor)
                .build();
        return client.subscribeToShard(request, responseHandler);
    }
    // snippet-end:[kinesis.java2.stream_example.visitor]

    /**
     * Subscribes to the stream of events by implementing the SubscribeToShardResponseHandler.Visitor interface
     */
    private static CompletableFuture<Void> responseHandlerBuilderVisitor(KinesisAsyncClient client, SubscribeToShardRequest request) {
        SubscribeToShardResponseHandler.Visitor visitor = new SubscribeToShardResponseHandler.Visitor() {
            @Override
            public void visit(SubscribeToShardEvent event) {
                System.out.println("Received subscribe to shard event " + event);
            }
        };
        SubscribeToShardResponseHandler responseHandler = SubscribeToShardResponseHandler
                .builder()
                .onError(t -> System.err.println("Error during stream - " + t.getMessage()))
                .subscriber(visitor)
                .build();
        return client.subscribeToShard(request, responseHandler);
    }

    /**
     * Creates a SubscribeToShardResponseHandler the classic way by implementing the interface
     */
    // snippet-start:[kinesis.java2.stream_example.custom_handler]
    private static CompletableFuture<Void> responseHandlerBuilderClassic(KinesisAsyncClient client, SubscribeToShardRequest request) {
        SubscribeToShardResponseHandler responseHandler = new SubscribeToShardResponseHandler() {

            @Override
            public void responseReceived(SubscribeToShardResponse response) {
                System.out.println("Receieved initial response");
            }

            @Override
            public void onEventStream(SdkPublisher<SubscribeToShardEventStream> publisher) {
                publisher
                        // Filter to only SubscribeToShardEvents
                        .filter(SubscribeToShardEvent.class)
                        // Flat map into a publisher of just records
                        .flatMapIterable(SubscribeToShardEvent::records)
                        // Limit to 1000 total records
                        .limit(1000)
                        // Batch records into lists of 25
                        .buffer(25)
                        // Print out each record batch
                        .subscribe(batch -> System.out.println("Record Batch - " + batch));
            }

            @Override
            public void complete() {
                System.out.println("All records stream successfully");
            }

            @Override
            public void exceptionOccurred(Throwable throwable) {
                System.err.println("Error during stream - " + throwable.getMessage());
            }
        };
        return client.subscribeToShard(request, responseHandler);
    }
    // snippet-end:[kinesis.java2.stream_example.custom_handler]

    /**
     * Use the SubscribeToShardResponseHandler.Builder and a traditional subscriber
     */
    // snippet-start:[kinesis.java2.stream_example.subscribe]
    private static CompletableFuture<Void> responseHandlerBuilderSubscriber(KinesisAsyncClient client, SubscribeToShardRequest request) {
        SubscribeToShardResponseHandler responseHandler = SubscribeToShardResponseHandler
                .builder()
                .onError(t -> System.err.println("Error during stream - " + t.getMessage()))
                .subscriber(MySubscriber::new)
                .build();
        return client.subscribeToShard(request, responseHandler);
    }
    // snippet-end:[kinesis.java2.stream_example.subscribe]

    /**
     * Subscribes to the publisher using the onEventStream lifecycle callback method, which allows greater control
     * over the publisher and allows transformation methods on the publisher, like map and buffer
     */
    private static CompletableFuture<Void> responseHandlerBuilderOnEventStream(KinesisAsyncClient client, SubscribeToShardRequest request) {
        SubscribeToShardResponseHandler responseHandler = SubscribeToShardResponseHandler
                .builder()
                .onError(t -> System.err.println("Error during stream - " + t.getMessage()))
                .onEventStream(p -> p.filter(SubscribeToShardEvent.class).subscribe(new MySubscriber()))
                .build();
        return client.subscribeToShard(request, responseHandler);
    }

    /**
     * Simple subscriber implementation that prints events and cancels the subscription after 100 events
     */
    // snippet-start:[kinesis.java2.stream_example.custom_subscriber]
    private static class MySubscriber implements Subscriber<SubscribeToShardEventStream> {

        private Subscription subscription;
        private AtomicInteger eventCount = new AtomicInteger(0);

        @Override
        public void onSubscribe(Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(SubscribeToShardEventStream shardSubscriptionEventStream) {
            System.out.println("Received event " + shardSubscriptionEventStream);
            if (eventCount.incrementAndGet() >= 100) {
                // Cancel the subscription at any time to stop receiving events
                subscription.cancel();
            }
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println("Error occurred while stream - " + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.println("Finished streaming all events");
        }
    }
    // snippet-end:[kinesis.java2.stream_example.custom_subscriber]
}

