package se.dmsoftware.bootstraptable.pagingtoolbar;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationIncrementLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationLink;
import org.apache.wicket.request.resource.CssResourceReference;

/**
 * User: Daniel
 * Date: 2012-04-20
 * Time: 00:50
 */
public class BootstrapPagingNavigator extends AjaxPagingNavigator {
    public BootstrapPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.renderCSSReference(new CssResourceReference(getClass(), "BootstrapPagingNavigator.css"));
    }

    @Override
    protected PagingNavigation newNavigation(String id, IPageable pageable, IPagingLabelProvider labelProvider) {
        return new PagingNavigation(id, pageable, labelProvider) {
            @Override
            protected AbstractLink newPagingNavigationLink(String id, IPageable pageable, int pageIndex) {
                return new PagingNavigationLink<Void>(id, pageable, pageIndex) {
                    @Override
                    protected void disableLink(ComponentTag tag) {
                        tag.put("class", "active");
                    }
                };
            }
        };
    }

    @Override
    protected Link<?> newPagingNavigationIncrementLink(String id, IPageable pageable, int increment) {
        return new AjaxPagingNavigationIncrementLink(id, pageable, increment) {
            @Override
            protected void disableLink(ComponentTag tag) {
                tag.put("class", "disabled");
            }
        };
    }

    @Override
    protected Link<?> newPagingNavigationLink(String id, IPageable pageable, int pageNumber) {
        return new AjaxPagingNavigationLink(id, pageable, pageNumber) {
            @Override
            protected void disableLink(ComponentTag tag) {
                tag.put("class", "disabled");
            }
        };
    }

    private void disableLink(final ComponentTag tag) {
		// if the tag is an anchor proper
		if (tag.getName().equalsIgnoreCase("a") || tag.getName().equalsIgnoreCase("link") ||
			tag.getName().equalsIgnoreCase("area"))
		{
            tag.put("class", "disabled");
		}
		// if the tag is a button or input
		else if ("button".equalsIgnoreCase(tag.getName()) ||
			"input".equalsIgnoreCase(tag.getName()))
		{
			tag.put("disabled", "disabled");
		}
    }
}
