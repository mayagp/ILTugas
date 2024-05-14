package com.example.tugasil.`interface`.screen.grup

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasil.`interface`.UiState
import com.example.tugasil.`interface`.component.GrupItem
import com.example.tugasil.`interface`.theme.myColor3
import com.example.tugasil.`interface`.theme.myColor4
import com.example.tugasil.model.DataFake
import com.example.tugasil.model.FavArtis
import org.koin.androidx.compose.koinViewModel




@Composable
fun GrupScreen(
    navigateToDetail: (Long) -> Unit,
    viewModel: GrupViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> viewModel.getAllArtisList()
            is UiState.Success -> {
                ArtisContent(
                    Artislist = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }

            is UiState.Error -> Log.d(
                "Error Get Data Artis",
                "Can't get data because: ${uiState.errorMessage}"
            )
        }
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtisContent(
    Artislist: List<FavArtis> ,
    navigateToDetail: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {

        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Grup",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold),
                    color = Color.Black
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(myColor4)
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(120.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {



            items(Artislist.size) { data ->
                Box(
                    modifier = Modifier
                        .clickable { navigateToDetail(DataFake.Artis[data].id.toLong())}
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(myColor3)) {
                    GrupItem(
                        image = DataFake.Artis.get(data).image,
                        name = DataFake.Artis.get(data).name,
                        descrip = DataFake.Artis.get(data).descrip,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(8.dp)
                            .clickable { navigateToDetail(DataFake.Artis[data].id.toLong()) }
                    )

                }

            }
        }
    }
