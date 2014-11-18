package com.puppycrawl.tools.checkstyle.api.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.puppycrawl.tools.checkstyle.api.Configurable;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Module {

    /**
     * The authoritative name of the module, effectively the name to be used in a Checkstyle configuration file. If not
     * explicitly specified it defaults to the simple class name of the module minus the "Check" postfix.
     *
     * @return the configurative name of the Checkstyle module
     */
    String name() default "";

    /**
     * This modules logical parent module class.
     *
     * @return the parent module class
     */
    Class<? extends Configurable> parentModule();

    /**
     * Determines whether a module is considered an internal "helper" module. This indicates to integrators that this
     * module might not need to be shown to users, instead only be configured in automatic fashion. Defaults to
     * <code>false</code>.
     *
     * @return <code>true</code> if the module is to be considered internal
     */
    boolean internal() default false;

    /**
     * Certain modules should only appear once in a Checkstyle configuration, e.g. FileContentsHolder. This option
     * indicates that this is such a module. Defaults to <code>false</code>.
     *
     * @return <code>true</code> if the module is a singleton
     */
    boolean singleton() default false;
}
