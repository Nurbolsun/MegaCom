package enums;

public enum ProductCategory {
    WATER(""),
    MILK(""),
    SUGAR(""),
    TEA("");

    private String productCategory;

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    ProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}
