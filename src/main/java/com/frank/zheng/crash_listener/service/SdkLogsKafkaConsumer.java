package com.frank.zheng.crash_listener.service;

import com.alibaba.fastjson.JSON;
import com.frank.zheng.crash_listener.dao.SdkLogItemDao;
import com.frank.zheng.crash_listener.model.SdkLogItem;
import com.frank.zheng.crash_listener.model.SdkLogItemRaw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SdkLogsKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(SdkLogsKafkaConsumer.class);

    @Autowired
    SdkLogItemTransformer transformer;

    @Autowired
    SdkLogItemDao logItemDao;



    @KafkaListener(topics = "${kafka.topic.sdkLogs}", containerFactory = "sdkLogItemKafkaListenerContainerFactory")
    public void sdkLogItemListener(String message) {
        //System.out.println("got a sdk log item: " + logItem);
        SdkLogItemRaw rawItem = JSON.parseObject(message, SdkLogItemRaw.class);
        SdkLogItem logItem = transformer.transform(rawItem);
        logger.info("Got a sdk log item, timestamp: " + logItem.getDevice_timestamp());
        logItemDao.insert(logItem);
    }
}
