package com.frank.zheng.crash_listener.dao;

import com.frank.zheng.crash_listener.model.SdkLogItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.lang.NonNull;


@Mapper
public interface SdkLogItemDao {
    /*
create table sdk_log (
	`id` bigint(20) not null auto_increment,
	`source` tinyint DEFAULT '0' COMMENT 'log source, 0:unknown 1:advanced auction sdk 2:monetization sdk',
	`bundle_id` varchar(256) DEFAULT '' COMMENT 'app bundle id',
	`device_guid` varchar(128) DEFAULT '' COMMENT 'device unique guid',
	`device_timestamp` bigint(20) DEFAULT '0' COMMENT 'log timestamp on device, milliseconds',
	`log_level` tinyint DEFAULT '0' COMMENT 'log level, 0: unknown, 2:verbose, 3:debug, 4:info, 5:warn, 6:error, 7:assert, 8:crash',
	`batch_id` int(11) DEFAULT '0' COMMENT 'batch id of the device logs',
	`log_message` text COMMENT 'the log_message field of the log',
	`crash_msg` varchar(512) DEFAULT '' COMMENT 'the crash message',
	`crash_stack_trace` varchar(4096) DEFAULT '' COMMENT 'the crash stack trace',
	`crash_stack_trace_hash` varchar(64) DEFAULT '' COMMENT 'the hash of crash stack trace',
	`crash_ex_class` varchar(128) DEFAULT '' COMMENT 'the crash exception class',
	`event_id` varchar(128) DEFAULT '' COMMENT 'the event_id of the log',
	`time_zone` varchar(64) DEFAULT '' COMMENT 'the time zone of the device',
	`log_context` varchar(256) DEFAULT '' COMMENT 'the context of the log',
	`sdk_version` varchar(32) DEFAULT '' COMMENT 'the sdk version',
	`sdk_user_agent` varchar(64) DEFAULT '' COMMENT 'the sdk user agent',
	`plugin_name` varchar(32) DEFAULT '' COMMENT 'the plugin of the sdk',
	`device_os` tinyint DEFAULT '0' COMMENT 'the device os, 1: Android 2:iOS 0:unknown',
    `ctime` int(11) DEFAULT '0' COMMENT 'creation time seconds',
    `utime` int(11) DEFAULT '0' COMMENT 'update time seconds',
    `valid` tinyint(2) DEFAULT NULL COMMENT '0:invalid 1:valid',
	primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='sdk logs table'
     */


    String TABLE_NAME = "sdk_log";
    String INSERT_FIELDS = "source,bundle_id,device_guid,device_timestamp,log_level,batch_id,log_message,crash_msg,crash_stack_trace," +
            "crash_stack_trace_hash,crash_ex_class,event_id,time_zone,log_context,sdk_version,sdk_user_agent,plugin_name,device_os,ctime,utime,valid";
    String VALUE_FIELDS = "#{source},#{bundle_id},#{device_guid},#{device_timestamp},#{log_level},#{batch_id},#{log_message},#{crash_msg},#{crash_stack_trace}," +
            "#{crash_stack_trace_hash},#{crash_ex_class},#{event_id},#{time_zone},#{log_context},#{sdk_version},#{sdk_user_agent},#{plugin_name},#{device_os}," +
            "unix_timestamp(),unix_timestamp(),1";



    @Insert("INSERT INTO " + TABLE_NAME + "(" + INSERT_FIELDS + ")" + " VALUES(" + VALUE_FIELDS + ")")
    @Options(useGeneratedKeys = true)
    int insert(@NonNull SdkLogItem logItem);

}
