package de.dmeiners.mapping.impl.jexl.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Permission;

import static java.util.Objects.nonNull;

public class MySecurityManager extends SecurityManager {

	private final SecurityManager delegate;

	public MySecurityManager() {

		delegate = System.getSecurityManager();
	}

	@Override
	public void checkPermission(Permission perm) {

		System.out.println(perm);

		if (!perm.getName().equals("setPolicy") && !perm.getName().equals("getProtectionDomain")) {

			if (nonNull(delegate)) {

				delegate.checkPermission(perm);
			}
		}
	}
}
