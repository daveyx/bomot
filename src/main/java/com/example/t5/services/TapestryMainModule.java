package com.example.t5.services;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.ServiceBinder;

import info.code8.tapestry.TapestryApplication;

@TapestryApplication
public class TapestryMainModule {

	public static void bind(ServiceBinder binder) {
		binder.bind(SomeInterface.class, SomeInterfaceImpl.class);
	}

	public static void contributeIgnoredPathsFilter(Configuration<String> configuration) {
		configuration.add("/playground/.*");
		configuration.add("/playground");
	}
}
