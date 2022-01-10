package com.example.layoutgeneration

class LayoutGeneration {
    fun generateLayout(items: List<Int>): List<PromoWithSpan> {
        val promoList = mutableListOf<PromoWithSpan>()

        promoList.add(0, PromoWithSpan(
            HierarchicalCollectionPromoType.LargePromo,
            SpanType.Full
            )
        )

        val alone = (items.size - 1) % 2
        val pairs = (items.size - 1) / 2


        for (index in 1 .. items.size) {
            promoList.add(createGridPromo())
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
