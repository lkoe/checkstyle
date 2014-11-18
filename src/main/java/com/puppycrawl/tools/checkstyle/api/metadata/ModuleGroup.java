package com.puppycrawl.tools.checkstyle.api.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation
 *
 * @author Lars Ködderitzsch
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleGroup {

    /**
     * The internal name of the module group. Will be used to look up a human readable name for the module group from
     * properties file or similar mechanism. If not specified it defaults to the last segment of the fully qualified
     * package name.
     *
     * @return the internal name of the module group.
     */
    String name() default "";

    /**
     * Defines the order of this module group, compared to other module groups. Lower values mean higher precedence.
     *
     * @return the order indicator for this group.
     */
    int order() default Integer.MAX_VALUE;
}
