package de.dmeiners.mapping.impl.jexl.security;

import java.security.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class AllPermissionPolicy extends Policy {

    private static class AllPermissionsSingleton extends PermissionCollection {

        private static final Vector<Permission> ALL_PERMISSIONS = new Vector<>(Collections.singletonList(new AllPermission()));

        @Override
        public void add(Permission permission) {

        }

        @Override
        public boolean implies(Permission permission) {
            return true;
        }

        @Override
        public Enumeration<Permission> elements() {
            return ALL_PERMISSIONS.elements();
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
