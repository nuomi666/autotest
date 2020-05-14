package dal.model.gas_merchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_app_version")
public class GasAppVersionDO implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 应用代码
     */
    @Column(name = "app_code")
    private String appCode;

    /**
     * 应用名称
     */
    @Column(name = "app_name")
    private String appName;

    /**
     * 版本代码
     */
    @Column(name = "version_code")
    private Integer versionCode;

    /**
     * 版本名称
     */
    @Column(name = "version_name")
    private String versionName;

    /**
     * 应用商店代码
     */
    @Column(name = "store_code")
    private String storeCode;

    /**
     * 应用商店名称
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 更新级别
     */
    @Column(name = "upgrade_level")
    private String upgradeLevel;

    /**
     * 更新内容
     */
    @Column(name = "upgrade_content")
    private String upgradeContent;

    /**
     * 创建时间
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
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取应用代码
     *
     * @return app_code - 应用代码
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * 设置应用代码
     *
     * @param appCode 应用代码
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode == null ? null : appCode.trim();
    }

    /**
     * 获取应用名称
     *
     * @return app_name - 应用名称
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置应用名称
     *
     * @param appName 应用名称
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 获取版本代码
     *
     * @return version_code - 版本代码
     */
    public Integer getVersionCode() {
        return versionCode;
    }

    /**
     * 设置版本代码
     *
     * @param versionCode 版本代码
     */
    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    /**
     * 获取版本名称
     *
     * @return version_name - 版本名称
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * 设置版本名称
     *
     * @param versionName 版本名称
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    /**
     * 获取应用商店代码
     *
     * @return store_code - 应用商店代码
     */
    public String getStoreCode() {
        return storeCode;
    }

    /**
     * 设置应用商店代码
     *
     * @param storeCode 应用商店代码
     */
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode == null ? null : storeCode.trim();
    }

    /**
     * 获取应用商店名称
     *
     * @return store_name - 应用商店名称
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置应用商店名称
     *
     * @param storeName 应用商店名称
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * 获取更新级别
     *
     * @return upgrade_level - 更新级别
     */
    public String getUpgradeLevel() {
        return upgradeLevel;
    }

    /**
     * 设置更新级别
     *
     * @param upgradeLevel 更新级别
     */
    public void setUpgradeLevel(String upgradeLevel) {
        this.upgradeLevel = upgradeLevel == null ? null : upgradeLevel.trim();
    }

    /**
     * 获取更新内容
     *
     * @return upgrade_content - 更新内容
     */
    public String getUpgradeContent() {
        return upgradeContent;
    }

    /**
     * 设置更新内容
     *
     * @param upgradeContent 更新内容
     */
    public void setUpgradeContent(String upgradeContent) {
        this.upgradeContent = upgradeContent == null ? null : upgradeContent.trim();
    }

    /**
     * 获取创建时间
     *
     * @return raw_add_time - 创建时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置创建时间
     *
     * @param rawAddTime 创建时间
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
        sb.append(", appCode=").append(appCode);
        sb.append(", appName=").append(appName);
        sb.append(", versionCode=").append(versionCode);
        sb.append(", versionName=").append(versionName);
        sb.append(", storeCode=").append(storeCode);
        sb.append(", storeName=").append(storeName);
        sb.append(", upgradeLevel=").append(upgradeLevel);
        sb.append(", upgradeContent=").append(upgradeContent);
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
        GasAppVersionDO other = (GasAppVersionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppCode() == null ? other.getAppCode() == null : this.getAppCode().equals(other.getAppCode()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getVersionCode() == null ? other.getVersionCode() == null : this.getVersionCode().equals(other.getVersionCode()))
            && (this.getVersionName() == null ? other.getVersionName() == null : this.getVersionName().equals(other.getVersionName()))
            && (this.getStoreCode() == null ? other.getStoreCode() == null : this.getStoreCode().equals(other.getStoreCode()))
            && (this.getStoreName() == null ? other.getStoreName() == null : this.getStoreName().equals(other.getStoreName()))
            && (this.getUpgradeLevel() == null ? other.getUpgradeLevel() == null : this.getUpgradeLevel().equals(other.getUpgradeLevel()))
            && (this.getUpgradeContent() == null ? other.getUpgradeContent() == null : this.getUpgradeContent().equals(other.getUpgradeContent()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppCode() == null) ? 0 : getAppCode().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getVersionCode() == null) ? 0 : getVersionCode().hashCode());
        result = prime * result + ((getVersionName() == null) ? 0 : getVersionName().hashCode());
        result = prime * result + ((getStoreCode() == null) ? 0 : getStoreCode().hashCode());
        result = prime * result + ((getStoreName() == null) ? 0 : getStoreName().hashCode());
        result = prime * result + ((getUpgradeLevel() == null) ? 0 : getUpgradeLevel().hashCode());
        result = prime * result + ((getUpgradeContent() == null) ? 0 : getUpgradeContent().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}