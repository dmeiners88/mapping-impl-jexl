package de.dmeiners.mapping.impl.jexl.security;

import java.security.AccessControlContext;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class JexlScriptAccessControlContext {

	public static final AccessControlContext INSTANCE;

	static {

		RuntimePermission allPermission = new RuntimePermission("accessClassInPackage.sun.util.Calendar");

		PermissionCollection perms = allPermission.newPermissionCollection();
		perms.add(allPermission);

		INSTANCE = new AccessControlContext(new ProtectionDomain[]{
			new ProtectionDomain(null, perms)
		});
	}
}
