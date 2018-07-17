package de.dmeiners.mapping.impl.jexl.security;

import java.security.AllPermission;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Policy;

public class AllPermissionPolicy extends Policy {

	private static final PermissionCollection permissions = new AllPermission().newPermissionCollection();

	@Override
	public PermissionCollection getPermissions(CodeSource codesource) {

		return permissions;
	}
}
