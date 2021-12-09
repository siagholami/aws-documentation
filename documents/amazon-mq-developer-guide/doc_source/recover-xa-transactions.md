# Avoid Slow Restarts by Recovering Prepared XA Transactions<a name="recover-xa-transactions"></a>

ActiveMQ supports distributed \(XA\) transactions\. Knowing how ActiveMQ processes XA transactions can help avoid slow recovery times for broker restarts and failovers in Amazon MQ

Unresolved prepared XA transactions are replayed on every restart\. If these remain unresolved, their number will grow over time, significantly increasing the time needed to start up the broker\. This affects restart and failover time\. You must resolve these transactions with a `commit()` or a `rollback()` so that performance doesn't degrade over time\.

One cause of these unresolved transactions is an issue with Apache ActiveMQ\. This may cause unresolved prepared transactions when Amazon MQ restarts\. For more information, see the related Apache [ ActiveMQ defect](https://issues.apache.org/jira/browse/AMQ-7067)\.

To monitor your unresolved prepared XA transactions, you can use the `JournalFilesForFastRecovery` metric in Amazon CloudWatch Logs\. If this number is increasing, or is consistently higher than `1`, you should recover your unresolved transactions with code similar to the following example\. For more information, see [Quotas in Amazon MQ](amazon-mq-limits.md)\.

The following example code walks through prepared XA transactions and closes them with a `rollback()`\. 

```
import org.apache.activemq.ActiveMQXAConnectionFactory;

import javax.jms.XAConnection;
import javax.jms.XASession;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

public class RecoverXaTransactions {
    private static final ActiveMQXAConnectionFactory ACTIVE_MQ_CONNECTION_FACTORY;
    final static String WIRE_LEVEL_ENDPOINT =
            "tcp://localhost:61616";;
    static {
        final String activeMqUsername = "MyUsername123";
        final String activeMqPassword = "MyPassword456";
        ACTIVE_MQ_CONNECTION_FACTORY = new ActiveMQXAConnectionFactory(activeMqUsername, activeMqPassword, WIRE_LEVEL_ENDPOINT);
        ACTIVE_MQ_CONNECTION_FACTORY.setUserName(activeMqUsername);
        ACTIVE_MQ_CONNECTION_FACTORY.setPassword(activeMqPassword);
    }

    public static void main(String[] args) {
        try {
            final XAConnection connection = ACTIVE_MQ_CONNECTION_FACTORY.createXAConnection();
            XASession xaSession = connection.createXASession();
            XAResource xaRes = xaSession.getXAResource();

            for (Xid id : xaRes.recover(XAResource.TMENDRSCAN)) {
                xaRes.rollback(id);
            }
            connection.close();

        } catch (Exception e) {          
        }
    }
}
```

In a real\-world scenario, you could check your prepared XA transactions against your XA Transaction Manager\. Then you can decide whether to handle each prepared transaction with a `rollback()` or a `commit()`\.