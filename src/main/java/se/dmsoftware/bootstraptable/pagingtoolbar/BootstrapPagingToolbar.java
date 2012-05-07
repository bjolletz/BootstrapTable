package se.dmsoftware.bootstraptable.pagingtoolbar;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

/**
 * Paging toolbar for the Twitter bootstrap look and feel.
 *
 * @author Daniek Åkerlund
 */
public class BootstrapPagingToolbar extends AjaxNavigationToolbar {

    public BootstrapPagingToolbar(DataTable<?> table) {
        super(table);
    }

    @Override
    protected PagingNavigator newPagingNavigator(String navigatorId, DataTable<?> table) {
        return new BootstrapPagingNavigator(navigatorId, table);
    }

}
