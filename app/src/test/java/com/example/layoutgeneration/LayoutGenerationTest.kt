package com.example.layoutgeneration

import org.junit.Assert
import org.junit.Test


internal class LayoutGenerationTest {

    private val layoutGeneration = MobileLayoutGeneration()
    @Test
    fun `first promo is always a large promo with span Full`() {
        val list = layoutGeneration.generateLayout(listOf(1,2,3))
        val expected = PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full)
        Assert.assertEquals(expected.promoType, list.first().promoType)
        Assert.assertEquals(expected.spanType, list.first().spanType)
    }

    @Test
    fun `for three promo, the promo 2 and 3 are marked as grid promos with span Half`() {
        val list = layoutGeneration.generateLayout(listOf(1,2,3))

        val expected = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Half),
            PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Half),
        )
        Assert.assertEquals(expected[1].promoType, list[1].promoType)
        Assert.assertEquals(expected[1].spanType, list[1].spanType)

        Assert.assertEquals(expected[2].promoType, list[2].promoType)
        Assert.assertEquals(expected[2].spanType, list[2].spanType)
    }

    @Test
    fun `for four promos, the promo 2,3,4 are marked horizontal`() {
        val list = layoutGeneration.generateLayout(listOf(1,2,3,4))

        val expected = listOf(
            PromoWithSpan(HierarchicalCollectionPromoType.LargePromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalPromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalPromo, SpanType.Full),
            PromoWithSpan(HierarchicalCollectionPromoType.HorizontalPromo, SpanType.Full),
        )

        Assert.assertEquals(expected[1].promoType, list[1].promoType)
        Assert.assertEquals(expected[1].spanType, list[1].spanType)
    }
}