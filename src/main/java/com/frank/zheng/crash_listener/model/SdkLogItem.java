package com.frank.zheng.crash_listener.model;

public class SdkLogItem {
    private long id;
    private int source;
    private String bundle_id;
    private String device_guid;
    private long device_timestamp;
    private int log_level;
    private int batch_id;
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getBundle_id() {
        return bundle_id;
    }

    public void setBundle_id(String bundle_id) {
        this.bundle_id = bundle_id;
    }

    public String getDevice_guid() {
        return device_guid;
    }

    public void setDevice_guid(String device_guid) {
        this.device_guid = device_guid;
    }

    public long getDevice_timestamp() {
        return device_timestamp;
    }

    public void setDevice_timestamp(long device_timestamp) {
        this.device_timestamp = device_timestamp;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public int getLog_level() {
        return log_level;
    }

    public void setLog_level(int log_level) {
        this.log_level = log_level;
    }

    public String getLog_message() {
        return log_message;
    }

    public void setLog_message(String log_message) {
        this.log_message = log_message;
    }

    public String getCrash_msg() {
        return crash_msg;
    }

    public void setCrash_msg(String crash_msg) {
        this.crash_msg = crash_msg;
    }

    public String getCrash_stack_trace() {
        return crash_stack_trace;
    }

    public void setCrash_stack_trace(String crash_stack_trace) {
        this.crash_stack_trace = crash_stack_trace;
    }

    public String getCrash_stack_trace_hash() {
        return crash_stack_trace_hash;
    }

    public void setCrash_stack_trace_hash(String crash_stack_trace_hash) {
        this.crash_stack_trace_hash = crash_stack_trace_hash;
    }

    public String getCrash_ex_class() {
        return crash_ex_class;
    }

    public void setCrash_ex_class(String crash_ex_class) {
        this.crash_ex_class = crash_ex_class;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getLog_context() {
        return log_context;
    }

    public void setLog_context(String log_context) {
        this.log_context = log_context;
    }

    public String getSdk_user_agent() {
        return sdk_user_agent;
    }

    public void setSdk_user_agent(String sdk_user_agent) {
        this.sdk_user_agent = sdk_user_agent;
    }

    public String getSdk_version() {
        return sdk_version;
    }

    public void setSdk_version(String sdk_version) {
        this.sdk_version = sdk_version;
    }

    public String getPlugin_name() {
        return plugin_name;
    }

    public void setPlugin_name(String plugin_name) {
        this.plugin_name = plugin_name;
    }

    public int getDevice_os() {
        return device_os;
    }

    public void setDevice_os(int device_os) {
        this.device_os = device_os;
    }

    public int getCtime() {
        return ctime;
    }

    public void setCtime(int ctime) {
        this.ctime = ctime;
    }

    public int getUtime() {
        return utime;
    }

    public void setUtime(int utime) {
        this.utime = utime;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }
}
