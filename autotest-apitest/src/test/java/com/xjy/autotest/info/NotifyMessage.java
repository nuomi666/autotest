package com.xjy.autotest.info;


import com.google.common.collect.Maps;
import com.xyb.adk.common.lang.env.Env;
import com.xyb.adk.common.lang.validator.Validators;
import com.xyb.adk.common.util.ToString.Invisible;
import java.util.Map;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class NotifyMessage {
    public static final String ALL = "ALL";
    public static final String SEPARATOR = "_";
    @NotNull
    @Length(
            min = 35,
            max = 35
    )
    private String gid;
    @NotNull
    @Length(
            min = 1,
            max = 64
    )
    private String topic;
    @NotNull
    @Length(
            min = 1,
            max = 64
    )
    private String id;
    @Length(
            min = 1,
            max = 64
    )
    private String toSystem = "ALL";
    @Invisible
    @Length(
            min = 1,
            max = 64
    )
    private String fromSystem ;
    @NotNull
    @Length(
            min = 1,
            max = 64
    )
    private String event;
    @Invisible
    @Length(
            min = 1,
            max = 32
    )
    private String env =Env.getEnv();
    @Invisible
    @NotNull
    private Map<String, Object> data;

    public NotifyMessage() {
    }

    public void param(String key, Object value) {
        if (this.data == null) {
            this.data = Maps.newHashMap();
        }

        this.data.put(key, value);
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getEnv() {
        return this.env;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getFromSystem() {
        return this.fromSystem;
    }

    public void setFromSystem(String fromSystem) {
        this.fromSystem = fromSystem;
    }

    public String getToSystem() {
        return this.toSystem;
    }

    public void setToSystem(String toSystem) {
        this.toSystem = toSystem;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append(this.fromSystem);
        stringBuilder.append("_");
        stringBuilder.append(this.toSystem);
        stringBuilder.append("_");
        stringBuilder.append(this.event);
        stringBuilder.append("_");
        stringBuilder.append(this.env);
        return stringBuilder.toString();
    }

    public void check() {
        Validators.checkJsr303(this, new Class[0]);
    }

    public String getGid() {
        return this.gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("NotifyMessage{gid=");
        sb.append(this.getGid());
        sb.append(", id=").append(this.getId());
        sb.append(", topic=").append(this.getTopic());
        sb.append(", event=").append(this.getEvent());
        sb.append(", fromSystem=").append(this.getFromSystem());
        sb.append(", toSystem=").append(this.getToSystem());
        sb.append(", env=").append(this.getEnv());
        sb.append(", data=").append(this.getData());
        sb.append('}');
        return sb.toString();
    }
}
