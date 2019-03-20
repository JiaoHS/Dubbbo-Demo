package activemq.p2p;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @auther coraljiao
 * @date 2019/3/20 14:43
 * @description
 */
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message msg) {
        TextMessage message=(TextMessage)msg;
        if(message != null){
            try {
                System.out.println(message.getText());//获取消息
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
