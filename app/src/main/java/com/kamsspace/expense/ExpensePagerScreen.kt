package com.kamsspace.expense

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable

// Creating 3 pages on the screen to swipe
// Initial page is 1 (such as page ListenScreen())
@Composable
fun ExpensePagerScreen() {
    val pagerState = rememberPagerState(
        initialPage = 1
    ) { 3 } // 3 pages

    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> HistoryScreen()
            1 -> ListenScreen()
            2 -> DiscoverScreen()
        }
    }

}