package com.example.tugasil.`interface`.screen.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tugasil.`interface`.UiState
import com.example.tugasil.`interface`.component.TopMenuItem
import com.example.tugasil.`interface`.navigation.Screen
import com.example.tugasil.`interface`.theme.TugasILTheme
import com.example.tugasil.`interface`.theme.myColor3
import com.example.tugasil.`interface`.theme.myColor4
import com.example.tugasil.model.DataFake
import com.example.tugasil.model.FavArtis
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewmodel: HomeViewModel = koinViewModel(),
    navigateToDetail: (Long) -> Unit,
) {
    viewmodel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> viewmodel.getAllArtisList()
            is UiState.Success -> {
                HomeContent(
                    artisFavorite = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }

            is UiState.Error -> Log.d(
                "Error Get Data",
                "Can't get data because: ${uiState.errorMessage}"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    artisFavorite: List<FavArtis>,
    navigateToDetail: (Long) -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {

            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Home",
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold),
                        color = Color.Black
                    )
                },
                modifier = Modifier
                    .align(Alignment.TopCenter),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.Black.copy(alpha = 0.5f))
            )
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(myColor4),
        ) {
            Text(
                text = "Artis",
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }

        LazyRow(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp),
        ) {
            items(artisFavorite.size) { data ->

                    Box(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { navigateToDetail(DataFake.Artis[data].id.toLong()) }
                            .clip(shape = RoundedCornerShape(8.dp))
                            .background(myColor3)
                    ) {
                        TopMenuItem(
                            image = DataFake.Artis[data].image,
                            name = DataFake.Artis[data].name,
                            descrip = DataFake.Artis[data].descrip,
                            modifier = Modifier
                                .padding(8.dp)
                                .width(120.dp)
                                .align(Alignment.Center)
                                .clickable { navigateToDetail(DataFake.Artis[data].id.toLong()) }
                        )
                    }
                }
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(myColor4),
        ) {
            Text(
                text = "Best-selling menu",
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(end = 4.dp, start = 4.dp, bottom = 4.dp),

            ) {

                    }
                }

@Composable
@Preview(showBackground = true)
private fun PreviewScreen(navController: NavHostController = rememberNavController()) {
    TugasILTheme {
        HomeScreen(
            navigateToDetail = { artisId ->
                navController.navigate(Screen.DetailScreen.createRoute(artisId))
            }
        )
    }
}