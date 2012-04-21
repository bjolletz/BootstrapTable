package se.dmsoftware.bootstraptable;

/**
 * User: Daniel
 * Date: 2012-04-21
 * Time: 16:11
 */
public enum BootstrapTableStyle {
    BORDERED("table-bordered"),
    STRIPED("table-striped"),
    CONDENSED("table-condensed");

    private String cssClass;

    BootstrapTableStyle(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getCssClass() {
        return cssClass;
    }
}
