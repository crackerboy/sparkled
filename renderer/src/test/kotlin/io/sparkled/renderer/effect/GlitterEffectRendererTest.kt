package io.sparkled.renderer.effect

import io.sparkled.model.animation.easing.Easing
import io.sparkled.model.animation.easing.EasingTypeCode
import io.sparkled.model.animation.effect.Effect
import io.sparkled.model.animation.effect.EffectTypeCode
import io.sparkled.model.animation.fill.Fill
import io.sparkled.model.animation.fill.FillTypeCode
import io.sparkled.model.animation.param.ParamName
import io.sparkled.model.util.ParamUtils.param
import io.sparkled.util.RenderUtils
import io.sparkled.util.matchers.SparkledMatchers.hasRenderedFrames
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import kotlin.intArrayOf as f

class GlitterEffectRendererTest {

    @Test
    fun can_render() {
        val effect = Effect(
            endFrame = 29,
            type = EffectTypeCode.GLITTER,
            params = listOf(
                param(name = ParamName.DENSITY, value = 50),
                param(name = ParamName.LIFETIME, value = .2f)
            ),
            easing = Easing(type = EasingTypeCode.LINEAR),
            fill = Fill(
                type = FillTypeCode.SOLID,
                params = listOf(
                    param(name = ParamName.COLOR, value = "0xff0000")
                )
            )
        )

        val renderedStagePropData = RenderUtils.render(effect, effect.endFrame + 1, 10)

        assertThat(
            renderedStagePropData, hasRenderedFrames(
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x120000, 0x000000, 0x070000, 0x070000, 0x070000, 0x150000, 0x000000, 0x0B0000, 0x000000),
                f(0x000000, 0x1C0000, 0x070000, 0x070000, 0x070000, 0x150000, 0x230000, 0x000000, 0x1C0000, 0x000000),
                f(0x000000, 0x200000, 0x150000, 0x000000, 0x000000, 0x2B0000, 0x2A0000, 0x000000, 0x350000, 0x000000),
                f(0x000000, 0x1C0000, 0x2B0000, 0x0E0000, 0x0E0000, 0x470000, 0x2B0000, 0x0E0000, 0x550000, 0x000000),
                f(0x000000, 0x120000, 0x470000, 0x230000, 0x230000, 0x6A0000, 0x230000, 0x230000, 0x590000, 0x000000),
                f(0x000000, 0x000000, 0x6A0000, 0x400000, 0x400000, 0x6A0000, 0x150000, 0x400000, 0x550000, 0x000000),
                f(0x000000, 0x000000, 0x950000, 0x630000, 0x630000, 0x630000, 0x000000, 0x630000, 0x4A0000, 0x000000),
                f(0x000000, 0x000000, 0x8E0000, 0x8E0000, 0x8E0000, 0x550000, 0x000000, 0x8E0000, 0x390000, 0x000000),
                f(0x000000, 0x000000, 0x7F0000, 0xBF0000, 0xBF0000, 0x400000, 0x000000, 0xBF0000, 0x200000, 0x000000),
                f(0x000000, 0x000000, 0x6A0000, 0xB10000, 0xB10000, 0x230000, 0x000000, 0xB10000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x4E0000, 0x9C0000, 0x9C0000, 0x000000, 0x000000, 0x9C0000, 0x270000, 0x000000),
                f(0x000000, 0x000000, 0x2A0000, 0x800000, 0x800000, 0x2B0000, 0x000000, 0x800000, 0x550000, 0x000000),
                f(0x2B0000, 0x000000, 0x000000, 0x550000, 0x550000, 0x550000, 0x000000, 0x550000, 0x800000, 0x000000),
                f(0x550000, 0x000000, 0x000000, 0x2A0000, 0x2A0000, 0x800000, 0x000000, 0x2A0000, 0xAA0000, 0x000000),
                f(0x800000, 0x000000, 0x000000, 0x000000, 0x000000, 0xAA0000, 0x000000, 0x000000, 0xD50000, 0x000000),
                f(0xAA0000, 0x000000, 0x000000, 0x000000, 0x000000, 0xD50000, 0x000000, 0x2B0000, 0xFF0000, 0x000000),
                f(0xD50000, 0x000000, 0x000000, 0x000000, 0x000000, 0xFF0000, 0x000000, 0x550000, 0xD50000, 0x000000),
                f(0xFF0000, 0x000000, 0x000000, 0x000000, 0x000000, 0xD50000, 0x000000, 0x800000, 0xAA0000, 0x000000),
                f(0xC30000, 0x000000, 0x000000, 0x000000, 0x000000, 0x9C0000, 0x000000, 0x9C0000, 0x750000, 0x000000),
                f(0x8E0000, 0x000000, 0x000000, 0x000000, 0x000000, 0x6A0000, 0x000000, 0xB10000, 0x470000, 0x000000),
                f(0x600000, 0x000000, 0x000000, 0x000000, 0x000000, 0x400000, 0x000000, 0xBF0000, 0x200000, 0x000000),
                f(0x390000, 0x000000, 0x000000, 0x000000, 0x000000, 0x1C0000, 0x000000, 0x8E0000, 0x000000, 0x000000),
                f(0x190000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x630000, 0x190000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x400000, 0x2B0000, 0x000000),
                f(0x120000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x230000, 0x350000, 0x000000),
                f(0x1C0000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x0E0000, 0x390000, 0x000000),
                f(0x200000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x350000, 0x000000),
                f(0x1C0000, 0x000000, 0x000000, 0x070000, 0x070000, 0x000000, 0x000000, 0x000000, 0x2B0000, 0x000000),
                f(0x120000, 0x000000, 0x000000, 0x070000, 0x070000, 0x000000, 0x000000, 0x000000, 0x120000, 0x000000)
            )
        )
    }
}
