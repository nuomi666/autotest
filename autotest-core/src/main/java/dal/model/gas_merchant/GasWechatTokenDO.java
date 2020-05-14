package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_wechat_token")
public class GasWechatTokenDO implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 授权刷新令牌
     */
    @Column(name = "component_access_token")
    private String componentAccessToken;

    /**
     * 接口调用凭据
     */
    @Column(name = "component_verify_ticket")
    private String componentVerifyTicket;

    /**
     * 第三方平台id
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * token新增时间
     */
    @Column(name = "token_add_time")
    private Date tokenAddTime;

    /**
     * ticket新增时间
     */
    @Column(name = "ticket_add_time")
    private Date ticketAddTime;

    /**
     * 新增时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 更新时间
     */
    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取授权刷新令牌
     *
     * @return component_access_token - 授权刷新令牌
     */
    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    /**
     * 设置授权刷新令牌
     *
     * @param componentAccessToken 授权刷新令牌
     */
    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken == null ? null : componentAccessToken.trim();
    }

    /**
     * 获取接口调用凭据
     *
     * @return component_verify_ticket - 接口调用凭据
     */
    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }

    /**
     * 设置接口调用凭据
     *
     * @param componentVerifyTicket 接口调用凭据
     */
    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket == null ? null : componentVerifyTicket.trim();
    }

    /**
     * 获取第三方平台id
     *
     * @return app_id - 第三方平台id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置第三方平台id
     *
     * @param appId 第三方平台id
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取token新增时间
     *
     * @return token_add_time - token新增时间
     */
    public Date getTokenAddTime() {
        return tokenAddTime;
    }

    /**
     * 设置token新增时间
     *
     * @param tokenAddTime token新增时间
     */
    public void setTokenAddTime(Date tokenAddTime) {
        this.tokenAddTime = tokenAddTime;
    }

    /**
     * 获取ticket新增时间
     *
     * @return ticket_add_time - ticket新增时间
     */
    public Date getTicketAddTime() {
        return ticketAddTime;
    }

    /**
     * 设置ticket新增时间
     *
     * @param ticketAddTime ticket新增时间
     */
    public void setTicketAddTime(Date ticketAddTime) {
        this.ticketAddTime = ticketAddTime;
    }

    /**
     * 获取新增时间
     *
     * @return raw_add_time - 新增时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置新增时间
     *
     * @param rawAddTime 新增时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取更新时间
     *
     * @return raw_update_time - 更新时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param rawUpdateTime 更新时间
     */
    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", componentAccessToken=").append(componentAccessToken);
        sb.append(", componentVerifyTicket=").append(componentVerifyTicket);
        sb.append(", appId=").append(appId);
        sb.append(", tokenAddTime=").append(tokenAddTime);
        sb.append(", ticketAddTime=").append(ticketAddTime);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GasWechatTokenDO other = (GasWechatTokenDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getComponentAccessToken() == null ? other.getComponentAccessToken() == null : this.getComponentAccessToken().equals(other.getComponentAccessToken()))
            && (this.getComponentVerifyTicket() == null ? other.getComponentVerifyTicket() == null : this.getComponentVerifyTicket().equals(other.getComponentVerifyTicket()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getTokenAddTime() == null ? other.getTokenAddTime() == null : this.getTokenAddTime().equals(other.getTokenAddTime()))
            && (this.getTicketAddTime() == null ? other.getTicketAddTime() == null : this.getTicketAddTime().equals(other.getTicketAddTime()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getComponentAccessToken() == null) ? 0 : getComponentAccessToken().hashCode());
        result = prime * result + ((getComponentVerifyTicket() == null) ? 0 : getComponentVerifyTicket().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getTokenAddTime() == null) ? 0 : getTokenAddTime().hashCode());
        result = prime * result + ((getTicketAddTime() == null) ? 0 : getTicketAddTime().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}