package de.dmeiners.mapping.impl.jexl.security;

import java.security.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class AllPermissionPolicy extends Policy {

    private static class AllPermissionsSingleton extends PermissionCollection {

        private static final List<Permission> ALL_PERMISSIONS = Collections.singletonList(new AllPermission());

        @Override
        public void add(Permission permission) {
            // The AllPermission already contains all other permissions.
        }

        @Override
        public boolean implies(Permission permission) {
            return true;
        }

        @Override
        public Enumeration<Permission> elements() {

            return Collections.enumeration(ALL_PERMISSIONS);
        }

        @Override
        public boolean isReadOnly() {
            return false;
        }
    }

    private static final AllPermissionsSingleton ALL_PERMISSIONS_SINGLETON = new AllPermissionsSingleton();

    @Override
    public PermissionCollection getPermissions(CodeSource codesource) {
        return ALL_PERMISSIONS_SINGLETON;
    }
}
