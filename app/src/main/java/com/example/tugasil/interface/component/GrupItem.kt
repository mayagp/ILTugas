package com.example.tugasil.`interface`.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasil.R
import com.example.tugasil.`interface`.theme.Shapes
import com.example.tugasil.`interface`.theme.TugasILTheme
import com.example.tugasil.model.DataFake

@Composable
fun GrupItem(
    image: Int,
    name: String,
    modifier: Modifier = Modifier,
    descrip: Any
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(Shapes.medium)
        )
        Text(
            text = name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )


    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    TugasILTheme  {
        GrupItem(R.drawable.enha, "Falcon" , descrip = DataFake)
    }
}