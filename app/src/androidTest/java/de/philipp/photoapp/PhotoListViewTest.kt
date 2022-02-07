package de.philipp.photoapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.philipp.photoapp.data.Photo
import de.philipp.photoapp.photolist.PhotoListView
import de.philipp.photoapp.ui.theme.PhotoAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PhotoListViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displayListItem() {
        val itemTitle = "item title"

        composeTestRule.setContent {
            PhotoAppTheme {
                PhotoListView(
                    listOf(
                        Photo(
                            albumId = 1,
                            id = 1,
                            thumbnailUrl = "",
                            title = itemTitle,
                            url = ""
                        )
                    )
                ) {}
            }
        }

        composeTestRule.onNodeWithText("Photos").assertIsDisplayed()
        composeTestRule.onNodeWithText(itemTitle).assertIsDisplayed()
    }
}