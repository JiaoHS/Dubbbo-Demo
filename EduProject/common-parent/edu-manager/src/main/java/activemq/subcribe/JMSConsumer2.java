package activemq.subcribe;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @auther coraljiao
 * @date 2019/3/20 14:32
 * @description
 */
public class JMSConsumer2 {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接
        Session session;//会话
        Destination destination;//消息目的地
        MessageConsumer consumer;//消息消费者

        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);

        try {
            connection = connectionFactory.createConnection();//通过工厂获取连接
            connection.start();//启动连接
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);//创建session
            destination = session.createTopic("新闻队列T");
            consumer = session.createConsumer(destination);//创建消息消费者
            System.out.println("USERNAME:"+USERNAME);
            //另一种方式，写MQ的监听器
            consumer.setMessageListener(new MyMessageListener2());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class MyMessageListener2 implements MessageListener {
    @Override
    public void onMessage(Message msg) {
        TextMessage message=(TextMessage)msg;
        if(message != null){
            try {
                System.out.println("MyMessageListener2:"+message.getText());//获取消息
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
