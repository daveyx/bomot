package com.example.t5.services;

import org.apache.shiro.realm.Realm;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.tynamo.security.services.SecurityFilterChainFactory;
import org.tynamo.security.services.impl.SecurityFilterChain;
import org.tynamo.shiro.extension.realm.text.ExtendedPropertiesRealm;

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

	public static void contributeWebSecurityManager(Configuration<Realm> configuration) {
		ExtendedPropertiesRealm realm = new ExtendedPropertiesRealm("classpath:shiro-users.properties");
		configuration.add(realm);
	}

	public static void contributeSecurityConfiguration(
			OrderedConfiguration<SecurityFilterChain> configuration,
			SecurityFilterChainFactory factory) {
		// OrderedConfiguration must be named, so they can be overridden later
		configuration.add("signup-anon", factory.createChain("/authc/signup").add(factory.anon()).build());
		
		configuration.add("authc_signup", factory.createChain("/authc/signup").add(factory.anon()).build());
		configuration.add("authc", factory.createChain("/authc/**").add(factory.authc()).build());
		configuration.add("partlyauthc", factory.createChain("/partlyauthc/**").add(factory.anon()).build());
		configuration.add("contributed", factory.createChain("/contributed/**").add(factory.authc()).build());
		configuration.add("user_signup", factory.createChain("/user/signup").add(factory.anon()).build());
		configuration.add("user", factory.createChain("/user/**").add(factory.user()).build());
		configuration.add("roles_user", factory.createChain("/roles/user/**").add(factory.roles(), "user").build());
		configuration.add("roles_manager", factory.createChain("/roles/manager/**").add(factory.roles(), "manager").build());
		configuration.add("perms_view", factory.createChain("/perms/view/**").add(factory.perms(), "news:view").build());
		configuration.add("perms_edit", factory.createChain("/perms/edit/**").add(factory.perms(), "news:edit").build());

		configuration.add("ports_ssl", factory.createChain("/ports/ssl").add(factory.ssl()).build());
		configuration.add("ports_9000", factory.createChain("/ports/port9090").add(factory.port(), "9090").build());

		configuration.add("hidden", factory.createChain("/hidden/**").add(factory.notfound()).build());
	}
}
