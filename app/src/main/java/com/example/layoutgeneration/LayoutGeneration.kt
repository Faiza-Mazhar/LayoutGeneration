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
        val isEven = remainingItems % 2 == 0

        if (isEven) {
            val largePromoCount = min(remainingItems, 4)
            for (i in 1..largePromoCount) {
                promoList.add(PromoWithSpan(
                    HierarchicalCollectionPromoType.GridPromo,
                    SpanType.Half
                ))
            }
            remainingItems -= largePromoCount
        } else {
            //TODO: handle odd cases
        }

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
