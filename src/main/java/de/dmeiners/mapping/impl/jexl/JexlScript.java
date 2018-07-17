package de.dmeiners.mapping.impl.jexl;

import de.dmeiners.mapping.api.BaseScript;
import de.dmeiners.mapping.api.ExecutionException;
import de.dmeiners.mapping.api.ResultTypeException;
import de.dmeiners.mapping.impl.jexl.security.AllPermissionPolicy;
import de.dmeiners.mapping.impl.jexl.security.JexlScriptAccessControlContext;
import de.dmeiners.mapping.impl.jexl.security.MySecurityManager;
import org.apache.commons.jexl3.JexlException;
import org.apache.commons.jexl3.MapContext;

import java.security.AccessController;
import java.security.Policy;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JexlScript extends BaseScript {

    private final org.apache.commons.jexl3.JexlScript script;
    private final Map<String, Object> extensions;

    JexlScript(org.apache.commons.jexl3.JexlScript script, Map<String, Object> extensions) {
        this.script = script;
        this.extensions = extensions;
    }

    @Override
    public <T> List<T> execute(Collection<T> targets, Map<String, Object> context) {

        Map<String, Object> extendedContext = new HashMap<>(context);
        extendedContext.putAll(this.extensions);

        return targets.stream()
            .map(target -> executeScript(target, extendedContext))
            .map(result -> castResult(targets.iterator().next(), result))
            .collect(Collectors.toList());
    }

    private <T> Object executeScript(T target, Map<String, Object> context) {

        System.setSecurityManager(new MySecurityManager());
        Policy.setPolicy(new AllPermissionPolicy());

        Object result;

        try {
            result = AccessController.doPrivileged((PrivilegedAction<Object>) () -> script.execute(new MapContext(context), target),
                JexlScriptAccessControlContext.INSTANCE);
        } catch (JexlException e) {
            throw new ExecutionException(String.format("Error executing parsed script: '%s'",
                script.getParsedText()), e);
        }

        return result;
    }

    private <T> T castResult(T target, Object result) {

        if (!target.getClass().isInstance(result)) {
            throw new ResultTypeException(String.format("Script did not return an object of type '%s'.",
                target.getClass().getName()));
        }

        // The above check should let this "cast" never fail. At runtime we are dealing with objects anyway.
        return (T) result;
    }
}
