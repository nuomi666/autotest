package dal.model.clear;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenuDO implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单编号
     */
    private String code;

    /**
     * 菜单父编号
     */
    private String pcode;

    /**
     * 当前菜单的所有父菜单编号
     */
    private String pcodes;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * url地址
     */
    private String url;

    /**
     * 菜单排序号
     */
    private Integer num;

    /**
     * 菜单层级
     */
    private Integer levels;

    /**
     * 是否是菜单（1：是  0：不是）
     */
    private Integer ismenu;

    /**
     * 备注
     */
    private String tips;

    /**
     * 菜单状态 :  ENABLE:启用   DISABLE:不启用
     */
    private String status;

    /**
     * 是否打开:    1:打开   0:不打开
     */
    private Integer isopen;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单编号
     *
     * @return code - 菜单编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置菜单编号
     *
     * @param code 菜单编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取菜单父编号
     *
     * @return pcode - 菜单父编号
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * 设置菜单父编号
     *
     * @param pcode 菜单父编号
     */
    public void setPcode(String pcode) {
        this.pcode = pcode == null ? null : pcode.trim();
    }

    /**
     * 获取当前菜单的所有父菜单编号
     *
     * @return pcodes - 当前菜单的所有父菜单编号
     */
    public String getPcodes() {
        return pcodes;
    }

    /**
     * 设置当前菜单的所有父菜单编号
     *
     * @param pcodes 当前菜单的所有父菜单编号
     */
    public void setPcodes(String pcodes) {
        this.pcodes = pcodes == null ? null : pcodes.trim();
    }

    /**
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取菜单图标
     *
     * @return icon - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取url地址
     *
     * @return url - url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url地址
     *
     * @param url url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取菜单排序号
     *
     * @return num - 菜单排序号
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置菜单排序号
     *
     * @param num 菜单排序号
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取菜单层级
     *
     * @return levels - 菜单层级
     */
    public Integer getLevels() {
        return levels;
    }

    /**
     * 设置菜单层级
     *
     * @param levels 菜单层级
     */
    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    /**
     * 获取是否是菜单（1：是  0：不是）
     *
     * @return ismenu - 是否是菜单（1：是  0：不是）
     */
    public Integer getIsmenu() {
        return ismenu;
    }

    /**
     * 设置是否是菜单（1：是  0：不是）
     *
     * @param ismenu 是否是菜单（1：是  0：不是）
     */
    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    /**
     * 获取备注
     *
     * @return tips - 备注
     */
    public String getTips() {
        return tips;
    }

    /**
     * 设置备注
     *
     * @param tips 备注
     */
    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    /**
     * 获取菜单状态 :  ENABLE:启用   DISABLE:不启用
     *
     * @return status - 菜单状态 :  ENABLE:启用   DISABLE:不启用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置菜单状态 :  ENABLE:启用   DISABLE:不启用
     *
     * @param status 菜单状态 :  ENABLE:启用   DISABLE:不启用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取是否打开:    1:打开   0:不打开
     *
     * @return isopen - 是否打开:    1:打开   0:不打开
     */
    public Integer getIsopen() {
        return isopen;
    }

    /**
     * 设置是否打开:    1:打开   0:不打开
     *
     * @param isopen 是否打开:    1:打开   0:不打开
     */
    public void setIsopen(Integer isopen) {
        this.isopen = isopen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", pcode=").append(pcode);
        sb.append(", pcodes=").append(pcodes);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", url=").append(url);
        sb.append(", num=").append(num);
        sb.append(", levels=").append(levels);
        sb.append(", ismenu=").append(ismenu);
        sb.append(", tips=").append(tips);
        sb.append(", status=").append(status);
        sb.append(", isopen=").append(isopen);
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
        SysMenuDO other = (SysMenuDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getPcode() == null ? other.getPcode() == null : this.getPcode().equals(other.getPcode()))
            && (this.getPcodes() == null ? other.getPcodes() == null : this.getPcodes().equals(other.getPcodes()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getLevels() == null ? other.getLevels() == null : this.getLevels().equals(other.getLevels()))
            && (this.getIsmenu() == null ? other.getIsmenu() == null : this.getIsmenu().equals(other.getIsmenu()))
            && (this.getTips() == null ? other.getTips() == null : this.getTips().equals(other.getTips()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsopen() == null ? other.getIsopen() == null : this.getIsopen().equals(other.getIsopen()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getPcode() == null) ? 0 : getPcode().hashCode());
        result = prime * result + ((getPcodes() == null) ? 0 : getPcodes().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getLevels() == null) ? 0 : getLevels().hashCode());
        result = prime * result + ((getIsmenu() == null) ? 0 : getIsmenu().hashCode());
        result = prime * result + ((getTips() == null) ? 0 : getTips().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsopen() == null) ? 0 : getIsopen().hashCode());
        return result;
    }
}