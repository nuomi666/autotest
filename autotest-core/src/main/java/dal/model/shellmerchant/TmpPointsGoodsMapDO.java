package dal.model.shellmerchant;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tmp_points_goods_map")
public class TmpPointsGoodsMapDO implements Serializable {
    @Column(name = "old_points_goods_id")
    private String oldPointsGoodsId;

    @Column(name = "new_points_goods_id")
    private String newPointsGoodsId;

    @Column(name = "goods_type")
    private String goodsType;

    private static final long serialVersionUID = 1L;

    /**
     * @return old_points_goods_id
     */
    public String getOldPointsGoodsId() {
        return oldPointsGoodsId;
    }

    /**
     * @param oldPointsGoodsId
     */
    public void setOldPointsGoodsId(String oldPointsGoodsId) {
        this.oldPointsGoodsId = oldPointsGoodsId == null ? null : oldPointsGoodsId.trim();
    }

    /**
     * @return new_points_goods_id
     */
    public String getNewPointsGoodsId() {
        return newPointsGoodsId;
    }

    /**
     * @param newPointsGoodsId
     */
    public void setNewPointsGoodsId(String newPointsGoodsId) {
        this.newPointsGoodsId = newPointsGoodsId == null ? null : newPointsGoodsId.trim();
    }

    /**
     * @return goods_type
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * @param goodsType
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", oldPointsGoodsId=").append(oldPointsGoodsId);
        sb.append(", newPointsGoodsId=").append(newPointsGoodsId);
        sb.append(", goodsType=").append(goodsType);
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
        TmpPointsGoodsMapDO other = (TmpPointsGoodsMapDO) that;
        return (this.getOldPointsGoodsId() == null ? other.getOldPointsGoodsId() == null : this.getOldPointsGoodsId().equals(other.getOldPointsGoodsId()))
            && (this.getNewPointsGoodsId() == null ? other.getNewPointsGoodsId() == null : this.getNewPointsGoodsId().equals(other.getNewPointsGoodsId()))
            && (this.getGoodsType() == null ? other.getGoodsType() == null : this.getGoodsType().equals(other.getGoodsType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOldPointsGoodsId() == null) ? 0 : getOldPointsGoodsId().hashCode());
        result = prime * result + ((getNewPointsGoodsId() == null) ? 0 : getNewPointsGoodsId().hashCode());
        result = prime * result + ((getGoodsType() == null) ? 0 : getGoodsType().hashCode());
        return result;
    }
}