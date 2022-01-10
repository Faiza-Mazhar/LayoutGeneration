package com.example.layoutgeneration

import kotlin.math.min

class LayoutGeneration {
    fun generateLayout(items: List<Int>): List<PromoWithSpan> {

        val inputSize = items.size
        var remainingItems = inputSize

        val promoList = mutableListOf<PromoWithSpan>()

        //first cell is always a large promo
        promoList.add(
            PromoWithSpan(
            HierarchicalCollectionPromoType.LargePromo,
            SpanType.Full
            )
        )

        remainingItems--

        val remainderFromGrid = min(remainingItems, 4) % 2
        var gridPromoCount = min(remainingItems, 4) - remainderFromGrid
        remainingItems -= gridPromoCount

        var horizontalPromoCount = min(remainingItems, 4)

        if(horizontalPromoCount == 1) {
            gridPromoCount-=2
            horizontalPromoCount+=2
        }
        remainingItems -= horizontalPromoCount

        var horizontalTextOnlyPromoCount = min(remainingItems, 4)

        if(horizontalTextOnlyPromoCount == 1) {
            horizontalTextOnlyPromoCount--
            horizontalPromoCount++
        }


        promoList.addAll(getPromoTypeAndSpan(gridPromoCount, HierarchicalCollectionPromoType.GridPromo, SpanType.Half))
        promoList.addAll(getPromoTypeAndSpan(horizontalPromoCount, HierarchicalCollectionPromoType.HorizontalPromo, SpanType.Full))
        promoList.addAll(getPromoTypeAndSpan(horizontalTextOnlyPromoCount, HierarchicalCollectionPromoType.HorizontalTextOnlyPromo, SpanType.Full))

        return promoList
    }

    private fun getPromoTypeAndSpan(
        gridPromoCount: Int,
        promoType: HierarchicalCollectionPromoType,
        spanType: SpanType
    ): MutableList<PromoWithSpan> {
        val list = mutableListOf<PromoWithSpan>()
        for (i in 1..gridPromoCount) {
            list.add(
                PromoWithSpan(
                    promoType,
                    spanType
                )
            )
        }
        return list
    }
}

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
