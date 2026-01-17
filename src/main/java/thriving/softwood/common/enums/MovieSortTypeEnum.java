package thriving.softwood.common.enums;

public enum MovieSortTypeEnum {
    BY_POPULARITY("热门"), BY_RELEASE_DATE("时间"), BY_SCORE("评价");

    private String sortType;

    MovieSortTypeEnum(String sortType) {
        this.sortType = sortType;
    }

    public String sortType() {
        return sortType;
    }

    public static MovieSortTypeEnum getBySortType(String sortType) {
        for (MovieSortTypeEnum movieSortTypeEnum : MovieSortTypeEnum.values()) {
            if (movieSortTypeEnum.sortType.equals(sortType)) {
                return movieSortTypeEnum;
            }
        }
        return null;
    }
}
