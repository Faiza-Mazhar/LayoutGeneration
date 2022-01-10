package com.example.layoutgeneration

import kotlin.math.min

class LayoutGeneration {
    fun generateLayout(items: List<Int>): List<PromoWithSpan> {

        val inputSize = items.size
        var remainingItems = inputSize

        val promoList = mutableListOf<PromoWithSpan>()

        //first cell is always a large promo
        promoList.add(PromoWithSpan(
            HierarchicalCollectionPromoType.LargePromo,
            SpanType.Full
            )
        )

        remainingItems--

        val gridPromoCount = min(remainingItems, 4)
        for (i in 1..gridPromoCount) {
            promoList.add(
                PromoWithSpan(
                    HierarchicalCollectionPromoType.GridPromo,
                    SpanType.Half
                )
            )
        }
        remainingItems -= gridPromoCount

        val horizontalPromoCount = min(remainingItems, 4)
        for (i in 1..horizontalPromoCount) {
            promoList.add(
                PromoWithSpan(
                    HierarchicalCollectionPromoType.HorizontalPromo,
                    SpanType.Full
                )
            )
        }
        remainingItems -= horizontalPromoCount

        val horizontalTextOnlyPromoCount = min(remainingItems, 4)
        for (i in 1..horizontalTextOnlyPromoCount) {
            promoList.add(
                PromoWithSpan(
                    HierarchicalCollectionPromoType.HorizontalTextOnlyPromo,
                    SpanType.Full
                )
            )
        }
        remainingItems -= horizontalTextOnlyPromoCount

        //TODO: horizontals

        //TODO: text only

        return promoList
    }
}

fun createGridPromo() = PromoWithSpan(HierarchicalCollectionPromoType.GridPromo, SpanType.Half)

data class PromoWithSpan(val promoType: HierarchicalCollectionPromoType, val spanType: SpanType)

enum class HierarchicalCollectionPromoType {
    LargePromo,
    GridPromo,
    HorizontalPromo,
    HorizontalTextOnlyPromo,
}

enum class SpanType(val span: Int) {
    Full(12),
    Half(6),
    OneThird(4),
    Quarter(3),
}
