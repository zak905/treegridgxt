package com.opencode.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.opencode.components.MyTreeGrid;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TreeGrid implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		MyTreeGrid treegrid = new MyTreeGrid();
		RootPanel.get("treegrid").add(treegrid.asWidget());

	}
}
