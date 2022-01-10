package com.example.layoutgeneration

class LayoutGeneration {
    fun generateLayout(items: List<Int>): List<PromoWithSpan> {
        val promoList = mutableListOf<PromoWithSpan>()

        //first cell is always a large promo
        promoList.add(PromoWithSpan(
            HierarchicalCollectionPromoType.LargePromo,
            SpanType.Full
            )
        )

        var remainingItems = items.subList(1, items.size)
        val isEven = remainingItems.size % 2 == 0

        if (isEven) {
            val largePromoCount = remainingItems.take(4).size
            for (i in 1..largePromoCount) {
                promoList.add(PromoWithSpan(
                    HierarchicalCollectionPromoType.GridPromo,
                    SpanType.Half
                ))
            }
            //remainingItems = remainingItems.subList(largePromoCount, items.size)
        } else {

        }
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
