package com.example.layoutgeneration

import kotlin.math.ceil

class TabletLayoutGeneration {
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

        val row = ceil(remainingItems / 4f).toInt()

        val firstRowCount = remainingItems / row
        remainingItems -= firstRowCount

        val secondRowCount = if (row >= 2) (remainingItems / (row - 1)) else 0
        remainingItems -= secondRowCount

        val thirdRowCount = if (row >= 3) (remainingItems / (row - 2)) else 0

        promoList.addAll(getPromoTypeAndSpan(firstRowCount, HierarchicalCollectionPromoType.GridPromo))
        promoList.addAll(getPromoTypeAndSpan(secondRowCount, HierarchicalCollectionPromoType.GridPromo))
        promoList.addAll(getPromoTypeAndSpan(thirdRowCount, HierarchicalCollectionPromoType.HorizontalTextOnlyPromo))
        return promoList
    }

    private fun getPromoTypeAndSpan(
        gridPromoCount: Int,
        promoType: HierarchicalCollectionPromoType
    ): MutableList<PromoWithSpan> {
        val list = mutableListOf<PromoWithSpan>()
        val spanType = when(gridPromoCount) {
            1 -> SpanType.Full
            2 -> SpanType.Half
            3 -> SpanType.OneThird
            4 -> SpanType.Quarter
            else -> SpanType.Full // shall we throw an exception
        }
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