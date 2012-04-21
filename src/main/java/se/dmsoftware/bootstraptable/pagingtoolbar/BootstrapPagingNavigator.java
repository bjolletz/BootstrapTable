package se.dmsoftware.bootstraptable.pagingtoolbar;

import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.navigation.paging.*;
import org.apache.wicket.request.resource.CssResourceReference;

/**
 * User: Daniel
 * Date: 2012-04-20
 * Time: 00:50
 */
public class BootstrapPagingNavigator extends PagingNavigator {
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
    protected AbstractLink newPagingNavigationIncrementLink(String id, IPageable pageable, int increment) {
        return new PagingNavigationIncrementLink<Void>(id, pageable, increment) {
            @Override
            protected void disableLink(ComponentTag tag) {
                tag.put("class", "disabled");
            }
        };
    }

    @Override
    protected AbstractLink newPagingNavigationLink(String id, IPageable pageable, int pageNumber) {
        return new PagingNavigationLink<Void>(id, pageable, pageNumber) {
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
