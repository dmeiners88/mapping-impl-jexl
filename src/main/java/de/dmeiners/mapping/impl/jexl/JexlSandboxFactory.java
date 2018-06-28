package de.dmeiners.mapping.impl.jexl;

import org.apache.commons.jexl3.introspection.JexlSandbox;

class JexlSandboxFactory {

    private static final String FOR_NAME_METHOD_NAME = "forName";
    private static final String EXIT_METHOD_NAME = "exit";

    private JexlSandboxFactory() {
    }

    static JexlSandbox create() {

        JexlSandbox sandbox = new JexlSandbox();
        sandbox.black(System.class.getName()).execute(EXIT_METHOD_NAME);
        sandbox.black(Runtime.class.getName()).execute(EXIT_METHOD_NAME);
        sandbox.black(Class.class.getName()).execute(FOR_NAME_METHOD_NAME);
        sandbox.black(Byte.class.getName()).execute(FOR_NAME_METHOD_NAME);
        sandbox.black(Short.class.getName()).execute(FOR_NAME_METHOD_NAME);
        sandbox.black(Integer.class.getName()).execute(FOR_NAME_METHOD_NAME);
        sandbox.black(Long.class.getName()).execute(FOR_NAME_METHOD_NAME);
        sandbox.black(Float.class.getName()).execute(FOR_NAME_METHOD_NAME);
        sandbox.black(Double.class.getName()).execute(FOR_NAME_METHOD_NAME);
        sandbox.black(Boolean.class.getName()).execute(FOR_NAME_METHOD_NAME);
        sandbox.black(Character.class.getName()).execute(FOR_NAME_METHOD_NAME);

        return sandbox;
    }
}
