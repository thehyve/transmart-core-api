package org.transmartproject.core.doc

import java.lang.annotation.*

/**
 * Annotates types that are not to be used by the clients of the library,
 * only implementations.
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target([ElementType.TYPE, ElementType.METHOD])
public @interface SPI { }
