package com.example.corrutinas

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.corrutinas.ui.theme.CorrutinasTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CorrutinasTheme {
                Surface {
                    var retrofit = RetrofitHelper.getInstance()
                    val albums = remember { mutableStateOf<List<AlbumsDataResponse>>(emptyList())  }

                    lifecycleScope.launch(Dispatchers.IO){
                        var resultado = retrofit.getAlbums()
                        withContext(Dispatchers.Main){
                            if (resultado.isSuccessful) {
                                albums.value = resultado.body() ?: emptyList()
                            }
                        }
                    }
                    SuperHeroList(albums = albums.value)
                }
            }
        }
    }
}

@Composable
fun SuperHeroList(albums: List<AlbumsDataResponse>) {

    LazyColumn (modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
        ) {
            items(albums) { album ->
                Text(
                    text = "${album.userID} / ${album.id} / ${album.title}",
                )
            }
        }


}
