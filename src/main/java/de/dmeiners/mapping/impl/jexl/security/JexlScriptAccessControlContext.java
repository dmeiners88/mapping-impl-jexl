package de.dmeiners.mapping.impl.jexl.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ReflectPermission;
import java.security.AccessControlContext;
import java.security.Permissions;
import java.security.ProtectionDomain;

public class JexlScriptAccessControlContext {

    private static final Logger logger = LoggerFactory.getLogger(JexlScriptAccessControlContext.class);

    private JexlScriptAccessControlContext() {
    }

    public static final AccessControlContext INSTANCE;

    static {
        Permissions perms = new Permissions();
        perms.add(new ReflectPermission("suppressAccessChecks"));
        perms.add(new RuntimePermission("accessDeclaredMembers"));

        INSTANCE = new AccessControlContext(new ProtectionDomain[]{
            new ProtectionDomain(null, perms)
        });

        logger.debug("Initialized with the following permissions: {}", perms);
    }
}
