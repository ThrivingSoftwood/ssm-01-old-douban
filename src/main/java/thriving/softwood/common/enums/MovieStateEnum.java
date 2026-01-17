package thriving.softwood.common.enums;

public enum MovieStateEnum {
    UPCOMING(0, "即将上映"), OUT_NOW(1, "已上映"), OFFLINE(2, "已下线");

    private int code;
    private String desc;

    MovieStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return code;
    }

    public String description() {
        return desc;
    }
}
