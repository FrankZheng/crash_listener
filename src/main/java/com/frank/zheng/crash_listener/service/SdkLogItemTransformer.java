package com.frank.zheng.crash_listener.service;

import com.alibaba.fastjson.JSON;
import com.frank.zheng.crash_listener.model.CrashInfo;
import com.frank.zheng.crash_listener.model.SdkLogItem;
import com.frank.zheng.crash_listener.model.SdkLogItemRaw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class SdkLogItemTransformer {

    private static final Logger logger = LoggerFactory.getLogger(SdkLogItemTransformer.class);

    private static final Map<String, Integer> levelMap = new HashMap<>();
    static {
        levelMap.put("verbose", 2);
        levelMap.put("debug", 3);
        levelMap.put("info", 4);
        levelMap.put("warn", 5);
        levelMap.put("error", 6);
        levelMap.put("assert", 7);
        levelMap.put("crash", 8);
    }

    private static final Map<String, Integer> sourceMap = new HashMap<>();
    static {
        sourceMap.put("sdk-hbs-logs", 1);
    }


    /*
    private long id;
    private String bundle_id;
    private String device_guid;
    private long device_timestamp;
    private int log_level;
    private String log_message;
    private String crash_msg;
    private String crash_stack_trace;
    private String crash_stack_trace_hash;
    private String crash_ex_class;
    private String event_id;
    private String time_zone;
    private String log_context;
    private String sdk_user_agent;
    private String sdk_version;
    private String plugin_name;
    private int device_os;
    private int ctime;
    private int utime;
    private int valid;
     */


    public SdkLogItem transform(@NonNull SdkLogItemRaw rawItem) {
        SdkLogItem item = new SdkLogItem();
        item.setBundle_id(rawItem.getBundle_id());
        item.setBatch_id(rawItem.getBatch_id());
        item.setDevice_guid(rawItem.getDevice_guid());
        item.setDevice_timestamp(getDeviceTimestamp(rawItem));
        item.setLog_level(getLogLevel(rawItem));
        item.setLog_message(rawItem.getLog_message());
        item.setSource(getSource(rawItem));

        fillCrashInfo(item, rawItem);

        item.setEvent_id(rawItem.getEvent_id());
        item.setTime_zone(rawItem.getTime_zone());
        item.setLog_context(rawItem.getContext());

        fillSdkUserAgent(item, rawItem);
        fillDeviceOs(item, rawItem);
        return item;
    }

    long getDeviceTimestamp(SdkLogItemRaw rawItem) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        try {
            Date date = sdf.parse(rawItem.getDevice_timestamp());
            return date.getTime();
        } catch (ParseException e) {
            logger.error("Failed to parse the device time stamp, " + rawItem.getDevice_timestamp());
        }
        return 0;
    }

    int getLogLevel(SdkLogItemRaw rawItem) {
        //0: unknown, 2:verbose, 3:debug, 4:info, 5:warn, 6:error, 7:assert, 8:crash
        Integer code = levelMap.get(rawItem.getLog_level());
        if (code != null) {
            return code;
        }
        return 0;
    }

    int getSource(SdkLogItemRaw rawItem) {
        //0: unknown, 1:advanced auction sdk 2:monetization sdk
        Integer source = sourceMap.get(rawItem.getType());
        if (source != null) {
            return source;
        }
        return 0;

    }

    void fillCrashInfo(@NonNull SdkLogItem logItem, @NonNull SdkLogItemRaw rawItem) {
        CrashInfo crashInfo = JSON.parseObject(rawItem.getLog_message(), CrashInfo.class);
        logItem.setCrash_msg(crashInfo.getMsg());
        logItem.setCrash_stack_trace(crashInfo.getStackTrace());
        logItem.setCrash_stack_trace_hash(crashInfo.getHash());
        logItem.setCrash_ex_class(crashInfo.getExClass());
    }

    void fillSdkUserAgent(SdkLogItem item, SdkLogItemRaw rawItem) {
        String userAgent = rawItem.getSdk_user_agent();
        item.setSdk_user_agent(userAgent);
        //TODO: VungleHBS/1.0.0;native
        String[] parts = userAgent.split(";");
        if (parts.length > 1) {
            item.setPlugin_name(parts[1]);
            //parse the sdk version
            String[] parts1 = parts[0].split("/");
            if (parts1.length > 1) {
                item.setSdk_version(parts1[1]);
            }
        }
    }

    void fillDeviceOs(SdkLogItem item, SdkLogItemRaw rawItem) {
        item.setDevice_os(1); //now the raw log doesn't include os info, hard code to android for now
    }


}
