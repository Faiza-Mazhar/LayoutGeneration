package com.example.layoutgeneration

import org.junit.Assert.fail
import org.junit.Test


internal class TabletLayoutGeneratorTest {

    companion object {
        private val EXPECTED_FOR_3 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Half),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Half),
        )

        private val EXPECTED_FOR_4 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
        )

        private val EXPECTED_FOR_5 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
        )

        private val EXPECTED_FOR_6 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Half),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Half),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
        )

        private val EXPECTED_FOR_7 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
        )

        private val EXPECTED_FOR_8 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
        )

        private val EXPECTED_FOR_9 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
        )

        private val EXPECTED_FOR_10 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.OneThird),
        )

        private val EXPECTED_FOR_11 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
        )

        private val EXPECTED_FOR_12 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.OneThird),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
        )

        private val EXPECTED_FOR_13 = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Quarter),
        )

        private val ALL_EXPECTED = listOf(
            EXPECTED_FOR_3,
            EXPECTED_FOR_4,
            EXPECTED_FOR_5,
            EXPECTED_FOR_6,
            EXPECTED_FOR_7,
            EXPECTED_FOR_8,
            EXPECTED_FOR_9,
            EXPECTED_FOR_10,
            EXPECTED_FOR_11,
            EXPECTED_FOR_12,
            EXPECTED_FOR_13,
            )
    }

    private fun createInput(count: Int): List<Int> {
        val output = mutableListOf<Int>()
        for (i in 1..count) {
            output.add(i)
        }
        return output
    }

    private val layoutGeneration = TabletLayoutGeneration()

    @Test
    fun `run generation on all sizes`() {
        var failed = false
        for (count in 3..13) {
            val expected = ALL_EXPECTED[count-3]
            val input = createInput(count)
            val output = layoutGeneration.generateLayout(input)

            if (expected != output) {
                failed = true
                println("$count - Failed, got $output")
            } else {
                println("$count - Passed")
            }
        }

        if (failed) {
            fail("Something went wrong")
        }
    }
}