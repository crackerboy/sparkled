package io.sparkled.model.animation.param

enum class ParamType {

    /**
     * Indicates that no type has been provided.
     */
    NONE,

    /**
     * A single color value.
     */
    COLOR,

    /**
     * Multiple color values.
     */
    COLORS,

    /**
     * A number, either whole or fractional.
     */
    DECIMAL,

    /**
     * A whole number.
     */
    INTEGER
}