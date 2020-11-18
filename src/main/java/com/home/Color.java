package com.home;

/**
 * TODO
 *
 * @author ahao 2020-08-21
 */
public class Color {
    private Integer cid;
    private String color;

    public Color() {
    }

    public Color(Integer cid, String color) {
        this.cid = cid;
        this.color = color;
    }

    public Integer getCid() {
        return this.cid;
    }

    public String getColor() {
        return this.color;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setColor(String color) {
        this.color = color;
    }



    protected boolean canEqual(final Object other) {
        return other instanceof Color;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $cid = this.getCid();
        result = result * PRIME + ($cid == null ? 43 : $cid.hashCode());
        final Object $color = this.getColor();
        result = result * PRIME + ($color == null ? 43 : $color.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Color(cid=" + this.getCid() + ", color=" + this.getColor() + ")";
    }
}
