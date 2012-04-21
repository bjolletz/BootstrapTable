package se.dmsoftware.bootstraptable;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.markup.repeater.data.IDataProvider;

import java.util.List;

/**
 * A DataTable modified for the Twitter bootstrap look and feel.
 *
 * @see se.dmsoftware.bootstraptable.pagingtoolbar.BootstrapPagingToolbar
 *
 * @author Daniel Åkerlund
 */
public class BootstrapTable<T> extends DataTable<T> {

    public BootstrapTable(String id, List<IColumn<T>> iColumns, IDataProvider<T> tiDataProvider, int rowsPerPage, BootstrapTableStyle[] tableStyles) {
        super(id, iColumns, tiDataProvider, rowsPerPage);

        TransparentWebMarkupContainer table = new TransparentWebMarkupContainer("table");
        table.add(new AttributeModifier("class", getTableStyles(tableStyles)));
        add(table);

    }

    private String getTableStyles(BootstrapTableStyle[] tableStyles) {
        StringBuilder styles = new StringBuilder("table");
        for (BootstrapTableStyle tableStyle : tableStyles) {
            styles.append(" ");
            styles.append(tableStyle.getCssClass());
        }
        return styles.toString();
    }

}
