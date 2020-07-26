package com.gw.springboot_websocket.websocket;


import javafx.scene.input.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @author GuoWei qq:1677488547
 * @version 1.0
 * @date 2020/7/26 20:39
 */

@Component
@EnableScheduling
public class TimeTask
{
    private static Logger logger = LoggerFactory.getLogger(TimeTask.class);
    @Scheduled(cron = "0/1 * * * * ?")
    public void test(){
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateformat.format(System.currentTimeMillis());
        System.err.println(dateStr+"*********   定时任务执行   **************");
        CopyOnWriteArraySet<MyWebSocket> webSocketSet =
                MyWebSocket.getWebSocketSet();
        int i = 0 ;
        webSocketSet.forEach(c->{
            try {
                DateFormat dateFormat = new SimpleDateFormat();
                c.sendMessage("  定时发送  " + dateFormat.format(new Date()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.err.println(dateStr+"/n 定时任务完成.......");
    }
}
