package com.example.t5.pages;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

@RequiresAuthentication
public class PlaygroundT5 {

	@Inject
	private AjaxResponseRenderer ajaxResponseRenderer;

	@Inject
	private Block block;

	void onAjax() {
		ajaxResponseRenderer.addRender("middlezone", block);
	}
}
