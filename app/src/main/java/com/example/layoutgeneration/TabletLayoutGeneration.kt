package com.example.layoutgeneration

import kotlin.math.ceil

class TabletLayoutGeneration {
    companion object {
        const val MAX_ITEM_IN_ROW = 4f
    }
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

        val numRows = ceil(remainingItems / MAX_ITEM_IN_ROW).toInt()

        val firstRowCount = remainingItems / numRows
        remainingItems -= firstRowCount

        val secondRowCount = if (numRows >= 2) (remainingItems / (numRows - 1)) else 0
        remainingItems -= secondRowCount

        val thirdRowCount = if (numRows >= 3) (remainingItems / (numRows - 2)) else 0

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