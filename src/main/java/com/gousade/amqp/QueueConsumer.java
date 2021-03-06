package com.gousade.amqp;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author ucs_fuqing
 * @version 1.0
 * @date 2017年8月11日 下午2:39:51
 * @parameter
 * @return
 * @since
 */
public class QueueConsumer extends PointToPoint implements Runnable, Consumer {

    public QueueConsumer(String pointName) throws IOException, TimeoutException {
        super(pointName);
    }

    public void run() {
        try {
            channel.basicConsume(pointName, true, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer " + consumerTag + " registered");

    }

    @Override
    public void handleCancelOk(String consumerTag) {

    }

    @Override
    public void handleCancel(String consumerTag) throws IOException {

    }

    @SuppressWarnings("rawtypes")
    @Override
    public void handleDelivery(String consumerTag, Envelope env, BasicProperties props, byte[] body)
            throws IOException {
        Map map = SerializationUtils.deserialize(body);
        System.out.println("Message Number " + map.get("tagId") + " received.");
//        channel.basicAck(env.getDeliveryTag(), false);
    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

    }

    @Override
    public void handleRecoverOk(String consumerTag) {

    }

}